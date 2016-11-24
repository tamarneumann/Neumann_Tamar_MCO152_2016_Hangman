package HangmanGame;

import words.*;
import exceptions.InvalidDifficultyLevelException;
import wordBank.*;

public class Hangman 
{
	private GuessWord guessWord;
	private WordBank wordBank;
	//private HangmanGuy hangmanGuy;
	
	public Hangman(String level) throws InvalidDifficultyLevelException
	{
		guessWord = new GuessWord(level);
		wordBank = new WordBank();
	}
	
	public boolean guessLetter(char letter)
	{
		wordBank.removeGuessedLetter(letter);
		return guessWord.guessLetter(letter);
	}
	
	public boolean guessWord(String word)
	{
		return guessWord.guessTheWord(word);
	}
	
	public boolean guessed()
	{
		return guessWord.guessed();
	}
	
	public String displayWord()
	{
		return guessWord.toString();
	}
}
