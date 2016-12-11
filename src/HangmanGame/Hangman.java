package HangmanGame;

import words.*;
import exceptions.InvalidDifficultyLevelException;
import exceptions.LetterAlreadyGuessException;
import wordBank.*;

public class Hangman 
{
	private GuessWord guessWord;
	private WordBank wordBank;
	private Person hmperson;
	
	public Hangman(String level) throws InvalidDifficultyLevelException
	{
		guessWord = new GuessWord(level);
		wordBank = new WordBank();
		hmperson = new Person();
	}
	
	public boolean guessLetter(char letter) throws LetterAlreadyGuessException
	{
		wordBank.removeGuessedLetter(letter);
		boolean guessed= guessWord.guessLetter(letter);
		
		//if the letter guessed was incorrect, increment the variable.
		 if(!guessed)
		 {
			 hmperson.increaseGuess();
		 }
		return guessed;
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
	
	public int getIncorrectGuess()
	{
		return hmperson.getIncorrectGuess();
	}
	
	public String getWord()
	{
		return guessWord.getWord();
	}
	
	//create a static method so it can be accessed before the hangman
	//object is initialized
	//it needs to be this way because the user needs to see instructions
	//so they know to select a difficulty and the object is only
	//instantiated once a level is selected
	public static String gameRules()
	{
		StringBuilder rules = new StringBuilder();
		rules.append("Game Rules:\n"
				+ "1. Select a difficulty\n"
				+ "2. Guess letters one at a time until the word is guessed\n"
				+ "3. You can guess until the hangman guy is complete");
		//write up the game rules
		return rules.toString();
	}
	
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		sb.append(hmperson.getObject() +"\n" 
				+ wordBank.printLettersRemaining()+"\n"
				+ wordBank.printLettersGuessed()+"\n"
				+ "\nYour Word is:  " + guessWord);
		
		return sb.toString();
	}
}
