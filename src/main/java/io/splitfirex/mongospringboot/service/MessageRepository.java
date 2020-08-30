package io.splitfirex.mongospringboot.service;

import io.splitfirex.mongospringboot.model.Mensaje;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Mensaje, String> {



}
