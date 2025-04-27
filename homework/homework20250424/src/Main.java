/* Возьмите за основу проект demo20250423_1 из пятого урока.
 Реализуйте перевод денег со счета на счет без взаимной блокировки (deadlock),
 используя ReentrantLock. Например, вы можете использовать timeout при оидание блокировки.
 */

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

            Account accountA = new Account(1000);
            Account accountB = new Account(1000);
            Thread t1 = new Thread(() -> {
                try {
                    if (SafeTransfer.transfer(accountA, accountB, 100, 1, TimeUnit.SECONDS)) {
                        System.out.println("Transfer A -> B successful");
                    } else {
                        System.out.println("Transfer A -> B failed (timeout)");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            Thread t2 = new Thread(() -> {
                try {
                    if (SafeTransfer.transfer(accountB, accountA, 200, 1, TimeUnit.SECONDS)) {
                        System.out.println("Transfer B -> A successful");
                    } else {
                        System.out.println("Transfer B -> A failed (timeout)");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            t1.start();
            t2.start();
        }
    }


