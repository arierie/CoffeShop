package id.arieridwan.coffeshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TopMenuActivity extends AppCompatActivity {

    private ListView mListView;

    String[] menuArray = {"Moccachino", "Frappuchino", "Robusta", "Kopi Lampung",
            "Arabica", "Kopi Luwak", "Cortado", "Flat White", "Cafe Cubano", "Espresso"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_menu);

        mListView = (ListView) findViewById(R.id.mListView);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menuArray);
        mListView.setAdapter(adapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
