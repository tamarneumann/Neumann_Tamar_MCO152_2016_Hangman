package words;

public class GuessWord  
{
	private char[] wordArray;
	private GenerateWord word;
	private int guessedLetters;
	
	public GuessWord(String level)
	{
		word= new GenerateWord(level);
        
   		wordArray= new char[word.getNumLetters()];
		
		for(int i=0;i<wordArray.length;i++)
		{
			wordArray[i]='_';
		}
	}
	
	public boolean guessLetter(char letter)
	{
		boolean correct=false;
		for(int i=0;i<wordArray.length;i++)
		{
			if(word.getWord().charAt(i)==letter)
			{
				wordArray[i]=word.getWord().charAt(i);
				guessedLetters++;
				
				correct=true;
			}
		}
		return correct;
	}
	
	public boolean guessTheWord(String otherWord)
	{
		return word.getWord().equalsIgnoreCase(otherWord);
	}
	
	public String getWord()
	{
		return word.getWord();
	}
	
	public char[] getWordArray()
	{
		return wordArray;
	}
	
	public boolean guessed()
	{
		return guessedLetters==wordArray.length;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		
			for(char x:wordArray)
			{
				sb.append(x+" ");
			}
		return sb.toString();
	}
}
