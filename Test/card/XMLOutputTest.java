package card;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class XMLOutputTest {

    @Test
    void out() {
            CreditCard creditCard = new CreditCard("341000000000000", "5/20/2030", "Eve", "American Express","");
            ArrayList<CreditCard> outputlist = new ArrayList();
            outputlist.add(creditCard);
            CSVOutput out = new CSVOutput(outputlist);
            out.out();
        }
}