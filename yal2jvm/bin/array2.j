.class public array2
.super java/lang/Object

.method public static sum_array([I)I
.limit locals 10
.limit stack 10
iconst_0
istore_1

iconst_0
istore_2

loop0:

iload_1
iload_0
if_icmplt loop0_end

iload_2
aload_0
aload_1
iadd
istore_2

iload_1
iconst_1
iadd
istore_1


goto loop0
loop0_end:
iload_2
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 10
.limit stack 10
bipush 16
istore_0

iload_0
newarray int
astore_1

iconst_0
istore_2

loop0:

iload_2
iload_0
if_icmplt loop0_end

iconst_1
aload_1
aload_2
iload_2
iconst_1
iadd
istore_2


goto loop0
loop0_end:
iload_-1
invokestatic array2/sum_array(I)I

istore_3

ldc "sum of array elements = "
iload_3
invokestatic io/println(Ljava/lang/String;I)

return
.end method


.method static public <clinit>()V
.limit stack 0
.limit locals 0
return
.end method
