package hlk.com.mystudyandroidtest.ui.socketdemo;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by user on 2017/3/10.
 */

public class Client implements Runnable {


    private Handler handler;
    private Socket client;
    private PrintWriter os;
    private BufferedReader is;

    private boolean isConnect = true;

    public Client(Handler handler) {
        this.handler = handler;
    }

    public void send(String data) {
        if (os != null) {
            os.print(data);
            os.flush();
        }
    }


    @Override
    public void run() {


        try {
            client = new Socket("localhost", 8000);
            Log.i("socket", "Client=======连接服务器成功========="+getLocalIpAddress());
            client.setSoTimeout(30000);

            os = new PrintWriter(client.getOutputStream());
            is = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String result = "";

            while (isConnect) {

                try {
                    result = is.readLine();

                    Message message = handler.obtainMessage();
                    message.arg1 = 0x12;
                    message.obj = result;
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void cloes() {
        try {
            if (os != null) {
                os.close();
            }
            if (is != null) {
                is.close();
            }

            if (client != null) {
                client.close();
            }
            isConnect = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLocalIpAddress() {

        try {

            for (Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces();

                 en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf
                        .getInetAddresses();

                     enumIpAddr.hasMoreElements(); ) {

                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {

                        return inetAddress.getHostAddress();

                    }

                }

            }

        } catch (SocketException ex) {
        }

        return null;

    }
}
