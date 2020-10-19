import Exceptions.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Import {
    // Sample format for the txt file to be imported

    //Customer;Name;Password
    //Employee;Name;Password;BirthYear;Address;GrossSalary
    //Game;Title;Genre;DailyRentFee
    //Album;Title;Artist;Year;DailyRentFee

    public static String importDataFromATxt(String filePath, CustomerLibrary customerLibrary, EmployeeLibrary employeeLibrary, GameLibrary gameLibrary, AlbumLibrary albumLibrary){
        try {
            File myFile = new File(filePath);
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
            StringBuilder builder = new StringBuilder();
            String line = null;
            int lineCounter=0;
            int customerCounter=0;
            int employeeCounter=0;
            int gameCounter=0;
            int albumCounter=0;
            while ((line = reader.readLine()) != null) {
                lineCounter++;
                String[] partsOfCurrentLine = line.split(";");
                if(partsOfCurrentLine[0].equalsIgnoreCase("customer")){
                    try{
                        customerLibrary.registerCustomer(partsOfCurrentLine[1],partsOfCurrentLine[2]);
                        customerCounter++;
                    }catch (EmptyNameException | EmptyPasswordException ex){
                        builder.append("Invalid input at line "+lineCounter+"\n");
                        builder.append(ex.getMessage());
                        builder.append("\n");
                    }

                }else if(partsOfCurrentLine[0].equalsIgnoreCase("employee")){
                    try{
                        employeeLibrary.registerEmployee(partsOfCurrentLine[1],partsOfCurrentLine[2],Integer.parseInt(partsOfCurrentLine[3]),partsOfCurrentLine[4], Double.parseDouble(partsOfCurrentLine[5]));
                        employeeCounter++;
                    }catch ( EmptyNameException | EmptyPasswordException | EmployeeNegativeBirthYearException | EmployeeEmptyAddressException | EmployeeNegativeSalaryException
                            ex){
                        builder.append("Invalid input at line "+lineCounter+"\n");
                        builder.append(ex.getMessage());
                        builder.append("\n");
                    }
                }else if(partsOfCurrentLine[0].equalsIgnoreCase("game")){
                    try{
                        gameLibrary.registerGame(partsOfCurrentLine[1], partsOfCurrentLine[2], Double.parseDouble(partsOfCurrentLine[3]));
                        gameCounter++;
                    }catch (EmptyNameException | NegativeRentFeeException | GameEmptyGenreException ex){
                        builder.append("Invalid input at line "+lineCounter+"\n");
                        builder.append(ex.getMessage());
                        builder.append("\n");
                    }

                }else if(partsOfCurrentLine[0].equalsIgnoreCase("album")){
                    try{
                        albumLibrary.registerAlbum(partsOfCurrentLine[1], partsOfCurrentLine[2], Integer.parseInt(partsOfCurrentLine[3]), Double.parseDouble(partsOfCurrentLine[4]));
                        albumCounter++;
                    }catch (EmptyNameException | NegativeRentFeeException | AlbumEmptyArtistException | AlbumNegativeYearException ex){
                        builder.append("Invalid input at line "+lineCounter+"\n");
                        builder.append(ex.getMessage());
                        builder.append("\n");
                    }

                }else{
                    builder.append("Invalid input at line "+lineCounter+"\n");
                }
            }
            if(customerCounter > 0){
                builder.append(customerCounter + " customers ");
            }
            if (employeeCounter > 0){
                builder.append(employeeCounter + " employees ");
            }
            if (gameCounter > 0){
                builder.append(gameCounter + " games ");
            }
            if (albumCounter > 0){
                builder.append(albumCounter + " albums ");
            }
            if(customerCounter+employeeCounter+gameCounter+albumCounter>0){
                builder.append("\nTotal: "+(customerCounter+employeeCounter+gameCounter+albumCounter)+ " records have been imported successfully");
            } else {
                builder.append("No data to import!");
            }
            reader.close();
            return builder.toString();
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }
}
