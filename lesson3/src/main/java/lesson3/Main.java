package lesson3;

//1. Реализовать программу, в которой два потока поочередно пишут ping и pong.
//2. Реализовать потокобезопасный счетчик с помощью интерфейса Lock.


public class Main {

    public static void main(String[] args) {
        System.out.println("Start");
        PingPong ping = new PingPong();
        new Thread(ping).start();
        new Thread(ping).start();
    }
}
