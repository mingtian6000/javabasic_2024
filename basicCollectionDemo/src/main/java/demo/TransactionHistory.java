package demo;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * this class is used to show demo of usage of ArrayDeque
 */
public class TransactionHistory {
    private ArrayDeque<String> history;
    public TransactionHistory() {
        history = new ArrayDeque<>();
    }
    public void addTransaction(String transaction) {
        history.offerLast(transaction);
    }

    public void printRecentTransactions(int count) {
        Iterator<String> items= history.descendingIterator();
        for (Iterator<String> it = items; it.hasNext(); ) {
            String transaction = it.next();
            System.out.println(transaction);
            count--;
            if (count == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        TransactionHistory transactionHistory = new TransactionHistory();
        transactionHistory.addTransaction("Deposit $1000");
        transactionHistory.addTransaction("Withdraw $500");
        transactionHistory.addTransaction("Transfer $200 to account number XXXX");
        transactionHistory.addTransaction("Payment of $50");

        transactionHistory.printRecentTransactions(3);
    }
}
