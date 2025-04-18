/*
Реализовать 2 потока:
первый поток должен выводить на экран все числа, которые делятся на 2;
второй поток должен выводить все числа которые делятся на 3;
Main должен запускать оба эти потока, засыпать на 3 секунды и завершать выполнение программы (т.е. оба потока тоже должны прекратить свою работу)

 */


public class Main {
    public static void main(String[] args) {
        Thread task2 = new Task(2,2);
        Thread task3 = new Task(3,3);

        task2.setDaemon(true);
        task3.setDaemon(true);

        task2.start();
        task3.start();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--- game over ----");

    }
}


