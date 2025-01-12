package demo.queue;

import java.util.PriorityQueue;
import java.util.UUID;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Message> queue = new PriorityQueue<>();
        Message msg1 = new Message(170000001L, "{'data': 'first message'}", "7acadc92-8509-405e-b3fa-412f3ef910f3", 1, "router1");
        Message msg2 = new Message(170000159L, "{'data': 'second message'}", "519b0266-c5f4-4d89-b4c1-8c68651d939f", 1, "router2");
        Message msg3 = new Message(170000132L, "{'data': 'third message'}","c0894f03-3cc7-4668-a591-03ef38f3f198", 1, "adapter1");

        queue.offer(msg1);
        queue.offer(msg2);
        queue.offer(msg3);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
