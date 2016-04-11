import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by tristangreeno on 4/11/16.
 */
public class ReadWriteFileTest {
    @Test
    public void readPeopleFile() throws Exception {

        File file = new File("src/people.csv");
        ReadWriteFile.scanPeople(file);

        assertNotNull("Failure - null values", ReadWriteFile.listOfPersons);
    }

    @Test
    public void writeToJson() throws Exception {
        Integer temp = 23;
        Person person = new Person(temp, "A", "B", "C", "D", "E");

        assertEquals("Failure - information written incorrectly", person.country, "D");
        assertEquals("Failure - information written incorrectly", person.country, "X");
    }

}