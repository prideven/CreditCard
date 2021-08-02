package card;

public class OutputFile {
    OutputHandler h;
    String JUnitTestString;

    public OutputFile(OutputHandler h) {
        this.h = h;
    }

    public void determineOutputfile(String input) {
        String json = ".json";
        String xml = ".xml";
        String csv = ".csv";
        int index = input.indexOf(".");
       String type = input.substring(index);


        if (type.equals(json)) {
            this.h = new JsonOutput(this.h.listOfCards);
            this.h.out();
            this.JUnitTestString = json;
        }

        if (type.equals(csv)) {
            this.h = new CSVOutput(this.h.listOfCards);
            this.h.out();
            this.JUnitTestString = csv;
        }

        if (type.equals(xml)) {
            this.h = new XMLOutput(this.h.listOfCards);
            this.h.out();
            this.JUnitTestString = xml;
        }

    }
}
