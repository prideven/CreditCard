package card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetermineFileTypeTest {

    @Test
    void fileType() {
        String input1 = "/Users/priyanka/Documents/Project1/Test/output/sample.xml";
        String input2 = "/Users/priyanka/Documents/Project1/Test/output/sample.csv";
        Handler handler = new Handler(input1);
        InputFile inputfile = new InputFile(handler);
        inputfile.determineInput(input1);
        Handler handler1 = new Handler(input2);
        InputFile inputf = new InputFile(handler1);
        inputf.determineInput(input2);

        assert ".xml".equals(inputfile.JUnitTestString);
        assert ".csv".equals(inputf.JUnitTestString);

    }

}