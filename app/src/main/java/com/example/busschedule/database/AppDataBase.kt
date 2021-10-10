package com.example.busschedule.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.busschedule.Schedule
import com.example.busschedule.ScheduleDao

//Теперь, когда мы определили ViewModel, DAO - нам все еще нужно указать Room что делать со всеми этими классами.
// Вот где на помощь приходит класс AppDatabase. Android-приложение, использующее Room создает подклассы
// и выполняет несколько ключевых функций. В нашем приложении AppDatabase необходимо:

//Указать, какие Entity определены в базе данных.
//Предоставить доступ к одному экземпляру каждого класса DAO.
//Выполнить любую дополнительную настройку, например предварительное заполнение базы данных.
@Database(entities = arrayOf(Schedule::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    //Класс базы данных позволяет другим классам простой доступ к классам DAO
    abstract fun scheduleDao(): ScheduleDao

    //При использовании AppDatabase класса вы хотите убедиться, что существует только один экземпляр базы данных,
    //чтобы предотвратить состояние гонки или другие потенциальные проблемы. Экземпляр хранится в companion object,
    // и вам также понадобится метод, который либо возвращает существующий экземпляр,
    // либо создает базу данных в первый раз. Это определено в companion object.
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        //функцию для возврата экземпляра AppDatabase
        //В реализации для getDatabase()вы используете оператор Элвиса, чтобы либо вернуть существующий экземпляр базы данных
        // (если он уже существует), либо создать базу данных в первый раз, если это необходимо.
        // В этом приложении данные предварительно заполнены. Вы также вызываете createFromAsset(),
        // чтобы загрузить существующие данные bus_schedule.db. Файл можно найти в assets.database пакете в вашем проекте.
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .createFromAsset("database/bus_schedule.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}