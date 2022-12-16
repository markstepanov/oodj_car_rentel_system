package oodj_car_rental_system.utils;


import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import oodj_car_rental_system.ApplicationContext.ApplicationContext;
import oodj_car_rental_system.Entities.Bookings.Booking;
import oodj_car_rental_system.Entities.cars.Car;
import oodj_car_rental_system.Entities.users.Customer;
import oodj_car_rental_system.ORMdeep.TableReader;
import oodj_car_rental_system.ORMdeep.TableWriter;
import oodj_car_rental_system.Repository.BookingRepository;
import oodj_car_rental_system.Repository.CarRepository;
import oodj_car_rental_system.Repository.UserRepository;
import org.bouncycastle.crypto.agreement.srp.SRP6Client;

import java.sql.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;


public class PdfGenerator {


    private UserRepository userRepository;
    private CarRepository carRepository;
    private BookingRepository bookingRepository;

    private ArrayList<Booking> bookings;

    private  float totalIncome;

    private HashMap<String, Integer> carHashMap;

    public PdfGenerator(UserRepository userRepository, CarRepository carRepository, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.bookingRepository = bookingRepository;
        totalIncome = 0f;
        this.carHashMap = new HashMap<>();
    }

    public void generatePdf(String path) throws Exception {

        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        Document document = new Document(pdfDocument);


        document.add(new Paragraph("Report").setFontSize(30));
        document.add(new Paragraph("Date " + LocalDate.now().toString()));

        document.add(new Paragraph("\n\n"));
        document.add(new Paragraph("Bookings:")).setFontSize(30);



        drawAllBookings(document);
        drawTotalIncome(document);
        drawMostPopularCar(mostPopularCar(), document);
        document.close();

    }

    private void drawMostPopularCar(String carName, Document document){


        document.add(new Paragraph("\n\n"));
        document.add(new Paragraph("Most Popular Car:").setFontSize(20));
        document.add(new Paragraph(carName).setFontSize(10));
    }

    private String mostPopularCar(){
        String carName = null;
        int highestCarValue = 0;

        for( String  val: carHashMap.keySet()){
            int currentValue = carHashMap.get(val);
            if (currentValue > highestCarValue){
                highestCarValue = currentValue;
                carName = val;
            }
        }
        return carName;

    }

    private  void drawTotalIncome(Document document){
        document.add(new Paragraph("\n\n"));
        document.add(new Paragraph("Total Income:").setFontSize(20));
        int total = this.bookings.size();
        document.add(new Paragraph(total + " bookings, RM"+ totalIncome).setFontSize(10));


    }

    private void drawAllBookings(Document document) throws Exception {
        float[] tableRows = {100f, 100f, 150f, 150f, 150f};
        Optional<ArrayList<Booking>> optionalBookings = this.bookingRepository.getAllClosedBookings();
        if (optionalBookings.isEmpty()) {
            throw new Exception();
        }
        this.bookings = optionalBookings.get();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");



        Table table = new Table(tableRows);
        table.addCell(getCell("Username"));
        table.addCell(getCell("Car Model"));
        table.addCell(getCell("Booking Start"));
        table.addCell(getCell("Booking End"));
        table.addCell(getCell("Total Price"));
        table.setWidth(650f);
        document.add(table);




        for (Booking booking : bookings) {
            Table table1 =new  Table(tableRows);
            Customer customer;
            Car car;
            try {
                customer = this.userRepository.getCustomerByUserId(booking.getRelatedToUser()).orElseThrow();
                car = this.carRepository.getCarById(booking.getRelatedToCar()).orElseThrow();
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            table1.addCell(getCell(customer.getUsername()));
            table1.addCell(getCell(car.getName()));
            table1.addCell(getCell(booking.getBookingStartDate().format(myFormatObj)));
            table1.addCell(getCell(booking.getClosingTime().format(myFormatObj)));
            table1.addCell(getCell(String.valueOf(booking.calculateBookingPrice(car.getPricePerHour(), PricingFactor.HOURS))));
            totalIncome += booking.calculateBookingPrice(car.getPricePerHour(),PricingFactor.HOURS);
            if ( this.carHashMap.get(car.getName())== null){
                this.carHashMap.put(car.getName(), 1);
            } else {
                this.carHashMap.replace(car.getName(), this.carHashMap.get(car.getName()) + 1);
            }
            table1.setWidth(650f);
            document.add(table1);
        }

    }

    private  Cell getCell(String text){

        return  new Cell().add(new Paragraph(text).setFontSize(6f)).setMaxWidth(150f);
    }


}
