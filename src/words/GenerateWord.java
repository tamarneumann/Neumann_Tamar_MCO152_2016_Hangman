package words;

import java.util.Random;
import exceptions.*;

public class GenerateWord 
{
	private int id;
	private int numLetters;
	private String word;
	
	public GenerateWord(String level)
	{
		Random num = new Random();
		
		//check the level word that the user wants
		//and generate a random number based on the numbers of words available for that level
		//then search the enumerated type for the word corresponding to that number
		if(level.equalsIgnoreCase("easy"))
		{
			id = num.nextInt((EasyWords.values().length)) + 1;
			for(EasyWords w : EasyWords.values())
			{
		        if( w.getID() == id)
		        {
		            this.word = w.toString();
		            break;
		        }
		    }
		}
		else if(level.equalsIgnoreCase("medium"))
		{
			id = num.nextInt((MediumWords.values().length)) + 1;
			for(MediumWords w : MediumWords.values())
			{
		        if( w.getID() == id)
		        {
		            this.word = w.toString();
		            break;
		        }
		    }
		}
		else if(level.equalsIgnoreCase("hard"))
		{
			id = num.nextInt((HardWords.values().length)) + 1;
			for(HardWords w : HardWords.values())
			{
		        if( w.getID() == id)
		        {
		            this.word = w.toString();
		            break;
		        }
		    }
		}
		else
			throw new InvalidDifficultyLevelException();
		
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
