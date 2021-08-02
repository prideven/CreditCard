package card;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class XMLOutput extends OutputHandler{
        String JUnitTestString;
        DOMSource source;
        Transformer aTransformer;

        public XMLOutput(ArrayList<CreditCard> listCreditCards) {
            super(listCreditCards);
        }

        public void out() {
            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();

            try {
                DocumentBuilder build = dFact.newDocumentBuilder();
                Document doc = build.newDocument();
                Element root = doc.createElement("Root");
                doc.appendChild(root);
                Iterator var5 = this.listOfCards.iterator();

                while(var5.hasNext()) {
                    CreditCard c = (CreditCard)var5.next();
                    Element Details = doc.createElement("Row");
                    root.appendChild(Details);
                    Element number = doc.createElement("CreditCardNumber");
                    number.appendChild(doc.createTextNode(c.creditCardNumber));
                    Details.appendChild(number);
                    Element date = doc.createElement("ExpirationDate");
                    date.appendChild(doc.createTextNode(c.date));
                    Details.appendChild(date);
                    Element holder = doc.createElement("NameOfCardholder");
                    holder.appendChild(doc.createTextNode(c.name));
                    Details.appendChild(holder);
                    Element cardType = doc.createElement("CardType");
                    cardType.appendChild(doc.createTextNode(c.cardType));
                    Details.appendChild(cardType);
                    Element error = doc.createElement("Error");
                    error.appendChild(doc.createTextNode(c.error));
                    Details.appendChild(error);
                }

                TransformerFactory tranFactory = TransformerFactory.newInstance();
                this.aTransformer = tranFactory.newTransformer();
                this.aTransformer.setOutputProperty("encoding", "ISO-8859-1");
                this.aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                this.aTransformer.setOutputProperty("indent", "yes");
                this.source = new DOMSource(doc);

                try {
                    String name = MainTest.outputfile;
                    FileWriter fos = new FileWriter(name);
                    StreamResult result = new StreamResult(fos);
                    this.aTransformer.transform(this.source, result);
                } catch (IOException var12) {
                    var12.printStackTrace();
                } catch (TransformerException var13) {
                    var13.printStackTrace();
                }
            } catch (ParserConfigurationException var14) {
                var14.printStackTrace();
            } catch (TransformerConfigurationException var15) {
                var15.printStackTrace();
            }

        }
    }

