package card;

import java.util.ArrayList;

public class Handler {
    String file;
    ArrayList<CreditCard> cards = new ArrayList<CreditCard>();
    public Handler(String file){
        this.file=file;
    }
    public void handleFile(){
    }
    public void includeCard(CreditCard obj){
        cards.add(obj);
    }
    public ArrayList<CreditCard> getCards(){
        return cards;
    }
}
