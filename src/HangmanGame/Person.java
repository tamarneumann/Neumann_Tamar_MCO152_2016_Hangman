package HangmanGame;

public class Person 
{
	private int incorrectGuess; //Player's amount of incorrect guesses.
	
	//Each object is another part of the hangman. 
	private String object1;
	private String object2;
	private String object3;
	private String object4;
	private String object5;
	private String object6;
	private String object7;
	private String object8;
	private String object9;
	private String object10;
	
	public Person()
	{
		incorrectGuess = 0;
		object1 = "+----------------+";
		object2 = "|" +
			    "\n|" +
		        "\n|" +
	        	"\n|" +
			    "\n|" +                     
			    "\n+----------------+";
		object3 = "+---------+" +
				"\n|" +
			    "\n|" +
		        "\n|" +
	        	"\n|" +
			    "\n|" +                     
			    "\n+----------------+"; 
		object4 = "+---------+" +
				"\n|         |" +
			    "\n|" +
		        "\n|" +
	        	"\n|" +
			    "\n|" +                     
			    "\n+----------------+";  
		object5 = "+---------+" +
				"\n|         |" +
				"\n|         @" +
		        "\n|" +
	        	"\n|" +
			    "\n|" +                     
			    "\n+----------------+"; 
		object6 = "+---------+" +
				"\n|         |" +
				"\n|         @" +
				"\n|         |" +
	        	"\n|" +
			    "\n|" +                     
			    "\n+----------------+"; 
		object7 = "+---------+" +
				"\n|         |" +
				"\n|         @" +
				"\n|        /|" +
	        	"\n|" +
			    "\n|" +                     
			    "\n+----------------+"; 
		object8 = "+---------+" +
				"\n|         |" +
				"\n|         @" +
				"\n|        /|\\ " +
	        	"\n|" +
			    "\n|" +                     
			    "\n+----------------+"; 
		object9 = "+---------+" +
				"\n|         |" +
				"\n|         @" +
				"\n|        /|\\ " +
				"\n|        / " +
			    "\n|" +                     
			    "\n+----------------+"; 
		object10 = "+---------+" +
			   "\n|         |" +
			   "\n|         @" +
			   "\n|        /|\\ " +
			   "\n|        / \\" +
			   "\n|  " +                     
			   "\n+----------------+";

	}
	
	/**
	 * Method to get the player's number of incorrect guesses.
	 * @return the number of incorrect guesses.
	 */
	public int getIncorrectGuess()
	{
		return incorrectGuess;
	}
	
	/**
	 * Method to increase the player's number of incorrect guesses.
	 */
	public void increaseGuess()
	{
		incorrectGuess++;
	}
	
	
	public String getObject()
	{
		//you don't need break statements in the switch because it will return and never get there
		switch (incorrectGuess)
		{
			case 0:
				return "";
			case 1:
				return object1;
			case 2:
				return object2;
			case 3:
				return object3;
			case 4:
				return object4;
			case 5:
				return object5;
			case 6:
				return object6;
			case 7:
				return object7;
			case 8:
				return object8;
			case 9:
				return object9;
			default:
				return object10;
		}
	}
}
