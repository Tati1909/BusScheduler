package com.example.busschedule

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Schedule(
    //аннотацией @PrimaryKey мы указали, что в таблице — ключ id
    @PrimaryKey
    val id: Int,
    //В SQL столбцы по умолчанию могут иметь нулевые значения и должны быть явно отмечены как ненулевые,
    // если вы хотите иначе. Это противоположно тому, как все работает в Kotlin, где значения по умолчанию не могут быть нулевыми.
    //Название остановки
    @NonNull @ColumnInfo(name = "stop_name")
    val stopName: String,
    //Время прибытия
    @NonNull @ColumnInfo(name = "arrival_time")
    val arrivalTime: Int
)