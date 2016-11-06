package exceptions;


public class InvalidDifficultyLevelException extends RuntimeException
{
		public InvalidDifficultyLevelException()
		{
			super("Not a valid difficulty level");
		}

	

}
