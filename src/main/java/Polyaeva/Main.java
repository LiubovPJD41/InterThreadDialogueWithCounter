package Polyaeva;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int count = 4;
        int sleepTime = 15000;
        ExecutorService executor = Executors.newFixedThreadPool(count);
        List<Future<String>> tasks = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            //MyThread myThread = new MyThread();
            String threadName = (Integer.toString(i + 1));
            Callable<String> callable = new MyThread(threadName);
            Future<String> future = executor.submit(callable);
            tasks.add(future);
        }
        for (Future fut : tasks) {
            try {
                System.out.println(fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}


//public class Main {
   // public static void main(String[] args) throws InterruptedException {
      //  int count = 4;
      //  int sleepTime = 15000;
       // ExecutorService executor = Executors.newFixedThreadPool(count);
        //List<Future<String>> tasks = new ArrayList<>();
        //for (int i = 0; i < count; i++) {
            // MyThread myThread = new MyThread();
         //   String threadName = (Integer.toString(i + 1));
         //   Callable<String> callable = new MyThread(threadName);
           // Future<String> future = executor.submit(callable);
          //  tasks.add(future);
       // }
      //  for (Future fut : tasks) {
          // try {
          //      System.out.println(fut.get());
         //   } catch (InterruptedException | ExecutionException e) {
         //       e.printStackTrace();
        //    }
      //  }
        //executor.shutdown();
       // System.out.println("Using invokeAny()");

      //  ExecutorService executorNext = Executors.newFixedThreadPool(count);
       // String result = "";
      //  List<Callable<String>> tasksNext = new ArrayList<>();
        //for (int i = 0; i < count; i++) {
            // MyThread myThread = new MyThread();
           // String threadName = (Integer.toString(i + 1));
          //  Callable<String> callable = new MyThread(threadName);
            //tasksNext.add(callable);
        //}
       // try {
           // result = executorNext.invokeAny(tasksNext);
          //  System.out.println("The fastest Thread's result: " + result);
       // } catch (InterruptedException | ExecutionException e) {
      //      e.printStackTrace();
      //  }
      //  executorNext.shutdown();
    //}
//}