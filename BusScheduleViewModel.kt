


class BusScheduleViewModel(private val scheduleDAO: ScheduleDAO) {
    fun fullSchedule(): LiveData<List<Schedule>> = scheduleDAO.getAll()
}