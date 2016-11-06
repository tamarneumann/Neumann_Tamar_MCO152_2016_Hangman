import words.*;
import java.util.Scanner;
import exceptions.*;

public class HangmanMain 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the level you would like to play: easy, medium or hard: ");
		String level = input.nextLine();
		
		try{
		GuessWord word = new GuessWord(level);
		System.out.println("\n"+word);
		System.out.println(word.getWord());
		}
		catch(InvalidDifficultyLevelException e)
		{
			System.out.println(e);
		}
	}
}
