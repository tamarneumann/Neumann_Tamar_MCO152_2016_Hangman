package wordBank;

import java.util.ArrayList;
import exceptions.*;

public class WordBank 
{
	//use array list so don't need to keep track of size
	private ArrayList<Character> lettersLeft;
	private ArrayList<Character> lettersGuessed;
	
	//set up the word bank that lettersLeft has the whole alphabet and lettersGuessed starts off empty
	public WordBank()
	{
		lettersLeft = new ArrayList<Character>();
		lettersGuessed = new ArrayList<Character>();
		
		//fill the array list of all letters
		for(char alphabet = 'A'; alphabet <= 'Z';alphabet++) 
		{
		    lettersLeft.add(alphabet);
		}
	}
	
	/**
	 * Method to remove the letter the player guessed from the array of unguessed letters.
	 * @param guess the players guessed letter.
	 */
	public void removeGuessedLetter(Character guess)
	{
		guess = Character.toUpperCase(guess);
		
		for(int i = 0; i < lettersLeft.size(); i++)
		{
			//Remove the letter from the word bank if it is found in the array of unused letters.
			if(lettersLeft.get(i) == guess)
			{
				lettersLeft.remove(guess);
				lettersGuessed.add(guess);
				return;
			}
		}
		
		//If the letter was not in the array of unused letters.
		throw new InvalidGuessException();
	}
	
	public String printLettersRemaining()
	{
		StringBuilder bank = new StringBuilder();
		bank.append(String.format("%s%n", "Letters Remaining"));
		bank.append("----------------------");
		if(lettersLeft.size() == 0)
			bank.append(String.format("%n|%20s", ""));
		else
		{
			for(int i = 0; i < lettersLeft.size(); i++)
			{
				if(i == 0)
					bank.append("\n|");
				else if(i % 5 == 0)
					bank.append("|\n|");
				bank.append(String.format("%-4c", lettersLeft.get(i)));	
				if(i == lettersLeft.size() - 1)
				{
					if(i % 5 == 0)
						bank.append(String.format("%16s", ""));
					else if(i % 5 == 1)
						bank.append(String.format("%12s", ""));
					else if(i % 5 == 2)
						bank.append(String.format("%8s", ""));
					else if(i % 5 == 3)
						bank.append(String.format("%4s", ""));
				}
			}
		}
		bank.append("|\n----------------------");
		return bank.toString();
	}
	
	public String printLettersGuessed()
	{
		StringBuilder bank = new StringBuilder();
		bank.append(String.format("%s%n", "Letters Guessed"));
		bank.append("----------------------");
		if(lettersGuessed.size() == 0)
			bank.append(String.format("%n|%20s", ""));
		else
		{
			for(int i = 0; i < lettersGuessed.size(); i++)
			{
				if(i == 0)
					bank.append("\n|");
				else if(i % 5 == 0)
					bank.append("|\n|");
				bank.append(String.format("%-4c", lettersGuessed.get(i)));	
				if(i == lettersGuessed.size() - 1)
				{
					if(i % 5 == 0)
						bank.append(String.format("%16s", ""));
					else if(i % 5 == 1)
						bank.append(String.format("%12s", ""));
					else if(i % 5 == 2)
						bank.append(String.format("%8s", ""));
					else if(i % 5 == 3)
						bank.append(String.format("%4s", ""));
				}
			}
		}
		bank.append("|\n----------------------");
		return bank.toString();
	}
	
	//prints letters guessed and letters remaining
	public String toString()
	{
		return printLettersRemaining() + "\n" + printLettersGuessed();
	}
}
