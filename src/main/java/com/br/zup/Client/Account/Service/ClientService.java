package com.br.zup.Client.Account.Service;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.Client.Account.Models.Account;
import com.br.zup.Client.Account.Models.Client;
import com.br.zup.Client.Account.Repositories.AccountRepository;
import com.br.zup.Client.Account.Repositories.ClientRepository;

@Service
public class ClientService {

	private ClientService clientService;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AccountRepository accountRepository;

	public Iterable<Client> displayCustomers(){
		return clientRepository.findAll();
	}

	public String registerCustomer( Client client, Account account) {
		if(account.getCurrentBalance() < 150) {
			return "insufficient funds";
		}else {
			account.setClient(client);
			accountRepository.save(account);
			return " Registered Customer";
		}
	}
	public Client displayCustomerInformation(Integer id) {
		return clientRepository.findById(id).get();
	}
	public String displayCustumerInformation ( Client client, Account account) {
		return "customer information";
}
}
