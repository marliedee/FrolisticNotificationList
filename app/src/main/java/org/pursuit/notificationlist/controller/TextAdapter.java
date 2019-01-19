package org.pursuit.notificationlist.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.notificationlist.R;
import org.pursuit.notificationlist.view.TextViewHolder;

import java.util.List;

public class TextAdapter extends RecyclerView.Adapter<TextViewHolder> {
    private List<Integer> textFro;

    public TextAdapter(List<Integer> textFro) {
        this.textFro = textFro;
    }
    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_item_view, parent, false);
        return new TextViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {

        Integer text = textFro.get(position);
        holder.onBind(text);
    }

    @Override
    public int getItemCount() {
        return textFro.size();
    }
}
