package card;

import org.junit.jupiter.api.Test;

class CreditCardReaderTest {
    CreditCard creditCard;
    @Test
    void getIssuer() {
        String cardNumber1 = "341000000000000";
        String cardNumber2 = "4120000000000";
        String cardNumber3 = "5410000000000000";

        String date1 = "9/7/26";
        String date2 = "10/11/21";
        String date3 = "6/3/24";

        String name1 = "Alice";
        String name2 = "Bob";
        String name3 = "Eve";

        CardReader c1 = new CardReader(new CreditCard(cardNumber1));
        CardReader c2 = new CardReader(new CreditCard(cardNumber2));
        CardReader c3 = new CardReader(new CreditCard(cardNumber3));

        c1.getIssuer(cardNumber1,date1,name1);
        creditCard = new AmericanExpress(cardNumber1);
        String testamex = "American Express";
        assert (c1.creditCard.cardType.equals(testamex));

        c2.getIssuer(cardNumber2,name2,date3);
        creditCard = new VisaCard(cardNumber2);
        String testvisa = "VISA";
        assert (c2.creditCard.cardType.equals(testvisa));

        c3.getIssuer(cardNumber3,name3,date3);
        creditCard = new Mastercard(cardNumber3);
        String testmaster = "MASTERCARD";
        assert (c3.creditCard.cardType.equals(testmaster));

    }

}