package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import HangmanGame.Hangman;

public class HangmanTests {

	private Hangman hangman;
	
	@Test
	public void ReturnNumberOfIncorrectGuesses()
	{
		 hangman=new Hangman("easy");
		 //a number will always be incorrect
		 hangman.guessLetter('5');
		 assertEquals(1, hangman.getIncorrectGuess());
		
	}
}
