package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private ImageView image;
    private Button button;
    Bitmap bitmap;
    private WallpaperManager wp ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
        image.buildDrawingCache();
        bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        wp = WallpaperManager.getInstance(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    wp.setBitmap(bitmap);
                    Toast.makeText(MainActivity.this, "Wallpaper Set Successfully!!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "Wallpaper Not Set Successfully!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    void setup (){
        image = (ImageView)findViewById(R.id.image);
        button = (Button)findViewById(R.id.button);
    }
}