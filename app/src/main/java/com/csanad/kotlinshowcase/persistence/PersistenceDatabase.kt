package com.csanad.kotlinshowcase.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.coroutineScope
import kotlin.concurrent.thread

@Database(entities = [Persistence::class], version = 1, exportSchema = false)
abstract class PersistenceDatabase : RoomDatabase() {

    abstract fun getPersistenceDao(): PersistenceDao

    fun readPersistence() = getPersistenceDao().readPersistence()

    fun insertPersistence(entry: Persistence) {
        thread {
            getPersistenceDao().insertPersistence(entry)
        }
    }

    companion object {
        @Volatile
        private lateinit var instance: PersistenceDatabase
        fun getInstance(context: Context?): PersistenceDatabase? {
            if (!this::instance.isInitialized) {
                synchronized(this) {
                    if (!this::instance.isInitialized) {
                        if (context != null) {
                            instance = Room.databaseBuilder(
                                context.applicationContext,
                                PersistenceDatabase::class.java,
                                "persistence_database"
                            ).build()
                        } else {
                            return null
                        }
                    }
                }
            }
            return instance
        }
    }
}