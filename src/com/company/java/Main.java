import org.xml.sax.InputSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        InputStream listStream = null;
        InputSource listSource;
        ArrayList<Anime> animeList = new ArrayList<>();
        ArrayList<Anime> resultList;
        XMLDataParser parser = new XMLDataParser(animeList);
        Randomizer randomizer;

        try {
            //listStream = new FileInputStream(new File("src/com/company/res/animelist_1578925630_-_4974327.xml"));
            listStream = new FileInputStream(new File("src/com/company/res/animelist_1605005651_-_4974327.xml"));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: List XML file not found.");
            System.exit(1);
        }

        listSource = new InputSource(listStream);
        parser.getAnimeFromSource(listSource);

        randomizer = new Randomizer(animeList);
        resultList = randomizer.randomizeAnime();

        System.out.println("");

        for (Anime a: resultList) {
            if(a.episodes == 1){
                System.out.println(a.name + " - " + a.episodes + " Episode");
            }else {
                System.out.println(a.name + " - " + a.episodes + " Episodes");
            }
        }

    }
}
