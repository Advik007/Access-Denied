package accessdeniedsoftwre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UDPAttacks {
	public static String UDPAttack = null, NTPAttack = null, MemAttack = null;
public static String test="";
	public static void main(String[] args) {

		// All Variables Being Used
		// Opening Command Prompt to launch Wireshark (tshark)
		Runtime rt = Runtime.getRuntime();
		int tshark = MainScreen.tshark;String userNameUsable=MainScreen.userNameUsable;
		// Establishing CMD Commands to be used - navigate to Wireshark in Program Files
		// and Read 2 Packets of Data while exporting
		// the output to a separate txt file
		String CMDCommands = "tshark -i " + tshark
				+ " -c 2 > C:/Users/"+userNameUsable+"/Desktop/Access_Denied_temp/Wireshark.txt";

		// Creating a CMDOutputList for (reading output of the CMD Command - reading
		// tshark's data)
		ArrayList<String> lines = new ArrayList<String>();
		
		// Variables established to check whether IP's of both packets are the same
		String IP = "";
		char ch;
		char cha;
		String Lens = "";

		// Variables established to check the reputation of the IP Address using CMD's
		// nslookup
		String IPRep = "";
		char chacha;

		// Using a try-catch function to catch errors
		try {
			// Executing the CMD Function on the User's Computer
			rt.exec(new String[] { "cmd.exe", "/C", CMDCommands });
			Thread.sleep(100);

		} catch (IOException | InterruptedException e) {
			// using Java's IOException Classes to detect Runtime Errors
			e.printStackTrace();
		}

		// Using "lines" as an CMDOutputList for reading output of the above CMD Command
		// Using BufferedReader and FileReader as classes

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
		System.out.println("---------------------------");
		// If CMDOutput fails to capture at packets, exit the program
		if (CMDOutput[0] == null) {
			return;
		}

		// If the CMDOutput (First Packet) has UDP within the string
		if (CMDOutput[0].contains("UDP")) {

			// Finding the IP of the first Packet using charAt()
			for (int i = 16; i <= 46; i++) {
				ch = CMDOutput[0].charAt(i);
				IP = IP + ch;
			}
			// Since tshark takes a while to get hex data per packet, Access Denied thought
			// of testing the length of packets instead
			// of the hex data since they are rather similar
			for (int z = (CMDOutput[0].length() - 10); z < CMDOutput[0].length(); z++) {
				cha = CMDOutput[0].charAt(z);
				Lens = Lens + cha;
			}

		} else {
			return;
		}

		// Testing if the Second Packet has the same IP, Protocol and Length
		if (CMDOutput[1].contains(IP) && CMDOutput[1].contains("UDP") && CMDOutput[1].contains(Lens)) {

			// Testing for the reputation of the IP Address - finding the IP Address of the
			// 1st packet
			for (int z = 17; z <= 31; z++) {
				chacha = CMDOutput[0].charAt(z);
				IPRep = IPRep + chacha;
			}

			// CMDC - String containing lookup of reputation of a IP from the variable IPRep
			String CMDC = "nslookup " + IPRep + " > C:/Users/"+userNameUsable+"/Desktop/Access_Denied_temp/output.txt";

			// Executing the CMDC in cmd.exe via Runtime variable "rt"
			try {
				rt.exec(new String[] { "cmd.exe", "/C", CMDC });
			} catch (IOException e) {
				// Catching any errors in IOException
				e.printStackTrace();
			}
			// Establishing an ArrayList again to read CMD's Output as above
			ArrayList<String> IPR = new ArrayList<String>();
			try (BufferedReader br1 = new BufferedReader(new FileReader("C:/Users/"+userNameUsable+"/Desktop/Access_Denied_temp/output.txt"))) {

				String sCurrentLine2;

				while ((sCurrentLine2 = br1.readLine()) != null) {
					IPR.add(sCurrentLine2);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			// Conversion of IPR - ArrayList to CMDOutputs as an Array
			String IPRepu[] = new String[IPR.size()];
			String CMDOutputs[] = new String[8];

			for (int j = 0; j < IPR.size(); j++) {
				IPRepu[j] = IPR.get(j);
				CMDOutputs[j] = IPRepu[j];
			}

			// If the 5th line of the output is blank (where reputation is stored), UDP
			// Attack DETECTED!
			
			int index5=CMDOutput[0].indexOf('�');
			int index6=CMDOutput[0].indexOf('.');
			
			for(int z=index6+8; z<=index5-2; z++) {
				test=test+test.charAt(z);
			}
			if(test==MainScreen.st) {
				return;
			}
			
			if (CMDOutputs[6] == null && test!=MainScreen.st) {
				
				UDPAttack = ("UDP-Based Flood Attack by "+ test + " Detected by Access Denied! Please click Accept, to block the IP Address, causing this attack.");
			System.out.println(UDPAttack);
			}
			if ((CMDOutput[0].contains("11211")&& test!=MainScreen.st) || (CMDOutput[1].contains("11211")&& test!=MainScreen.st)) {
				NTPAttack = ("NTP Amplification Attack by "+ test + " Detected by Access Denied! Please click Accept, to block the IP Address, causing this attack.");
				System.out.println(NTPAttack);
			}
			if ((CMDOutput[1].contains("123")&& test!=MainScreen.st) || (CMDOutput[0].contains("123")&& test!=MainScreen.st)) {
				MemAttack = ("Memcached Server Attack by " +test+" Detected by Access Denied! Please click Accept, to block the IP Address, causing this attack.");
			System.out.println(MemAttack);
			}
		}

	}

}
