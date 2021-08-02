package card;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JsonFileHandlerTest {
    @Test
    void handleFile() {
        String test = "/Users/priyanka/Documents/Project1/Test/input/Junitjson.json";
        JsonFileHandler fileHandler = new JsonFileHandler(test);
        fileHandler.handleFile();
        ArrayList<CreditCard> cardList = fileHandler.getCards();
        for (CreditCard card : cardList) {
            assert (card.name.equals("Alice"));
            assert (card.creditCardNumber.equals("5410000000000000"));
        }
    }
}