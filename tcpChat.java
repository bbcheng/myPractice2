//package命名规则：priv.个人名.项目名.模块名.……
import java.io.*;
import java.net.*;

class  tcpsend 
{
	public static void main(String[] args) throws Exception
	{
		InetAddress i = InetAddress.getLocalHost();//获取本地IP地址并打印
		String add = i.getHostAddress();
		System.out.println("ip:::  "+add);

		Socket s = new Socket(add,10000);//客户端创建一个socket端口

		BufferedReader bufr =	//定义一个缓冲区存储键盘录入的数据
			new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bufw =	//定义一个缓冲区在控制台写入数据
			new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

		BufferedReader buf =	//定义一个缓冲区读取服务器端发送过来的数据
			new BufferedReader(new InputStreamReader(s.getInputStream()));


		String line = null;		//把在控制台写入的数据发送到服务器端
		while((line = bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			bufw.write(line);
			bufw.newLine();
			bufw.flush();

			String str = buf.readLine();//读取服务器发送的数据并打印
			System.out.println("server:::  "+str);
		}

		bufr.close();			//关闭资源
		s.close();
	}
}

class  tcprece 
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(10000);
		//创建服务器端口
		Socket s = ss.accept();//连接客户端
		String add = s.getInetAddress().getHostAddress();
		System.out.println("ip:::  "+add);//打印客户端IP地址

		BufferedReader bufr =	//读取客户端发送的数据
			new BufferedReader(new InputStreamReader(s.getInputStream()));

		BufferedWriter bufw =	//向客户端发送反馈
			new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

		BufferedReader buf =	//读取键盘录入的数据
			new BufferedReader(new InputStreamReader(System.in));

		String line = null;
		while((line = bufr.readLine())!=null)
		{	
			System.out.println("client:::  "+line);
			//bufw.write(line.toUpperCase());

			String zc = buf.readLine();
			
			bufw.write(zc);
		
			bufw.newLine();
			bufw.flush();
		
		}
		s.close();	//关闭资源
		ss.close();
	}
}
