package network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zx
 */
public class InetAddrTest {
    public static List<String> getHostIPs(String... hostname) throws UnknownHostException {
        List<String> list = new ArrayList<>();
        if(hostname.length > 0){
            String host = hostname[0];
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for(InetAddress inetAddress: addresses){
                list.add(inetAddress.toString());
            }
        }else{
            InetAddress localhostAddr = InetAddress.getLocalHost();
            list.add(localhostAddr.toString());
        }
        return list;
    }

}
