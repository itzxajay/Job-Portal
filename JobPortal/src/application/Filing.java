package application;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Filing {
    static String filename; 
    public static void writeData(ApplicantDetails data) throws IOException{ 
        FileWriter filewriter = new FileWriter(new File(filename),true); 
        filewriter.write(data.toString()+ "\n");
        filewriter.close(); 
    }
}