package basis.concurrent.inaction.chap6;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2018/1/16.
 */
public class MyThreadPoolExecutorTest {
    public static void main(String[] args) {
        MyThreadPoolExecutor threadPoolExecutor = new MyThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new MyThreadPoolExecutor.CallerRunsPolicy());
//        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            Task task = new Task("Task:" + i);
            threadPoolExecutor.execute(task);
        }
    }

    private static class Task implements Runnable {
        private String name;

        public Task(String name) {
            this.name = name;
        }

        public void run() {
            System.out.println(name + " start running!");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {

            }
            System.out.println(name + " end running!");
        }
    }
}
