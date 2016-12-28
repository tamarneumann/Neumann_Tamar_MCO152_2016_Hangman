package HangmanGame;
import words.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.sun.xml.internal.ws.util.StringUtils;

import exceptions.*;
import wordBank.*;

public class HangmanMain 
{	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		final int MAX_TURNS = 10;
		char playAgain;
		
		//display the rules of the game.
		System.out.println(Hangman.gameRules());
		
		do
		{
			Hangman hangman = null;//a hangman object.
			boolean flag = false;  //to control the try catch loop.
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
			
			
			boolean guess = false; //To see if the player's guess is correct.
			
			do
			{
				System.out.print("\n" + hangman + "\n\nGuess a letter: ");
				
				
				try {
					guess = hangman.guessLetter(input.nextLine().toUpperCase().charAt(0));
					
					if(!guess)
						  System.out.println("The letter you guessed is incorrect.");
				}
				catch(InvalidGuessException e)
				{
					System.out.println("Invalid guess");
				}
				
			}while(!hangman.guessed() && hangman.getIncorrectGuess() < MAX_TURNS);
			
			if(hangman.guessed())
				System.out.println("Congratulations you guessed "+ hangman.displayWord() + "!");
			
			else
				System.out.println("You lose! The word is " + hangman.getWord());
			
			
			System.out.print("Would you like to play again? (\"Y/N\") ");
		
		//reset the flag to false for the try catch statement.
			flag=false;
			
			playAgain = input.nextLine().toUpperCase().charAt(0);
					
				while(playAgain!='Y' && playAgain!='N')
				{	
					System.out.println("Enter \"Y\" or \"N\":");
					playAgain = input.nextLine().toUpperCase().charAt(0);
				}
			
		}while(playAgain == 'Y');
		
		System.out.println("Thank you for playing!");
	}

}
