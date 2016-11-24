package HangmanGame;
import words.*;
import java.util.Scanner;
import exceptions.*;
import wordBank.*;

public class HangmanMain 
{
	public static void main(String[] args)
	{
		boolean guess;
		GuessWord word = null;
		WordBank bank = new WordBank();
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the level you would like to play: easy, medium or hard: ");
		String level = input.nextLine();
		
		try
		{
			word = new GuessWord(level);
		}
		catch(InvalidDifficultyLevelException e)
		{
			System.out.println(e);
		}
		do
		{
		
		    System.out.println(bank.toString());
			System.out.println("\n"+word);
			
			guess=guessLetter(input, word, bank);
			
			if(!guess)
				  System.out.println("The letter you guessed is incorrect.");
			 
		}while(word.guessed());
		
		System.out.println(word);
		System.out.println("Congratulations you guess the word "+word.getWord()+"!");
	}
	
	public static boolean guessLetter(Scanner input, GuessWord word, WordBank bank)
	{
		char letter;
		boolean guess;
		
		System.out.println("Guess a letter");
		letter=input.nextLine().toUpperCase().charAt(0);	
		
		guess=word.guessLetter(letter);
		bank.removeGuessedLetter(letter);
		
		return guess;
	}
}
