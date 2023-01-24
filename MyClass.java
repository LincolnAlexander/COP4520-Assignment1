import java.util.*;
import java.io.*;

public class MyClass implements Runnable{

    private int threadNum;
    private int startNum;
    private int endNum;
    private long sumOfPrimes;
    private long primesFound;
    private ArrayList <Integer> maxList;
    public MyClass(int threadNum, int startNum, int endNum, long sumOfPrimes, long primesFound)
    {
      this.threadNum = threadNum;
      this.startNum = startNum;
      this.endNum = endNum;
      this.sumOfPrimes = sumOfPrimes;
      this.primesFound = primesFound;
    }
    public void run()
    {
      //System.out.println("Running..." +threadNum);
      findPrimes(startNum, endNum, sumOfPrimes);
    }

    public void findPrimes(int startNum, int endNum, long sumOfPrimes)
    {
      int n = endNum;
      boolean[] primes = new boolean[endNum + 1];
      Arrays.fill(primes, true);
      primes[0] = primes[1] = false;
      
     
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
            sumOfPrimes += i;
            //System.out.println(i + " ");
        }
    }

    if(threadNum == 8)
    {
      ArrayList<Integer> l = new ArrayList<>();
      for(int i = startNum; i <=n; i++)
      {
        if(primes[i])
        {
          if(l.size() < 10)
          {
            l.add(i);
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
    //System.out.println("Number of prime numbers between "+ startNum +" and " + endNum + "Primes Found: " + count + " sum of primes " + sumOfPrimes);
  }
  
    public static void main(String[] args) 
    {

      long start = System.currentTimeMillis();
      long end;
       
      System.out.println("Hello World, Java app");
      // Thread 1
      MyClass m1 = new MyClass(1,1,12500000, 0,0);
      Thread my1 = new Thread(m1);
      my1.start();
      
      // Thread 2
      MyClass m2 = new MyClass(2,12500001,25000000,0,0);
      Thread my2 = new Thread(m2);
      my2.start();

      // // Thread 3
      MyClass m3 = new MyClass(3,25000001, 37500000,0,0);
      Thread my3 = new Thread(m3);
      my3.start();

      // // Thread 4
      MyClass m4 = new MyClass(4,37500001, 50000000,0,0);
      Thread my4 = new Thread(m4);
      my4.start();

      // // Thread 5
      MyClass m5 = new MyClass(5, 50000001, 62500000,0,0);
      Thread my5 = new Thread(m5);
      my5.start();

      // // Thread 6
      MyClass m6 = new MyClass(6, 62500001, 75000000,0,0);
      Thread my6 = new Thread(m6);
      my6.start();

      // // Thread 7
      MyClass m7 = new MyClass(7, 75000001, 87500000,0,0);
      Thread my7 = new Thread(m7);
      my7.start();
      
      // // Thread 8
      MyClass m8 = new MyClass(8, 87500001, 100000000,0,0);
      Thread my8 = new Thread(m8);
      my8.start();

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


      long totalPrimesFound = m1.primesFound + m2.primesFound + m3.primesFound + m4.primesFound + m5.primesFound + m6.primesFound + m7.primesFound + m8.primesFound;
      long sumOfPrimes = m1.sumOfPrimes + m2.sumOfPrimes + m3.sumOfPrimes + m4.sumOfPrimes + m5.sumOfPrimes + m6.sumOfPrimes + m7.sumOfPrimes + m8.sumOfPrimes;
      
      end = System.currentTimeMillis();
      // System.out.println("Program Finished in: " + (end - start) + "ms");
      // System.out.println(m8.maxList.toString());
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