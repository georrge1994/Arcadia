package support;

/**
 * Created by Sublimee on 15.03.2017.
 */

// Информация хранится в таблице "groupUsers" и отображает пользователя в конкретной группе
public class LocalUser {
    String email = ""; // локальный email пользователя в базе
    String name = "";  // локальное имя пользователя в базе
    String role = "";  // локальная роль пользователя в базе

    public LocalUser(){
    };

    public LocalUser (String email, String name, String role){
        this.email = email;
        this.name = name;
        this.role = role;

    }
}
