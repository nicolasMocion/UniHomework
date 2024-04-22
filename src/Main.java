public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        StringBuilder word = new StringBuilder();

        long endTime = System.currentTimeMillis() + 20000;

        while (System.currentTimeMillis() < endTime) {
            ThreadA threadA = new ThreadA(word, semaphore);
            ThreadB threadB = new ThreadB(word, semaphore);

            threadA.start();
            threadA.join();

            threadB.start();
            threadB.join();
        }
    }
}