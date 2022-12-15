package oodj_car_rental_system.utils;

import java.time.LocalDateTime;

public class CardInformation {

    private String cardNumber;
    private String cardHolderName;
    private String ccv;

    private String validThruMM;
    private String validThruYYYY;

    private float amount;

    public CardInformation(String cardNumber, String cardHolderName, String ccv, String validThruMM, String validThruYYYY, int amount) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.ccv = ccv;
        this.validThruMM = validThruMM;
        this.validThruYYYY = validThruYYYY;
        this.amount = amount;
    }

    public boolean checkIfCardIsValid() {
        if (!checkCardNumber()) {
            return false;
        }

        if (!checkCCV()) {
            return false;
        }

        if (!checkAmount()) {
            return false;
        }

        if (!checkCardValidationDate()) {
            return false;
        }

        return true;
    }

    private boolean checkAmount() {
        if (amount <= 0) {
            return false;
        }
        return true;
    }

    private boolean checkCCV() {
        if (ccv.length() != 3) {
            return false;
        }
        try {
            Integer.parseInt(ccv);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private boolean checkCardNumber() {
        if (cardNumber.length() != 8) {
            return false;
        }

        try {
            Integer.parseInt(cardNumber);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private boolean checkCardValidationDate() {
        int year, month;
        try {
            year = Integer.parseInt(validThruYYYY);
            month = Integer.parseInt(validThruMM);
        } catch (Exception e) {
            return false;
        }

        LocalDateTime validThruDate;
        try {
            validThruDate = LocalDateTime.of(year, month, 1, 0, 0, 0, 0);
        } catch (Exception e) {
            return false;
        }

        if (validThruDate.isBefore(LocalDateTime.now())) {
            return false;
        }
        return true;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public String getValidThruMM() {
        return validThruMM;
    }

    public void setValidThruMM(String validThruMM) {
        this.validThruMM = validThruMM;
    }

    public String getValidThruYYYY() {
        return validThruYYYY;
    }

    public void setValidThruYYYY(String validThruYYYY) {
        this.validThruYYYY = validThruYYYY;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
