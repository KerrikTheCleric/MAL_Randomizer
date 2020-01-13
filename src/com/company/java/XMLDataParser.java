import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;

/**
 * <h1>XMLDataParser</h1>
 * A parser class for XML.
 * <p>
 * animeList - List of Anime objects.
 * <p>
 *
 * @author  Victor Gustafsson
 * @version 1.0
 * @since   2020-01-13
 */

public class XMLDataParser {

    private ArrayList<Anime> animeList;

    /**
     * Standard constructor.
     * @param animeList List to fill with Anime objects.
     */

    public XMLDataParser(ArrayList<Anime> animeList) {
        this.animeList = animeList;
    }

    /**
     * Parses an input source of MAL XML for anime shows and puts shows tagged as "Plan to Watch" into the anime list.
     * @param is An input source of MAL XML.
     */

    public void getAnimeFromSource(InputSource is){

        DocumentBuilderFactory dbFactory;
        dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        Document doc;
        NodeList nList;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(is);
            doc.getDocumentElement().normalize();
            nList = doc.getElementsByTagName("anime");

            for (int temp = 0; temp < nList.getLength(); temp++){
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element e = (Element) nNode;
                    Anime a;

                    a = new Anime(e.getElementsByTagName("series_title").item(
                            0).getTextContent(),
                            Integer.parseInt(e.getElementsByTagName("series_episodes").item(
                            0).getTextContent()),
                            e.getElementsByTagName("my_status").item(
                            0).getTextContent()
                            );
                    if (a.status.equals("Plan to Watch")){
                        animeList.add(a);
                    }
                }
            }
        } catch (Exception e) {
            /* Catches all exceptions related to parsing
            (ParserConfigurationException, SAXException and IOException)
            , tells the user which one triggered and quits the program,
            since it can't run correctly without parsed data.*/

            JOptionPane.showMessageDialog(new JFrame(),
                    "Parsing failed due to " + e.getClass().getSimpleName());
            System.exit(1);
        }

    }

}
