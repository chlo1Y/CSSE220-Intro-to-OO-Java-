import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author yangz
 *
 */
public class StringMethodsPracticeTest {

	private StringMethodsPractice practice;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.practice= new StringMethodsPractice();
	}

	@Test
	public void testShout() {
		assertEquals("HELLO", this.practice.shout("hello"));
	}

}
