package ua.rozhkov;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.testng.Assert.*;

public class FibonachiSeqTest {

	FibonachiSeq fibonachiSeq;

	@BeforeMethod
	public void setUp() throws Exception {
		fibonachiSeq = new FibonachiSeq();
	}

	@DataProvider(name = "testFormSeqData")
	public Object[][] createData() {
		return new Object[][]{
				{"1", "0 1 1 2 3 5 8"},
				{"4 15", "5 8 13"},
				{"5, 25", "5 8 13 21"}
		};
	}

	@Test(dataProvider = "testFormSeqData")
	public void testFormSeq(String input, String expected) throws Exception {
		String actual = fibonachiSeq.formSeq(input);
		assertEquals(expected, actual);
	}
}