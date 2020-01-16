package ProducerConsumer;

public class mainPC {

    public static void main(String[] args) {

        final Producer  p =new Producer();

        Thread t1 = new Thread(()-> {
            try {
                p.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()-> {
            try {
                p.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}
