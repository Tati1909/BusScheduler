package com.example.busschedule

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

//Аннотации @Insert, @Update, @Delete управляют модификацией данных. А аннотация @Query
//создаёт запросы к базе данных.
//Если поле, которое мы хотим добавить, уже есть, то выбираем соответствующую стратегию
//OnConflictStrategy (IGNORE, ABORT, REPLACE).

@Dao
interface ScheduleDao {

    //Это первый экран
    //Запрос указывается как строка, переданная в @Query аннотацию. Определяем функцию, getAll(),
    //которая возвращает список остановок и времени прибытия по возрастанию(ASC)
    //Преобразуем функцию DAO для возврата Flow(асинхронный поток) см. 5.1.2.9
    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
    fun getAll(): Flow<List<Schedule>>

    //Это второй экран(1 выбранная пользователем остановка и все ее расписание)
    @Query("SELECT * FROM schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC")
    fun getByStopName(stopName: String): Flow<List<Schedule>>

}