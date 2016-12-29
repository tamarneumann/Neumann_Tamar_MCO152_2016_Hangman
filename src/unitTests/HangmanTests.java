package unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import HangmanGame.Hangman;

public class HangmanTests {

	private Hangman hangman;
	
	@Before
	public void setUp()
	{
		hangman = new Hangman();
	}
	
	@Test
	public void GuessLetterRetrunsTrueIfCorrect()
	{
		hangman.usePlayersWord("random");
		assertFalse(hangman.guessLetter('s'));
		assertTrue(hangman.guessLetter('r'));
		assertTrue(hangman.guessLetter('a'));
		assertTrue(hangman.guessLetter('n'));
		assertTrue(hangman.guessLetter('d'));
		assertTrue(hangman.guessLetter('o'));
		assertTrue(hangman.guessLetter('m'));
		 
	}
}
