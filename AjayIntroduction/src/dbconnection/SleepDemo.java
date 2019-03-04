package dbconnection;

public class SleepDemo implements Runnable 
{ 
    Thread t; 
    public void run() 
    { 
        for (int i = 0; i < 4; i++) 
        { 
            System.out.println(Thread.currentThread().getName() 
                                                   + "  " + i); 
            try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        } 
    } 
  
    public static void main(String[] args) throws Exception 
    { 
        Thread t = new Thread(new SleepDemo()); 
  
        // call run() function 
        t.start(); 
  
        Thread t2 = new Thread(new SleepDemo()); 
  
        // call run() function 
        t2.start(); 
    } 
}