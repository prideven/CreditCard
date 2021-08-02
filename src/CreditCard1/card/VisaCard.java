package card;

public class VisaCard extends CreditCard{

    public VisaCard (String cardNumber, String date, String name){
        super(cardNumber,date,name);
    }

    public VisaCard (String cardNumber, String date, String name,String issuer,String error ){
        super(cardNumber,date,name,issuer,error);
    }

    
    //handle Junit test
    public VisaCard(String cardNumber2) {
        super(cardNumber2);
    }

    @Override
    public boolean checkIfValidCard(String creditCardNumber) {
        if (super.checkIfValidCard(creditCardNumber)){
            if (creditCardNumber.length()==13 || creditCardNumber.length()==16){
                setCardType();
                setErrorType();
                return true;
            }
            else{
            }
        }
        super.setCardType("Not a valid card");
        super.setErrorType("Not a valid VisaCard");
        return false;
    }

    public void setCardType(){
        super.setCardType("VISA");
    }

    public void setErrorType(){
        super.setErrorType("");
    }
}
