package org.pursuit.notificationlist.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import org.pursuit.notificationlist.R;
import org.pursuit.notificationlist.SecondActivity;

import static org.pursuit.notificationlist.MainActivity.imagesDisplay;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    public static final String TAG = "image_call";
    public static SharedPreferences sharedPreferences;
    private Intent intent2;
    private ImageView froView;

    public ImageViewHolder(final View itemView) {
        super(itemView);
        froView = itemView.findViewById(R.id.fro);
        sharedPreferences = itemView.getContext().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = itemView.getContext().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
                intent2 = new Intent(itemView.getContext(), SecondActivity.class);
                intent2.putExtra("image", imagesDisplay.get(getAdapterPosition()));
                itemView.getContext().startActivity(intent2);

            }
        });
    }

    public void onBind(Integer imageResId) {
        froView.setImageResource(imageResId);

    }
}


