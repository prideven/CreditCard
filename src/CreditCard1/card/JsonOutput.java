package card;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonOutput extends OutputHandler {
    String JUnitTestString;

    public JsonOutput(ArrayList<CreditCard> listOfCards) {
        super(listOfCards);
    }

    public void out() {
        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(listOfCards,new TypeToken<ArrayList<CreditCard>>() {
        }.getType());

        JsonArray jsonArray = element.getAsJsonArray();
        JsonArray newArray = new JsonArray();
        newArray.addAll(jsonArray);
       JUnitTestString=jsonArray.get(0).toString();
        try {
            String name=MainTest.outputfile;
            FileWriter file = new FileWriter(name);

            file.write("[\n");

            for (int i = 0; i < jsonArray.size() - 1; i++) {
                file.write(jsonArray.get(i).toString() + ",\n");
            }

            file.write(jsonArray.get(jsonArray.size() - 1).toString() + "\n");

            file.write("]\n");

            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

