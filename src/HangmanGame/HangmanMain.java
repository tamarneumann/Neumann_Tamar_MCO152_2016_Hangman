package HangmanGame;
import words.*;
import java.util.Scanner;
import exceptions.*;
import wordBank.*;

public class HangmanMain 
{
	public static Scanner input = new Scanner(System.in);	//create the scanner as a field so you don't need to pass
	
	public static void main(String[] args)
	{
		final int MAX_TURNS = 10;
		int playAgain;
		
		do
		{
			Hangman hangman = null;
			
			System.out.println(gameRules());
			
			boolean flag = false;
			do
			{
				System.out.print("Please select a difficulty, easy, medium or hard: ");
				try
				{
					hangman = new Hangman(input.nextLine());
					flag = true;
				}
				catch(InvalidDifficultyLevelException e)
				{
					System.out.println(e);
					System.out.print("Please enter a valid difficulty: ");
				}
			} while(!flag);
			
			boolean guess;
			
			do
			{
				System.out.print("\n" + hangman + "\n\nGuess a letter: ");
				guess=guessLetter(hangman);
				
				if(!guess)
					  System.out.println("The letter you guessed is incorrect.");
				 
			}while(!hangman.guessed() && hangman.getIncorrectGuess() < MAX_TURNS);
			
			if(hangman.guessed())
				System.out.println("Congratulations you guess "+ hangman.displayWord() + "!");
			else
				System.out.println("You lose! The word is " + hangman.getWord());
			
			System.out.print("Would you like to play again? (0 = no, 1 = yes) ");
			playAgain = input.nextInt();
			input.nextLine();	//get rid of the enter in the buffer
		}while(playAgain == 1);
		
		System.out.println("Thank you for playing!");
	}
	
	public static boolean guessLetter(Hangman hangman)
	{
		return hangman.guessLetter(input.nextLine().toUpperCase().charAt(0));
	}
	
	public static String gameRules()
	{
		StringBuilder rules = new StringBuilder();
		rules.append("Game Rules:\n");
		//write up the game rules
		return rules.toString();
	}
}
