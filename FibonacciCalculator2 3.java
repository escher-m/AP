//Karishma Sinha 2018339
import java.util.*;
import java.lang.*;
import java.io.*; 
  
public class FibonacciCalculator2 
{
    public static void main(String[] args)
    {
        Scanner in= new Scanner(System.in);
        final Queues queue= new Queues();
        Producer producer = new Producer(Queues q);
        Thread t1= new Thread(producer);

        Consumer consumer = new Consumer(Queues q);
        t1.start();
        boolean menu=true;
        int flag=0;
        while(menu)
        {
            
                System.out.println("Choose option:");
                System.out.println("1. Enter N for which to find corresponding Fibonacci number.");
                System.out.println("2. Display fibonacci numbers for all Ns entered.");
                System.out.println("3. Terminate.");
                int option=in.nextInt();
                switch(option)
                {
                    case 1: if(flag==0)
                            {
                                t1.start();
                                flag=1;
                            }
                            else
                            {
                                t1.run();
                            }
                            t1.getN();
                            break;
                    case 2: queue.display();
                            break;
                    case 3: t1.join();
                            exit();
                            break;
                    default: System.out.println("Incorrect input");
                            break;
                }
            
        }
        //new Thread(producer).start();

    }
}
public static class Queues
{
    private volatile Queue<Integer> q1 = new LinkedList<>();
    private volatile Queue<Integer> q2 = new LinkedList<>();
    private volatile Queue<Float> time = new LinkedList<>();
    private volatile int arr=new int[45];
    private volatile boolean empty = false;

    public synchronized void putN(int N)
    {
        
        q1.add(N);
        notifyAll();
        //System.out.println( who + " ate cookie "+ contents);
    }

    public synchronized void putfN(int fN,float t) 
    {

        q2.add(fN);
        time.add(t);
        
        notifyAll();
    }
     public synchronized void display() 
    {
        int size=q2.size();
        for(int i=0;i<size;i++)
        {
            System.out.println(q2.remove());
        }
        
        notifyAll();
    }
    
    

}
class Fibonacci 
{
    int result, n;
    public Fibonacci(int n)
    { 
        this.n = n; 
    }
    public static int fib(int n)
    {
        if(n<2)
        {
            return n;
        }
        else
        { 
            return fib(n-1) + fib(n-2);
        }
    }
    public void calculate() 
    {
        result = fib(n);
    }
    public int getResult() 
    { 
        return result; 
    }
    
}
class Producer implements Runnable
{
    private Queues q;
    
    public Producer(Queues q) 
    {
        this.q = q;
        //this.q2=q2;
    }
    public void getN() 
    {
        int N=in.nextInt();
        q.putN(N);
        //jar.putCookie("Marge", cookieNumber);
        try 
        {
            Thread.sleep((int)Math.random() * 500);
        } 
        catch (InterruptedException ie) 
        {
            
        }
    }
    public void run()
    {
        //Scanner in= new Scanner(System.in);
        int NoCt=in.nextInt();
        for (int i = 0 ; i < NoCt ; i++) 
        {   
            new Thread(consumer).start();
        }
        //getN();//queues-putN
        // try
        // {
        //     Queues.enterN();
        // }
        // catch(InterruptedException e)
        // {

        // }
        
    }
}
class Consumer implements Runnable
{
    private Queues q;
    
    public Consumer(Queues q) 
    {
        this.q = q;
        //this.q2=q2;
    }
    public void getfN() throws InterruptedException
    {
        while(true)
        {
            synchronized(this)
            {
                int n=q1.remove()
                long start = System.currentTimeMillis();
                      
                Fibonacci fib = new Fibonacci(n);
                int result = fib.getResult();
                long end = System.currentTimeMillis();
                float sec = (end - start) / 1000F;
                q.putfN(result, sec);
            }
        }
    }
    public void run()
    {
        getfN();//queues-putfN;
        try
        {
            Queues.enterfN();
        }
        catch(InterruptedException e)
        {

        }
        
    }
}

