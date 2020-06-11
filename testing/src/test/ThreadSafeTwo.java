package test;

public class ThreadSafeTwo implements Runnable {
    //静态变量，所有对象共享
    private static int count = 0;

    @Override
    public  synchronized void run() {
        //这里对线程体进行同步

            for (int i = 0; i < 100; i++) {
                count();
            }
        }


    public  void count() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeTwo threadSafe = new ThreadSafeTwo();
        Thread thread1 = new Thread(threadSafe);
        Thread thread2 = new Thread(threadSafe);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);
    }
}