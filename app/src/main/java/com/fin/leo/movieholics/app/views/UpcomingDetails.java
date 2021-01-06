package com.fin.leo.movieholics.app.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.fin.leo.movieholics.R;
import com.fin.leo.movieholics.app.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.Arrays;

public class UpcomingDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_details);

        // Get the Intent that started this activity and extract the object Serializable
        Intent intent = getIntent();
        Movie message = (Movie)intent.getSerializableExtra(UpcomingList.EXTRA_MESSAGE);

        // Populate the data from the data object to the view objects
        TextView textViewName = findViewById(R.id.TextViewName);
        textViewName.setText(message.getTitle());
        TextView textViewMovieGenders = findViewById(R.id.textViewMovieGenders);
        textViewMovieGenders.setText(Arrays.toString(message.getGenres()));
        TextView textViewMovieReleaseDate = findViewById(R.id.textViewMovieReleaseDate);
        textViewMovieReleaseDate.setText(message.getRelease_date());
        TextView textViewOverview = findViewById(R.id.textViewMovieOverview);
        textViewOverview.setText(message.getOverview());
        ImageView imageViewPoster = findViewById(R.id.imageViewPosterDetails);
        Picasso.get()
                .load(message.getPoster_path())
                .resize(600, 800)
                .centerCrop()
                .into(imageViewPoster);
    }
}
