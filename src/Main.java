
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Starting to read and write people files...");

        ReadWriteFile.readPeopleFile();
        ReadWriteFile.writeToJson();

        System.out.println("File created and program is finished.");
    }
}
