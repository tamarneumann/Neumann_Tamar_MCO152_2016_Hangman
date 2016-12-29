package HangmanGame;

import words.*;
import exceptions.InvalidDifficultyLevelException;
import exceptions.InvalidGuessException;
import wordBank.*;

public class Hangman 
{
	private GuessWord guessWord;
	private WordBank wordBank;
	private Person hmperson;
	
	public Hangman(){
		wordBank = new WordBank();
		hmperson = new Person();
		guessWord=new GuessWord();
		
	}
	
	public void usePlayersWord(String word)
	{
		guessWord.playerWord(word);
	}
	
	public void createRandomWord(String level)
	{
		guessWord.randomWord(level);
	}
	
	public boolean guessLetter(char letter) throws InvalidGuessException
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
	
	public void guessWord(String word)
	{
		 guessWord.guessTheWord(word);
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
				+ "WELCOME TO HANGMAN. "
				+ "\n-THE GOAL OF THE GAME IS TO GUESS A WORD, ONE LETTER AT A TIME."
				+ "\n-EVERY INCORRECT LETTER YOU GUESS ADDS A PART TO THE HANGMAN."
				+ "\n-AFTER 10 INCORRECT GUESSES, THE HANGMAN IS COMPLETE MAKING IT A GAME OVER."
				+ "\n-IF AT ANY POINT YOU WOULD LIKE TO GUESS THE ENTIRE WORD, ENTER \"0\". ");
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
