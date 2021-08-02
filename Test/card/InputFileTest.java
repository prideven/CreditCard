package card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputFileTest {
    @Test
    void determineInput() {
        String name1 = "/Users/priyanka/Documents/Project1/Test/input/JunitTest.xml";
        Handler handler = new Handler(name1);
        InputFile inputfile = new InputFile(handler);
        inputfile.determineInput(name1);
        assert ".xml".equals(inputfile.JUnitTestString);
    }
}