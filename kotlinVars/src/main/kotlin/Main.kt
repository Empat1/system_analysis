import junit.framework.TestCase.assertEquals
import org.jetbrains.annotations.TestOnly
import org.junit.Test

fun nextBiggerNumber(n: Long): Long {
    return -1
}


fun main() {

}

@Test
fun basicTests() {
    assertEquals(21, nextBiggerNumber(12))
    assertEquals(531, nextBiggerNumber(513))
    assertEquals(2071, nextBiggerNumber(2017))
    assertEquals(441, nextBiggerNumber(414))
    assertEquals(414, nextBiggerNumber(144))
}