package org.pursuit.notificationlist.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.notificationlist.R;
import org.pursuit.notificationlist.SecondActivity;

import static org.pursuit.notificationlist.MainActivity.imagesDisplay;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "image_call";
    public static SharedPreferences sharedPreferences;
    public static Intent intent2;
    public static ImageView froView;
    public static Integer froSecondView;
    public static TextView tv;
    public static ImageView iv;

    public ImageViewHolder(final View itemView) {
        super(itemView);
        froView = itemView.findViewById(R.id.fro);
        sharedPreferences = itemView.getContext().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View view) {
                tv = itemView.findViewById(R.id.textView);
                iv = itemView.findViewById(R.id.second_image);
                froSecondView = imagesDisplay.get(getAdapterPosition());
                sharedPreferences = itemView.getContext().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
//                tv.setText("Beauty");
//                iv.setImageResource(imagesDisplay.size());
                intent2 = new Intent(itemView.getContext(), SecondActivity.class);
                itemView.getContext().startActivity(intent2);

            }
        });
    }

    public void onBind (Integer imageResId) {
        froView.setImageResource(imageResId);

    }
}


