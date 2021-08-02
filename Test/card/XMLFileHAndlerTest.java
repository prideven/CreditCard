package card;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class XMLFileHAndlerTest {

    @Test
    void handleFile() {
        String test = "/Users/priyanka/Documents/Project1/Test/input/JunitTest.xml";
        XMLFileHAndler fileHAndler = new XMLFileHAndler(test);
        fileHAndler.handleFile();
        ArrayList<CreditCard> cardList = fileHAndler.getCards();
        Iterator iterator = cardList.iterator();

        CreditCard c;
            if (!iterator.hasNext()) {
                return;
            }
            c = (CreditCard) iterator.next();
            assert (c.creditCardNumber.equals("5410000000000000"));

    }

}