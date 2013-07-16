package com.pekall.codebase.net;

import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * author: hepin1989@gmail.com
 */
public class NetAddressGather {
    private static Enumeration<NetworkInterface> interfaceAddresses ;
    private static List<InetAddress> inetAddresses;
    private static List<Inet4Address> ipv4Addresses;
    private static List<Inet6Address> ipv6Addresses;

    static{
        try {
            interfaceAddresses = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static {
        if (interfaceAddresses != null) {
            final List<InetAddress> addresses = new ArrayList<InetAddress>();
            while (interfaceAddresses.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) interfaceAddresses
                        .nextElement();
                try {
                    if (networkInterface.isLoopback()) {
                        continue;
                    }
                } catch (SocketException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Enumeration<InetAddress> netaddress = networkInterface.getInetAddresses();
                while (netaddress.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) netaddress
                            .nextElement();
                    addresses.add(inetAddress);
                }
            }
            inetAddresses = addresses;
        }
    }

    //get the ipv4,and ipv6 address
    static{
        if (inetAddresses != null) {
            ipv4Addresses = new ArrayList<Inet4Address>();
            ipv6Addresses = new ArrayList<Inet6Address>();

            for(InetAddress address : inetAddresses){
                if (address instanceof Inet4Address) {
                    ipv4Addresses.add((Inet4Address) address);
                }else {
                    ipv6Addresses.add((Inet6Address) address);
                }
            }
        }
    }


    public static List<Inet4Address> getIp4aAddresses(){
        return ipv4Addresses;
    }

    public static List<Inet6Address> getIp6Addresses(){
        return ipv6Addresses;
    }

    public static List<InetAddress> getIpaAddresses(){
        return inetAddresses;
    }
}
