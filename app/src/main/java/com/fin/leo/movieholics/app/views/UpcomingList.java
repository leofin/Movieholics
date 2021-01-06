package com.fin.leo.movieholics.app.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fin.leo.movieholics.R;
import com.fin.leo.movieholics.app.models.Movie;
import com.fin.leo.movieholics.app.services.UpcomingServices;

import java.util.ArrayList;

public class UpcomingList extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.fin.leo.movieholics.MESSAGE";
    private Integer page = 1;
    private Integer nrPages = 1;
    private UpcomingServices upcomingServices = UpcomingServices.getInstanceUpcomingServices();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_list);
        renderListView();
    }

    public void nextPage(View view){
        page += 1;
        if(page > nrPages){
            page = nrPages;
        }
        renderListView();
    }

    public void previousPage(View view){
        page -= 1;
        if(page <= 0){
            page = 1;
        }
        renderListView();
    }

    public void renderListView(){
        ListView upcomingListView = findViewById(R.id.upcomingListView);
        final ArrayList<Movie> items = upcomingServices.getUpcomingMovies(page);
        nrPages = upcomingServices.getTotalPages();

        MoviesAdapter adapter = new MoviesAdapter(this, items);
        upcomingListView.setAdapter(adapter);
        upcomingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(UpcomingList.this, UpcomingDetails.class);
                intent.putExtra(EXTRA_MESSAGE, items.get(position));
                startActivity(intent);
            }
        });
    }
}
