import javax.swing.*;
import java.awt.*;

public class ThreadA extends Thread {
    private Semaphore semaphore;
    private StringBuilder word;
    public ThreadA(StringBuilder word,Semaphore semaphore) {
        this.semaphore = semaphore;
        this.word = word;
    }

    @Override
    public void run() {
        long endTime = System.currentTimeMillis() + 6000;
        String word2 = JOptionPane.showInputDialog("Ingrese un dato");

        while (System.currentTimeMillis() < endTime) {
            word.append(word2);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        semaphore.release(); // Release the semaphore to allow ThreadB to proceed
    }

}