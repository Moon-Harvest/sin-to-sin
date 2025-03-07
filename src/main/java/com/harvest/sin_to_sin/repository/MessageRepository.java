package com.harvest.sin_to_sin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harvest.sin_to_sin.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

}
