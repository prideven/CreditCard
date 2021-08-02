package card;
import java.util.ArrayList;

public class InputFile {
    Handler h;
    ArrayList<CreditCard> parsedcards;
    String JUnitTestString;

    public InputFile(Handler h) {
        this.h = h;
    }

    public void determineInput(String file) {
        String json = ".json";
        String xml = ".xml";
        String csv = ".csv";
        this.parsedcards = new ArrayList();
        int index = file.indexOf('.');
        String type = file.substring(index);

        if (type.equals(json)) {
            h = new JsonFileHandler(h.file);
            h.handleFile();
           parsedcards = h.getCards();
            JUnitTestString = json;
        }

        if (type.equals(csv)) {
            this.h = new CSVFileHandler(this.h.file);
            this.h.handleFile();
            this.parsedcards = this.h.getCards();
            this.JUnitTestString = csv;
        }

        if (type.equals(xml)) {
            this.h = new XMLFileHAndler(this.h.file);
            this.h.handleFile();
            this.parsedcards = this.h.getCards();
            this.JUnitTestString = xml;
        }

    }
}
