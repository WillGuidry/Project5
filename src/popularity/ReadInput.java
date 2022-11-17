package popularity;

import java.io.File;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ReadInput {

    private EngagementDLList<EngagementPerson> data;
    private EngagementDLList<EngagementPerson> januaryPeople;
    private EngagementDLList<EngagementPerson> febuaryPeople;
    private EngagementDLList<EngagementPerson> marchPeople;
    private EngagementDLList<EngagementPerson> aprilPeople;

    public ReadInput(String fileName)
        throws java.text.ParseException,
        FileNotFoundException {
        januaryPeople = new EngagementDLList<EngagementPerson>();
        febuaryPeople = new EngagementDLList<EngagementPerson>();
        marchPeople = new EngagementDLList<EngagementPerson>();
        aprilPeople = new EngagementDLList<EngagementPerson>();

        data = readFile(fileName);

    }


    public EngagementDLList<EngagementPerson> readFile(String fileName)
        throws FileNotFoundException {

        EngagementDLList<EngagementPerson> listOfPeople =
            new EngagementDLList<EngagementPerson>();
        Scanner file = new Scanner(new File(fileName));

        while (file.hasNextLine()) {
            String read = file.nextLine();
            Scanner currLine = new Scanner(read).useDelimiter(",\\s*");
            String[] value = new String[10];
            for (int i = 0; i < 10; i++) {
                if (currLine.hasNext()) {
                    value[i] = currLine.next();
                }
            }
            if (value[0].equals("January")) {
                EngagementPerson jan = new EngagementPerson(value[0], value[1],
                    value[2], value[3], value[4], Integer.parseInt(value[5]),
                    Integer.parseInt(value[6]), Integer.parseInt(value[7]),
                    Integer.parseInt(value[8]), Integer.parseInt(value[9]));
                januaryPeople.add(jan);
            }
            if (value[0].equals("February")) {
                EngagementPerson feb = new EngagementPerson(value[0], value[1],
                    value[2], value[3], value[4], Integer.parseInt(value[5]),
                    Integer.parseInt(value[6]), Integer.parseInt(value[7]),
                    Integer.parseInt(value[8]), Integer.parseInt(value[9]));
                febuaryPeople.add(feb);
            }
            if (value[0].equals("March")) {
                EngagementPerson march = new EngagementPerson(value[0],
                    value[1], value[2], value[3], value[4], Integer.parseInt(
                        value[5]), Integer.parseInt(value[6]), Integer.parseInt(
                            value[7]), Integer.parseInt(value[8]), Integer
                                .parseInt(value[9]));
                marchPeople.add(march);
            }

            if (this.validMonth(value[0])) {
                EngagementPerson person = new EngagementPerson(value[0],
                    value[1], value[2], value[3], value[4], Integer.parseInt(
                        value[5]), Integer.parseInt(value[6]), Integer.parseInt(
                            value[7]), Integer.parseInt(value[8]), Integer
                                .parseInt(value[9]));
                listOfPeople.add(person);

            }

        }
        file.close();
        return listOfPeople;
    }


    public EngagementDLList<EngagementPerson> getJanuaryPeople() {
        return januaryPeople;
    }


    public EngagementDLList<EngagementPerson> getFebuaryPeople() {
        return febuaryPeople;
    }


    public EngagementDLList<EngagementPerson> getMarchPeople() {
        return marchPeople;
    }


    public int[] getLikesForPerson() {
        int[] numberPeople = new int[this.getJanuaryPeople().size()];
        for (int i = 0; i < this.getJanuaryPeople().size(); i++) {
            numberPeople[i] = this.getJanuaryPeople().get(i).getLikes() + this
                .getFebuaryPeople().get(i).getLikes() + this.getMarchPeople()
                    .get(i).getLikes();
        }

        return numberPeople;
    }


    public int[] getCommentsForPerson() {
        int[] numberPeople = new int[this.getJanuaryPeople().size()];
        for (int i = 0; i < this.getJanuaryPeople().size(); i++) {
            numberPeople[i] = this.getJanuaryPeople().get(i).getComments()
                + this.getFebuaryPeople().get(i).getComments() + this
                    .getMarchPeople().get(i).getComments();
        }
        return numberPeople;
    }


    public void printOutput2() throws FileNotFoundException {
        String pattern = "#.#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        decimalFormat.applyPattern(pattern);
        for (int x = 0; x < this.getMarchPeople().size(); x++) {
            double sum = this.getLikesForPerson()[x] + this
                .getCommentsForPerson()[x];
            double sum2 = sum / this.getMarchPeople().get(x).getFollowers()
                * 100;
            System.out.println(decimalFormat.format(sum2));
        }
    }


    private boolean validMonth(String input) {
        return input.equals("January") || input.equals("Febuary") || input
            .equals("March") || input.equals("April") || input.equals("May")
            || input.equals("June") || input.equals("July") || input.equals(
                "August") || input.equals("September") || input.equals(
                    "October") || input.equals("November") || input.equals(
                        "December");
    }


    private boolean countryExists(String input) {
        return input.length() == 2;
    }
}
