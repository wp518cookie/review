package basis.sourcecode.nio;

/**
 * Created by Administrator on 2017/11/22.
 */
public class TimeServer {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer).start();
    }
}
