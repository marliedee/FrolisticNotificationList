package org.pursuit.notificationlist.controller;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.notificationlist.R;
import org.pursuit.notificationlist.view.ImageViewHolder;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter <ImageViewHolder>  {

    private List<Integer> imageList;

        public ImageAdapter(List<Integer> imageList) {
            this.imageList = imageList;
        }


        @Override
        public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_view, parent, false);
            return new ImageViewHolder(childView);
        }

        @Override
        public void onBindViewHolder(ImageViewHolder holder, int position) {
            Integer image = imageList.get(position);
            holder.onBind(image);

        }

        @Override
        public int getItemCount() {
            return imageList.size();
        }


    }
