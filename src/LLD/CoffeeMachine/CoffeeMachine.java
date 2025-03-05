package LLD.CoffeeMachine;

import java.util.List;
import java.util.Map;

public class CoffeeMachine {

    private Map<CoffeeType, List<Ingredient>> recipes;
    private List<Ingredient> listOfIngredientsAvailable;

    public CoffeeMachine(){
        recipes = Map.of(
                CoffeeType.LATTE, new Latte().getIngredients(),
                CoffeeType.ESPRESSO, new Latte().getIngredients(),
                CoffeeType.CAPPUCCINO, new Latte().getIngredients()
        );

        listOfIngredientsAvailable = List.of(
                new Ingredient("Beans", 20),
                new Ingredient("Milk", 20)
        );
    }

    // NOTE: returns null if not possible
    public Coffee placeOrder(CoffeeType coffeeType){
        Coffee brewedCoffee;
        if(coffeeType == CoffeeType.LATTE){
            brewedCoffee = new Latte().make(listOfIngredientsAvailable);
            if(brewedCoffee != null){
                this.removeIngredients(coffeeType);
            }
        }else if(coffeeType == CoffeeType.ESPRESSO){
            brewedCoffee = new Espresso().make(listOfIngredientsAvailable);
            if(brewedCoffee != null){
                this.removeIngredients(coffeeType);
            }
        }else{
            brewedCoffee = new Cappuccino().make(listOfIngredientsAvailable);
            if(brewedCoffee != null){
                this.removeIngredients(coffeeType);
            }
        }

        return brewedCoffee;
    }

    public List<Ingredient> checkIngredients(){
        return this.listOfIngredientsAvailable;
    }

    public void fillIngredients(List<Ingredient> moreIngredients){
        for(Ingredient i : this.listOfIngredientsAvailable){
            for(Ingredient j : moreIngredients){
                if(i.getName().equals(j.getName())){
                    i.setAmount(i.getAmount() + j.getAmount());
                }
            }
        }
    }

    public void removeIngredients(CoffeeType coffeeType){
        List<Ingredient> coffeeIngredients = recipes.get(coffeeType);
        for(Ingredient i : this.listOfIngredientsAvailable){
            for(Ingredient j : coffeeIngredients){
                if(i.getName().equals(j.getName())){
                    i.setAmount(i.getAmount() - j.getAmount());
                }
            }
        }
    }

}
