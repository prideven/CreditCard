package card;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CSVFileHandlerTest {

    @Test
    void handleFile() {
        String file = "/Users/priyanka/Documents/Project1/Test/input/JunitCsvFile.csv";
        CSVFileHandler out = new CSVFileHandler(file);
        out.handleFile();
        ArrayList<CreditCard> cardlist = out.getCards();
        for (CreditCard creditCard : cardlist) {
            assert (creditCard.name.equals("4120000000000"));
        }
    }
}




