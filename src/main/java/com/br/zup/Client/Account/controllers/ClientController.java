package com.br.zup.Client.Account.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.zup.Client.Account.Models.Account;
import com.br.zup.Client.Account.Models.Client;
import com.br.zup.Client.Account.Service.ClientService;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping("/")
	public ModelAndView displayForm() {
		ModelAndView modelAndView = new ModelAndView("custumer.html");
		modelAndView.addObject("Client", clientService.displayCustomers());
		return modelAndView;
	}

	@PostMapping("/")
	public ModelAndView registerCustomer(@Valid Client cliente, BindingResult bindingClient, @Valid Account conta,
			BindingResult bindinAccount) {
		ModelAndView modelAndView = new ModelAndView("custumer.html");

		if (bindingClient.hasErrors() || bindinAccount.hasErrors()) {
			List<String> message = new ArrayList<String>();
			for (ObjectError objectError : bindingClient.getAllErrors()) {
				message.add(objectError.getDefaultMessage());
			}

			for (ObjectError objectError1 : bindinAccount.getAllErrors()) {
				message.add(objectError1.getDefaultMessage());
			}
			modelAndView.addObject("message", message);
			modelAndView.addObject("Client", clientService);
			return modelAndView;
		} else {
			modelAndView.addObject("message", clientService.registerCustomer(cliente, conta));

		}
		modelAndView.addObject("Client", clientService.displayCustomers());
		return modelAndView;
	}

	@GetMapping("/client/{id}")
	public ModelAndView displayCustomerInformation(@PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("customerInformation.html");
		modelAndView.addObject("client", clientService.displayCustomerInformation(id));
		return modelAndView;
	}
	@PostMapping("/client/{id}")
	public ModelAndView displayCustumerInformation(@Valid Client cliente, BindingResult bindingClient, @Valid Account conta,
			BindingResult bindinAccount) {
		ModelAndView modelAndView = new ModelAndView("custumerInformation.html");

		return modelAndView;
	}
}