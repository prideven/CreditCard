package card;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CSVFileHandler extends Handler {

    public CSVFileHandler(String file) {
        super(file);
    }
    public void handleFile() {
        String creditCardNumber;
        String name;
        String date;
        String line;



        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.file))) {
            int line_no = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (line_no == 0) {
                    line_no++;
                    continue;
                }
                String[] values = line.split(",");
                creditCardNumber = new BigDecimal(values[0]).toPlainString();
                date = values[1];
                name = values[2];

                CreditCard creditCard = new CreditCard(creditCardNumber, date, name);
                super.includeCard(creditCard);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<CreditCard> getCards() {
        return super.getCards();
    }
}



