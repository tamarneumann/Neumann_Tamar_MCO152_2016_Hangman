package unitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import exceptions.*;
import words.*;

public class GenerateWordTests 
{
	private GenerateWord word;
	
	@Test
	public void HangmanEasyWordsNotNull()
	{
		word = new GenerateWord("easy");
		assertNotNull(word);
	}
	
	@Test
	public void HangmanMediumWordsNotNull()
	{
		word=new GenerateWord("medium");
		assertNotNull(word);
	}
	
	@Test
	public void HangmanHardWordsNotNull()
	{
		word=new GenerateWord("hard");
		assertNotNull(word);
	}
	
	@Test
	public void EnumeratedEasyWordsMatchID()
	{
		assertEquals(20,EasyWords.GRAB.getID());
	}

	@Test
	public void EnumeratedMediumWordsMatchID()
	{
		assertEquals(20,MediumWords.FOLK.getID());

	}

	@Test
	public void EnumeratedHardWordsMatchID()
	{
		assertEquals(20,HardWords.ESSENTIAL.getID());	
	}
	
	@Test (expected=InvalidDifficultyLevelException.class)
	public void InvalidDifficultyInputThrowsException()
	{
		word=new GenerateWord("incorrectText");
	}
}
	


