public class Semaphore {
    private int permits;

    public Semaphore(int permits) {  // The permits are declared at the main, or the class where the multithreading is needed
        this.permits = permits;
    }

    public synchronized void acquire() throws InterruptedException {
        while (permits == 0) {
            wait(); // The upcoming thread is stuck until the semaphore lets it through
        }
        permits--; // Decrement the number of permits
    }

    public synchronized void release() {
        permits++; // Increment the number of permits
        notify(); // Notify waiting threads that permits are available
    }
}