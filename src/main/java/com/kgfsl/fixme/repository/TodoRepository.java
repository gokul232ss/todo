package com.kgfsl.fixme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kgfsl.fixme.model.Todo;
public interface TodoRepository extends JpaRepository<Todo, Long> {

}