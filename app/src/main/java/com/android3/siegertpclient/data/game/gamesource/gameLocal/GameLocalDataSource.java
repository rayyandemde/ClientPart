package com.android3.siegertpclient.data.game.gamesource.gameLocal;

import com.android3.siegertpclient.data.game.Game;
import com.android3.siegertpclient.data.invitation.Invitation;
import com.android3.siegertpclient.data.invitation.invitationsource.invitationLocal.InvitationDao;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public class GameLocalDataSource {

        final GameDao gameDao;


    public GameLocalDataSource(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    public void saveGame(@NotNull Game game) {
            gameDao.insertGame(game);
        }

    public boolean check() {

        return false;
    }

    }



