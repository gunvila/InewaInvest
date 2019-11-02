package buu.informatics.s59161125.myprojectterminewsinvest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewCryptoAdpter (var context: Context?, var listcrypto: ArrayList<crypto>): BaseAdapter() {
    private class ViewHolder(row: View?){
        var txtName: TextView

        init {
            this.txtName = row?.findViewById(R.id.txtCrypto) as TextView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if(convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.listview_item_crypto,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var setCryto:crypto = getItem(position) as crypto
        viewHolder.txtName.text = setCryto.name
        return view as View

    }

    override fun getItem(position: Int): Any {
        return listcrypto[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listcrypto.count()
    }


}