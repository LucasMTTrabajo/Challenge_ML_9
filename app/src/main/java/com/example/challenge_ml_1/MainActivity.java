package com.example.challenge_ml_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private SearchView searchView;

    private ItemsAndSearchViewModel itemsAndSearchViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemsAndSearchViewModel = new ViewModelProvider( this ).get(ItemsAndSearchViewModel.class);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem mSearch = menu.findItem(R.id.appSearchBar);

        searchView = (SearchView) mSearch.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                itemsAndSearchViewModel.getItems( query );
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

}