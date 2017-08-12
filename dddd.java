import java.io.*;
import java.net.*;

class  tcpsend implements Runnable
{
    String add = null;
    Socket s;
    public tcpsend(Socket s){
        this.s = s;
        InetAddress i = null;
        try {
            i = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        add = i.getHostAddress();
        System.out.println("ip:::  "+add);
    }
    public  void run()
    {
        try{
            BufferedReader bufr =
                    new BufferedReader(new InputStreamReader(System.in));

            BufferedWriter bufw =
                    new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            BufferedReader buf =
                    new BufferedReader(new InputStreamReader(s.getInputStream()));
            String line = null;
            while((line = bufr.readLine())!=null)
            {
                if("over".equals(line))
                    break;
                bufw.write(line);
                bufw.newLine();
                bufw.flush();

                String str = buf.readLine();
                System.out.println("server:::  "+str);
            }
        }
        catch (Exception e){
            throw new RuntimeException("����ʧ�ܣ�");
        }

        //  Socket s = new Socket(add,10000);
        finally{
            //  bufr.close();
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}











class  tcprece implements Runnable
{
    ServerSocket ss;
    Socket s;
    String add = null;
    public tcprece(ServerSocket ss){
        this.ss = ss;
        try {
            ss = new ServerSocket(10000);
            s = ss.accept();
            add = s.getInetAddress().getHostAddress();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("ip:::  "+add);
    }
    public  void run()
    {
       try{
           BufferedReader bufr =
                   new BufferedReader(new InputStreamReader(s.getInputStream()));

           BufferedWriter bufw =
                   new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

           BufferedReader buf =
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
       }
       catch (Exception e){
           throw new RuntimeException("����ʧ�ܣ�");
       }

        finally{
           try {
               ss.close();
               s.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }

}
class ddddd 
{
	 public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(10000);
        Socket s = new Socket();
		new Thread(new tcprece(ss)).start();
		new Thread(new tcpsend(s)).start();
    }

}
