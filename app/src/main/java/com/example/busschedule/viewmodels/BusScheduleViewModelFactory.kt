package com.example.busschedule.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.busschedule.ScheduleDao

//Хотя вы закончили определение ViewModel, вы не можете просто создать экземпляр объекта BusScheduleViewModel напрямую и
// ожидать, что все будет работать. Поскольку ViewModel класса BusScheduleViewModel должна учитывать жизненный цикл,
// она должна быть создана с помощью объекта, который может реагировать на события жизненного цикла.
// Если вы создадите его экземпляр непосредственно в одном из ваших фрагментов,
// тогда ваш объект фрагмента должен будет обрабатывать все управление памятью,
// что выходит за рамки того, что должен делать код вашего приложения. Вместо этого вы можете создать класс,
// называемый Factory, который будет создавать для вас экземпляры объектов ViewModel.
//Чтобы создать Factory, создайте новый класс BusScheduleViewModelFactory, наследующийся от ViewModelProvider.Factory.
class BusScheduleViewModelFactory(
    private val scheduleDao: ScheduleDao
) : ViewModelProvider.Factory {
    //create() возвращает BusScheduleViewModelFactory с некоторой проверкой ошибок.
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BusScheduleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BusScheduleViewModel(scheduleDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
//Теперь вы можете создать экземпляр BusScheduleViewModelFactory с помощью BusScheduleViewModelFactory.create(),
// чтобы ваша ViewModel могла быть осведомлена о жизненном цикле, и вашему фрагменту не нужно было обрабатывать это напрямую.