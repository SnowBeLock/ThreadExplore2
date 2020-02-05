package edu.jcourse;

import java.util.ArrayList;
import java.util.List;

public class Main {
private static int counter=0;
    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            count();
           Thread t=new Thread(Main::count);
           threads.add(t);
           t.start();
        }
        for (Thread t :threads
                ) {t.join();
        }
        System.out.println(counter);
    }
    private static void count(){

        for (int i = 0; i <1_000_000 ; i++) {
            inc();
        }
    }
    private static synchronized void inc(){   //sync your time 1 thread= 1 time | 2nd thread = 2 time (!||)
        counter++;
    }
}
