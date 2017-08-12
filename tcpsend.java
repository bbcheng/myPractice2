import java.io.*;
import java.net.*;

class  tcpsend
{
	public static void main(String[] args) throws Exception
	{
		InetAddress i = InetAddress.getLocalHost();
		String add = i.getHostAddress();
		System.out.println(add);
		Socket s = new Socket(add,10000);
		OutputStream out = s.getOutputStream();

		out.write("zzzzzccccc".getBytes());
		s.close();
	}
}

class  tcprece 
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(10000);
		Socket s = ss.accept();
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));
		s.close();

	}
}
