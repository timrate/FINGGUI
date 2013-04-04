package Fing_GUI;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class getIPaddresses {

  public static String[] GiveInetAddressArray() {
		String hostname = null;
		try {
			hostname = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InetAddress[] address = null;
		try {
			address = InetAddress.getAllByName(hostname);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] addresslist = new String[address.length];
		for (int i = 0; i < address.length; i++) {
			int length = hostname.length();
			String newstring = address[i].toString();
			newstring = newstring.substring(length + 1);
			addresslist[i] = newstring;

		}

		return addresslist;
	}
}
