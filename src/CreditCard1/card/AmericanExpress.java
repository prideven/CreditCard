package card;

public class AmericanExpress extends CreditCard{

    public AmericanExpress(String cardNumber,String date, String name){
        super(cardNumber,date,name);
    }
    public AmericanExpress(String cardNumber,String date,String name,String issuer,String error){
        super(cardNumber,date,name,issuer,error);
    }

    public AmericanExpress(String cardNumber1) {
        super(cardNumber1);
    }

    @Override
    public boolean checkIfValidCard(String creditCardNumber) {
        if (super.checkIfValidCard(creditCardNumber)) {
            if (creditCardNumber.length()==15){
                if ((creditCardNumber.charAt(1))== '4' | creditCardNumber.charAt(1)== '7') {
                    setCardType();
                    setErrorType();
                    return true;
                }
            }
        }
        super.setCardType("Not a valid card");
        super.setErrorType("Not a valid Amex card");
        return false;
    }
    public void setCardType(){
        super.setCardType("American Express");
    }

    public void setErrorType(){
        super.setErrorType("");
    }

}
