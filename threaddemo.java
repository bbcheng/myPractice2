/*
线程：
	第一种方法：
		创建类必须继承Thread类，并且复写run方法。

		创建子类对象的时候，通过start方法开始运行线程。

	
	第二种方法：
		创建类实现接口Runable；复写一个无参run方法。

*/

/*
class demo extends Thread
{
	public void run()
	{
		for (int x=0;x<10 ;x++ )
		{
			System.out.println("thread : run"+x);
		}
	}
}

class threaddemo 
{
	public static void main(String[] args) 
	{
		demo d  = new demo();
		d.start();

		for (int x=0;x<10 ;x++ )
		{
			System.out.println("Hello World!"+x);
		}
	}
}
*/

class demo implements Runnable
{
	private int x = 100;

	public void run()
	{
		while(true)
		{
			if(x>0)
			{
				System.out.println(Thread.currentThread().getName()+"... run"+ x--);
			}
		}
	}
}

class threaddemo 
{
	public static void main(String[] args) 
	{
		demo d  = new demo();

		Thread t = new Thread(d);
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		t.start();
		t1.start();
		t2.start();

		for (int x=0;x<10 ;x++ )
		{
			System.out.println("Hello World!"+x);
		}
	}
}