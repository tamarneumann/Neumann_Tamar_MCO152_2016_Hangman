package unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import exceptions.*;
import words.*;

public class GenerateWordTests 
{
	private GenerateWord word;
	
	@Before
	public void setUp()
	{
		word = new GenerateWord();
	}
	
	@Test
	public void HangmanEasyWordsNotNull()
	{
		word.createRandomWord("easy");
		assertNotNull(word);
	}
	
	@Test
	public void HangmanMediumWordsNotNull()
	{
		word.createRandomWord("medium");
		assertNotNull(word);
	}
	
	@Test
	public void HangmanHardWordsNotNull()
	{
		word.createRandomWord("hard");
		assertNotNull(word);
	}
	
	
	@Test (expected=InvalidDifficultyLevelException.class)
	public void InvalidDifficultyInputThrowsException()
	{
		word.createRandomWord("incorrectText");
	}
	
	@Test
	public void UserWordNotNull()
	{
		word.setWord("userWord");
		assertNotNull(word);
	}
	
	@Test
	public void UserEnterWordGetsCorrectNumLetters()
	{
		word.setWord("example");
		assertEquals(7, word.getNumLetters());
	}
	
	@Test
	public void GetWordReturnsCorrectWord()
	{
		word.setWord("example");
		assertEquals("example", word.getWord());
	}
}
	


