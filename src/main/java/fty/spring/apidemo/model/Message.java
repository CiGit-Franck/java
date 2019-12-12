/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.spring.apidemo.model;

import java.time.LocalDateTime;

/**
 *
 * @author utilisateur
 */
public class Message {

    private String message;
    private LocalDateTime date;

    public Message() {
        this.date = LocalDateTime.now();
    }

    public Message(String message) {
        this.message = message;
        this.date = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" + "message=" + message + ", date=" + date + '}';
    }

}
