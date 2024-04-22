import javax.swing.*;

public class ThreadManager implements Runnable{

    boolean runHilo;

    ThreadManager H1 = new ThreadManager();

    ThreadManager H2 = new ThreadManager();
    Thread hiloN1 = new Thread(H1);
    
    Thread hiloN2 = new Thread(H2);
    
    String kotoba = "";

    Semaphore semaphore = new Semaphore(1);

    @Override
    public void run() {

        Thread current = Thread.currentThread();

        if (current == hiloN1){

            kotoba = JOptionPane.showInputDialog("Ingrese un dato");

            long tac = System.currentTimeMillis();
            long tf = tac + 6000;

            while(System.currentTimeMillis() < tf){

                kotoba= kotoba + kotoba;
                System.out.println("Executing 1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }

        if(current == hiloN2){

            System.out.println(kotoba);
            System.out.println("Borrado");
            kotoba = "";

        }

    }
    
    private void execute1(){

        kotoba = JOptionPane.showInputDialog("Ingrese un dato");

        long tac = System.currentTimeMillis();
        long tf = tac + 6000;

        while(System.currentTimeMillis() < tf){

            kotoba= kotoba + kotoba;
            System.out.println("Executing 1");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        
    }

    private void execute2(){

        System.out.println(kotoba);
        System.out.println("Borrado");
        kotoba = "";

    }

    public void start1() {

        this.runHilo = true;

        hiloN1 = new Thread(this);
        hiloN1.start();

    }

    public void start2() {

        this.runHilo = true;
        hiloN2 = new Thread(this);
        hiloN2.start();
    }

}
