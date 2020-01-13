import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {


    public static void main(String[] args) {

        InputStream listStream;

        try {
            listStream = new FileInputStream(new File("src/com/company/res/animelist_1578925630_-_4974327.xml"));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: List XML file not found.");
            System.exit(1);
        }
    }
}
