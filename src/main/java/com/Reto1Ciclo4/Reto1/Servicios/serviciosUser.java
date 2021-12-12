/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto1Ciclo4.Reto1.Servicios;

import com.Reto1Ciclo4.Reto1.Modelo.User;
import com.Reto1Ciclo4.Reto1.Repositorio.UserRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author raque
 */
@Service
public class serviciosUser {
    
    @Autowired
    private UserRepositorio metodosCrud;
    

    /**
     * Listar todos los usuarios
     * @return 
     */
    public List<User> getAll(){
        return metodosCrud.getAll();
    }
    
    /**
     * Listar usuarios por ID
     * @param id
     * @return 
     */
    public Optional<User> getUser(int id){
        return metodosCrud.getUser(id);
    }
    
    /**
     * Buscar email existente
     * @param email
     * @return 
     */
    public boolean getExistsEmail(String email){
        return metodosCrud.getExistsEmail(email);
    }
    
    /**
     * Buscar combinación Email-contraseña
     * @param email
     * @param password
     * @return 
     */
    public User getExistsEmailAndPassword(String email, String password){
        
        return metodosCrud.getExistsEmailAndPassword(email,password);
    }

    /**
     * Crear nuevo usuario
     * @param user
     * @return
     * @throws Exception 
     */
    public User save(User user) throws Exception{
        
        try {
            if(user.getId()==null){
                return metodosCrud.save(user);
            }else{
                Optional<User> evt=metodosCrud.getUser(user.getId());
                if(evt.isEmpty()){
                    return metodosCrud.save(user);
                }else{
                    return  user;
                }
            }
        } catch (Exception e) {
            
           throw new Exception("El correo ya existe");
            
        }
        
            
        //}
        
    }
    
    /**
     * Actualizar datos de usuario
     * @param user
     * @return 
     */
    public User update(User user){
        if (user.getId()!=null){
            Optional<User> evt = metodosCrud.getUser(user.getId());
            if (!evt.isEmpty()){
                if (user.getEmail()!=null){
                    evt.get().setEmail(user.getEmail());
                }
                if (user.getPassword()!=null){
                    evt.get().setPassword(user.getPassword());
                }
                if (user.getName()!=null){
                    evt.get().setName(user.getName());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else {
                return user;
            }
        }else {
            return user;
        }
    }
    
    /**
     * Eliminar Usuario
     * @param id
     * @return 
     */
    public boolean deleteUser(int id){
        Boolean del = getUser(id).map(user -> {
            metodosCrud.delete(user);
            return true;
        }).orElse(false);
        return del;
    }

    

}
