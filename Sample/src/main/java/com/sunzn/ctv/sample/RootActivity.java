package com.sunzn.ctv.sample;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by sunzn on 2017/6/12.
 */

public class RootActivity extends ListActivity {

    private String[] mTitles = new String[]{
            SingleActivity.class.getSimpleName(),
            GroupActivity.class.getSimpleName()
    };

    private Class[] mActivities = new Class[]{
            SingleActivity.class,
            GroupActivity.class
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mTitles));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        startActivity(new Intent(this, mActivities[position]));
    }

}
