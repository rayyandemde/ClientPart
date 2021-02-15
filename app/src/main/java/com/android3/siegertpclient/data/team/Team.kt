package com.android3.siegertpclient.data.team.teamsource.teamLocal

import androidx.room.*

@Entity
data class Team(
    @PrimaryKey(autoGenerate = true)
    var teamId: Int,
    @ColumnInfo(name = "team_name") var teamName: String,
    @ColumnInfo(name = "password") var password: String,

    @TypeConverters(MemberConverter::class)
    @ColumnInfo(name = "member_list") var memberList: MemberList?,

    )


data class MemberList(
    val memberList: ArrayList<String> = ArrayList()
)
class MemberConverter {
    @TypeConverter
    fun toMemberList(value: String?): MemberList {
        if (value == null || value.isEmpty()) {
            return MemberList()
        }

        val list: List<String> = value.split(",")
        val stringList = ArrayList<String>()
        for (item in list) {
            if (!item.isEmpty()) {
                stringList.add(item.toString())
            }
        }
        return MemberList(stringList)
    }

    @TypeConverter
    fun toString(memberList: MemberList?): String {

        var string = ""

        if (memberList == null) {
            return string
        }

        memberList.memberList.forEach {
            string += "$it,"
        }
        return string
    }
}