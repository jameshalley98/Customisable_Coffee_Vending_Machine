import java.io.*;
import java.util.ArrayList;

public class Store_Account_Data {

    private static String FILE_PATH = "src/accounts/";
    private static String FILE_EXTENSION = ".txt";

    public static void main(String[] args) {

        Coffee coffee1 = new Coffee("testing1","chai",2,"skim",2,"sweetener",1);
        Coffee coffee2 = new Coffee("testing2","coffee",1,"milk",1,"sugar",2);

        ArrayList<Coffee> coffeeList = new ArrayList<>();
        coffeeList.add(coffee1);
        coffeeList.add(coffee2);

        makeFile("Test");

        addCoffeeToAccount(coffee1,"Test");

    }

//next to add, feature to remove specific coffee from account

    public static boolean checkIfAccountExists (String filePath) {
        File test = new File(filePath);
        return test.exists();
    }

    //Make sure the coffee names aren't already in the account file

    public static String[] readLinesOfFile (String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            ArrayList<String> lines = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            String line = br.readLine();

            while (!(line == null)) {
                lines.add(line);
                line = br.readLine();
            }

            String[] output = lines.toArray(new String[lines.size()]);

            return output;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String[] getNamesOfCoffees (String[] lines) {

        ArrayList<String> coffeeNames = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals("")) {
                coffeeNames.add(lines[i+1]);
            }
        }

        String[] output = coffeeNames.toArray(new String[coffeeNames.size()]);

        return output;
    }



    //Saving the file

    public static boolean onlyNewCoffees (Coffee newCoffee, String accountName) {

        String[] listOfCoffeeNames = getNamesOfCoffees(readLinesOfFile(FILE_PATH + accountName + FILE_EXTENSION));

        for (String name : listOfCoffeeNames) {
            if (newCoffee.getName().equals(name)) {
                return false;
            }
        }

        return true;

    }

    public static void makeFile (String accountName) {

         if (!checkIfAccountExists(FILE_PATH + accountName + FILE_EXTENSION)) {
             try (FileWriter fWriter = new FileWriter(FILE_PATH + accountName + FILE_EXTENSION,false)) {
                 PrintWriter pWriter = new PrintWriter(fWriter);

                 pWriter.println(accountName);
                 pWriter.println("##Coffees##");

                 pWriter.close();

                 System.out.println("New template file successfully made. Can be found: " + FILE_PATH + accountName + FILE_EXTENSION);

             } catch (IOException e) {
                 e.printStackTrace();
             }
         } else {
             System.out.println("File already exists. Found at: " + FILE_PATH + accountName + FILE_EXTENSION);
         }
    }

    public static void addCoffeeToAccount (Coffee c, String accountName) {

        if (onlyNewCoffees(c,accountName)) {
            try (FileWriter fWriter = new FileWriter(FILE_PATH + accountName + FILE_EXTENSION,true)) {
                PrintWriter pWriter = new PrintWriter(fWriter);

                pWriter.println("");
                pWriter.println(c.getName());
                pWriter.println(c.getMainIngredient() + "-" + c.getMainAmount());
                pWriter.println(c.getMilkType() + "-" + c.getMilkAmount());
                pWriter.println(c.getSugarType() + "-" + c.getSugarAmount());
                pWriter.println("END");

                pWriter.close();

                System.out.println("Successfully added coffee " + c.getName() + " to account name " + accountName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error. Coffee name is already taken");
        }

    }

}
