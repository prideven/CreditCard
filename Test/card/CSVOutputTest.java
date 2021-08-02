package card;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CSVOutputTest {
    CSVOutputTest() {
    }
    @Test
    void out() {
        CreditCard card1 = new CreditCard("4120000000000", "4/20/2030", "Bob", "VISA","");
        ArrayList<CreditCard> testlist = new ArrayList();
        testlist.add(card1);
        CSVOutput out = new CSVOutput(testlist);
        out.out();
        String data = "4120000000000,4/20/2030,Bob,VISA";
        assert data.equals(out.JunitTestString);
    }
}