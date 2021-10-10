package com.example.busschedule

import android.app.Application
import com.example.busschedule.database.AppDatabase

//Вам нужно будет предоставить собственный подкласс Application класса и создать lazyсвойство,
//которое будет содержать результат getDatabase().
class BusScheduleApplication : Application() {
    //Свойство database должно быть lazy и возвращать результат вызова getDatabase() вашего AppDatabase класса
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}