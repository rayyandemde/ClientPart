package com.android3.siegertpclient.data.tournament

import androidx.room.ColumnInfo
import  androidx.room.Entity
import androidx.room.PrimaryKey

//This class is not yet complete
@Entity
data class Tournament(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "tournament_id") val tournamentId: Int,
                      @ColumnInfo(name = "participant_form") val participantForm: String,
                      @ColumnInfo(name = "admin_id") val adminId: String)