package card;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class JsonFileHandler extends Handler {

    public JsonFileHandler(String file){
        super(file);
    }

    public void handleFile() {
        String creditCardNumber="";
        String expirationDate="";
        String Name="";

        JSONParser parser = new JSONParser();
        Object obj;
        try {
            obj = parser.parse(new FileReader(this.file));
            JSONArray jsonArray = (JSONArray) obj;

            for (int j=0; j<jsonArray.size(); j++ ){
                Object jsonObject1 = jsonArray.get(j);
                JSONObject jo = (JSONObject) jsonObject1;

                Long val = (long) jo.get("CardNumber");
                creditCardNumber = Long.toString(val);
                expirationDate = (String) jo.get("ExpirationDate");
                Name = (String) jo.get("NameOfCardholder");
                CreditCard creditCard = new CreditCard(creditCardNumber, expirationDate, Name);
                super.includeCard(creditCard);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();}

        catch (ParseException e){
                e.printStackTrace();
            }
         catch(IOException e)  {
            e.printStackTrace();
        }
    }
    public ArrayList<CreditCard> getCards() {
        return super.getCards();
    }
}
