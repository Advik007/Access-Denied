package accessdeniedsoftwre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TCPAttackSYN {

	public static String ARPattack = null;
	public static String test="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runtime rt = Runtime.getRuntime();
		int tshark = MainScreen.tshark;
		String userNameUsable=MainScreen.userNameUsable;
		
		String CMDCommands = "tshark -i "+tshark+" -c 2 > C:/Users/"+userNameUsable+"/Desktop/Access_Denied_temp/Wireshark.txt";

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
			System.out.println("test");
			CMDOutput[j] = CMDOutput[j] + '.';
			System.out.println(CMDOutput[j]);
			System.out.println("_------------------------lalalalla------------------_"); 
		}
		
if(CMDOutput[0]==null) {
	return;
}
		if (CMDOutput[0].contains("ARP") && CMDOutput[0].contains("Who has")) {
			int index = CMDOutput[0].indexOf('?');// returns the index of s char value

			int index2 = CMDOutput[0].indexOf('s');
			String IP = "";
			for (int j = index2 + 2; j < index; j++) {
				char ch = CMDOutput[0].charAt(j);
				IP = IP + ch;
			}

			int index3 = CMDOutput[1].indexOf('t');// returns the index of s char value

			int index4 = CMDOutput[1].indexOf('.');
			String MAC = "";
			for (int j = index3 + 2; j < index4; j++) {
				char ch = CMDOutput[0].charAt(j);
				MAC = MAC + ch;
			}

			String CMDCommand = "arp -a " + IP + " > C:/Users/"+userNameUsable+"/Desktop/Access_Denied_temp/ARPPoisoning.txt";

			try {
				rt.exec(new String[] { "cmd.exe", "/C", CMDCommand });
				Thread.sleep(1000);
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ArrayList<String> line = new ArrayList<String>();
			try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/"+userNameUsable+"/Desktop/Access_Denied_temp/ARPPoisoning.txt"))) {

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

			String Packet[] = new String[lines.size()];
			String CMDARP[] = new String[20];
			CMDARP[4]=null;
			// Converting "lines" to an Array which can be easily readable - as CMDOutput
			for (int j = 0; j < line.size(); j++) {
				Packet[j] = line.get(j);
				CMDARP[j] = Packets[j];
				System.out.println(CMDARP[j]);
				
			}
			System.out.println("---------------------------");
if(CMDOutput[0]==null) {
	return;
}
			if ((CMDOutput[1].contains("ARP") && CMDOutput[1].contains(IP) && CMDARP[4].contains(MAC))
					|| CMDOutput[1].contains("duplicate use")) {
			int index5=CMDOutput[0].indexOf('�');
			int index6=CMDOutput[0].indexOf('.');
			String test="";
			for(int z=index6+8; z<=index5-2; z++) {
				test=test+test.charAt(z);
			}
			if(test==MainScreen.st) {
				return;
			}
			if(test!=MainScreen.st) {
				ARPattack = ("ARP Spoofing Attack by "+ test +" Detected by Access Denied! Please click Accept, to block the IP Address, causing this attack.");
				System.out.println(ARPattack);
			}
			
			else {
				return;
			}
			}
			
			
		}
	}

}

