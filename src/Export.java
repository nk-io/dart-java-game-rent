import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Export {

    public static void createExport(String rentHistory) {
        try {
            File export = new File("export.txt");
            if (export.createNewFile()) {
                System.out.println("Export created: " + export.getName());
            } else {
                System.out.println("Export already exists. Updating export...");
            }
            writeToFile(rentHistory);
        } catch (IOException e) {
            System.out.println("Something went wrong.");
        }
    }

    public static void writeToFile(String rentHistory){
        try {
            FileWriter writer = new FileWriter("export.txt");
            writer.write(rentHistory);
            writer.close();
        } catch (IOException e) {
            System.out.println("Something went wrong.");
        }
    }


}
