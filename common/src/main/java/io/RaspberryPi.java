package io;

import java.io.*;

/**
 * @author zx
 */
public class RaspberryPi implements Serializable {
    private String IPAddress;
    private String macAddress;
    private class Auth{
        public String username;
        public String password;

        public Auth() {
            this.username = "root";
            this.password = "1234abcd";
        }

        @Override
        public String toString() {
            return "Auth{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

        public Class<? extends Auth> getAuth(){
            return this.getClass();
        }
    }
    public RaspberryPi(String IPAddress, String macAddress) {
        this.IPAddress = IPAddress;
        this.macAddress = macAddress;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
    public Auth getAuth(){
        Auth auth = new Auth();
        return auth;
    }

    @Override
    public String toString() {
        return "RaspberryPi{" +
                "type='" + IPAddress + '\'' +
                ", macAddress='" + macAddress + '\'' +
                '}';
    }

    public void save(){
        String path = "src/main/resources/" + this.getClass().getSimpleName() + ".out";
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static RaspberryPi restore(String piName){
        String path = "src/main/resources/" + piName + ".out";
        RaspberryPi raspberryPi = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
            raspberryPi = (RaspberryPi) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return raspberryPi;
    }


}
