package test;

/**
 * @author pengwei
 * @date 2020/5/13
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
