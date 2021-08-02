package card;

import org.junit.Test;

public class OutputFileTest {

    @Test
    public void determineOutputfile() {
        String output1 = "/Users/priyanka/Documents/Project1/Test/input/JunitTest.xml";
        String output2 = "/Users/priyanka/Documents/Project1/Test/output/sample.csv";

        Handler handler = new Handler(output1);
        InputFile inputFile = new InputFile(handler);
        inputFile.determineInput(output1);

        Handler p2 = new Handler(output2);
        InputFile i2 = new InputFile(p2);
        i2.determineInput(output2);

        assert (".xml".equals(inputFile.JUnitTestString));
        assert (".csv".equals(i2.JUnitTestString));

    }
}