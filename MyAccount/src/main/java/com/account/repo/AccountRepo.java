package com.account.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.account.model.Account;

@Repository
public interface AccountRepo extends MongoRepository<Account, Integer>{

	Account findByAccNo(int accNo);
}
