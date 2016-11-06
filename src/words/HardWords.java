package words;

public enum HardWords 
{
	ACCORDINGLY(1),
	APPARENTLY(2),
	APPOINTMENT(3),
	APPROACH(4),
	ARRANGEMENT(5),
	CAMPAIGN(6),
	CHAMPAIGN(7),
	CIRCUMSTANCE(8),
	COMMISSION(9),
	CONSIDERATE(10),
	CONSTANTLY(11),
	CONSTITUTION(12),
	CONTRACTOR(13),
	DISCUSSION(14),
	EARNESTLY(15),
	ECSTATIC(16),
	EGYPT(17),
	ENGAGEMENT(18),
	ENTERTAINMENT(19),
	ESSENTIAL(20),
	ESTABLISHED(21),
	EXCHANGE(22),
	EXPLANATION(23),
	GENERATION(24),
	GRANDMOTHER(25),
	INDEPENDENT(26),
	INSTANTIATE(27),
	LEAGUE(28),
	MANUFACTURING(29),
	MATHEMATICS(30),
	MYSTERIOUS(31),
	NEIGHBORHOOD(32),
	OCCASIONALLY(33),
	PENNSYLVANIA(34),
	PHILADELPHIA(35),
	POLICEMAN(36),
	PRACTICALLY(37),
	RELATIONSHIP(38),
	REMARKABLE(39),
	REQUIRE(40),
	SATELLITE(41),
	SATISFIED(42),
	TOBACCO(43),
	UNIVERSITY(44);

	private int id;

	private HardWords(int id)
	{
		this.id = id;
	}

	public int getID()
	{
		return id;
	}
}