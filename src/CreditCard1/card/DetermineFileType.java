package card;

public class DetermineFileType {



    public void fileType(String input_file){
        String xml=".xml";
        String json=".json";
        String csv=".csv";

        int index=input_file.indexOf('.');
        String type = input_file.substring(index);


        if (input_file.equals(xml)){


        }

        if (input_file.equals(json)){

        }

        if (input_file.equals(csv)){

        }


    }
}
