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
        sdf.timeZone = TimeZone.getDefault() // Set the desired timezone, if needed

        val formattedDate = sdf.format(date)
        return formattedDate
    }

}
