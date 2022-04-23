import java.util.Random;
import java.util.concurrent.BlockingQueue;

//生产者
public class Producer implements Runnable {
    private final BlockingQueue<Integer> blockingQueue;
    private Random random;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int info = random.nextInt(100);
            try {
                blockingQueue.put(info);
                System.out.println("生产面包，编号为" + info);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
