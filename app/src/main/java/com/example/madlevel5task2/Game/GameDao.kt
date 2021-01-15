package com.example.madlevel5task2.Game


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.madlevel5task2.Game.Game

@Dao
interface GameDao {

    @Insert
    suspend fun insertGame(game: Game)

    @Query("SELECT * FROM gameListTable")
    fun getAllGames(): LiveData<List<Game>>

    @Query("DELETE FROM gameListTable")
    suspend fun deleteAllGames()

    @Update
    suspend fun updateGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

}