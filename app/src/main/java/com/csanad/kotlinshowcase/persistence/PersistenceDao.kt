package com.csanad.kotlinshowcase.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersistenceDao {
    @Insert
    fun insertPersistence(persistence: Persistence)

    @Query("SELECT * FROM persistence ORDER BY id DESC")
    fun readPersistence(): LiveData<List<Persistence>>

    @Query("DELETE FROM persistence")
    fun erasePersistence()
}