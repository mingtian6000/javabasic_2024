package designPattern;

interface Product {
    void doSomething();
}

class ConcreteProductA implements Product {
    @Override
    public void doSomething() {
        System.out.println("ConcreteProductA do something.");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void doSomething() {
        System.out.println("ConcreteProductB do something.");
    }
}


class ProductFactory {
    public static Product createProduct(String type) {
        if (type.equals("A")) {
            return new ConcreteProductA();
        } else if (type.equals("B")) {
            return new ConcreteProductB();
        } else {
            System.out.println("invalid product type.");
        }
        return null;
    }
}

// 使用示例
public class FactoryPatternExample {
    public static void main(String[] args) {
        Product productA = ProductFactory.createProduct("A");
        productA.doSomething();

        Product productB = ProductFactory.createProduct("B");
        productB.doSomething();
    }
}