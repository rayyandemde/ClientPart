package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentLocal;

import com.android3.siegertpclient.data.tournament.Tournament;
import com.android3.siegertpclient.data.user.User;
import com.android3.siegertpclient.data.user.usersource.userLocal.UserDao;

import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.regex.Pattern;

public class TournamentLocalDataSource {



    final TournamentDao tournamentDao;


    public TournamentLocalDataSource(TournamentDao tournamentDao) {
        this.tournamentDao = tournamentDao;
    }

    public boolean check(@NotNull String tournamentName) {
        boolean b1 = Pattern.matches("[a-zA-Z0-9]",tournamentName);

        if(b1)  {
            return true;
        }
        return false;
    }

    public void saveUser(@NotNull Tournament newtournament) {
      tournamentDao.insertTournaments(newtournament);
    }

    @NotNull
    public String getId() {

        return createRandomStr(15);

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