package org.e11eman;

import com.github.steveice10.packetlib.ProxyInfo;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Random;

public class Main extends Thread {
    public static ArrayList<String> Proxies;
    public static ArrayList<Bot> bots = new ArrayList<>();
    public static boolean exit;

    static {
        try {
            Proxies = HTTP.getHTML("https://raw.githubusercontent.com/VosmoslaGod/RandomShiz/main/Socks5Proxies.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) { MainGUI.main(); }

    public void run() {
        while(!Thread.interrupted()) {
            Random random = new Random();
            int randomNumber = random.nextInt(Proxies.size());
            String[] proxy = Proxies.get(randomNumber).split(":");
            SocketAddress addr = new InetSocketAddress(
                    proxy[0], Integer.parseInt(proxy[1]));

            ProxyInfo PROXY = new ProxyInfo(ProxyInfo.Type.SOCKS5,  addr);

            Bot bot;

                bot = new Bot(MainGUI.host.getText(), Integer.parseInt(MainGUI.port.getText()),  random.nextInt(100000) + MainGUI.username2.getText(), PROXY);

            bots.add(bot);
        }
    }
}

