package Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.healthfood.R;

import java.util.HashMap;
import java.util.List;

public class GourmetBaseAdapter extends BaseAdapter {

    List<HashMap> data;
    Context context;
    ViewHolder viewHolder = null;
    private int[] count;

    public GourmetBaseAdapter(List<HashMap> data, Context context) {
        this.data = data;
        this.context = context;
        count = new int[data.size()];
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.buju_gourmet_listview, null);
            viewHolder.name = convertView.findViewById(R.id.buju_gourment_username);
            viewHolder.date = convertView.findViewById(R.id.buju_gourment_time);
            viewHolder.comment = convertView.findViewById(R.id.buju_gourment_text);
            viewHolder.image = convertView.findViewById(R.id.buju_gourment_pic);
            viewHolder.praise = convertView.findViewById(R.id.buju_gourment_praise);
            viewHolder.praise_count = convertView.findViewById(R.id.buju_gourment_count);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(data.get(position).get("name").toString());
        viewHolder.date.setText(data.get(position).get("date").toString());
        viewHolder.comment.setText(data.get(position).get("comment").toString());
        viewHolder.image.setBackgroundResource((Integer) data.get(position).get("image"));
        viewHolder.praise_count.setText(count[position] + "");
        viewHolder.praise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count[position]++;
                GourmetBaseAdapter.this.notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
