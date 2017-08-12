/*
�̣߳�
	��һ�ַ�����
		���������̳�Thread�࣬���Ҹ�дrun������

		������������ʱ��ͨ��start������ʼ�����̡߳�

	
	�ڶ��ַ�����
		������ʵ�ֽӿ�Runable����дһ���޲�run������

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