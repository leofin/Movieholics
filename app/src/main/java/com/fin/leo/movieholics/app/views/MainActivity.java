package com.fin.leo.movieholics.app.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fin.leo.movieholics.R;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView2);
        Picasso.get()
                .load("http://1.bp.blogspot.com/-rfkuFN8KVdo/VqZaEEbAO9I/AAAAAAAAAtw/5B0e4Gbr2MI/s640/474973944.jpg")
                .resize(600, 800)
                .centerCrop()
                .into(imageView);
        TextView menu = findViewById(R.id.textView4);
        menu.bringToFront();
        menu.invalidate();
        imageView.invalidate();
    }

    public void sendToUpcomingList(View v){
        Intent intent = new Intent(this, UpcomingList.class);
        startActivity(intent);
    }
}
