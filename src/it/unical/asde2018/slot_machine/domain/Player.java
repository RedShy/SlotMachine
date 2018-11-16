package it.unical.asde2018.slot_machine.domain;

public class Player
{
	private int coins = 200;
	private String name;

	public Player(int saldo, String nome)
	{
		super();
		this.coins = saldo;
		this.name = nome;
	}

	public int getCoins()
	{
		return coins;
	}

	public void setCoins(int coins)
	{
		this.coins = coins;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
