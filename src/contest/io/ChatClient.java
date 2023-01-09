package contest.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Scanner;

public class ChatClient{


    public static String getTime()
    {
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        return hour+":"+ minute+":"+second;
    }

    public static void main(String[] args) {
        try{
            Socket s = new Socket("127.0.0.1",9988);
            BufferedReader br = new BufferedReader
                    (new InputStreamReader(s.getInputStream()));
            PrintWriter printWriter = new PrintWriter(s.getOutputStream(),true);
            new Thread(()->{
                Scanner scanner = new Scanner(System.in);
                while (true){
                    while (scanner.hasNext()) {
                        String next = scanner.nextLine();
                        printWriter.println(next);
                        System.out.println("client发送  "+getTime()+"\r\n"+next+"\r\n");
                    }
                }
            }).start();
            while(true) {
                //不停的读取服务器端发来的信息
                String info = br.readLine();
                System.out.println("server发送  "+getTime()+"\r\n"+info+"\r\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
