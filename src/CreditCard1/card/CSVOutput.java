package card;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CSVOutput extends OutputHandler  {
    String JunitTestString;
    public CSVOutput(ArrayList<CreditCard> listOfCards){
        super( listOfCards);
    }
    public void out() {
        String header = "CreditCardNumber, ExpirationDate, NameOfCardHolder, CardType, Error\n";
        String recordAsCsv = (String)this.listOfCards.stream().map(CreditCard::toCsvRow).collect(Collectors.joining(System.getProperty("line.separator")));
        this.JunitTestString = recordAsCsv;
        try {
            String name = MainTest.outputfile;
            FileWriter file = new FileWriter(name);
            file.write(header.concat(recordAsCsv));
            file.flush();
            file.close();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }
}
