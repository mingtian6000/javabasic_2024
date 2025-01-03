package designPattern;

import java.util.ArrayList;
import java.util.List;

// just sim subject and subscription
public class ObserverPatternExample {
    public static void main(String[] args) {
        ConcretTopic subject = new ConcretTopic();
        ConcreteObserver observer1 = new ConcreteObserver();
        ConcreteObserver observer2 = new ConcreteObserver();

        subject.attach(observer1);
        subject.attach(observer2);

        subject.setState("状态 1");
        subject.setState("状态 2");
    }
}


interface Topic{
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObserver();
}

interface Observer{
    void update(Topic topic);
}

class ConcretTopic implements Topic{
    private List<Observer> observers = new ArrayList<>();
    private String state;
    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
    public String getState() {
        return state;
    }

// once state has set to somevalue, it will trigger notifyAll method
    public void setState(String state) {
        this.state = state;
        notifyObserver();
    }
}

class ConcreteObserver implements Observer{
    @Override
    public void update(Topic topic) {
            if (topic instanceof ConcretTopic) {
                ConcretTopic concreteSubject = (ConcretTopic) topic;
                System.out.println("Observer: Subject state changed to " + concreteSubject.getState());
            }
        }
}

