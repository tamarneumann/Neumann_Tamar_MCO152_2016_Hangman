package HangmanGame;
import words.*;
import java.util.Scanner;
import exceptions.*;
import wordBank.*;

public class HangmanMain 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Hangman hangman = null;
		
		boolean flag = false;
		do
		{
			System.out.print("Please enter the level you would like to play: easy, medium or hard: ");
			try
			{
				hangman = new Hangman(input.nextLine());
				flag = true;
			}
			catch(InvalidDifficultyLevelException e)
			{
				System.out.println(e);
			}
		} while(!flag);
		
		boolean guess;
		
		do
		{
			System.out.println("\n"+hangman);
			
			guess=guessLetter(input, hangman);
			
			if(!guess)
				  System.out.println("The letter you guessed is incorrect.");
			 
		}while(!hangman.guessed());
		
	
		System.out.println("Congratulations you guess the word "+hangman.displayWord()+"!");
	}
	
	public static boolean guessLetter(Scanner input, Hangman hangman)
	{
		char letter;
		boolean guess;
		
		System.out.println("Guess a letter");
		letter=input.nextLine().toUpperCase().charAt(0);	
		
		guess=hangman.guessLetter(letter);
		
		return guess;
	}
}
