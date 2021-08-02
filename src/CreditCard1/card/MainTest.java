package card;

import java.util.ArrayList;

public class MainTest {
    static String inputfile;
    static String outputfile;
    static ArrayList<CreditCard> outputcards = new ArrayList<CreditCard>();
    public static void main(String[] args) {
//        inputfile = "/Users/priyanka/Documents/Project1/Test/input/Sample.csv";
//        outputfile ="/Users/priyanka/Documents/Project1/Test/output/sample.csv";

        inputfile = args[0];
        outputfile = args[1];

        //handle input
        InputFile inputFile = new InputFile(new Handler(inputfile));
        inputFile.determineInput(inputfile);
        ArrayList<CreditCard> parsedcards = new ArrayList<>();
        parsedcards = inputFile.parsedcards;
        String cardNumber = "";
        String name = "";
        String date = "";
        for (CreditCard c : parsedcards)  {
            cardNumber = c.creditCardNumber;
            name = c.name;
            date = c.date;
            CardReader inputcard = new CardReader(new CreditCard(cardNumber, date, name));
            CreditCard outputcard = inputcard.getIssuer(cardNumber, date, name);
            outputcards.add(outputcard);
        }
        //handle output
        OutputFile outputFile = new OutputFile(new OutputHandler(outputcards));
        outputFile.determineOutputfile(outputfile);

    }
}