.class public aval3
.super java/lang/Object

.method public static f(II)I
.limit locals 10
.limit stack 10
iload_0
iload_1
if_icmplt loop0_end

iconst_2
istore_2

iconst_4
istore_2


loop0_end:
iload_2
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 10
.limit stack 10
iconst_2
istore_0

iconst_3
istore_1

iload_0
iload_1
invokestatic aval3/f(I;I)I

istore_0

iload_0
invokestatic io/println(I)

bipush 6
istore_0

iload_0
iload_1
invokestatic aval3/f(I;I)I

istore_0

iload_0
invokestatic io/println(I)

return
.end method


.method static public <clinit>()V
.limit stack 0
.limit locals 0
return
.end method

