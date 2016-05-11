package tech.eightman.beginnerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AdapterActivity extends AppCompatActivity {
    private String[] mLangs = new String[]{"C++","C","Java","C#","Scala","Python"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                R.layout.item_list,
                mLangs);

        ListView listView = (ListView)findViewById(R.id.someListView);
        listView.setAdapter(arrayAdapter);
    }
}
