.class public programa2
.super java/lang/Object

.method public static f1([I)[I
.limit locals 4
.limit stack 4
iconst_0
istore_1

aload_0
arraylength
istore_2

iload_2
newarray int
astore_3

loop0:

iload_1
aload_0
arraylength
if_icmpge loop0_end

aload_3
iload_1
aload_0
iload_1
iaload
iastore
iinc 1 1
goto loop0

loop0_end:
aload_3
areturn
.end method

.method public static f2(I)[I
.limit locals 3
.limit stack 3
iload_0
newarray int
astore_1

iconst_0
istore_2
loop0:
iload_2
aload_1
arraylength
if_icmpge loop0_end
aload_1
iload_2
iconst_1
iastore
iinc 2 1
goto loop0
loop0_end:


aload_1
areturn
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 4
.limit stack 8
bipush 100
newarray int
astore_0

aload_0
iconst_0
iload_-1
iconst_1
iastore
aload_0
bipush 99
iload_-1
iconst_2
iastore
aload_0
invokestatic programa2/f1([I)[I

istore_1

aload_1
iconst_0
iload_-1
iaload
istore_2

aload_1
bipush 99
iload_-1
iaload
istore_3

ldc "first: "
iload_2
invokestatic io/println(Ljava/lang/String;I)V

ldc "last: "
iload_3
invokestatic io/println(Ljava/lang/String;I)V

bipush 100
invokestatic programa2/f2(I)[I

istore_1

aload_1
iconst_0
iload_-1
iaload
istore_2

aload_1
bipush 99
iload_-1
iaload
istore_3

ldc "first: "
iload_2
invokestatic io/println(Ljava/lang/String;I)V

ldc "last: "
iload_3
invokestatic io/println(Ljava/lang/String;I)V
return
.end method


.method static public <clinit>()V
.limit locals 0
.limit stack 1 
return
.end method

