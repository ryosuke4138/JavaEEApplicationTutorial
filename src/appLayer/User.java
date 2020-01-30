package appLayer;

import dataLayer.DB_user;

public class User {
    public boolean isValidUserCredentials(String sUserName, String sUserPassword) {
        DB_user DB_user_object = new DB_user();

        return DB_user_object.isValidUserLogin(sUserName, sUserPassword);
    }
}
