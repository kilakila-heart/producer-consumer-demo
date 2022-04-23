import java.util.concurrent.BlockingQueue;

//消费者
public class Consumer implements Runnable {
    private final BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int info;
        for (int i = 0; i < 10; i++) {
            try {
                info = blockingQueue.take();
                System.out.println("吃面包，编号为" + info);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
