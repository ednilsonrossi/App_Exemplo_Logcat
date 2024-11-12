package br.edu.ifsp.dmo1.exemplologcat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MessageLogAdapter(context: Context, datasource: List<String>) :
    ArrayAdapter<String>(context, R.layout.item_actions, datasource) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            itemView = inflater.inflate(R.layout.item_actions, null)
        }

        val textView = itemView?.findViewById<TextView>(R.id.text_action)
        textView?.text = getItem(position)

        return itemView!!
    }
}