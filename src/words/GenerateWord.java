package words;

import java.util.Random;
import exceptions.*;

public class GenerateWord 
{
	private int id;
	private int numLetters;
	private String word;
	
	public GenerateWord(){}
	
	public void createRandomWord(String level)
	{
		Random num = new Random();
		
		//check the level word that the user wants
		//and generate a random number based on the numbers of words available for that level
		//then search the enumerated type for the word corresponding to that number
		if(level.equalsIgnoreCase("easy"))
		{
			EasyWords w[] = EasyWords.values();		//generate a random number from 1 through the number of words of that level		
			id = num.nextInt((w.length));		
			this.word = w[id].toString();
		}
		else if(level.equalsIgnoreCase("medium"))
		{
			MediumWords w[] = MediumWords.values();
			id = num.nextInt((w.length));		
			this.word = w[id].toString();
		}
		else if (level.equalsIgnoreCase("hard"))
		{
			HardWords w[] = HardWords.values();
			id = num.nextInt((w.length));		
			this.word = w[id].toString();
		}
		else
			throw new InvalidDifficultyLevelException();
		
			
		this.numLetters = word.length();
	}

	public void setWord(String word){
		this.word=word;
		this.numLetters = word.length();
	}
	
	public int getNumLetters()
	{
		return numLetters;
	}
	
	public String getWord()
	{
		return word;
	}
}
