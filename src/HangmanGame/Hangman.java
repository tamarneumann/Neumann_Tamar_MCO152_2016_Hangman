package HangmanGame;

import words.*;
import exceptions.InvalidDifficultyLevelException;
import wordBank.*;

public class Hangman 
{
	private GuessWord guessWord;
	private WordBank wordBank;
	private int incorrectLetter; //keep count of incorrect guesses.
	//private HangmanGuy hangmanGuy;
	
	public Hangman(String level) throws InvalidDifficultyLevelException
	{
		incorrectLetter=0;
		guessWord = new GuessWord(level);
		wordBank = new WordBank();
	}
	
	public boolean guessLetter(char letter)
	{
		wordBank.removeGuessedLetter(letter);
		boolean guessed= guessWord.guessLetter(letter);
		
		//if the letter guessed was incorrect, increment the variable.
		 if(!guessed)
			 incorrectLetter++;
		 
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
		return incorrectLetter;
	}
	
	public String getWord()
	{
		return guessWord.getWord();
	}
	
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		sb.append(wordBank.printLettersRemaining()+"\n"
				+ wordBank.printLettersGuessed()+"\n"
				+ "\nYour Word is:  " + guessWord);
		
		return sb.toString();
	}
}
