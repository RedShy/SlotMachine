package it.unical.asde2018.slot_machine.domain;

import java.util.Random;

public class NumberGame
{
	private int firstNumber;
	private int secondNumber;
	private int thirdNumber;
	private int maxAllowedNumber = 3;
	
	public NumberGame()
	{
		play();
	}

	public void play()
	{
		Random rand = new Random();
		firstNumber = rand.nextInt(maxAllowedNumber);
		secondNumber = rand.nextInt(maxAllowedNumber);
		thirdNumber = rand.nextInt(maxAllowedNumber);
	}

	public boolean win()
	{
		return firstNumber == secondNumber && secondNumber == thirdNumber;
	}

	public int getFirstNumber()
	{
		return firstNumber;
	}

	public void setFirstNumber(int firstNumber)
	{
		this.firstNumber = firstNumber;
	}

	public int getSecondNumber()
	{
		return secondNumber;
	}

	public void setSecondNumber(int secondNumber)
	{
		this.secondNumber = secondNumber;
	}

	public int getThirdNumber()
	{
		return thirdNumber;
	}

	public void setThirdNumber(int thirdNumber)
	{
		this.thirdNumber = thirdNumber;
	}
	
	
}
