import java.util.ArrayList;

public class Account {

    String AccountName;
    ArrayList<Coffee> coffees;

    public Account (String AccountNameP,
                    ArrayList<Coffee> coffeesP) {

        this.AccountName = AccountNameP;
        this.coffees = coffeesP;

    }

    public String getAccountName() {return AccountName;}

    public ArrayList<Coffee> getCoffees() {return coffees;}
}
