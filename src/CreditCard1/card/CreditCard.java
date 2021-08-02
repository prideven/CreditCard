package card;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreditCard {

     String name;
     String creditCardNumber;
     String date;
     String cardType;
     String error;



    public CreditCard(String creditCardNumber, String date,String name)
    {
        this.creditCardNumber=creditCardNumber;
        this.date=date;
        this.name=name;
    }
    public CreditCard(String creditCardNumber,String date, String name,String cardType, String error){
        this.name=name;
        this.date=date;
        this.creditCardNumber=creditCardNumber;
        this.cardType =cardType;
        this.error= error;
    }

    public CreditCard(String cardNumber1) {
        creditCardNumber=cardNumber1;
    }



    public boolean checkIfValidCard(String creditCardNumber)
    {
        if (creditCardNumber.length() >19) {
            this.cardType ="Not a valid card Number";
            this.error= "Card number is above 19 digits";
            return false;
    }
            return true;
    }

    public void setCardType(String cardType){
        this.cardType = cardType;
    }

    public void setErrorType(String error){
        this.error=error;
    }


    public String toCsvRow() {
        return Stream.of(creditCardNumber, date, name, cardType,error).map(value -> value.replaceAll("\"", "\"\""))
                .map(value -> Stream.of("\"", ",").anyMatch(value::contains) ? "\"" + value + "\"" : value)
                .collect(Collectors.joining(","));
    }

    @Override
    public String toString() {
        return ("\nCreditCardNumber:" + this.creditCardNumber + "\nExpirationDate: " + this.date + "\nNameOfCardHolder: " + this.name + "\nCardType: "
                + this.cardType +"\nerror: " + this.error);
    }


}
