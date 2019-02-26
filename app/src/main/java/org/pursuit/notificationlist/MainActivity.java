package org.pursuit.notificationlist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import org.pursuit.notificationlist.controller.ImageAdapter;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "image_call";
    public static ArrayList<Integer> imagesDisplay;
    private Intent intentGo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView frolisticRecycleView = findViewById(R.id.Frolistic_Recycleview);

        imagesDisplay = new ArrayList<>();
        imagesDisplay.add(R.drawable.bantufro);
        imagesDisplay.add(R.drawable.bigfro);
        imagesDisplay.add(R.drawable.blackskirtfro);
        imagesDisplay.add(R.drawable.blackwhitefro);
        imagesDisplay.add(R.drawable.classyfro);
        imagesDisplay.add(R.drawable.cutefro);
        imagesDisplay.add(R.drawable.cutefro2);
        imagesDisplay.add(R.drawable.earringsfro);
        imagesDisplay.add(R.drawable.elegantfro);
        imagesDisplay.add(R.drawable.firstfroicon);
        imagesDisplay.add(R.drawable.flygirlfro);
        imagesDisplay.add(R.drawable.fro);
        imagesDisplay.add(R.drawable.glassesfro);
        imagesDisplay.add(R.drawable.headwrapfro);
        imagesDisplay.add(R.drawable.jeansfro);
        imagesDisplay.add(R.drawable.malefro);
        imagesDisplay.add(R.drawable.mirrorfro);
        imagesDisplay.add(R.drawable.readingfro);
        imagesDisplay.add(R.drawable.tattoofro);
        imagesDisplay.add(R.drawable.threefro);

        ImageAdapter imageAdapter = new ImageAdapter(imagesDisplay);
        frolisticRecycleView.setAdapter(imageAdapter);
        frolisticRecycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }

    public void ClickHere(View view) {
        Uri webpage = Uri.parse("https://www.naturallycurly.com/");
        intentGo = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intentGo);
    }
}











