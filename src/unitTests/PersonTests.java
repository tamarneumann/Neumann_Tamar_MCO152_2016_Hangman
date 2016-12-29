package unitTests;

import static org.junit.Assert.*;

import org.junit.*;

import HangmanGame.Person;

public class PersonTests {

	private Person person;
	
	@Before
	public void createPerson()
	{
		 person=new Person();
	}
	
	@Test
	public void testIncreaseGuessAndGetter()
	{
		person.increaseGuess();
		assertEquals(1,person.getIncorrectGuess());
		
	}
	public void testPersonObjectNotNull()
	{
		
		assertNotNull(person.getObject());
	}
}
