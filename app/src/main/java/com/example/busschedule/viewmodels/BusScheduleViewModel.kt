package com.example.busschedule.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.busschedule.Schedule
import com.example.busschedule.ScheduleDao
import kotlinx.coroutines.flow.Flow

//ViewModel для нашего ScheduleDao
class BusScheduleViewModel(private val scheduleDao: ScheduleDao) : ViewModel() {
    //1 экран - полное расписание
    fun fullSchedule(): Flow<List<Schedule>> = scheduleDao.getAll()

    //2 экран - расписание по имени остановки
    fun scheduleForStopName(name: String): Flow<List<Schedule>> = scheduleDao.getByStopName(name)
}


