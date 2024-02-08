package com.example.tp4.busClassFeature

import androidx.lifecycle.LiveData


class BusScheduleViewModel(private val scheduleDAO: ScheduleDAO): ViewModel() {
    fun fullSchedule(): LiveData<List<Schedule>> = scheduleDAO.getAll()
}