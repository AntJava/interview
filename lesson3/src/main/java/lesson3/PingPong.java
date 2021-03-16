package lesson3;

public class PingPong implements Runnable{

    private static String text = "ping";
    private int num = 10;
    private Object monitor = new Object();

    public void changeText(){
       if (text.equals("ping")) text = "pong";
       else text = "ping";
    }

    @Override
    public void run() {
        if ( num > 0 ) {
            for (int i = 0; i < num; i++) {
                try {
                    synchronized (monitor) {
                        System.out.println(text);
                        //System.out.println(Thread.currentThread());
                        changeText();
                        monitor.notify();
                        if (i != num - 1) monitor.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
