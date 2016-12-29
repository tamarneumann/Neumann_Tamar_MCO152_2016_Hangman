package HangmanGame;
import words.*;

import java.util.InputMismatchException;
import java.util.Scanner;


import exceptions.*;
import wordBank.*;

public class HangmanMain 
{	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		final int MAX_TURNS = 10;
		char playAgain;
		int gameOption;
		Hangman hangman = new Hangman();//a hangman object.
		boolean flag = false;  //to control the try catch loop.
		
		//display the rules of the game.
		System.out.println(Hangman.gameRules());
		

		do
		{
			
			
			System.out.println("Enter an option: \n1.Play with a friend \n2.Play against the computer");
			gameOption=input.nextInt();
			
				while(gameOption!=1 &&gameOption!=2)
				{
					System.out.println("Enter a valid option:");
					gameOption=input.nextInt();
				}
			
				if(gameOption==1)
				{
					String playersWord, wordConfirm;
				
					do{
						input.nextLine();
					System.out.print("Enter a word: ");
					playersWord=input.nextLine();
					
					
					System.out.print("Confirm word: ");
					wordConfirm=input.nextLine();	
					
					  if(!playersWord.equalsIgnoreCase(wordConfirm))
						  System.out.println("Words do not match. Try again.");
					}
					while(!playersWord.equalsIgnoreCase(wordConfirm));
					
					hangman.usePlayersWord(playersWord);
				}
				else
				{
					do
					{
						input.nextLine();
						System.out.print("Please select a difficulty, easy, medium or hard: ");
						try
						{
							hangman.createRandomWord(input.nextLine());
							flag = true;
						}
						catch(InvalidDifficultyLevelException e)
						{
							System.out.println(e);
							System.out.print("Please enter a valid difficulty: ");
						}
					}
					while(!flag);
			    }
			
			boolean guess = false; //To see if the player's guess is correct.
			String letter;
			
			do
			{
				System.out.print("\n" + hangman + "\n\nGuess a letter: ");
				letter=input.nextLine();
				
				if(letter.equals("0"))
				{
					System.out.print("Guess the word:");
					letter=input.nextLine();
					hangman.guessWord(letter);
					break;
				}
				else
				{
					try 
					{
						guess = hangman.guessLetter(letter.toUpperCase().charAt(0));
					
						if(!guess)
							System.out.println("The letter you guessed is incorrect.");
					}
					catch(InvalidGuessException e)
					{
						System.out.println("Invalid guess");
					}
				}
				
			}
			while(!hangman.guessed() && hangman.getIncorrectGuess() < MAX_TURNS);
			
			if(hangman.guessed())
				System.out.println("Congratulations you guessed "+ hangman.displayWord() + "!");
			else
				System.out.println("You lose! The word is " + hangman.getWord());
			
			
			System.out.print("Would you like to play again? (\"Y/N\") ");
			
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
