package com.android3.siegertpclient.data.Result.resultsource.resultLocal

import androidx.room.*
import com.android3.siegertpclient.data.Result.Result
import com.android3.siegertpclient.data.game.Game

@Dao
interface ResultDao {
    @Insert
    fun insertResult(vararg result: Result?)

    @Update
    fun updateResult(vararg result: Result?)

    @Delete
    fun deleteResult(vararg result: Result?)

    @Query("DELETE FROM Result")
    fun deleteAllResults()

    @get:Query("SELECT * FROM Result")
    val allResults: List<Result?>?

}