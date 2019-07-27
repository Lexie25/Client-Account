package com.br.zup.Client.Account.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zup.Client.Account.Models.Client;
@Repository
public interface ClientRepository extends CrudRepository<Client,Integer>{


}
