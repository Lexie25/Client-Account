package com.br.zup.Client.Account.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zup.Client.Account.Models.Account;
@Repository
public interface AccountRepository extends CrudRepository<Account,Integer>{

}
