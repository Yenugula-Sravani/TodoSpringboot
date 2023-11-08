package com.kumaran.repository;

import com.kumaran.Model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Todorepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Todo> findAll() {
        return jdbcTemplate.query("SELECT * FROM todo;",new BeanPropertyRowMapper<>(Todo.class));
    }

    public Todo findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM todo WHERE id=?;",new Object[]{id},new BeanPropertyRowMapper<>(Todo.class));
    }

    public void addTodo(Todo todo) {
        jdbcTemplate.update("insert into todo (name) values (?);",new Object[]{todo.getName()});
    }


    public void updateTodo(Todo todo) {
        jdbcTemplate.update("UPDATE todo SET name=? WHERE id=?;",new Object[]{todo.getName(),todo.getId()});
    }

    public void deleteTodo(int id) {
        jdbcTemplate.update("DELETE FROM todo WHERE id=?",new Object[]{id});
    }
}
