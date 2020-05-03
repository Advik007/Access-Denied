package accessdeniedsoftwre;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class MainScreen extends JFrame {

	public static int tshark;
	public static String user;
	public static String userNameUsable;
	public static String st="";

	private JPanel contentPane;
	private JTextField userName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		Runtime rt=Runtime.getRuntime();		
		
		try {
			rt.exec(new String[] {"cmd.exe", "/C", "echo %username% > C:/Users/Administrator/Desktop/Access_Denied.txt"});
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ArrayList<String> PC = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Administrator/Desktop/Access_Denied.txt"))) {

			// Establishment of a String to read line by line in the output text file
			String sCurrentLine;

			// br.readLine means reading the line given in the text file using the
			// BufferedReader Variable "br"
			// Adding the Output line by line to the CMDOutputList
			while ((sCurrentLine = br.readLine()) != null) {
				PC.add(sCurrentLine);
			}

			// To Catch any Error during reading of data
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		String CMDPC[] = new String[PC.size()];
		String userNamePC[] = new String[20];
		// Converting "lines" to an Array which can be easily readable - as CMDOutput
		for (int j = 0; j < PC.size(); j++) {
			CMDPC[j] = PC.get(j);
			userNamePC[j] = CMDPC[j];	
		}
		userNameUsable=userNamePC[0];
		int indexuser=userNameUsable.indexOf(' ');
		String str = "";
		for(int m=0; m<indexuser; m++) {
			char user=userNameUsable.charAt(m);
			str=str+user;
		}
		userNameUsable=str;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 485);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblAccessDenied = new JLabel("Access Denied");
		lblAccessDenied.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccessDenied.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 41));
		contentPane.add(lblAccessDenied, "1, 2, 30, 1, center, default");
		
		JLabel lblSelectTheInterface = new JLabel("Select the Interface You");
		lblSelectTheInterface.setFont(new Font("Lucida Handwriting", Font.PLAIN, 17));
		lblSelectTheInterface.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSelectTheInterface, "8, 4");
		
		JLabel lblPleaseEnterThe = new JLabel("Please Enter the Name of");
		lblPleaseEnterThe.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		contentPane.add(lblPleaseEnterThe, "22, 4");
		
		JLabel lblWouldLikeTo = new JLabel("Would Like to Analyse");
		lblWouldLikeTo.setFont(new Font("Lucida Handwriting", Font.PLAIN, 17));
		lblWouldLikeTo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblWouldLikeTo, "8, 6");
		
		
		String CMDCommands="tshark -D > C:/Users/"+userNameUsable+"/Desktop/Access_Denied_temp/InterfaceList.txt";
		
		try {
			rt.exec(new String[] {"cmd.exe", "/C", CMDCommands});
			Thread.sleep(2000);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<String> lines = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/"+userNameUsable+"/Desktop/Access_Denied_temp/InterfaceList.txt"))) {

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
		String CMDOutput[] = new String[20];
		int index, index2;
		// Converting "lines" to an Array which can be easily readable - as CMDOutput
		for (int j = 0; j < lines.size(); j++) {
			Packets[j] = lines.get(j);
			CMDOutput[j] = Packets[j];
			
		}
		String s;
		for(int z=0; z<lines.size(); z++) {
			s= " "+ (z+1) + ". ";
			index=CMDOutput[z].indexOf('(');
			index2=CMDOutput[z].indexOf(')');
			for(int k=index+1;k<=index2-1;k++) {
				char ch = CMDOutput[z].charAt(k);
				s=s+ch;
				
			}
			CMDOutput[z]=s;
			
		}
		
		try {
			rt.exec(new String[] {"cmd.exe", "/C", "ipconfig | findstr /C:Address > C:/Users/"+userNameUsable+"/Desktop/Access_Denied_temp/IP.txt"});
			Thread.sleep(2000);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<String> arrIP = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/"+userNameUsable+"/Desktop/Access_Denied_temp/IP.txt"))) {

			// Establishment of a String to read line by line in the output text file
			String sCurrentLine1;

			// br.readLine means reading the line given in the text file using the
			// BufferedReader Variable "br"
			// Adding the Output line by line to the CMDOutputList
			
			while ((sCurrentLine1 = br.readLine()) != null) {
				arrIP.add(sCurrentLine1);
			}

			// To Catch any Error during reading of data
		} catch (IOException e) {
			e.printStackTrace();
		}

		String Packet[] = new String[arrIP.size()];
		String IP[] = new String[arrIP.size()];
		
		for (int j = 0; j < arrIP.size(); j++) {
			Packet[j] = arrIP.get(j);
			IP[j] = Packet[j];
			if(IP[j].contains("IPv4")) {
				int index3=IP[j].indexOf(':');
				IP[j]=IP[j]+'/';
				int index4=IP[j].indexOf('/');
				for(int p=index3+2; p<=(index4-1); p++) {
					char ch=IP[j].charAt(p);
					st=st+ch;
			
				}
				System.out.println(st);
			}
		}
		
		JLabel lblUserYouAre = new JLabel("User You Are Logged Into");
		lblUserYouAre.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		contentPane.add(lblUserYouAre, "22, 6");
		
		Box horizontalBox = Box.createHorizontalBox();
		contentPane.add(horizontalBox, "44, 6");
		
		JLabel label_1 = new JLabel("");
		contentPane.add(label_1, "45, 6, 8, 1");
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox comboBox = new JComboBox(CMDOutput);
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setForeground(Color.RED);
		comboBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		contentPane.add(comboBox, "2, 8, 13, 1, fill, default");
		
		userName = new JTextField();
		contentPane.add(userName, "22, 8, fill, default");
		userName.setColumns(10);
		
		JButton btnConfigure = new JButton("Configure!");
		btnConfigure.setFont(new Font("Georgia", Font.PLAIN, 15));
		contentPane.add(btnConfigure, "8, 10");
		
		btnConfigure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				tshark = comboBox.getSelectedIndex();
				tshark=tshark+1;
				
				user=userName.getText();
			}
		});
		
		JLabel lblYourLocalIpv = new JLabel("Your Local IPv4 Address: ");
		lblYourLocalIpv.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 17));
		contentPane.add(lblYourLocalIpv, "8, 16");
		
		JLabel label = new JLabel(st);
		label.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 17));
		contentPane.add(label, "12, 16");
		
		
		
		JButton btnBeginAnalysing = new JButton("Begin Analysing!");
		btnBeginAnalysing.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					for(int l=0;;l++) {
						ICMPAttacks.main(null);
						UDPAttacks.main(null);
						TCPAttackSYN.main(null);
						
						Object[] options = {"Accept",
			                    "Decline"};
						//Test of Memcached Attacks
						if(UDPAttacks.MemAttack!=null ) {
							//Making the Warning Box x=0 if "accept", x=1 if "decline"
							 int x=JOptionPane.showOptionDialog(null,
								    UDPAttacks.MemAttack,
								    "Security Breach",
								    JOptionPane.YES_NO_OPTION,
								    JOptionPane.QUESTION_MESSAGE,
								    null,     //do not use a custom Icon
								    options,  //the titles of buttons
								    options[0]); //default button title);
							//Checking if Accept Option is Checked
							if(x==0) {
								try {
									//Executing a CMD Command to block the Attacker's IP Address
									rt.exec(new String[] {"cmd.exe", "/C", "netsh advfirewall firewall add rule name=\"BLOCKED IP\" interface=any dir=in "
											+ "action=block remoteip="+UDPAttacks.test});
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else {
								return;
							}
						}
						if( UDPAttacks.NTPAttack!=null ) {
							int y= JOptionPane.showOptionDialog(null,
									UDPAttacks.NTPAttack,
								    "Security Breach",
								    JOptionPane.YES_NO_OPTION,
								    JOptionPane.QUESTION_MESSAGE,
								    null,     //do not use a custom Icon
								    options,  //the titles of buttons
								    options[0]); //default button title);
							
							if(y==0) {
								try {
									rt.exec(new String[] {"cmd.exe", "/C", "netsh advfirewall firewall add rule name=\"BLOCKED IP\" interface=any dir=in action=block remoteip="+UDPAttacks.test});
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else {
								return;
							}
						}
						if(UDPAttacks.UDPAttack!=null ) {
							int z=JOptionPane.showOptionDialog(null,
									UDPAttacks.UDPAttack,
								    "Security Breach",
								    JOptionPane.YES_NO_OPTION,
								    JOptionPane.QUESTION_MESSAGE,
								    null,     //do not use a custom Icon
								    options,  //the titles of buttons
								    options[0]); //default button title);
							
							if(z==0) {
								try {
									rt.exec(new String[] {"cmd.exe", "/C", "netsh advfirewall firewall add rule name=\"BLOCKED IP\" interface=any dir=in action=block remoteip="+UDPAttacks.test});
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else {
								return;
							}
						}
						if(ICMPAttacks.ICMPAttack!=null) {
							int aa = JOptionPane.showOptionDialog(null,
									ICMPAttacks.ICMPAttack,
								    "Security Breach",
								    JOptionPane.YES_NO_OPTION,
								    JOptionPane.QUESTION_MESSAGE,
								    null,     //do not use a custom Icon
								    options,  //the titles of buttons
								    options[0]); //default button title);
							
							if(aa==0) {
								try {
									rt.exec(new String[] {"cmd.exe", "/C", "netsh advfirewall firewall add rule name=\"BLOCKED IP\" interface=any dir=in action=block remoteip="+ICMPAttacks.test});
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else {
								return;
							}
						}
						if(TCPAttackSYN.ARPattack!=null) {
							int az = JOptionPane.showOptionDialog(null,
								    TCPAttackSYN.ARPattack,
								    "Security Breach",
								    JOptionPane.YES_NO_OPTION,
								    JOptionPane.QUESTION_MESSAGE,
								    null,     //do not use a custom Icon
								    options,  //the titles of buttons
								    options[0]); //default button title
							
							if(az==0) {
								try {
									rt.exec(new String[] {"cmd.exe", "/C", "netsh advfirewall firewall add rule name=\"BLOCKED IP\" interface=any dir=in action=block remoteip="+TCPAttackSYN.test});
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else {
								return;
							}
						}
					}
				}
		});
		contentPane.add(btnBeginAnalysing, "8, 24, 14, 1");
		
		JButton btnStopAnalysing = new JButton("Stop Analysing");
		contentPane.add(btnStopAnalysing, "8, 26, 14, 1");
		btnStopAnalysing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				return;
			}
		});
	
	
		
			

}
}
