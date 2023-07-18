import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Letters implements Iterable<Thread>{
    List<Thread> threads = new ArrayList<>();
    Letters(String string){
        char[] letters = string.toCharArray();
        for (char letter:
             letters) {
            threads.add(new Thread(()->{
                while (true){
                    System.out.print(letter);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }));
        }
    }
    public void start(){
        for (Thread thread :
                threads) {
            thread.start();
        }
    }

    public void stop(){
        for (Thread thread:
             threads) {
            thread.interrupt();
        }
    }

    @Override
    public Iterator<Thread> iterator() {
        return threads.iterator();
    }
}
