package demo.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class AkkaExample {
    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("GreetingSystem");
        ActorRef greetingActor = actorSystem.actorOf(GreetingActor.props(), "greetingActor");
        greetingActor.tell("Alice", ActorRef.noSender());
        actorSystem.terminate();
    }
}
