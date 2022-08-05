package org.e11eman;

import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundChatPacket;
import com.sun.management.OperatingSystemMXBean;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;

import static org.e11eman.Main.bots;

public class MainGUI {
    static final JFrame frame = new JFrame("Server Flooder: Main Menu");
    static final JTextField host = new JTextField();
    static final JLabel host2 = new JLabel("Host:");
    static final JTextField port = new JTextField();
    static final JLabel port2 = new JLabel("Port:");
    static final JLabel threads = new JLabel("Threads:");
    static final JTextField threads2 = new JTextField();
    static final JLabel username = new JLabel("Username:");
    static final JTextField username2 = new JTextField();
    static final JButton start = new JButton("Start");
    static final JButton stop = new JButton("Stop");
    static final JLabel mem = new JLabel();
    static final JLabel cpu = new JLabel();
    static final JLabel message = new JLabel("Message:");
    static final JTextField message2 = new JTextField();
    static final JButton send = new JButton("Send Message");
    static OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
    public static ArrayList<Thread> threadcount = new ArrayList<>();
    public static void main() {
        host2.setBounds(0, 0, 200, 20);
        host.setBounds(40, 0, 200, 20);
        port.setBounds(40, 25, 200, 20);
        port2.setBounds(0, 25, 200, 20);
        threads.setBounds(0, 50, 200, 20);
        threads2.setBounds(55, 50, 200, 20);
        username.setBounds(0, 75, 200, 20);
        username2.setBounds(65, 75, 200, 20);
        start.setBounds(0, 100, 200,20);
        stop.setBounds(0,125,200,20);
        mem.setBounds(0,150, 200, 20);
        cpu.setBounds(0,175,200,20);
        message.setBounds(0, 200, 200, 20);
        message2.setBounds(60, 200, 200, 20);
        send.setBounds(0, 225, 200, 20);

        frame.add(host);
        frame.add(host2);
        frame.add(port);
        frame.add(port2);
        frame.add(threads);
        frame.add(threads2);
        frame.add(username);
        frame.add(username2);
        frame.add(start);
        frame.add(stop);
        frame.add(mem);
        frame.add(cpu);
        frame.add(message);
        frame.add(message2);
        frame.add(send);
        frame.setSize(300,600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Window was closed");
                System.exit(0);
            }
        });

        start.addActionListener(e -> {
            if(e.getSource() == start) {
                System.out.println("Started");
                for (int i = 0; i < Integer.parseInt(threads2.getText()); i++) {
                    Thread a = new Main();
                    a.start();

                    threadcount.add(a);
                }
            }
        });

        send.addActionListener(e -> {
            if(e.getSource() == send) {
                for (int i  = 0; i < bots.size(); i++) {
                    bots.get(i).session.send(new ServerboundChatPacket(message2.getText()));
                }
            }
        });

        stop.addActionListener(e -> {
            if(e.getSource() == stop) {
                System.out.println("Stopped");
                System.exit(9);
            }
        });

        while (true) {
            mem.setText(Tools.runGC());
            cpu.setText("Cpu Usage: " + String.valueOf(osBean.getProcessCpuLoad()));
        }
    }
}
