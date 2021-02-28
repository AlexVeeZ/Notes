package com.example.notes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public  class ListOfNotes extends Fragment implements NotesAdapterCallback{

    private final List<SimpleNote> notes = new ArrayList<>();
    private final NotesAdapter notesAdapter = new NotesAdapter(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initArrayList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_of_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        notesAdapter.setItems(notes);
    }

    private void initView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_notes);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), RecyclerView.VERTICAL));
        recyclerView.addItemDecoration(new NotesSpaceDecorator(getResources().getDimensionPixelSize(R.dimen.default_margin)));
        recyclerView.setAdapter(notesAdapter);
    }

    private void initArrayList(){
        notes.add(new SimpleNote("Заметка №1", "desc","00.00.1900"));
        notes.add(new SimpleNote("Заметка №2", "desc","00.00.1900"));
        notes.add(new SimpleNote("Заметка №3", "desc","00.00.1900"));
        notes.add(new SimpleNote("Заметка №4", "desc","00.00.1900"));
        notes.add(new SimpleNote("Заметка №5", "desc","00.00.1900"));
        notes.add(new SimpleNote("Заметка №6", "desc","00.00.1900"));
        notes.add(new SimpleNote("Заметка №7", "desc","00.00.1900"));
    }

    @Override
    public void onItemClicked(SimpleNote simpleNote) {
        CurrentNoteOne note_one = new CurrentNoteOne();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_container,note_one);
        ft.commit();
    }
}