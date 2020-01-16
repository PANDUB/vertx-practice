package ProducerConsumer;

import java.util.ArrayList;
import java.util.List;

public class Producer  {

    private List l1;
    private int max;

   public  Producer()
    {
        this.l1=new ArrayList();
        this.max=2;
    }

public void produce() throws InterruptedException {
    int value = 0;
    while(true) {
        synchronized (this) {

            if (l1.size() == max) {
                wait();
            }
            System.out.println("producer" + value);
            l1.add(value++);
            notify();
        }
    }

 }
    public void consume() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                if (l1.size() == 0) {
                    wait();
                }
                System.out.println("consumer" + value);
                l1.remove(value);
                notify();
            }

        }
    }
}
