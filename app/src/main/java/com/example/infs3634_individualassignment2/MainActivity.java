package com.example.infs3634_individualassignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main Activity";
    private RecyclerView hRecyclerView;
    private HolidayAdapter hAdapter;
    private RecyclerView.LayoutManager hLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Get handle to the recycler view
        hRecyclerView = findViewById(R.id.rvList);

        // Instantiate the layout manager
        hLayoutManager = new LinearLayoutManager(this);
        hRecyclerView.setLayoutManager(hLayoutManager);

        // Instantiate an adapter object
        hAdapter = new HolidayAdapter(Holiday.getHolidays());

        // Connect the adapter with the RecyclerView
        hRecyclerView.setAdapter(hAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                // Call filterable method from the adapter class to perform filtering
                hAdapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                hAdapter.getFilter().filter(s);
                return false;
            }
        });
        return true;

    }

    // React to user interaction with the menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sortName:
                // Sort the list by name (Not yet implemented in XML)
                hAdapter.sort(1);
                return true;
            case R.id.sortValue:
                // Sort the list by PriceUSD (Not yet implemented in XML)
                hAdapter.sort(2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    // Called when user taps on a row on the Recycler View
    private void launchDetailActivity(String message) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("key", message);
        startActivity(intent);
    }
}