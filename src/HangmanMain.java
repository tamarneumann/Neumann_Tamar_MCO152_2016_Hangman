import words.*;
import java.util.Scanner;
import exceptions.*;

public class HangmanMain 
{
	public static void main(String[] args)
	{
		boolean guess;
		GuessWord word = null;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the level you would like to play: easy, medium or hard: ");
		String level = input.nextLine();
		
		try{
		word = new GuessWord(level);
		}
		catch(InvalidDifficultyLevelException e)
		{
			System.out.println(e);
		}
		do
		{
		
	    
		System.out.println("\n"+word);
		
		guess=guessLetter(input, word);
		
		  if(!guess)
			  System.out.println("The letter you guessed is incorrect.");
		  
		System.out.println(word);
		
		   
	
		}
		while(word.notGuessed());
		
		System.out.println("Congratulations you guess the word "+word.getWord()+"!");
	}
	
	public static boolean guessLetter(Scanner input, GuessWord word)
	{
		char letter;
		boolean guess;
		
		System.out.println("Guess a letter");
		letter=input.nextLine().toUpperCase().charAt(0);	
		
		guess=word.guessLetter(letter);
		
		return guess;
	}
}
