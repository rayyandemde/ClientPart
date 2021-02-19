package com.android3.siegertpclient.data.Result.resultsource.resultLocal

import com.android3.siegertpclient.data.Result.Result
import com.android3.siegertpclient.data.tournament.Tournament


class ResultLocalDataSource(val resultDao: ResultDao) {
    fun saveResult(result: Result) {
        resultDao.insertResult(result)
    }


    fun getResult(){
        resultDao.allResults
    }
    fun deleteResult(){
        resultDao.deleteAllResults()
    }
    fun updateResult(result: Result){
        resultDao.updateResult(result)
    }

    fun check(): Boolean {
        return true
    }
}