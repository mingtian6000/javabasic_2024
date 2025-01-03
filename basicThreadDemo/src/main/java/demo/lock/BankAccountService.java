package demo.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;
public class BankAccountService {
    private final Map<String, Double> accounts = new HashMap<>();
    private final StampedLock lock = new StampedLock();

    public double getBalanceOptimistically(String accountId) {
        long stamp = lock.tryOptimisticRead();
        double balance = accounts.get(accountId);
        if (!lock.validate(stamp)) {
            // 数据可能已被修改，重新获取悲观读锁
            stamp = lock.readLock();
            try {
                balance = accounts.get(accountId);
            } finally {
                lock.unlockRead(stamp);
            }
        }
        return balance;
    }

    public double getBalancePessimistically(String accountId) {
        long stamp = lock.readLock();
        try {
            return accounts.get(accountId);
        } finally {
            lock.unlockRead(stamp);
        }
    }

    public void updateBalance(String accountId, double newBalance) {
        long stamp = lock.writeLock();
        try {
            accounts.put(accountId, newBalance);
        } finally {
            lock.unlockWrite(stamp);
        }
    }

/*    public static void main(String[] args) {
        BankAccountService bas =  new BankAccountService();
        bas.accounts.put("123456", 120.00);
        System.out.println(bas.getBalanceOptimistically("123456"));
        System.out.println(bas.getBalancePessimistically("123456"));
        bas.updateBalance("123456", 150.20);
        System.out.println(bas.getBalanceOptimistically("123456"));
    }*/
}
