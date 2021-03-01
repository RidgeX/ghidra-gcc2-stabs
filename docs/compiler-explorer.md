## Using Compiler Explorer

- Create compilation directory on virtual machine

```
[ridge@vbox ridge]$ mkdir ce
```

- Add scp to `/usr/bin` on virtual machine

```
[root@vbox /root]# ln -s /usr/local/bin/scp /usr/bin/scp
```

- Clone the repository

```
ridge@localhost:/d/compiler-explorer$ git clone https://github.com/compiler-explorer/compiler-explorer.git
```

- Add the EGCS compiler

```
ridge@localhost:/d/compiler-explorer$ vim etc/config/c.local.properties
compilers=egcs112

compiler.egcs112.name=EGCS 1.1.2
compiler.egcs112.exe=D:\compiler-explorer\egcs-1.1.2.bat
```

- Create batch executable

```
ridge@localhost:/d/compiler-explorer$ vim egcs-1.1.2.bat
@echo off
C:\Python310\python.exe D:\compiler-explorer\egcs-1.1.2.py %*
```

- Create shim script

```
ridge@localhost:/d/compiler-explorer$ vim egcs-1.1.2.py
import os, subprocess, sys, tempfile

scp = 'D:\\msys64\\usr\\bin\\scp.exe'
ssh = 'D:\\msys64\\usr\\bin\\ssh.exe'
hostname = 'vbox'
username = 'ridge'

with open('D:\\compiler-explorer\\egcs-1.1.2.log', 'a') as f:
    f.write(str(sys.argv) + '\n')

if len(sys.argv) < 2 or sys.argv[1] == '-fsyntax-only':
    print('gcc: No input files', file=sys.stdout)
    sys.exit(1)

if sys.argv[1] == '--version':
    print('egcs-2.91.66')
    sys.exit(0)

tempdir = tempfile.gettempdir()
dirname = None
args = list(sys.argv)
for arg in args:
    if arg.startswith(tempdir) and arg.endswith('example.c'):
        dirname = os.path.dirname(arg)
if not dirname:
    sys.exit(1)
args[0] = 'gcc'
for i, arg in enumerate(args):
    if arg.startswith(tempdir):
        args[i] = f'/home/{username}/ce/' + os.path.basename(arg)

subprocess.run([scp, os.path.join(dirname, 'example.c'), f'{hostname}:/home/{username}/ce/example.c'], check=True)
subprocess.run([ssh, hostname, ' '.join(args)], check=True)
subprocess.run([scp, f'{hostname}:/home/{username}/ce/output.s', os.path.join(dirname, 'output.s')], check=True)
```

- Compiling

```
ridge@localhost:/d/compiler-explorer$ npm install
ridge@localhost:/d/compiler-explorer$ npm install webpack -g
ridge@localhost:/d/compiler-explorer$ npm install webpack-cli -g
ridge@localhost:/d/compiler-explorer$ npm update webpack
```

- Running

```
ridge@localhost:/d/compiler-explorer$ npm start
```

- Open `http://localhost:10240/` in your web browser

- Select language `C` and compiler `EGCS 1.1.2`

- Unfilter Directives under `Filter...`

- Example output:

```
        .file   "example.c"
        .version        "01.01"
.stabs "/home/ridge/",100,0,0,.Ltext0
.stabs "/home/ridge/ce/example.c",100,0,0,.Ltext0
.text
        .stabs  "gcc2_compiled.", 0x3c, 0, 0, 0
.stabs "int:t(0,1)=r(0,1);0020000000000;0017777777777;",128,0,0,0
.stabs "char:t(0,2)=r(0,2);0;127;",128,0,0,0
.stabs "long int:t(0,3)=r(0,1);0020000000000;0017777777777;",128,0,0,0
.stabs "unsigned int:t(0,4)=r(0,1);0000000000000;0037777777777;",128,0,0,0
.stabs "long unsigned int:t(0,5)=r(0,1);0000000000000;0037777777777;",128,0,0,0
.stabs "long long int:t(0,6)=r(0,1);01000000000000000000000;0777777777777777777777;",128,0,0,0
.stabs "long long unsigned int:t(0,7)=r(0,1);0000000000000;01777777777777777777777;",128,0,0,0
.stabs "short int:t(0,8)=r(0,8);-32768;32767;",128,0,0,0
.stabs "short unsigned int:t(0,9)=r(0,9);0;65535;",128,0,0,0
.stabs "signed char:t(0,10)=r(0,10);-128;127;",128,0,0,0
.stabs "unsigned char:t(0,11)=r(0,11);0;255;",128,0,0,0
.stabs "float:t(0,12)=r(0,1);4;0;",128,0,0,0
.stabs "double:t(0,13)=r(0,1);8;0;",128,0,0,0
.stabs "long double:t(0,14)=r(0,1);12;0;",128,0,0,0
.stabs "complex int:t(0,15)=s8real:(0,1),0,32;imag:(0,1),32,32;;",128,0,0,0
.stabs "complex float:t(0,16)=r(0,16);4;0;",128,0,0,0
.stabs "complex double:t(0,17)=r(0,17);8;0;",128,0,0,0
.stabs "complex long double:t(0,18)=r(0,18);12;0;",128,0,0,0
.stabs "void:t(0,19)=(0,19)",128,0,0,0
        .align 4
.stabs "main:F(0,1)",36,0,1,main
.globl main
        .type    main,@function
main:
.stabn 68,0,1,.LM1-main
        pushl %ebp
        movl %esp,%ebp
.stabn 68,0,2,.LM2-main
        xorl %eax,%eax
        jmp .L1
.stabn 68,0,3,.LM3-main
        .p2align 4,,7
.L1:
        leave
        ret
.Lfe1:
        .size    main,.Lfe1-main
.stabs "",36,0,0,.Lscope0-main
        .stabs "",100,0,0,.Letext
.Letext:
        .ident  "GCC: (GNU) egcs-2.91.66 19990314/Linux (egcs-1.1.2 release)"
```
