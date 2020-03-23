# Access Denied - A JA Research Project
A software coded in Java to detect several cyber-attacks on your network, block attacker's IP addresses on your network's firewall and warns users with potential loss of sensitive data from their IoT devices. 

The description says it all! This repository is still under development and would be completed by the submission of the final solution! 

To prevent data from being stolen from our sensitive IoT devices,  Access Denied decided to stop the attack before it even accesses our network. Therefore, this software. We use this software to stop attacks before they attack our IoT devices. 

Using Eclipse and Java, we used tshark, a Wireshark-equivalent on CMD, such that its access to packet data across any server or network can be easily achieved.

## Graphic User Inferface
Our GUI (Graphic User Inferface) is user-friendly and does not require any technical setup by the user. 

![Our Access Denied GUI - Modified via Java](https://github.com/Advik007/Access-Denied/blob/master/Main%20GUI.png)

This is how our Main GUI looks like. The IP Address has been blackened out for safety reasons.

![Our Alert Screen when an Attack has been detected](https://github.com/Advik007/Access-Denied/blob/master/Alert%20Sign.jpg)

The Alert Screen is shown when an attack has been detected by our Java program.

## Updates
23-03-2020: We have only uploaded the Java Script available to block NTP Amplification Attacks, UDP Floods and Memcached Attacks. This uses the protocol of UDP and can be detected and blocked using our software. 
