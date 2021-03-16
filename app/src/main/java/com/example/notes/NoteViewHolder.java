package com.example.notes;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    private final NotesAdapterCallback callback;

    public NoteViewHolder(@NonNull View itemView, NotesAdapterCallback callback) {
        super(itemView);
        this.callback = callback;
    }

    public void onBind(int position, SimpleNote model){

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                callback.onLongItemClicked(getAdapterPosition());
                return false;
            }
        });

    }


}
