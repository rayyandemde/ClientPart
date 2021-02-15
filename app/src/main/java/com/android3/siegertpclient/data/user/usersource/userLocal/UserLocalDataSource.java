package com.android3.siegertpclient.data.user.usersource.userLocal;

import com.android3.siegertpclient.data.user.User;

import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.regex.Pattern;

public class UserLocalDataSource {
    final UserDao userDao;
    public UserLocalDataSource(UserDao userDao){

        this.userDao = userDao;

    }

    public boolean check(@NotNull String firstname, String surname, @NotNull String password, @NotNull String eMail) {
        boolean b1 = Pattern.matches("[a-zA-Z]",firstname)&&Pattern.matches("[a-zA-Z]",firstname);
        boolean b2 = Pattern.matches("[a-zA-Z0-9]",password);
        boolean b3 = Pattern.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$",eMail);
        if(b1&&b2&&b3)  {
          return true;
        }
        return false;
}

    public void saveUser(@NotNull User newUser) {
        userDao.insertUsers(newUser);
    }

    @NotNull
    public String getId() {

        return createRandomStr(12);

    }


    public static String createRandomStr(int length){
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            stringBuffer.append(str.charAt(number));
        }
        return stringBuffer.toString();
    }

}