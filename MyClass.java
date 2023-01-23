import java.util.*;
import java.io.*;

public class MyClass implements Runnable{

    private int threadNum;
    private int startNum;
    private int endNum;
    public MyClass(int threadNum, int startNum, int endNum)
    {
      this.threadNum = threadNum;
      this.startNum = startNum;
      this.endNum = endNum;
    }
    public void run()
    {
      System.out.println("Running..." +threadNum);
      findPrimes(startNum, endNum);
    }

    public void findPrimes(int startNum, int endNum)
    {
      int n = endNum;
      int number_of_integers = Math.max(startNum, endNum) - Math.min(startNum, endNum) + 1;
      boolean[] primes = new boolean[endNum + 1];
      Arrays.fill(primes, true);
      primes[0] = primes[1] = false;
      
      // if(startNum == 0)
      //   startNum = 2;
      for (int i = 2 ; i*i <= n; i++) {
        if (primes[i]) {
            for (int j = i*2; j <= n; j += i) {
                primes[j] = false;
            }
            //System.out.println(i + " ");
        }
    }
    int count = 0;
    for (int i = startNum; i <= n; i++) {
        if (primes[i]) {
            count++;
            //System.out.println(i + " ");
        }
    }
    System.out.println("Number of prime numbers between 1 and " + endNum + ": " + count);
  }
    // long start_number = 1;
    // long end_number = 100000000;
    // int n = (int)(100000000);
    // boolean[] primes = new boolean[n+1];
    // Arrays.fill(primes, true);
    // primes[0] = false;
    // int index = 0;
    // for (long i = 2; i*i <= end_number; i++) {
    //     if (primes[index]) {
    //         for (long j = Math.max(i*i, (start_number/i)*i); j <= end_number; j += i) {
    //             if (j >= start_number){
    //                 primes[(int)(j - start_number)] = false;
    //             }
    //         }
    //     }
    //     index++;
    // }
    // int count = 0;
    // for (int i = 0; i <= n; i++) {
    //     if (primes[i]) {
    //         count++;
    //     }
    // }
    // System.out.println("Number of prime numbers between " + start_number + " and " + end_number + ": " + count);

    // }

    public static void main(String[] args) 
    {

      long start = System.currentTimeMillis();
      int totalPrimesFound = 0;
      int sumOfPrimes = 0;
      try
      {
        FileWriter w = new FileWriter("primes.txt");
        w.write("Execution Time: \n");
        w.write("Total Number of Primes Found: \n");
        w.write("Sum of all Primes Found: \n");
        w.write("Top Ten Maximum Primes: \n");
        w.close();
      }
      catch(Exception e)
      {
        System.out.println(e);
      }
      
      long start_number = 120000001;
      long end_number = 25000000;
      long number_of_integers;
      if(start_number <= end_number){
          number_of_integers = end_number - start_number + 1;
          System.out.println("Number of integers between " + start_number + " and " + end_number + ": " + number_of_integers);
      }
      else{
          number_of_integers = start_number - end_number + 1;
          System.out.println("Number of integers between " + end_number + " and " + start_number + ": " + number_of_integers);
      }
      
      System.out.println("Hello World, Java app" + number_of_integers );
      // Thread 1
      MyClass m1 = new MyClass(1,1,12500000);
      Thread my1 = new Thread(m1);
      my1.start();

      // Thread 2
      // MyClass m2 = new MyClass(2,1200000,25000000);
      // Thread my2 = new Thread(m2);
      // my2.start();

      // // Thread 3
      // MyClass m3 = new MyClass(3,25000001, 37500000);
      // Thread my3 = new Thread(m3);
      // my3.start();

      // // Thread 4
      // MyClass m4 = new MyClass(4,37500001, 50000000);
      // Thread my4 = new Thread(m4);
      // my4.start();

      // // Thread 5
      // MyClass m5 = new MyClass(5, 50000001, 62500000);
      // Thread my5 = new Thread(m5);
      // my5.start();

      // // Thread 6
      // MyClass m6 = new MyClass(6, 62500001, 75000000);
      // Thread my6 = new Thread(m6);
      // my6.start();

      // // Thread 7
      // MyClass m7 = new MyClass(7, 75000001, 87500000);
      // Thread my7 = new Thread(m7);
      // my7.start();

      // // Thread 8
      // MyClass m8 = new MyClass(8, 87500001, 100000000);
      // Thread my8 = new Thread(m8);
      // my8.start();


      long end = System.currentTimeMillis();
      System.out.println("Program Finished in: " + (end - start) + "ms");

      
    }
  }