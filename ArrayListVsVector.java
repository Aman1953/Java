
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class ArrayListVsVector {
    public static void main(String[] args) throws InterruptedException {

        int size = 1000000;

        //ArrayList
        List<Integer> arrayList = new ArrayList<>();
        long start = System.currentTimeMillis(); // gives current time in milliseconds
        for (int i = 0; i <size ; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("\nAdded "+size+" elements to ArrayList in "+(end-start)+" ms\n");

        // Vector
        List<Integer> vector = new Vector<>();
         start = System.currentTimeMillis();
        for (int i = 0; i <size ; i++) {
            vector.add(i);
        }
         end = System.currentTimeMillis();
        System.out.println("Added "+size+" elements to Vector in "+(end-start)+" ms");

        // Multithreading in ArrayList
        List<Integer> multiThreadList = Collections.synchronizedList(new ArrayList<>());
//      List<Integer> multiThreadList = new ArrayList<>();
        start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i <size ; i++) {
                multiThreadList.add(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i <size ; i++) {
                multiThreadList.add(i);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        end = System.currentTimeMillis();
        System.out.println("\nAdded elements in multithreaded way to Arraylist in "+(end-start)+" ms");
        System.out.println("Size of multithreaded ArrayList is : "+multiThreadList.size());


        // Multithreading in Vector
        List<Integer> multiThreadVector = new Vector<>();
        start = System.currentTimeMillis();
         t1 = new Thread(() -> {
            for (int i = 0; i <size ; i++) {
                multiThreadVector.add(i);
            }
        });
         t2 = new Thread(() -> {
            for (int i = 0; i <size ; i++) {
                multiThreadVector.add(i);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        end = System.currentTimeMillis();
        System.out.println("\nAdded elements in multithreaded way to Vector in "+(end-start)+" ms");
        System.out.println("Size of multithreaded Vector is : "+multiThreadVector.size());


    }
}
