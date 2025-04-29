import java.util.concurrent.TimeUnit;


public class SafeTransfer {

    public static boolean transfer(Account from, Account to, int amount, long timeout, TimeUnit unit) throws InterruptedException {
        long stopTime = System.nanoTime() + unit.toNanos(timeout);
        while (System.nanoTime() < stopTime) {
            if (from.getLock().tryLock(timeout, unit)) {
                try {
                    if (to.getLock().tryLock(timeout, unit)) {
                        try {
                            if (from.withdraw(amount)) {
                                to.deposit(amount);
                                return true;
                            } else {
                                return false;
                            }
                        } finally {
                            to.getLock().unlock();
                        }
                    }
                } finally {
                    from.getLock().unlock();
                }
            }
            // Avoid tight loop, small pause
            Thread.sleep(10);
        }
        return false;
    }
}
