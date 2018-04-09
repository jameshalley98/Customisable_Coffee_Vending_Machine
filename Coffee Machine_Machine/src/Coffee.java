public class Coffee {

    String name;
    String mainIngredient;
    String milkType;
    String sugarType;
    int mainAmount;
    int milkAmount;
    int sugarAmount;

    public Coffee(String nameP,
                  String mainIngredientP,
                  int mainAmountP,
                  String milkTypeP,
                  int milkAmountP,
                  String sugarTypeP,
                  int sugarAmountP) {

        this.name = nameP;
        this.mainIngredient = mainIngredientP;
        this.milkType = milkTypeP;
        this.sugarType = sugarTypeP;
        this.mainAmount = mainAmountP;
        this.milkAmount = milkAmountP;
        this.sugarAmount = sugarAmountP;

    }

    public String getName(){
        return this.name;
    }
    public String getMainIngredient(){
        return this.mainIngredient;
    }
    public String getMilkType(){
        return this.milkType;
    }
    public String getSugarType() { return sugarType; }
    public int getMainAmount() {
        return mainAmount;
    }
    public int getMilkAmount() {
        return milkAmount;
    }
    public int getSugarAmount(){
        return this.sugarAmount;
    }

}

