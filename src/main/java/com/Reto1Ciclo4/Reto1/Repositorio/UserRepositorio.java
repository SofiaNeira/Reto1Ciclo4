/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto1Ciclo4.Reto1.Repositorio;

import com.Reto1Ciclo4.Reto1.Interface.interfaceUser;
import com.Reto1Ciclo4.Reto1.Modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author raque
 */
@Repository
public class UserRepositorio {
    
    @Autowired
    private interfaceUser crud;
    
    public List<User> getAll(){
        return (List<User>) crud.findAll();
    }
    
    public Optional<User> getUser(int id){
        return crud.findById(id);
    }
    
    public boolean getExistsEmail(String email){
        return crud.existsByEmail(email);
    }
    
    public User getExistsEmailAndPassword(String email, String password){
        return crud.findAllByEmailAndPassword(email, password);
    }

    public User save(User user){
        return crud.save(user);
    }
    
    public void delete(User user){
        crud.delete(user);
    }
    /*
    public Optional<User> getFindByEmail(String user) {
        return crud.findByEmail(String user);
    }
    */
}
