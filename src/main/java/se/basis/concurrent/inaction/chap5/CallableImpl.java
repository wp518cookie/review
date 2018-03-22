package se.basis.concurrent.inaction.chap5;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/1/12.
 */
public class CallableImpl implements Callable<String> {
    private String content;

    public CallableImpl(String content) {
        this.content = content;
    }

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(3);
        return content;
    }

    public static void main(String[] args) throws Exception {
        Callable<String> test = new CallableImpl("hello world!");
        FutureTask<String> task = new FutureTask(test);
        new Thread(task).start();
        String result = task.get();
        System.out.println(result);
    }
}
