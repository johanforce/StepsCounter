package com.example.stepscounter.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.stepscounter.data.local.AppDatabase.Companion.DATABASE_VERSION
import com.example.stepscounter.data.local.dao.DayDao
import com.example.stepscounter.data.local.entity.DayEntity

@Database(
    entities = [
        DayEntity::class,
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dayDao(): DayDao

    companion object {
        const val DATABASE_VERSION = 1
        private const val DB_NAME = "steps_db"

        fun build(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
}
