import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File spreadsheet = new File("KNNBigScope.csv");
        try {
            Scanner reader = new Scanner(spreadsheet);
            FileWriter fw = new FileWriter("DTResult.csv", true);
            PrintWriter pw = new PrintWriter(fw);
            reader.nextLine();

            while (reader.hasNext()) {
                int row = 1;
                String line = reader.nextLine();
                String[] info = line.split(",");
                System.out.println(line);
                if(Double.parseDouble(info[info.length-1]) > 0.52) {
                    pw.println(row + "," + line);
                }
                row++;
            }
            reader.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}