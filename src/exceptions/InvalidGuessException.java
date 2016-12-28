package exceptions;

public class InvalidGuessException extends RuntimeException
{
	public InvalidGuessException()
	{
		super("Invalid guess.");
		
	}
}
