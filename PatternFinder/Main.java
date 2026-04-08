import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File spreadsheet = new File("RFScope(0-100).csv"); // replace the text within the "" with the file you want to obtain the data from
        try {
            Scanner reader = new Scanner(spreadsheet);
            FileWriter fw = new FileWriter("RFResult.csv", true); // replace the text within the "" with the file that you want the found values be stored in
            PrintWriter pw = new PrintWriter(fw);
            reader.nextLine();

            int row = 1;
            while (reader.hasNext()) {
                String line = reader.nextLine();
                String[] info = line.split(",");
                System.out.println(line);
                if(Double.parseDouble(info[info.length-1]) >= 0.52) {
                    pw.println(row + "," + line);
                }
                row ++;
            }
            pw.flush();
            pw.close();
            fw.close();
            reader.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}