package it.unical.asde2018.slot_machine.components.services;

import java.util.Random;

import org.springframework.stereotype.Service;

import it.unical.asde2018.slot_machine.domain.NumberGame;
import it.unical.asde2018.slot_machine.domain.Player;

@Service
public class SlotMachineService
{
	private NumberGame game = new NumberGame();
	private final int fattoreVincita = 9;

	public void play(Player player, int bet)
	{
		game.play();
		if (game.win())
		{
			player.setCoins(player.getCoins() + bet * fattoreVincita);
		} else
		{
			player.setCoins(player.getCoins() - bet);
		}
	}

	public NumberGame getGame()
	{
		return game;
	}

}
