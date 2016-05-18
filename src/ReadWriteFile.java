import jodd.json.JsonSerializer;

import java.io.*;
import java.util.*;

/**
 * Created by tristangreeno on 4/11/16.
 */
public class ReadWriteFile extends Person {

    public static ArrayList<Person> listOfPersons = new ArrayList<>();
    private static ArrayList<String> countryNames = new ArrayList<>();
    private static ArrayList<Person> personsInCountry = new ArrayList<>();

    public static HashMap<String, ArrayList<Person>> mapOfPersonsAndName = new HashMap<>();

    static void readPeopleFile() throws FileNotFoundException {
        File file = new File("src/people.csv");

        scanPeople(file);

    }

    static public void scanPeople(File file) throws FileNotFoundException {
        Scanner personScanner = new Scanner(file);

        // skips first line
        personScanner.nextLine();

        while(personScanner.hasNext()){
            String line = personScanner.nextLine();
            String columns[] = line.split(",");
            Person person = new Person(Integer.parseInt(columns[0]), columns[1], columns[2], columns[3],
                    columns[4], columns[5]);
            if(!(countryNames.contains(columns[4]))) {
                countryNames.add(columns[4]);
            }

            listOfPersons.add(person);
        }

        Collections.sort(listOfPersons);

        for (String countryName : countryNames) {
            for (Person p : listOfPersons) {
                if (countryName.equals(p.country)) {
                    personsInCountry.add(p);
                }
            }

            mapOfPersonsAndName.put(countryName, personsInCountry);
        }
    }

    static public void writeToJson() throws IOException {
        JsonSerializer js = new JsonSerializer();
        File personsFile = new File("src/people.json");
        FileWriter fw = new FileWriter(personsFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        for(String c : countryNames) {
            String personJson = js.include("*").serialize(mapOfPersonsAndName.get(c));
            bw.write(personJson);
        }

        System.out.println(mapOfPersonsAndName.toString());

        System.out.println("JSON file created.");
        bw.close();
    }

}
