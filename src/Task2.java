import java.util.*;

public class Task2 implements Runnable{
    char letter;
    boolean suspended;
    Task2(char c){
        letter = c;
        suspended = true;
    }
    public void stop(){
        suspended = true;
    }
    public void resume(){
        suspended = false;
        synchronized (this){
            notify();
        }
    }
    @Override
    public void run() {
        Random random = new Random();
        while (true){
            synchronized (this){
                while (suspended){
                    try {
                        wait();
                    }catch (InterruptedException ignore){

                    }
                }
            }
            System.out.print(letter);
            try {
                Thread.sleep(random.nextInt(901)+100);
            }catch (InterruptedException ignore){

            }
        }
    }
}
