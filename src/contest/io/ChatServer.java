package contest.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) {
        try {
            //服务器监听
            ServerSocket ss = new ServerSocket(9988);
            //等待客户端连接
            Socket s = ss.accept();

            BufferedReader br = new BufferedReader
                    (new InputStreamReader(s.getInputStream()));

            PrintWriter printWriter  = new PrintWriter(s.getOutputStream(),true);
            new Thread(()->{
                Scanner scanner = new Scanner(System.in);
                while (true){
                    while (scanner.hasNext()) {
                        String next = scanner.nextLine();
                        printWriter.println(next);
                        System.out.println("server发送  "+getTime()+"\r\n"+next+"\r\n");
                    }
                }
            }).start();
            //读取从客户端发来的信息
            while(true) {
                String info = br.readLine();
                System.out.println(("client发送  "+getTime()+"\r\n"+info+"\r\n"));;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getTime()
    {
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        return hour+":"+ minute+":"+second;
    }
}
