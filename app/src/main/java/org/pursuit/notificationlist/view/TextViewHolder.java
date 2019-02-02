package org.pursuit.notificationlist.view;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.notificationlist.R;

/**
 * Class is also unused since TextAdapter isn't being used.
 */
public class TextViewHolder extends RecyclerView.ViewHolder {
    private TextView textFroView;

    public TextViewHolder(View itemView) {
        super(itemView);
        textFroView = itemView.findViewById(R.id.myblack);

    }

    public void onBind(Integer textResId) {
        textFroView.setText(textResId);

    }
}
