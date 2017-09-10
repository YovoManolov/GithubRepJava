package txtInputOutput;

import java.net.ServerSocket;
import java.net.Socket;

public class SercerClass {
    ServerSocket server = new ServerSocket(1211);
    Socket socket = server.accept();
}
