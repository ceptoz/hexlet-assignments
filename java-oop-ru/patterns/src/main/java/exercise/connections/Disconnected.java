package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection{
    private final TcpConnection tcpConnection;

    public Disconnected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
        System.out.println("Currently disconnected");
    }

    @Override
    public void connect() {
        System.out.println("Connecting...");
        this.tcpConnection.setState(new Connected(this.tcpConnection));
    }

    @Override
    public void disconnect() {
        System.out.println("Error");
    }

    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public void write(String text) {
        System.out.println("Error");
    }
}
// END
