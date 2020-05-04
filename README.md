# Access-Denied

A software coded in Java to detect several cyber-attacks on your network, block attacker's IP addresses on your network's firewall
and warns users with potential loss of sensitive data from their IoT devices.

The description says it all! Our Software is primarily coded in Java and covers over a thousand lines of code. We detect attacks
namely, UDP Flood Attacks, ICMP Flood Attacks, Memcached Attacks, NTP Amplification Attacks and ARP Poisoning Attacks.

Many cybersecurity measures involve decreasing the impact of attacks once launched, or simply securing one’s devices irrespective of the attack on the system. While
these provide safe and essential practices to follow, we found that addressing the attack mechanism itself was a more effective measure
when trying to stop hackers. This mechanism is most vulnerable when it is being sent across a server, which is why we chose to focus on
detection and removal of a threat as early as possible, in the transmission stages on the network.

Using Wireshark's CMD equivalent, tshark, we are able to analyse packets and detect attacks over a network, 
while countering their effects on IoT Devices and Modems.

Modems essentially run by setting up software on Linux based OSs on PCs.
### Section 1: Installation of Software for A More Cybersecure Network
* Installation of BCP38 and BCP84 
  * This is installed on the Linux host-computer which sets up a modem.

## Instructions to Setup
  * The functionality of BCP38 and BCP84 is primarily for detecting spoofing of IP Address in Packet Traffic. In computer networking, ingress filtering is a technique used to ensure that incoming packets are actually from the networks from which they claim to originate. This can be used as a countermeasure against various spoofing attacks where the attacker's packets contain fake IP addresses to make it difficult to find the source of the attack. This technique is often used in the denial-of-service attack, and this is a primary target of ingress filtering. This is the main concept through which BCP38 and BCP84 work.

* Installation of Wireshark on your Host PC
  * You may install Wireshark from the official website and should be placed ideally in the Path "C:\Program Files\Wireshark"
  * Wireshark is a free and open-source packet analyzer. It is used for network troubleshooting, analysis, software and communications protocol development, and education.
  * This tool is essential and crucial for analysing Packets and is used by our software.
  * Wireshark should also be added to the Environment Variables on your PC for optimal use, which covered in Section 2.
  
* Setting up of a Next Generation Firewall
  * A next-generation firewall (NGFW) is a part of the third generation of firewall technology, combining a traditional firewall with other network device filtering functions, such as an application firewall using in-line deep packet inspection (DPI), an intrusion prevention system (IPS).
  * Intrusion Detection Technology is a crucial part of NGFW, which is a device or software application that monitors a network for malicious activity or policy violations. Any malicious activity or violation is typically reported or collected centrally using a security information and event management system.
  
### Section 2: Path Variables + Wireshark
If you open a Properties window for My PC, and select the Advanced tab, there's an "Environment Variables" button. If you click that button, it pops up a window that lets you edit your environment variables; there will probably be one called "Path" in your user variables (as opposed to the "System variables"). Change Path so that the directory in which Wireshark is installed is one of the directories in it (Path is a semicolon-separated list of directories).
 
Here's the things you need to do:

* Enter a colon ';' after the end of the most previous listing. 
* Enter "C:\Program Files\Wireshark".
* Apply and Save.

### Section 3: Setup of Access Denied
This video can largely explain the setup of Access Denied from GitHub. 





## Screenshots - Previews 
![Login Screen](https://github.com/Advik007/Access-Denied/blob/master/Screenshot%20(152).png)

![Main GUI](https://github.com/Advik007/Access-Denied/blob/master/Screenshot%20(170).png)

![Alert!](https://github.com/Advik007/Access-Denied/blob/master/Screenshot%20(160).png)

## Updates
* 23-03-2019: Basic Setup of Software Completed. Detects UDP, Memcached and Amplification
* 02-05-2019: Functional and Completed, detects ICMP and ARP Poisoning.
 
