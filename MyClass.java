public class MyClass implements Runnable{

    private int threadNum;
    public MyClass(int threadNum)
    {
      this.threadNum = threadNum;
    }
    public void run()
    {
      System.out.println("Running..." +threadNum);
    }

    public static void main(String[] args) {
      System.out.println("Hello World, Java app");
      for(int i = 0; i < 8; i++)
      {
        MyClass m = new MyClass(i);
        Thread my = new Thread(m);
        my.start();
      }
      
      
    }
  }