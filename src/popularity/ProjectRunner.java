package popularity;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class ProjectRunner {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        ReadInput input = new ReadInput("sampleInput1.txt");
        input.printOutput2();
        
    }
}
