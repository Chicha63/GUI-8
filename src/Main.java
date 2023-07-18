import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Task2> threads = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            threads.add(new Task2(c));
        }

        int currentIndex = 0;
        for (int i = 0; i < threads.size(); i++) {
            Thread thread = new Thread(threads.get(i));
            thread.start();
            if (i != 0) {
                threads.get(i).stop();
            }
        }

        int numCycles = 10;
        for (int i = 0; i < numCycles; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threads.get(currentIndex).stop();
            currentIndex = (currentIndex + 1) % threads.size();
            threads.get(currentIndex).resume();
        }

        for (Task2 thread : threads) {
            System.out.println("Thread " + thread.letter + " is exiting.");
            thread.stop();
        }
    }
}