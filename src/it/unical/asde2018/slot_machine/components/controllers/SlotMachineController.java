package it.unical.asde2018.slot_machine.components.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.unical.asde2018.slot_machine.components.services.SlotMachineService;
import it.unical.asde2018.slot_machine.domain.Player;

@Controller
public class SlotMachineController
{

	@Autowired
	private SlotMachineService slotMachine;

	@GetMapping("slotMachine")
	public String viewSlotMachine(Model model, HttpSession session)
	{
		// TODO: prendi le monete da un database anziché dare 200 qui.
		// Se non c'è alcun player presente nella sessione
		if (session.getAttribute("player") == null)
		{
			// Ricavo il player con le sue monete dal database
			session.setAttribute("player", new Player(50, (String) session.getAttribute("user")));
		}

		Player player = (Player) session.getAttribute("player");

		// Lo inserisco nel modello così posso visualizzarlo nella JSP
		model.addAttribute("player", player);

		// Inserisco i numeri casuali da visualizzare nella JSP
		model.addAttribute("game", slotMachine.getGame());

		// se non è presente l'attributo "firstplay" vuol dire che ancora l'utente non
		// ha ancora giocato
		if (session.getAttribute("firstPlay") != null)
		{
			// comunico alla JSP la vittoria o la perdita
			if (slotMachine.getGame().win())
			{
				model.addAttribute("win", 1);
			} else
			{
				model.addAttribute("lose", 1);
			}
		}

		return "slot-machine";

	}

	@GetMapping("play")
	public String play(@RequestParam int bet, Model model, HttpSession session)
	{
		// Il player ha deciso di giocare inserendo una puntata

		// Ho bisogno di aggiornare il player quando fa la sua giocata
		Player player = (Player) session.getAttribute("player");

		// Se i soldi del player disponibili sono inferiori alla puntata non può giocare
		if (player.getCoins() < bet)
		{
			model.addAttribute("cantPlay", 1);
			return "forward:/slotMachine";
		}

		// Provo a giocare
		slotMachine.play(player, bet);

		// aggiorno il player
		session.setAttribute("player", player);

		// indico che il giocatore ha fatto la prima giocata
		session.setAttribute("firstPlay", 1);

		return "forward:/slotMachine";

	}
}
