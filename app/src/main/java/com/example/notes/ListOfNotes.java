package com.example.notes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public  class ListOfNotes extends Fragment implements NotesAdapterCallback{

    private final List<SimpleNote> notes = new ArrayList<>();
    private RecyclerView recyclerView;
    private final NotesAdapter notesAdapter = new NotesAdapter(this);
    private final NoteListAdapter noteListAdapter = new NoteListAdapter(new NoteItemCallback(), this);

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
        recyclerView = view.findViewById(R.id.rv_notes);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), RecyclerView.VERTICAL));
        recyclerView.addItemDecoration(new NotesSpaceDecorator(getResources().getDimensionPixelSize(R.dimen.default_margin)));
        //recyclerView.setAdapter(notesAdapter);
        recyclerView.setAdapter(noteListAdapter);
        noteListAdapter.submitList(notes);

    }


    private void initArrayList(){
        for (int i = 0; i < 100; i++) {
            String title = String.format("title %s", i);
            String description = String.format("description %s", i);
            notes.add(new SimpleNote(String.valueOf(i), title, description));
        };

    }



    @Override
    public void onItemClicked(int position) {
        SimpleNote model = notes.get(position);
        replaceFragment(model);
    }

    @Override
    public void onLongItemClicked(int position) {
        final List<SimpleNote> item = new ArrayList<>();
        notes.remove(position);
        item.addAll(notes);
        noteListAdapter.submitList(item);

        Toast.makeText(requireContext(), "УДАЛИТЬ", Toast.LENGTH_SHORT).show();
    }


    private void replaceFragment(@NonNull SimpleNote model){
        Fragment fragment = CurrentNoteFragment.newInstance(model);
        requireActivity().getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.content_container, fragment)
            .commit();

    }


}