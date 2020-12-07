package com.example.challenge_ml_1.ui.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.challenge_ml_1.model.viewmodel.CategoriesViewModel;
import com.example.challenge_ml_1.model.viewmodel.ItemsAndSearchViewModel;
import com.example.challenge_ml_1.R;
import com.example.challenge_ml_1.model.object.Product;
import com.example.challenge_ml_1.ui.fragment.ItemsDetailsFragment;
import com.example.challenge_ml_1.ui.fragment.ItemsFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private SearchView searchView;

    private ItemsAndSearchViewModel itemsAndSearchViewModel;

    private NavController navController;

    private Fragment currentFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_main);
            navController = Navigation.findNavController(findViewById(R.id.fragment_main_activity));

            itemsAndSearchViewModel = new ViewModelProvider(this).get(ItemsAndSearchViewModel.class);
            itemsAndSearchViewModel.getLiveDataProductItems().observe(this, products -> {
                if (products != null) {
                    getCurrentFragment();

                    if ( currentFragment instanceof ItemsFragment){
                        ((ItemsFragment) currentFragment ) . setProductAdapter((ArrayList<Product>) products);
                    }

                    if (currentFragment instanceof ItemsDetailsFragment) {
                        Log.i(TAG, "onCreate: Otra cosa. ");
                    }

                } else Log.e(TAG, "onChanged: Products es NULL. ");
            });
            itemsAndSearchViewModel.getLiveDataProductItem().observe(this, product -> {
                if (product != null) {
                    getCurrentFragment();

                    if (currentFragment instanceof ItemsFragment) {
                        searchView.setQuery("", false);
                        searchView.setIconified(true);
                        ((ItemsFragment) currentFragment).nextViewFragment(product);
                    }

                } else Log.e(TAG, "onChanged: product es NULL ");
            });
            
            navController.addOnDestinationChangedListener((controller, destination, arguments) -> {

                switch ( destination.getId() ) {
                    case R.id.nav_itemsFragment :
                        Log.i(TAG, "onDestinationChanged: ItemsFragment");
                        break;
                    case R.id.nav_itemsDetailFragment:
                        Log.i(TAG, "onDestinationChanged: ItemsDetailsFragment");
                        break;
                }

            });

        } catch ( Exception e ){
            Log.e(TAG, "onCreate: e - ", e);
        }
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
                searchView.clearFocus();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Toma el Fragment inflado ahora mismo y lo setea en 'currentFragment'.
     */
    private void getCurrentFragment() {
        currentFragment = getSupportFragmentManager().getPrimaryNavigationFragment().getChildFragmentManager().getPrimaryNavigationFragment();
    }

}