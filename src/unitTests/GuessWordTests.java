package unitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import words.*;

public class GuessWordTests 
{
	private GuessWord gword;
	
	@Test
	public void GuessWordHardNotNull()
	{
		gword = new GuessWord("hard");
		assertNotNull(gword);
	}
	
	@Test
	public void GuessWordMediumNotNull()
	{
		gword = new GuessWord("medium");
		assertNotNull(gword);
	}
	
	@Test
	public void GuessWordEasyNotNull()
	{
		gword = new GuessWord("easy");
		assertNotNull(gword);
	}
	
	
	@Test
	public void GuessLetterFindsMatchingLetterToUsersInput()
	{
		gword = new GuessWord("easy");
		if (gword.getWord().indexOf("a") != -1) 
			assertTrue(gword.guessLetter('a'));
		else
			assertFalse(gword.guessLetter('a'));
	}
	
	
}
