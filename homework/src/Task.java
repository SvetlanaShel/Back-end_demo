public class Task extends Thread {

    private final int factor;
    private final int start;

    public Task(int factor, int start) {
        this.factor = factor;
        this.start = start;

    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = start; true; i += factor) {
            System.out.println(name + " на " + factor + ": " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
