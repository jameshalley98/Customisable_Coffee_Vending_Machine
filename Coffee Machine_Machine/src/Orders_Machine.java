import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Orders_Machine {

    public static final String FILE_PATH = "src/Processinng_Accounts/accounts/";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the coffee you would like to order");
        String input = scanner.nextLine();

        Coffee coffee = constructCoffee(input,retrieveFile("Bob"));

        if (!(coffee == null)) {
            System.out.println("Name: " + coffee.getName() + " Main Ingredient: " + coffee.getMainIngredient() + " " + coffee.getMainAmount() + " Milk: " + coffee.getMilkType() + " " + coffee.getMilkAmount() + " Sugar: " + coffee.getSugarType() + " " + coffee.getSugarAmount());
        } else {
            System.out.println("Coffee not found");
        }

    }

    public static List<String> retrieveFile(String accountName) {

        List<String> data = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH + accountName + ".txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() > 1) {
                    data.add(line);
                }
            }

        } catch (IOException e){
            System.out.println("File not found. Error rF001");
            e.printStackTrace();
        }

        return data;

    }

    public static Coffee constructCoffee(String coffeeName, List<String> inputData) {

        int memNum = -1;
        for (int i = 1; i < inputData.size(); i ++) {
            if (inputData.get(i).replace("\n", "").replace("\r", "").equals(coffeeName)) {
                memNum = i;
                break;
            }
        }

        System.out.println(inputData);

        if (memNum == -1) {
            return null;
        }

        Coffee makeCoffee = new Coffee(inputData.get(memNum),
                splitIngAndNum(inputData.get(memNum + 1),0),
                Integer.parseInt(splitIngAndNum(inputData.get(memNum + 1),1)),
                splitIngAndNum(inputData.get(memNum + 2),0),
                Integer.parseInt(splitIngAndNum(inputData.get(memNum + 2),1)),
                splitIngAndNum(inputData.get(memNum + 3),0),
                Integer.parseInt(splitIngAndNum(inputData.get(memNum + 3),1)));

        return makeCoffee;

    }

    public static String splitIngAndNum(String toSplit, int wanted) {
        String[] splitStr = toSplit.split("-");
        return splitStr[wanted];
    }

}
