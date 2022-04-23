import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> eatPq = new LinkedBlockingDeque<>(1);
        Producer producer = new Producer(eatPq);
        Consumer consumer = new Consumer(eatPq);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }
}
