def sum(a: Int, b: Int): Int = a + b

val f0 = sum _
val f1 = sum(3, _)

sum(3, 5)
f0(3, 5)
f1(5)

val curryingSum: Int => Int => Int = a => b => a + b

val curryingF1 = curryingSum(3)
curryingF1(5)

def curryingSumV2(a: Int)(b: Int): Int = a + b

curryingSumV2(5)(7)

val c1 = curryingSumV2(7)_

val res = c1(3)