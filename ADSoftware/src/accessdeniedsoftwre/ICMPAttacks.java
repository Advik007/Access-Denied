package accessdeniedsoftwre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ICMPAttacks {

	public static String ICMPAttack = null;
	public static String test="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// All Variables
		Runtime rt = Runtime.getRuntime();
		int tshark = MainScreen.tshark;
		String userNameUsable=MainScreen.userNameUsable;
		String CMDCommands = "tshark -i " + tshark + " -c 2 > C:/Users/"+userNameUsable+"/Desktop/Access_Denied_temp/Wireshark.txt";
		
		try {
			rt.exec(new String[] { "cmd.exe", "/C", CMDCommands });
			Thread.sleep(1000);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String> lines = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/"+userNameUsable+"/Desktop/Access_Denied_temp/Wireshark.txt"))) {

			// Establishment of a String to read line by line in the output text file
			String sCurrentLine;

			// br.readLine means reading the line given in the text file using the
			// BufferedReader Variable "br"
			// Adding the Output line by line to the CMDOutputList
			while ((sCurrentLine = br.readLine()) != null) {
				lines.add(sCurrentLine);
			}

			// To Catch any Error during reading of data
		} catch (IOException e) {
			e.printStackTrace();
		}

		String Packets[] = new String[lines.size()];
		String CMDOutput[] = new String[3];
		// Converting "lines" to an Array which can be easily readable - as CMDOutput
		for (int j = 0; j < lines.size(); j++) {
			Packets[j] = lines.get(j);
			CMDOutput[j] = Packets[j];
			System.out.println(CMDOutput[j]);
		}
		System.out.println("__--------------------------__");
		if (CMDOutput[0] == null) {
			return;
		}
		String IP = "";
		if (CMDOutput[0].contains("ICMP")) {
			for (int j = 17; j <= 47; j++) {

				char c = CMDOutput[0].charAt(j);
				IP = IP + c;
			}
		}
		// If IP is Not SPOOFED
		if (CMDOutput[0].contains("ICMP") && CMDOutput[1].contains("ICMP") && CMDOutput[1].contains("Echo")
				&& CMDOutput[1].contains(IP) && CMDOutput[1].contains("(ping) request") && CMDOutput[0].contains("Echo")
				&& CMDOutput[0].contains("(ping) request")) {
			System.out.println("ICMP Attack Detected!");
		}
		// IP is SPOOFED
		if (!CMDOutput[1].contains(IP)) {
			if (CMDOutput[0].contains("ICMP") && CMDOutput[1].contains("ICMP") && CMDOutput[1].contains("Echo")
					&& CMDOutput[1].contains("(ping) request") && CMDOutput[0].contains("Echo")
					&& CMDOutput[0].contains("(ping) request")) {
				
				int index5=CMDOutput[0].indexOf('�');
				int index6=CMDOutput[0].indexOf('.');
				for(int z=index6+8; z<=index5-2; z++) {
					test=test+test.charAt(z);
				}
				if(test==MainScreen.st) {
					return;
				}
				if(test!=MainScreen.st) {
					ICMPAttack = ("ICMP Attack by" +test+" Detected by Access Denied! Please click Accept, to block the IP Address, causing this attack.");
					System.out.println(ICMPAttack);
				}
				}
				
			}
		}
	}


