package com.theironyard.novauc;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by souporman on 2/28/17.
 */
public class Users {
    String userName;
    String password;
    public static ArrayList<Blog> posts = new ArrayList();

    public Users(String userName, String password){
        this.userName=userName;
        this.password= password;
    }

}
