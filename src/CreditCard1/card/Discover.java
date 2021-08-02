package card;

public class Discover extends CreditCard {

    public Discover(String cardNumber, String date, String name) {
        super(cardNumber, date, name);
    }

    public Discover(String cardNumber, String date, String name, String issuer,String error) {
        super(cardNumber, date, name, issuer, error);
    }

    //For JUnit Test
    public Discover(String cardNumber1) {
        super(cardNumber1);
    }

    @Override
    public boolean checkIfValidCard(String creditCardNumber) {
        if (super.checkIfValidCard(creditCardNumber)) {
            if (creditCardNumber.length() == 16) {
                if (creditCardNumber.substring(0, 4).equals("6011")) {
                    setCardType();
                    setErrorType();
                    return true;
                }

            }

        }
        super.setCardType("Not a valid card");
        super.setErrorType("Not a valid Discover card");
        return false;
    }

    public void setCardType() {
        super.setCardType("DISCOVER");
    }

    public void setErrorType() {
        super.setErrorType("");
    }
}

