package com.br.zup.Client.Account.Models;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Client implements Serializable{
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@NotBlank(message = "Required name")
	@NotNull
	@Size(min = 2,message ="Name must be at least 3 letters")
	private String name;
	
	@NotBlank(message = "Required CPF!")
	@NotNull
	@Size(min = 11, message ="CPF must have at least 11 numbers")
	private String cpf;
	
	@NotBlank(message = "Phone number required")
	@NotNull
	@Size(min = 11, message = "phone number must have 11 numbers, counting DDD!")
	private String phone;
	
	@OneToOne(mappedBy = "client")
	private Account account;
	
	public Client() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
