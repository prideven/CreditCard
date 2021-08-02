package card;

public class CardReader implements CardReaderInterface {


    CreditCard creditCard;
    public CardReader(CreditCard creditCard){
        this.creditCard=creditCard;
    }
    public CreditCard getIssuer(String creditCardNumber,String date,String name) {
        char firstDigit = creditCardNumber.charAt(0);

        switch (firstDigit) {

            case '3': {
                creditCard = new AmericanExpress(creditCardNumber, date, name);
                if (creditCard.checkIfValidCard(creditCardNumber)) {
                    creditCard = new AmericanExpress(creditCardNumber, date, name, creditCard.cardType, creditCard.error);
                }
                break;
            }
            case '5': {
                creditCard = new Mastercard(creditCardNumber, date, name);
                if (creditCard.checkIfValidCard(creditCardNumber)) {
                    creditCard = new Mastercard(creditCardNumber, date, name, creditCard.cardType, creditCard.error);
                }
                break;
            }
            case '4': {
                creditCard = new VisaCard(creditCardNumber, date, name);
                if (creditCard.checkIfValidCard(creditCardNumber)) {
                    creditCard = new VisaCard(creditCardNumber, date, name, creditCard.cardType, creditCard.error);
                }
                break;
            }
            case '6': {
                creditCard = new Discover(creditCardNumber, date, name);
                if (creditCard.checkIfValidCard(creditCardNumber)) {
                    creditCard = new Discover(creditCardNumber, date, name, creditCard.cardType,creditCard.error);
                }
                break;
            }
        }
            return new CreditCard(creditCard.creditCardNumber, creditCard.date, creditCard.name, creditCard.cardType,creditCard.error);
    }

    }

