## Installing Red Hat Linux 6.2 in VirtualBox

1. Download the Red Hat Linux 6.2 installation media.

```
ridge@localhost:~$ wget http://archive.download.redhat.com/pub/redhat/linux/6.2/en/iso/i386/redhat-6.2-i386.iso
```

2. Create a new virtual machine with name `Red Hat 6.2` and version `Red Hat (32-bit)`. Leave the memory and hard disk settings as defaults.

3. Go to the network settings and select Adapter 1. Under Advanced, change the adapter type to `PCnet-FAST III`.

4. Go to the storage settings. Remove the SATA controller and add a BusLogic SCSI controller. Add the existing virtual disk image `Red Hat 6.2.vdi` to the SCSI controller. Add `redhat-6.2-i386.iso` to the IDE CD drive.

5. Start the virtual machine.

6. Press Enter to boot the installer.

7. Choose language `English` and keyboard layout `us`.

8. Select `OK` and choose installation type `GNOME Workstation`.

9. Initialize the partition table and use automatic partitioning.

10. Set the hostname to `vbox`. Leave the network setting `Use bootp/dhcp` checked and continue.

11. Leave the default mouse `Generic - 3 Button Mouse (PS/2)` selected and continue.

12. Check `Hardware clock set to GMT` and choose your timezone.

13. Set a root password. Set a regular user name and password. Select `OK` to finish adding users.

14. Choose `Generic FBDev` as the video card.

15. After installation, skip creating a boot disk and press Enter to reboot.

16. Login as the root user.

17. Add the line `vga=773` to your `/etc/lilo.conf` file to set the video mode to 1024x768 with 256 colors. Run `lilo` and reboot.

```
[root@vbox /root]# vi /etc/lilo.conf
boot=/dev/sda
map=/boot/map
install=/boot/boot.b
prompt
timeout=50
linear
default=linux
vga=773

image=/boot/vmlinuz-2.2.14-5.0
	label=linux
	initrd=/boot/initrd-2.2.14-5.0.img
	read-only
	root=/dev/sda5

[root@vbox /root]# lilo
[root@vbox /root]# reboot
```

18. Login as a regular user.

19. Start the GNOME desktop environment.

```
[ridge@vbox ridge]$ startx
```

20. Open Netscape Communicator and accept the license agreement.

21. Download Wget 1.5.3 on the host machine.

```
ridge@localhost:~$ mkdir www
ridge@localhost:~$ cd www
ridge@localhost:~/www$ wget https://ftp.gnu.org/gnu/wget/wget-1.5.3.tar.gz
```

22. Find the IP address of the host machine (`192.168.x.x`).

```
C:\Users\Ridge>ipconfig /all | find "IPv4 Address"
```

23. Start a web server on the host machine.

```
ridge@localhost:~/www$ python -m http.server 80
```

24. Navigate to `192.168.x.x` on the guest machine. Click on `wget-1.5.3.tar.gz` and save it to your home folder.

25. Close Netscape and log out of GNOME.

26. Compile and install Wget.

```
[ridge@vbox ridge]$ tar -xzvf wget-1.5.3.tar.gz
[ridge@vbox ridge]$ cd wget-1.5.3
[ridge@vbox wget-1.5.3]$ ./configure
[ridge@vbox wget-1.5.3]$ make
[ridge@vbox wget-1.5.3]$ exit

[root@vbox /root]# cd /home/ridge/wget-1.5.3
[root@vbox wget-1.5.3]# make install
[root@vbox wget-1.5.3]# reboot
```

27. Power off the virtual machine.

28. Open Host Network Manager from the File menu and confirm the default settings for `VirtualBox Host-Only Ethernet Adapter`:

```
(x) Configure adapter manually
IPv4 address: 192.168.56.1
IPv4 network mask: 255.255.255.0

[x] Enable DHCP server
Server address: 192.168.56.100
Server mask: 255.255.255.0
Lower address bound: 192.168.56.101
Upper address bound: 192.168.56.254
```

29. Go to the network settings and select Adapter 2. Enable the adapter and make it a  `Host-only Adapter`. Under Advanced, change the adapter type to `PCnet-FAST III`.

30. Start the virtual machine. If error `VERR_INTNET_FLT_IF_NOT_FOUND` occurs, try disabling and reenabling `VirtualBox Host-Only Ethernet Adapter` under Windows Network Connections.

31. Press Enter when the new hardware added message appears. Choose `Configure` and `Migrate existing network configuration`.

32. Download OpenSSL 0.9.5a and OpenSSH 2.5.1p1 on the guest machine.

```
[ridge@vbox ridge]$ wget http://www.mirrorservice.org/sites/ftp.wiretapped.net/pub/security/cryptography/libraries/ssl/openssl/openssl-0.9.5a.tar.gz
[ridge@vbox ridge]$ wget http://www.mirrorservice.org/pub/OpenBSD/OpenSSH/portable/openssh-2.5.1p1.tar.gz
```

