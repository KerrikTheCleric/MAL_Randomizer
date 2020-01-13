import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class Randomizer {

    private ArrayList<Anime> animeList;
    private int outputAmount = 0;

    public Randomizer(ArrayList<Anime> animeList) {
        this.animeList = animeList;

        parseConfig();
    }

    private void parseConfig(){

        Properties prop = new Properties();

        try {
            InputStream in = new FileInputStream("src/com/company/res/config.txt");
            prop.load(in);
            in.close();
            //System.out.println(prop.getProperty("amount"));
            this.outputAmount = Integer.parseInt(prop.getProperty("amount"));
        }
        catch(Exception e) {
            System.out.println("ERROR: Can't parse config.txt.");
            System.exit(1);
        }
    }

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
