import junit.framework.TestCase.assertEquals
import org.jetbrains.annotations.TestOnly
import org.junit.Test
import java.util.Scanner

fun nextBiggerNumber(n: Long): Long {
    return -1
}


fun main() {
    /*1*/val scanner = Scanner(System.`in`) /*1*/
    /*2*/println("Ввидете размер масива")
    /*3*/val sizeArray = scanner.nextInt()
    /*4*/if (sizeArray < 0) {
        /*5*/     println("Размер массива введен не корректно")
        /*6*/    return
        /*7*/}

    /*8*/var mul = 1;
    /*9*/for(i in 0 until sizeArray){
        /*10*/val element = scanner.nextInt();
        /*11*/if(element % 2 == 1){
            /*12*/mul *= element
        /*13*/}
        /*14*/}
    /*15*/println("Произведение = $mul")
}

@Test
fun basicTests() {
    assertEquals(21, nextBiggerNumber(12))
    assertEquals(531, nextBiggerNumber(513))
    assertEquals(2071, nextBiggerNumber(2017))
    assertEquals(441, nextBiggerNumber(414))
    assertEquals(414, nextBiggerNumber(144))
}


fun parse(s: String) : String{
    var a = s;
        a = a.replace("-" , "")
    a = a.replace("-\n" ," ")
    return a
}