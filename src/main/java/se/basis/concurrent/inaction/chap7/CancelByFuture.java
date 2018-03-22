package se.basis.concurrent.inaction.chap7;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2018/1/18.
 */
public class CancelByFuture {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<String> future = service.submit(new Task());
        service.shutdown();
    }

    private static class Task implements Callable<String> {
        @Override
        public String call() {
            System.out.println("task running");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                System.out.println("task interrupted");
            }
            return "task finish";
        }
    }
}
