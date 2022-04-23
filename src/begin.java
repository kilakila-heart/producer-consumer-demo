import java.util.concurrent.*;

public class begin {
    public static void main(String[] args) {
        SynchronousQueue synchronousQueue = new SynchronousQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 60, TimeUnit.MILLISECONDS, synchronousQueue);
        BlockingQueue<Integer> eatPq = new LinkedBlockingDeque<>(1);
        Producer producer = new Producer(eatPq);
        Consumer consumer = new Consumer(eatPq);
        threadPoolExecutor.execute(producer);
        threadPoolExecutor.execute(consumer);
        System.out.println("今天放假了！");//这一句顺序可能打乱
    }
}
