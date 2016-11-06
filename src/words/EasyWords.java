package words;

public enum EasyWords 
{
	ADULT(1),
	BREEZE(2),
	BRICK(3),
	CALM(4),
	CANAL(5),
	CAST(6),
	CHOSE(7),
	CLAW(8),
	COACH(9),
	COURT(10),
	DEEP(11),
	DOLL(12),
	DRESS(13),
	FACE(14),
	FANCY(15),
	FILM(16),
	FINE(17),
	FORT(18),
	FRUIT(19),
	GRAB(20),
	HABIT(21),
	KIDS(22),
	LABEL(23),
	LEVEL(24),
	LUNGS(25),
	MELT(26),
	MILL(27),
	PLACE(28),
	PLATE(29),
	PRIDE(30),
	RANGE(31),
	RING(32),
	ROCK(33),
	RUSH(34),
	SALE(35),
	SHAKE(36),
	SILLY(37),
	SLIP(38),
	SOAP(39),
	SPIN(40),
	STICK(41),
	STIFF(42),
	STOCK(43),
	TAIL(44),
	TALE(45),
	TRAP(46),
	VAIN(47),
	WOLF(48),
	ZOO(49);
	
	private int id;

	private EasyWords(int id)
	{
		this.id = id;
	}

	public int getID()
	{
		return id;
	}
}
