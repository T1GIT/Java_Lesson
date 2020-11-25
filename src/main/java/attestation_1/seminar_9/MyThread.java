package attestation_1.seminar_9;

public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            sleep(100);
        } catch (InterruptedException ignored) { }
        interrupt();
    }

    public static void main(String[] args) {
        Thread thread = new MyThread();
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try { thread.join(); }
        catch (InterruptedException ignored) { }
        thread.interrupt();
        System.out.println(thread.getState());
    }

}