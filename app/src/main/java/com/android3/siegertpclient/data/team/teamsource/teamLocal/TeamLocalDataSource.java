package com.android3.siegertpclient.data.team.teamsource.teamLocal;

import com.android3.siegertpclient.data.tournament.Tournament;
import com.android3.siegertpclient.data.tournament.tournamentsource.tournamentLocal.TournamentDao;

import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.regex.Pattern;

public class TeamLocalDataSource {


    final TeamDao teamDao;


    public TeamLocalDataSource(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public boolean check(@NotNull String teamName) {
        boolean b1 = Pattern.matches("[a-zA-Z0-9]",teamName);

        if(b1)  {
            return true;
        }
        return false;
    }

    public void saveUser(@NotNull Team newteam) {
        teamDao.insertTeam(newteam);
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
