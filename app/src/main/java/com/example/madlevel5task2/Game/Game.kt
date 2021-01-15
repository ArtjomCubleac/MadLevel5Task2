package com.example.madlevel5task2.Game


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.util.*

@Entity(tableName = "gameListTable")
data class Game(

    @ColumnInfo(name = "gameTitle")
    var title: String,

    @ColumnInfo(name = "gamePlatform")
    var platform: String,

    @ColumnInfo(name = "gameDate")
    var date: Date,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

)

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}