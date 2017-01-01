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
		final int MAX_TURNS = 10;  //The player only has 10 guesses.
		char playAgain;            //The player's response if he wants to play another game.
		boolean flag = false;      //To control the try catch loop.
		int gameOption;            //The player's response if he wants to play against a friend or the computer.
		String letter;	    	   //The player's guess.
		Hangman hangman = new Hangman();//a hangman object.
		
		
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
					String playersWord,  //Player's word for the game.
					        wordConfirm; //Player must confirm the word.
				
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
					
					//set up the game with the player's word.
					hangman.usePlayersWord(playersWord);
				}
				
				//if the user wants the computer to pick a word for him.
				else
				{
					do
					{
						input.nextLine(); //consume line.
						
						System.out.print("Please select a difficulty: easy, medium or hard: ");
						try
						{
							//create a new hangman game based on the player's choice of level.
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
		
			
			do
			{
				System.out.print("\n" + hangman + "\n\nGuess a letter: ");
				letter=input.nextLine();
				
				//If the player wants to guess the entire word.
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
			//continue to give the user guesses until he reached the max amount of turns.
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
