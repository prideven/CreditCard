package card;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;

public class XMLFileHAndler extends Handler {
    String file;
    public XMLFileHAndler(String file){
        super(file);
        this.file=file;
    }
    public void handleFile() {
        File file = new File(this.file);

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuiler;
        try {
            documentBuiler = documentBuilderFactory.newDocumentBuilder();
            Document doc;
            doc = documentBuiler.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("row");
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) node;
                    String date = e.getElementsByTagName("ExpirationDate").item(0).getTextContent();
                    String name = e.getElementsByTagName("NameOfCardholder").item(0).getTextContent();
                    String tempnumber = e.getElementsByTagName("CardNumber").item(0).getTextContent();
                    String creditCardNumber = new BigDecimal(tempnumber).toPlainString();
                    CreditCard credit = new CreditCard(creditCardNumber, date, name);
                    super.includeCard(credit);
                }
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public ArrayList<CreditCard> getCards() {
        return super.getCards();
    }

}

