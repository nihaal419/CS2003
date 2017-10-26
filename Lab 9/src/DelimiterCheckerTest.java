import static org.junit.Assert.*;

import org.junit.Test;

public class DelimiterCheckerTest {

	@Test
	public void test() {
		DelimiterChecker dcheck = new DelimiterChecker();
		boolean ch = dcheck.check("");
		assertEquals(true, ch);
		DelimiterChecker dcheck1 = new DelimiterChecker();
		boolean a = dcheck1.check("{");
		assertEquals(false, a);
		DelimiterChecker dcheck2 = new DelimiterChecker();
		boolean b = dcheck2.check("{}");
		assertEquals(true, b);
		DelimiterChecker dcheck3 = new DelimiterChecker();
		boolean c = dcheck3.check("{{}");
		assertEquals(false, c);
		DelimiterChecker dcheck4 = new DelimiterChecker();
		boolean d = dcheck4.check("{{}}");
		assertEquals(true, d);
	}

}
