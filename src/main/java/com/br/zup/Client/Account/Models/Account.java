package com.br.zup.Client.Account.Models;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
@Entity
public class Account implements Serializable {
	public static final long seriaVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@DecimalMin(value = "150.0", message = "Minimum amount of R $ 150,00 for checking account")
	private double currentBalance;

	private double savingsBalance;

	@OneToOne(cascade = {CascadeType.ALL})
	private Client client;

	public Account(Integer id,
			@DecimalMin(value = "150.0", message = "Minimum amount of R $ 150,00 for checking account") double currentBalance,
			double savingsBalance, Client client) {
		this.id = id;
		this.currentBalance = currentBalance;
		this.savingsBalance = savingsBalance;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
