package HangmanGame;

public class Person 
{
	private int incorrectGuess;
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
	
	public int getIncorrectGuess()
	{
		return incorrectGuess;
	}
	
	public void increaseGuess()
	{
		incorrectGuess++;
	}
	
	public String getObject()
	{
		if(incorrectGuess == 0)
			return "";
		else if(incorrectGuess == 1)
			return object1;
		else if(incorrectGuess == 2)
			return object2;
		else if(incorrectGuess == 3)
			return object3;
		else if(incorrectGuess == 4)
			return object4;
		else if(incorrectGuess == 5)
			return object5;
		else if(incorrectGuess == 6)
			return object6;
		else if(incorrectGuess == 7)
			return object7;
		else if(incorrectGuess == 8)
			return object8;
		else if(incorrectGuess == 9)
			return object9;
		else
			return object10;
	}
}
