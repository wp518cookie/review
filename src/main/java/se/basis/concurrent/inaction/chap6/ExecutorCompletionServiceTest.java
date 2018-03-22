package se.basis.concurrent.inaction.chap6;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2018/1/17.
 */
public class ExecutorCompletionServiceTest {
    public static void main(String[] args) throws Exception {
        Executor exec = Executors.newFixedThreadPool(5);
        CompletionService<String> service = new ExecutorCompletionService(exec);
        for (int i = 0; i < 10; i++) {
            service.submit(new Task(i + ""));
        }
        while (true) {
            System.out.println(service.take().get());
        }
    }

    private static class Task implements Callable<String> {
        private String name;

        public Task(String name) {
            this.name = name;
        }

        public String call() throws Exception {
            System.out.println("task: " + name + " start running");
            TimeUnit.SECONDS.sleep(2);
            return "task: " + name + " finish";
        }
    }
}
