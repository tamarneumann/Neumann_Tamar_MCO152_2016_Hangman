package exceptions;

public class LetterAlreadyGuessException extends RuntimeException
{
	public LetterAlreadyGuessException()
	{
		super("Letter already guessed");
		
	}
}
