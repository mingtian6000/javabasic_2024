package demo.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class GreetingActor extends AbstractActor {

    public static Props props() {
        return Props.create(GreetingActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, this::onReceiveGreeting)
                .build();
    }

    private void onReceiveGreeting(String name) {
        String greeting = "Hello, " + name + "!";
        System.out.println(greeting);
        // Send a response if needed
    }
}