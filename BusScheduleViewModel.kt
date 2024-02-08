class BusScheduleViewModel(): ViewModel() {
    fun fullSchedule(): LiveData<List<Schedule>> = scheduleDAO.getAll()
}