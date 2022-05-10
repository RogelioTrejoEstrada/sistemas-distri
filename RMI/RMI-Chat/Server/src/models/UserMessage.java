package models;

import java.io.Serializable;

/**
 * Se genera un modelo, con el cual se llevara el control de los mensajes
 * junto con el nombre del usuario
 */
public class UserMessage implements Serializable {
    public String username;
    public String message;

    public UserMessage(String username, String message) {
        this.message = message;
        this.username = username;
    }
}
