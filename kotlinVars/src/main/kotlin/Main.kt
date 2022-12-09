import junit.framework.TestCase.assertEquals
import org.jetbrains.annotations.TestOnly
import org.junit.Test
import java.util.Scanner

fun nextBiggerNumber(n: Long): Long {
    return -1
}


fun main() {
    val scanner = Scanner(System.`in`);
    var text = ""

    do {
        val s = scanner.nextLine();
        if(s!= "-1") text += s;
        else{
            println(parse(text))
            text = ""
        }
    }while (s != "-2")





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