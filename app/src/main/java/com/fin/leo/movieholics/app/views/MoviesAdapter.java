package com.fin.leo.movieholics.app.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fin.leo.movieholics.R;
import com.fin.leo.movieholics.app.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

public class MoviesAdapter extends ArrayAdapter<Movie> {
    // View lookup cache
    public class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public TextView textViewName;
        public TextView textViewMovieGenders;
        public TextView textViewMovieReleaseDate;
        public ImageView imageViewPoster;
        public Movie mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewName = view.findViewById(R.id.movie_name);
            textViewMovieGenders = view.findViewById(R.id.movie_gender);
            textViewMovieReleaseDate = view.findViewById(R.id.movie_release_date);
            imageViewPoster = view.findViewById(R.id.image_view_poster);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewName.getText() + "'";
        }
    }

    public MoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, R.layout.activity_upcoming_item, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Movie movie = getItem(position);


        ViewHolder holder;
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_upcoming_item, parent, false);
            holder = new ViewHolder(convertView);
        } else {
            holder = new ViewHolder(convertView);
        }

        // Populate the data from the data object via the viewHolder object
        // into the template view.
        holder.mItem = movie;
        holder.textViewName.setText(movie.getTitle());
        holder.textViewMovieGenders.setText(Arrays.toString(movie.getGenres()));
        holder.textViewMovieReleaseDate.setText(movie.getRelease_date());
        Picasso.get()
                    .load(movie.getPoster_path())
                    .resize(600, 800)
                    .centerCrop()
                    .into(holder.imageViewPoster);
        // Return the completed view to render on screen
        return convertView;
    }
}
