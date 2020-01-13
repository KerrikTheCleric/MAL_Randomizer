import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

/**
 * <h1>XMLDataParser</h1>
 * A parser class for XML.
 * <p>
 * animeList - List of Anime objects.
 * <p>
 * outputAmount - Amount of shows to randomize.
 * <p>
 *
 * @author  Victor Gustafsson
 * @version 1.0
 * @since   2020-01-13
 */

public class Randomizer {

    private ArrayList<Anime> animeList;
    private int outputAmount = 0;

    /**
     * Standard constructor.
     * @param animeList List of Anime objects.
     */

    public Randomizer(ArrayList<Anime> animeList) {
        this.animeList = animeList;
        parseConfig();
    }

    /**
     * Parses the config file and assigns a value to outputAmount.
     */

    private void parseConfig(){

        Properties prop = new Properties();

        try {
            InputStream in = new FileInputStream("src/com/company/res/config.txt");
            prop.load(in);
            in.close();
            this.outputAmount = Integer.parseInt(prop.getProperty("amount"));
        }
        catch(Exception e) {
            System.out.println("ERROR: Can't parse config.txt.");
            System.exit(1);
        }
    }

    /**
     * Randomizes a set of animes, adds them to a new list and removes them from the old to avoid duplicate results.
     * @return A list of random anime.
     */

    public ArrayList<Anime> randomizeAnime(){
        int listMax = animeList.size();
        int rolledNumber = 0;
        Random rand = new Random();
        ArrayList<Anime> returnList = new ArrayList<>();

        for(int i = 0; i<outputAmount; i++){
            rolledNumber = rand.nextInt(listMax);
            returnList.add(animeList.get(rolledNumber));
            animeList.remove(rolledNumber);
            listMax--;
        }
        return returnList;
    }
}
