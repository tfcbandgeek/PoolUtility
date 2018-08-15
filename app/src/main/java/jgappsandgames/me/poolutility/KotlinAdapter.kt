package jgappsandgames.me.poolutility

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class KotlinAdapter(val data: ArrayList<KotlinListObject>, val context: Activity): BaseAdapter() {
    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {
        val root = LayoutInflater.from(context).inflate(R.layout.list_pool, viewGroup, false)

        (root.findViewById<View>(R.id.id_) as TextView).setText(getItem(i).getID())
        (root.findViewById<View>(R.id.date) as TextView).text = getItem(i).date!!.time.toString()
        (root.findViewById<View>(R.id.word) as TextView).text = getItem(i).word

        return root
    }

    override fun getItem(p0: Int): KotlinListObject {
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        return getItem(p0).getID().toLong()
    }

    override fun getCount(): Int {
        return data.size
    }
}