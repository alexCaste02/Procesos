package apps;

import java.io.IOException;
import java.net.InetAddress;

public class ScannerRed {
    public static void main(String[] args) {

        String ip = "172.18.185.185";

        System.out.println("Comprobando subred " + (ip.substring(0, ip.lastIndexOf('.') + 1) + 0));
        for (int i = 1; i <= 254; i++) {
            String ipTest = ip.substring(0, ip.lastIndexOf('.') + 1) + i;
            new Thread(new CheckAddressConnectionThread(ipTest)).start();
        }

    }
}

class CheckAddressConnectionThread implements Runnable {

    private final String ip;

    public CheckAddressConnectionThread(String ip) {
        this.ip = ip;
    }

    @Override
    public void run() {
        try {
            System.out.println("Comprobando " + ip);
            if (InetAddress.getByName(ip).isReachable(5))
                System.out.println(ip + " --> " + InetAddress.getByName(ip).getHostName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

