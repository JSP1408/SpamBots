package org.e11eman;

import com.github.steveice10.mc.protocol.MinecraftProtocol;
import com.github.steveice10.packetlib.ProxyInfo;
import com.github.steveice10.packetlib.tcp.TcpClientSession;

public class Bot {
    public TcpClientSession session;

    public Bot(String host, Integer port, String username, ProxyInfo proxy) {
        MinecraftProtocol protocol = new MinecraftProtocol(username);
        TcpClientSession session = new TcpClientSession(host, port, protocol, proxy);

        this.session = session;
        session.connect();

    }

}