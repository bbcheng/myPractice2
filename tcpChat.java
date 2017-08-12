//package��������priv.������.��Ŀ��.ģ����.����
import java.io.*;
import java.net.*;

class  tcpsend 
{
	public static void main(String[] args) throws Exception
	{
		InetAddress i = InetAddress.getLocalHost();//��ȡ����IP��ַ����ӡ
		String add = i.getHostAddress();
		System.out.println("ip:::  "+add);

		Socket s = new Socket(add,10000);//�ͻ��˴���һ��socket�˿�

		BufferedReader bufr =	//����һ���������洢����¼�������
			new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bufw =	//����һ���������ڿ���̨д������
			new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

		BufferedReader buf =	//����һ����������ȡ�������˷��͹���������
			new BufferedReader(new InputStreamReader(s.getInputStream()));


		String line = null;		//���ڿ���̨д������ݷ��͵���������
		while((line = bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			bufw.write(line);
			bufw.newLine();
			bufw.flush();

			String str = buf.readLine();//��ȡ���������͵����ݲ���ӡ
			System.out.println("server:::  "+str);
		}

		bufr.close();			//�ر���Դ
		s.close();
	}
}

class  tcprece 
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(10000);
		//�����������˿�
		Socket s = ss.accept();//���ӿͻ���
		String add = s.getInetAddress().getHostAddress();
		System.out.println("ip:::  "+add);//��ӡ�ͻ���IP��ַ

		BufferedReader bufr =	//��ȡ�ͻ��˷��͵�����
			new BufferedReader(new InputStreamReader(s.getInputStream()));

		BufferedWriter bufw =	//��ͻ��˷��ͷ���
			new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

		BufferedReader buf =	//��ȡ����¼�������
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
		s.close();	//�ر���Դ
		ss.close();
	}
}
