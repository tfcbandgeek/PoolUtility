package jgappsandgames.me.poolutility;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class JavaAdapter extends BaseAdapter {
    private ArrayList<JavaListObject> data;
    private Activity context;

    public JavaAdapter(ArrayList<JavaListObject> data, Activity context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public JavaListObject getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return data.get(i).getID();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View root = LayoutInflater.from(context).inflate(R.layout.list_pool, viewGroup, false);

        ((TextView) root.findViewById(R.id.id_)).setText(getItem(i).getID());
        ((TextView) root.findViewById(R.id.date)).setText(getItem(i).date.getTime().toString());
        ((TextView) root.findViewById(R.id.word)).setText(getItem(i).word);

        return root;
    }
}
