package card;

public class Mastercard extends CreditCard {

    public Mastercard(String creditCardNumber, String date, String name) {
        super(creditCardNumber, date, name);
    }

    public Mastercard(String creditCardNumber, String date, String name, String issuer, String error) {
        super(creditCardNumber, date, name, issuer, error);

    }

    //for Junit Test
    public Mastercard(String cardNumber3) {
        super(cardNumber3);
    }

    @Override
    public boolean checkIfValidCard(String creditCardNumber) {
        if (super.checkIfValidCard(creditCardNumber)) {
            if (creditCardNumber.length() == 16) {
                char rangeOfSecondDigit[] = {'1', '2', '3', '4', '5'};
                if (checkIfRange((creditCardNumber.charAt(1)), rangeOfSecondDigit)) {
                    setCardType();
                    setErrorType();
                    return true;
                }
            }

        }
        super.setCardType("Not a Valid Card");
        super.setErrorType("Not a valid Mastercard");
        return false;
    }
    public boolean checkIfRange(char c, char[] array) {
        for (char x : array) {
            if (x == c) {
                return true;
            }
        }
        return false;
    }
    public void setCardType() {
        super.setCardType("MASTERCARD");
        }

        public void setErrorType(){
        super.setErrorType("");
        }
    }

