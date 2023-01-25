import java.util.*;
import java.io.*;

public class MyClass implements Runnable{

    // Variables for thraeds
    private int threadNum;
    private int startNum;
    private int endNum;
    private long sumOfPrimes;
    private long primesFound;
    private LinkedList <Integer> maxList;

    // Constructor
    public MyClass(int threadNum, int startNum, int endNum, long sumOfPrimes, long primesFound)
    {
      this.threadNum = threadNum;
      this.startNum = startNum;
      this.endNum = endNum;
      this.sumOfPrimes = sumOfPrimes;
      this.primesFound = primesFound;
    }
    // Runs findPrimes
    public void run()
    {
      //System.out.println("Running..." +threadNum);
      findPrimes(startNum, endNum, sumOfPrimes);
    }

    // Implented Sieve of Eratosthenes
    public void findPrimes(int startNum, int endNum, long sumOfPrimes)
    {
      
      int n = endNum;
      boolean[] primes = new boolean[endNum + 1];
      Arrays.fill(primes, true);
      primes[0] = primes[1] = false;
      
     // Loop goes through specific range
      for (int i = 2 ; i*i <= n; i++) {
        if (primes[i]) {
            for (int j = i*2; j <= n; j += i) {
                primes[j] = false;
            }
            
        }
    }
    // Counts all the primes nums for specific range
    int count = 0;
    for (int i = startNum; i <= n; i++) {
        if (primes[i]) {
            count++;
            sumOfPrimes += i;
          
        }
    }
    // On last thread we gather maximum 10 primes using LinkedList
    if(threadNum == 8)
    {
      LinkedList<Integer> l = new LinkedList<>();
      for(int i = endNum; i >=startNum; i--)
      {
        if(primes[i])
        {
          if(l.size() < 10)
          {
            l.addFirst(i);
            continue;
          }
          else
          break;
        }
      }
      this.maxList = l;
    }
    this.sumOfPrimes = sumOfPrimes;
    this.primesFound = count;

  }
  
    public static void main(String[] args) 
    {
      // Start Timer
      long start = System.currentTimeMillis();
      long end;
       
      System.out.println("Check primes.txt");

      // Create eight threads and start them.

      // Thread 1
      MyClass m1 = new MyClass(1,1,12500000, 0,0);
      Thread my1 = new Thread(m1);
      
      // Thread 2
      MyClass m2 = new MyClass(2,12500001,25000000,0,0);
      Thread my2 = new Thread(m2);
      

      // Thread 3
      MyClass m3 = new MyClass(3,25000001, 37500000,0,0);
      Thread my3 = new Thread(m3);

      // Thread 4
      MyClass m4 = new MyClass(4,37500001, 50000000,0,0);
      Thread my4 = new Thread(m4);

      // Thread 5
      MyClass m5 = new MyClass(5, 50000001, 62500000,0,0);
      Thread my5 = new Thread(m5);
      // Thread 6
      MyClass m6 = new MyClass(6, 62500001, 75000000,0,0);
      Thread my6 = new Thread(m6);

      // Thread 7
      MyClass m7 = new MyClass(7, 75000001, 87500000,0,0);
      Thread my7 = new Thread(m7);
      
      // Thread 8
      MyClass m8 = new MyClass(8, 87500001, 100000000,0,0);
      Thread my8 = new Thread(m8);

      // Start all threads
      my1.start();
      my2.start();
      my3.start();
      my4.start();
      my5.start();
      my6.start();
      my7.start();
      my8.start();


      // After all threads finish run the rest of code, so we can time how long the program takes.
      try
      {
        my1.join();
        my2.join();
        my3.join();
        my4.join();
        my5.join();
        my6.join();
        my7.join();
        my8.join();
      }
      catch(Exception e)
      {
        System.out.println(e);
      }

      // Get total Primes and sum of Primes from all threads
      long totalPrimesFound = m1.primesFound + m2.primesFound + m3.primesFound + m4.primesFound + m5.primesFound + m6.primesFound + m7.primesFound + m8.primesFound;
      long sumOfPrimes = m1.sumOfPrimes + m2.sumOfPrimes + m3.sumOfPrimes + m4.sumOfPrimes + m5.sumOfPrimes + m6.sumOfPrimes + m7.sumOfPrimes + m8.sumOfPrimes;
      
      // Stop timer
      end = System.currentTimeMillis();
      
      // Create primes.txt and write neccessary info ot it.
      try
      {
        FileWriter w = new FileWriter("primes.txt");
        w.write("Execution Time: " + (end - start) + "ms\n");
        w.write("Total Number of Primes Found: " + totalPrimesFound + "\n");
        w.write("Sum of all Primes Found: " + sumOfPrimes + "\n");
        w.write("Top Ten Maximum Primes: " + m8.maxList.toString() + "\n");
        w.close();
      }
      catch(Exception e)
      {
        System.out.println(e);
      }

    }
  }