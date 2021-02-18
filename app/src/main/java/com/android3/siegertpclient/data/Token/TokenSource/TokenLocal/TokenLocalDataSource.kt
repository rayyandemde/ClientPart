package com.android3.siegertpclient.data.Token.TokenSource.TokenLocal

import com.android3.siegertpclient.data.Token.Token

class TokenLocalDataSource(val tokenDao: TokenDao) {
    fun saveToken(token: Token) {
        tokenDao.insertToken(token)
    }
    fun refreshToken(token: Token) {
        tokenDao.updateToken(token)
    }

}