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
			id = num.nextInt((EasyWords.values().length)) + 1;	//generate a random number from 1 through the number of words of that level
			for(EasyWords w : EasyWords.values())				//go through the words of that level and if you find the id of the word that 
																//matches the random number set that word to be the word for the game
			{
		        if(w.getID() == id)
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
