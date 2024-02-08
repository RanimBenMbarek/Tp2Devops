import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class BusClassAdapter(private val onItemClick: ((Schedule) -> Unit)?) : RecyclerView.Adapter<BusClassAdapter.ViewHolder>() {
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.stopText.text = dataSet.get(position).stopName
        val formattedDate = GetDate(position)
        viewHolder.timeText.text = formattedDate.toString()
    }

    private fun GetDate(position: Int): String {
        val timestamp = dataSet.get(position).arrivalTime.toLong() // Your timestamp value

        val date =
            Date(timestamp * 1000) // Convert timestamp to milliseconds and create Date object

        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault() // Set the desired timezone, if needed

        val formattedDate = sdf.format(date)
        return formattedDate
    }

    fun updateList(dataList: List<Schedule>){
        this.dataSet = dataList;
        notifyDataSetChanged();
    }
    override fun getItemCount() = dataSet.size
}
