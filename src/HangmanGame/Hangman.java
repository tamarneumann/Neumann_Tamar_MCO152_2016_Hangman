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
		guessWord = new GuessWord();
		
	}
	
	/**
	 * Method to set up a game based on the player's word.
	 * @param word the word used for the hangman game.
	 */
	public void usePlayersWord(String word)
	{
		guessWord.playerWord(word);
	}
	
	/**
	 * Method to set up a game based on the player's selected level.
	 * @param level The player's choice of level.
	 */
	public void createRandomWord(String level)
	{
		guessWord.randomWord(level);
	}
	
	/**
	 * Method to test the player's guessed letter.
	 * @param letter The player's guess.
	 * @return Boolean value if player's guess was correct.
	 * @throws InvalidGuessException if the player did not guess the correct letter.
	 */
	public boolean guessLetter(char letter) throws InvalidGuessException
	{
		wordBank.removeGuessedLetter(letter);
		boolean guessed= guessWord.guessLetter(letter);
		
		//if the letter guessed was incorrect, 
		//increment the variable to keep track of players' incorrect guesses.
		 if(!guessed)
		 {
			 hmperson.increaseGuess();
		 }
		return guessed;
	}
	
	/**
	 * Method that takes the player's guess of the complete word.
	 * @param word the player's word guess.
	 */
	public void guessWord(String word)
	{
		 guessWord.guessTheWord(word);
	}
	
	/**
	 * Method to see if the word was guessed.
	 * @return Boolean value if word was guessed.
	 */
	public boolean guessed()
	{
		return guessWord.guessed();
	}
	
	/**
	 * String method to display the word used for the game. 
	 * If the letter was not guessed, there is an underscore instead.
	 * @return the word.
	 */
	public String displayWord()
	{
		return guessWord.toString();
	}
	
	/**
	 * Method to get the amount of incorrect guesses from the player.
	 * @return the number of incorrect guesses.
	 */
	public int getIncorrectGuess()
	{
		return hmperson.getIncorrectGuess();
	}
	
	
	/**
	 * Method that gets the complete word being used.
	 * @return the word being used for the game.
	 */
	public String getWord()
	{
		return guessWord.getWord();
	}
	
	public void resetGame()
	{
		wordBank.resetWordBank();
		guessWord.setWordGuessed(false);
		guessWord.setLettersGuessed(0);
	}
	//create a static method so it can be accessed before the hangman
	//object is initialized
	//it needs to be this way because the user needs to see instructions
	//before the game.
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
