package org.pursuit.notificationlist.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.notificationlist.R;
import org.pursuit.notificationlist.SecondActivity;

import static org.pursuit.notificationlist.MainActivity.imagesDisplay;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    public static final String TAG = "image_call";
    public static SharedPreferences sharedPreferences;
    private Intent intent2;
    public  static ImageView froView;
    private Integer froSecondView;
    private TextView tv;
    private ImageView iv;

    public ImageViewHolder(final View itemView) {
        super(itemView);
        froView = itemView.findViewById(R.id.fro);
        sharedPreferences = itemView.getContext().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View view) {
                sharedPreferences = itemView.getContext().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
                intent2 = new Intent(itemView.getContext(), SecondActivity.class);
                intent2.putExtra("image", imagesDisplay.get(0));
                intent2.putExtra("image2", imagesDisplay.get(1));
                intent2.putExtra("image3", imagesDisplay.get(2));
                intent2.putExtra("image4", imagesDisplay.get(3));
                intent2.putExtra("image5", imagesDisplay.get(4));
                intent2.putExtra("image6", imagesDisplay.get(5));
                intent2.putExtra("image7", imagesDisplay.get(6));
                intent2.putExtra("image8", imagesDisplay.get(7));
                intent2.putExtra("image9", imagesDisplay.get(8));
                intent2.putExtra("image10", imagesDisplay.get(9));
                intent2.putExtra("image11", imagesDisplay.get(10));
                intent2.putExtra("image12", imagesDisplay.get(11));
                intent2.putExtra("image13", imagesDisplay.get(12));
                intent2.putExtra("image14", imagesDisplay.get(13));
                intent2.putExtra("image15", imagesDisplay.get(14));
                intent2.putExtra("image16", imagesDisplay.get(15));
                intent2.putExtra("image17", imagesDisplay.get(16));
                intent2.putExtra("image18", imagesDisplay.get(17));
                intent2.putExtra("image19", imagesDisplay.get(18));
                intent2.putExtra("image20", imagesDisplay.get(19));
                itemView.getContext().startActivity(intent2);

            }
        });
    }

    public void onBind (Integer imageResId) {
        froView.setImageResource(imageResId);

    }
}


