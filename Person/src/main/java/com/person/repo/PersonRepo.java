package com.person.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.person.model.Person;


@Repository
public interface PersonRepo extends MongoRepository<Person, Integer>{

	Person findById(int id);

}
