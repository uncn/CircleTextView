package com.sunzn.ctv.sample;

import android.content.Context;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.sunzn.ctv.library.CircleTextView;

/**
 * Created by sunzn on 2017/6/12.
 */

public class GroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        ListView mGroup = (ListView) findViewById(R.id.group);
        mGroup.setAdapter(new GroupAdapter(this));
    }

    private static class GroupAdapter extends BaseAdapter {

        private final LayoutInflater mInflater;

        GroupAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.item_group, parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            switch (position % 2) {
                case 0:
                    holder.icon.setColor(ContextCompat.getColor(parent.getContext(), R.color.colorAccent));
                    break;
                case 1:
                    holder.icon.setColor(ContextCompat.getColor(parent.getContext(), R.color.colorPrimary));
                    break;
            }

            holder.icon.setText(String.valueOf(position));
            holder.text.setText("Item " + position);

            return convertView;
        }

    }

    private static class ViewHolder {

        CircleTextView icon;
        TextView text;

        ViewHolder(View view) {
            this.icon = (CircleTextView) view.findViewById(R.id.icon);
            this.text = (TextView) view.findViewById(R.id.text);
        }
    }

}
