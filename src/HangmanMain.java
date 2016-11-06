import words.*;
import java.util.Scanner;

public class HangmanMain 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the level you would like to play: easy, medium or hard: ");
		String level = input.nextLine();
		//add in exception if not easy medium or hard
		GenerateWord word = new GenerateWord(level);
		System.out.println(word.getWord());
	}
}
