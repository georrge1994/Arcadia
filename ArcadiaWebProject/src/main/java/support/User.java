package support;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sublimee on 15.03.2017.
 */

// Информация хранится непосредственно в таблице "users"
public class User extends LocalUser {

    String userKey = "";
    Map<Group, User> hashMap = new HashMap<Group, User>();

    public User (String key, String email, String name, String role){

        this.userKey = key;
        this.email = email;// глобальный email пользователя
        this.name = name;  // глобальное имя пользователя
        this.role = role;  // глобальная роль пользователя


    }

    public String getMail(){
        return this.email;
    }

    public String getKey(){
        return this.userKey;
    }

    public String getName(){
        return this.name;
    }

    public String getRole(){
        return this.role;
    }

    //пока нет даты
    public String getRegistrationDate() {
        String str = "Registration Date";
        return str;
    }
    //Vector groups = new Vector();
    //String avatarUrl = "";


}
