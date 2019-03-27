import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/*
   Item   Unit     Special
         Price     Price
  --------------------------
    A     50       3 for 130
    B     30       2 for 45
    C     20
    D     15

 */
class CheckOutTest {
    @Test
    @Throws(Exception::class)
    fun testTotalsEmpty() {
        assertEquals(0, price(""))
    }

    @Test
    @Throws(Exception::class)
    fun testTotalBasketContentA() {
        assertEquals(50, price("A"));
    }

    @Test
    @Throws(Exception::class)
    fun testTotalBasketContentB() {
        assertEquals(80, price("AB"))
    }

    @Test
    @Throws(Exception::class)
    fun testTotalBasketContentCDBA() {
        assertEquals(115, price("CDBA"))
    }

    @Test
    @Throws(Exception::class)
    fun testTotalBasketContentAA() {
        assertEquals(100, price("AA"))
    }

    @Test
    @Throws(Exception::class)
    fun testTotalBasketContentAAA() {
        assertEquals(130, price("AAA"))
    }

    @Test
    @Throws(Exception::class)
    fun testTotalBasketContentAAAA() {
        assertEquals(180, price("AAAA"))
    }

    @Test
    @Throws(Exception::class)
    fun testTotalBasketContentAAAAA() {
        assertEquals(230, price("AAAAA"))
    }

    @Test
    @Throws(Exception::class)
    fun testTotalBasketContentAAAAAA() {
        assertEquals(260, price("AAAAAA"))
    }

    @Test
    @Throws(Exception::class)
    fun testTotalBasketContentAAAB() {
        assertEquals(160, price("AAAB"))
    }

    @Test
    @Throws(Exception::class)
    fun testTotalBasketContentAAABB() {
        assertEquals(175, price("AAABB"))
    }

    @Test
    @Throws(Exception::class)
    fun testTotalBasketContentAAABBD() {
        assertEquals(190, price("AAABBD"))
    }

    @Test
    @Throws(Exception::class)
    fun testTotalBasketContentDABABA() {
        assertEquals(190, price("DABABA"))
    }
    /*
  		assertEquals(0, price(""))
        assertEquals(50, price("A"))
        assertEquals(80, price("AB"))
        assertEquals(115, price("CDBA"))

        assertEquals(100, price("AA"))
        assertEquals(130, price("AAA"))
        assertEquals(180, price("AAAA"))
        assertEquals(230, price("AAAAA"))
        assertEquals(260, price("AAAAAA"))

        assertEquals(160, price("AAAB"))
        assertEquals(175, price("AAABB"))
        assertEquals(190, price("AAABBD"))
        assertEquals(190, price("DABABA"))
  */

    private fun price(items: String): Int {
        val checkOut = CheckOut()
        for (i in 0 until items.length) {
            checkOut.scan(items.substring(i, i + 1))
        }
        return checkOut.total()
    }
}
