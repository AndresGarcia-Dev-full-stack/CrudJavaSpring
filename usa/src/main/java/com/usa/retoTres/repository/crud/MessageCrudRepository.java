package com.usa.retoTres.repository.crud;

import com.usa.retoTres.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
