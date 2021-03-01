## Using binutils

```
[ridge@vbox ridge]$ gcc --version
egcs-2.91.66

[ridge@vbox ridge]$ gdb --version
GNU gdb 19991004
Copyright 1998 Free Software Foundation, Inc.
(...)

[ridge@vbox ridge]$ objdump --version
GNU objdump 2.9.5
Copyright 1997, 1998, 1999 Free Software Foundation, Inc.
(...)
```

- Compile an object file

```
[ridge@vbox ridge]$ vi simple.c
int main(void) {
    return 0;
}

[ridge@vbox ridge]$ gcc -g -c simple.c
```

- Display the contents of the .stab section

```
[ridge@vbox ridge]$ objdump -G simple.o

simple.o:     file format elf32-i386

Contents of .stab section:

Symnum n_type n_othr n_desc n_value  n_strx String

-1     HdrSym 0      28     00000374 1
0      SO     0      0      00000000 10     /home/ridge/
1      SO     0      0      00000000 23     simple.c
2      OPT    0      0      00000000 32     gcc2_compiled.
3      LSYM   0      0      00000000 47     int:t(0,1)=r(0,1);0020000000000;0017777777777;
4      LSYM   0      0      00000000 94     char:t(0,2)=r(0,2);0;127;
5      LSYM   0      0      00000000 120    long int:t(0,3)=r(0,1);0020000000000;0017777777777;
6      LSYM   0      0      00000000 172    unsigned int:t(0,4)=r(0,1);0000000000000;0037777777777;
7      LSYM   0      0      00000000 228    long unsigned int:t(0,5)=r(0,1);0000000000000;0037777777777;
8      LSYM   0      0      00000000 289    long long int:t(0,6)=r(0,1);01000000000000000000000;0777777777777777777777;
9      LSYM   0      0      00000000 365    long long unsigned int:t(0,7)=r(0,1);0000000000000;01777777777777777777777;
10     LSYM   0      0      00000000 441    short int:t(0,8)=r(0,8);-32768;32767;
11     LSYM   0      0      00000000 479    short unsigned int:t(0,9)=r(0,9);0;65535;
12     LSYM   0      0      00000000 521    signed char:t(0,10)=r(0,10);-128;127;
13     LSYM   0      0      00000000 559    unsigned char:t(0,11)=r(0,11);0;255;
14     LSYM   0      0      00000000 596    float:t(0,12)=r(0,1);4;0;
15     LSYM   0      0      00000000 622    double:t(0,13)=r(0,1);8;0;
16     LSYM   0      0      00000000 649    long double:t(0,14)=r(0,1);12;0;
17     LSYM   0      0      00000000 682    complex int:t(0,15)=s8real:(0,1),0,32;imag:(0,1),32,32;;
18     LSYM   0      0      00000000 739    complex float:t(0,16)=r(0,16);4;0;
19     LSYM   0      0      00000000 774    complex double:t(0,17)=r(0,17);8;0;
20     LSYM   0      0      00000000 810    complex long double:t(0,18)=r(0,18);12;0;
21     LSYM   0      0      00000000 852    void:t(0,19)=(0,19)
22     FUN    0      1      00000000 872    main:F(0,1)
23     SLINE  0      1      00000000 0
24     SLINE  0      2      00000003 0
25     SLINE  0      3      00000007 0
26     FUN    0      0      00000009 0
27     SO     0      0      00000009 0
```

- Display Stabs debugging information

```
[ridge@vbox ridge]$ objdump -g simple.o

simple.o:     file format elf32-i386

/home/ridge/simple.c:
typedef int32 int;
typedef int8 char;
typedef int32 long int;
typedef uint32 unsigned int;
typedef uint32 long unsigned int;
typedef int64 long long int;
typedef uint64 long long unsigned int;
typedef int16 short int;
typedef uint16 short unsigned int;
typedef int8 signed char;
typedef uint8 unsigned char;
typedef float float;
typedef double double;
typedef float96 long double;
typedef struct %anon1 { /* size 8 */
  int real; /* bitsize 32, bitpos 0 */
  int imag; /* bitsize 32, bitpos 32 */
} complex int;
typedef complex float complex float;
typedef complex double complex double;
typedef complex float96 complex long double;
typedef void void;
int main ()
{ /* 0x0 */
  /* file /home/ridge/simple.c line 1 addr 0x0 */
  /* file /home/ridge/simple.c line 2 addr 0x3 */
  /* file /home/ridge/simple.c line 3 addr 0x7 */
} /* 0x9 */
```

- Disassemble code with line numbers and relocations included

```
[ridge@vbox ridge]$ objdump -dlr simple.o

simple.o:     file format elf32-i386

Disassembly of section .text:

00000000 <main>:
main():
/home/ridge/simple.c:1
   0:   55                      push   %ebp
   1:   89 e5                   mov    %esp,%ebp
/home/ridge/simple.c:2
   3:   31 c0                   xor    %eax,%eax
   5:   eb 00                   jmp    7 <main+0x7>
/home/ridge/simple.c:3
   7:   c9                      leave
   8:   c3                      ret
```
