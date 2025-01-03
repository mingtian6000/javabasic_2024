package designPattern;

public class DecoratorExample {
    public static void main(String[] args) {
        Coffee cf = new Coffee();
        System.out.println("original cost is : " + cf.cost());
        MilkDecorator coffeeWithMilk = new MilkDecorator(cf);
        System.out.println("coffee with milk is : "+coffeeWithMilk.cost());
        SugarDecorator coffeeWithSugar = new SugarDecorator(cf);
        System.out.println("coffee with sugar is : "+coffeeWithSugar.cost());
    }
}

class Coffee{
    int cost(){
        return 5;
    }
}

class CoffeeDecorator extends Coffee{
    Coffee coffee;
    CoffeeDecorator(Coffee coffee){
        this.coffee= coffee;
    }
    int cost(){
        return coffee.cost();
    }
}
class MilkDecorator extends CoffeeDecorator{

    MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    int cost(){
        return coffee.cost()+2;
    }
}
class SugarDecorator extends CoffeeDecorator{

    SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    int cost(){
        return coffee.cost()+1;
    }
}