package exercise;

import exercise.connections.Connection;
import exercise.connections.Disconnected;

// BEGIN
public class TcpConnection implements Connection{
    private Connection connection;

    public TcpConnection(String ip, int port) {
        this.connection = new Disconnected(this);
    }

    public String getCurrentState() {
        return this.connection.getCurrentState();
    }

    public void setState(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void write(String text) {
        this.connection.write(text);
    }

    public void connect() {
        this.connection.connect();
    }

    public void disconnect() {
        this.connection.disconnect();
    }
}
// END
