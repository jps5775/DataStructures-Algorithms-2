package LLD.CoffeeMachine;

public class Demo {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        Coffee freshCoffee = coffeeMachine.placeOrder(CoffeeType.ESPRESSO);
        Coffee freshCoffee2 = coffeeMachine.placeOrder(CoffeeType.CAPPUCCINO);
        Coffee freshCoffee3 = coffeeMachine.placeOrder(CoffeeType.LATTE);

    }
}
