import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class BusClassAdapter(private val onItemClick: ((Schedule) -> Unit)?) : RecyclerView.Adapter<BusClassAdapter.ViewHolder>() {
    private var dataSet : List<Schedule>  = listOf<Schedule>();

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.bus_layout, viewGroup, false)

        return ViewHolder(view)
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

    override fun getItemCount() = dataSet.size
}
