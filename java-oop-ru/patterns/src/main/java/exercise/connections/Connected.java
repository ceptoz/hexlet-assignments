package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {
    TcpConnection tcpConnection;

    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
        System.out.println("Connection established");
    }

    @Override
    public void connect() {
        System.out.println("Error");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnecting...");
        this.tcpConnection.setState(new Disconnected(this.tcpConnection));
    }

    @Override
    public String getCurrentState() {
        return "connected";
    }

    @Override
    public void write(String string) {
        System.out.println(string);
    }
}
// END
