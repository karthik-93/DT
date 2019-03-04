package dbconnection;
class Thread1{
	int num;
boolean valueSet=false;
	public synchronized void getNum() {
		while(!valueSet) {
			try {
				wait();
			}
			catch(Exception e) {
				
			}
		}
		System.out.println("number is "+num);
		valueSet=false;
		notify();
		
	}

	public  synchronized void setNum(int num) {
		while(valueSet) {
			try{
				wait();
			}catch(Exception e) {
				
			}
		}
		System.out.println("setting number "+num);
		this.num = num;
		valueSet=true;
		notify();
	}
	
}
class Producer implements Runnable{
Thread1 thread;

public Producer(Thread1 thread) {
	this.thread =thread;
	Thread t=new Thread(this,"Producer");
	t.start();
}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		while(true) {
			thread.setNum(i++);
			try {
			Thread.sleep(1000);
			}
			catch(Exception e) {
				
			}
		}
	}
	
}
class Consumer implements Runnable{

	Thread1 thread;
	public Consumer(Thread1 thread) {
		this.thread =thread;
		Thread t=new Thread(this,"Consumer");
		t.start();
	}
	@Override
	public void run() {
		while(true) {
			thread.getNum();
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				
			}
		}
		
	}
	
}
public class InterThread {
	public static void main(String[] args) {
	Thread1 t1=new Thread1();
	new Producer(t1);
	new Consumer(t1);
	}
}
