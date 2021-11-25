/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto1Ciclo4.Reto1.Modelo;

/**
 *
 * @author raque
 */
public class Message {
    public String Textmessage;

    public Message() {
    }

    public Message(String message) {
        this.Textmessage = message;
    }

    public String getMessage() {
        return Textmessage;
    }

    public void setMessage(String message) {
        this.Textmessage = message;
    }
    
}
