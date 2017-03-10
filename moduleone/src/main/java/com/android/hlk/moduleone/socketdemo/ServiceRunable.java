package com.android.hlk.moduleone.socketdemo;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by user on 2017/3/10.
 */

public class ServiceRunable implements Runnable {


    private Handler handler;
    private ServerSocket socket;
    private PrintWriter os;
    private BufferedReader is;
    private boolean isConnect = true;

    public ServiceRunable(Handler handler) {
        this.handler = handler;
    }


    public void send(String data) {
        if (os != null) {
//            os.write(data);
            os.print(data);
            os.flush();
        }
    }

    @Override
    public void run() {
        Log.i("socket", "Server=======打开服务=========");

        try {
            socket = new ServerSocket(8000);

            Socket client = socket.accept();
            Log.i("socket", "Server=======客户端连接成功=========");
            InetAddress inetAddress = client.getInetAddress();
            String ip = inetAddress.getHostAddress();
            Log.e("socket", "===客户端ID为ip========>" + ip);
            is = new BufferedReader(new InputStreamReader(client.getInputStream()));
            os = new PrintWriter(client.getOutputStream());
            String result = "";
            while (isConnect) {


                try {
                    result = is.readLine();
                    Log.i("socket", "服务端接到的数据为：" + result);
                    if (!TextUtils.isEmpty(result)) {
                        Message message = handler.obtainMessage();
                        message.obj = result;
                        message.arg1 = 0x11;
                        handler.sendMessage(message);
                    }

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

            if (socket != null) {
                socket.close();
            }
            isConnect = false;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
