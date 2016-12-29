package unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import words.*;

public class GuessWordTests 
{
	private GuessWord gword;
	
	@Before
	public void SetUp()
	{
		gword = new GuessWord();
	}
	
	@Test
	public void GuessWordNotNull()
	{
		assertNotNull(gword);
	}
	
	@Test
	public void RandomWordCreatesWord()
	{
		gword.randomWord("medium");
		assertNotNull(gword.getWord());
	}
	
	
	@Test
	public void GuessLetterFindsMatchingLetterToUsersInputFromRandomWord()
	{
		gword.randomWord("easy");
		if (gword.getWord().indexOf("a") != -1) 
			assertTrue(gword.guessLetter('a'));
		else
			assertFalse(gword.guessLetter('a'));
	}
	
	@Test
	public void GuessLetterFindsMatchingLetterToUsersInputFromUserWord()
	{
		gword.playerWord("player");
		assertTrue(gword.guessLetter('p'));
		assertTrue(gword.guessLetter('L'));
		assertTrue(gword.guessLetter('a'));
		assertTrue(gword.guessLetter('y'));
		assertTrue(gword.guessLetter('E'));
		assertTrue(gword.guessLetter('r'));
		assertFalse(gword.guessLetter('z'));
	}
	
	@Test
	public void IncorrectGuessTheWordIsFalse()
	{
		gword.randomWord("easy");
		assertFalse("wrong word".equals(gword));
	}
	
	@Test
	public void GuessCorrectWord()
	{
		gword.playerWord("hello");
		gword.guessTheWord("hello");
		assertTrue(gword.guessed());
	}
	
}
