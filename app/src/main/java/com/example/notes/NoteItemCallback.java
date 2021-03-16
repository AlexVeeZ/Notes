package com.example.notes;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class NoteItemCallback extends DiffUtil.ItemCallback<SimpleNote> {

    @Override
    public boolean areItemsTheSame(@NonNull SimpleNote oldItem, @NonNull SimpleNote newItem) {
        return oldItem.getTitle().equals(newItem.getTitle());
    }

    @Override
    public boolean areContentsTheSame(@NonNull SimpleNote oldItem, @NonNull SimpleNote newItem) {
        return oldItem.getDesc().equals(newItem.getDesc());

    }
}
