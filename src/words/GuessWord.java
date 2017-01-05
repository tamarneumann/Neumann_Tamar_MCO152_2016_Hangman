package words;

public class GuessWord  
{
	private char[] wordArray;  //array to hold the Hangman word.
	private GenerateWord word; //the word used for the Hangman game.
	private int guessedLetters;//the amount of letters correctly guessed.
	private boolean wordGuessed;//if the word was guessed.
	
	
	
	/**
	 * Constructor that generates a word based on the level chosen, 
	 * and create an array the size of the word filled with underscores.
	 * @param level The level chosen by the player.
	 */
	public GuessWord()
	{
		word=new GenerateWord();
		wordGuessed=false;	
       	
	}
	
	public void randomWord(String level)
	{
		word.createRandomWord(level);
		createArray(word);
		
	}
	
	public void playerWord(String wordX)
	{
		word.setWord(wordX.toUpperCase());
		createArray(word);
			
	}
	
	public void setWordGuessed(boolean wordGuessed)
	{
		this.wordGuessed=wordGuessed;
	}
	
	private void createArray(GenerateWord word)
	{
		wordArray= new char[word.getNumLetters()];
		for(int i=0;i<wordArray.length;i++)
		{
			wordArray[i]='_';
		}
	}
	
	/**
	 * Method that receives the players guessed letter.
	 * @param letter The letter the player guessed.
	 * @return Boolean variable to see if the letter guessed is correct.
	 */
	public boolean guessLetter(char letter)
	{
		letter = Character.toUpperCase(letter);
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
		if(guessedLetters==wordArray.length)
			wordGuessed=true;
		
		return correct;
	}
	
	/**
	 * Method that allows the user to guess the whole word.
	 * @param otherWord The users guess
	 * @return Boolean variable to see if the word guessed is correct.
	 */
	public void guessTheWord(String otherWord)
	{
		if(word.getWord().equalsIgnoreCase(otherWord))
		{		
			for(int i=0;i<wordArray.length;i++)
			{
				wordArray[i]=otherWord.charAt(i);
			}
			wordGuessed=true;
	    }
	}
	
	/**
	 * Getter Method to get the word that is being used.
	 * @return The Hangman word. 
	  */
	public String getWord()
	{
		return word.getWord();
	}
	
    /**
     * Method to see if the player guessed the Hangman word.
     * @return Boolean value if the word was guessed.
     */
	public boolean guessed()
	{
		return wordGuessed;
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