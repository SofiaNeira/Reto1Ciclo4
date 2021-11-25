/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto1Ciclo4.Reto1.Interface;

import com.Reto1Ciclo4.Reto1.Modelo.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author raque
 */
public interface interfaceUser extends CrudRepository<User, Integer> {

   public User findAllByEmailAndPassword(String email,String password);
   
   boolean existsByEmail(String email);
}
