package LLD.CoffeeMachine;

import java.util.List;

public interface Coffee {
    double getPrice();
    List<Ingredient> getIngredients();
    Coffee make(List<Ingredient> ingredients);
}
