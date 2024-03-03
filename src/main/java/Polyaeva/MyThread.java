package Polyaeva;

import java.util.Random;
import java.util.concurrent.Callable;

class MyThread extends Thread implements Callable <String> {
    private final int maximum = 3;
    private final int  minimum = 1;
    public MyThread(String name){
        super(name);
    }

    @Override
    public String call() {
        int counter = 0;
        Random rn = new Random();
        int x = rn.nextInt(maximum - minimum + 1) + minimum;
        try {
            while(counter!=x) {
                Thread.sleep(2500);
                //   System.out.println("Всем привет!");
                System.out.printf("I am %s. Hello everybody!\n", getName());
                counter++;
            }
        } catch (InterruptedException err) {

        } finally{
            System.out.printf("%s завершен\n", getName());
        }
        StringBuilder finalMessage = new StringBuilder();
        finalMessage.append("Thread No.");
        finalMessage.append(getName());
        finalMessage.append(" executed ");
        finalMessage.append(String.valueOf(counter));
        finalMessage.append(" times");

        return finalMessage.toString();
    }
}

