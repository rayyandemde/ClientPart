package com.android3.siegertpclient.data.Result.resultsource.resultLocal

import com.android3.siegertpclient.data.Result.Result


class ResultLocalDataSource(val resultDao: ResultDao) {
    fun saveResult(result: Result) {
        resultDao.insertResult(result)
    }

    fun check(): Boolean {
        return true
    }
}