33. Compile and install OpenSSL.

```
[ridge@vbox ridge]$ tar -xzvf openssl-0.9.5a.tar.gz
[ridge@vbox ridge]$ cd openssl-0.9.5a
[ridge@vbox openssl-0.9.5a]$ ./config
[ridge@vbox openssl-0.9.5a]$ make
[ridge@vbox openssl-0.9.5a]$ make test
[ridge@vbox openssl-0.9.5a]$ exit

[root@vbox /root]# cd /home/ridge/openssl-0.9.5a
[root@vbox openssl-0.9.5a]# make install
[root@vbox openssl-0.9.5a]# exit
```

34. Compile and install OpenSSH.

```
[ridge@vbox ridge]$ tar -xzvf openssh-2.5.1p1.tar.gz
[ridge@vbox ridge]$ cd openssh-2.5.1p1
[ridge@vbox openssh-2.5.1p1]$ ./configure --with-ipv4-default --with-md5-passwords
[ridge@vbox openssh-2.5.1p1]$ make
[ridge@vbox openssh-2.5.1p1]$ exit

[root@vbox /root]# cd /home/ridge/openssh-2.5.1p1
[root@vbox openssh-2.5.1p1]# make install
```

35. Create a startup script for OpenSSH and reboot.

```
[root@vbox openssh-2.5.1p1]# vi /etc/rc.d/init.d/sshd
#
# secure shell daemon
#
# chkconfig: 2345 90 05
# description: secure shell daemon
#

SSHD=/usr/local/sbin/sshd

[ -x $SSHD ] || exit 0

case "$1" in
  start)        echo "Starting secure shell daemon"
                eval $SSHD
                ;;
esac

[root@vbox openssh-2.5.1p1]# cd /etc/rc.d/init.d
[root@vbox init.d]# chmod +x sshd
[root@vbox init.d]# chkconfig --add sshd
[root@vbox init.d]# reboot
```

36. Check that `eth1` is present in the list of ethernet adapters.

```
[root@vbox /root]# ifconfig -a
```

37. Create a startup script for `eth1`.

```
[root@vbox /root]# vi /etc/sysconfig/network-scripts/ifcfg-eth1
DEVICE=eth1
BOOTPROTO=dhcp
ONBOOT=yes
```

38. Restart the network service to load the new script.

```
[root@vbox /root]# /etc/rc.d/init.d/network restart
```

39. Find the IP address of the guest machine (`192.168.56.x`).

```
[root@vbox /root]# ifconfig
```

40. Add a new entry to your SSH config on the host machine with the following insecure settings required for old SSH servers:

```
ridge@localhost:~/www$ cd ~
ridge@localhost:~$ mkdir .ssh
ridge@localhost:~$ vim .ssh/config
Host vbox
  Ciphers +aes256-cbc
  HostKeyAlgorithms +ssh-dss
  HostName 192.168.56.101
  KexAlgorithms +diffie-hellman-group1-sha1
  PubkeyAcceptedKeyTypes +ssh-rsa
  User ridge
```

41. Connect to the guest machine using password authentication.

```
ridge@localhost:~$ ssh vbox
```

42. Generate a RSA keypair and add it to the list of authorized keys.

```
[ridge@vbox ridge]$ mkdir .ssh
[ridge@vbox ridge]$ chmod 700 .ssh
[ridge@vbox ridge]$ /usr/local/bin/ssh-keygen -t rsa
[ridge@vbox ridge]$ cat .ssh/id_rsa.pub >> .ssh/authorized_keys2
[ridge@vbox ridge]$ chmod 600 .ssh/authorized_keys2
[ridge@vbox ridge]$ exit
```

43. Copy the keypair to the host machine.

```
ridge@localhost:~$ sftp vbox:.ssh/id_rsa.pub .ssh/vbox.pub
ridge@localhost:~$ sftp vbox:.ssh/id_rsa .ssh/vbox
```

44. Add the `IdentityFile` line under `Host vbox` in your SSH config on the host machine.

```
  IdentityFile ~/.ssh/vbox
```

45. Connect to the guest machine using key authentication.

```
ridge@localhost:~$ ssh vbox
[ridge@vbox ridge]$ exit
```

46. Create a simple C program and copy it to the guest machine.

```
ridge@localhost:~$ vim hello.c
#include <stdio.h>

int main(void) {
    printf("Hello world!\n");
    return 0;
}

ridge@localhost:~$ sftp vbox
sftp> put hello.c
sftp> bye
```

47. Check that the program compiles and runs successfully.

```
[ridge@vbox ridge]$ gcc -o hello hello.c
[ridge@vbox ridge]$ ./hello
Hello world!
```
