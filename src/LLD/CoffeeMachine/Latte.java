package LLD.CoffeeMachine;

import java.util.List;

public class Latte implements Coffee{

    private final double price = 1.50;
    private final List<Ingredient> ingredients = List.of(new Ingredient("Milk", 2), new Ingredient("Beans", 4));

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public Coffee make(List<Ingredient> ingredients) {
        for(Ingredient i : ingredients){
            boolean foundAndEnough = false;
            for(Ingredient j : this.ingredients){
                if(i.getName().equals(j.getName()) && i.getAmount() >= j.getAmount()){
                    foundAndEnough = true;
                    break;
                }
            }

            if(!foundAndEnough){ return null; }
        }

        return new Latte();
    }
}
