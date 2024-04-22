public class ThreadB extends Thread {
    private Semaphore semaphore;
    private StringBuilder word;

    public ThreadB(StringBuilder word, Semaphore semaphore) {
        this.word = word;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(); // Acquire the semaphore to wait for ThreadA to finish
            System.out.println("Concatenated word: " + word.toString());
            word.setLength(0); // Clear the concatenated word
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}