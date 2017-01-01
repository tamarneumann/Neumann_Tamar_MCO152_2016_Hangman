package unitTests;

import static org.junit.Assert.*;

import org.junit.*;

import wordBank.WordBank;

public class WordBankTests {
	
	private WordBank wb;
	
	@Before
	public void createWordBank()
	{
		 wb=new WordBank();
	}
	
	@Test
	public void testLettersLeftCorrectAmount()
	{
	    
		assertEquals(26, wb.getLettersLeft().size());	
		wb.removeGuessedLetter('A');
		assertEquals(25, wb.getLettersLeft().size());
	}
	
	@Test
	public void testLettersGuessedBeginsEmpty()
	{
		assertEquals(0,wb.getLettersGuessed().size());
	}
	
	@Test
	public void testLettersGuessedCorrectAmount()
	{
		wb.removeGuessedLetter('A');
		assertEquals(1, wb.getLettersGuessed().size());
	}

}
