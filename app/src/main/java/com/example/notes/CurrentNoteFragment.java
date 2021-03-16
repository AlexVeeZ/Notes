package com.example.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textview.MaterialTextView;

import org.w3c.dom.Text;


public class CurrentNoteFragment extends Fragment {


    public static final String ARG_PARAM = "ARG_PARAM";
    private EditText title;
    private EditText description;


    public static Fragment newInstance(@NonNull SimpleNote model){
        Fragment fragment = new CurrentNoteFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_PARAM, model);
        fragment.setArguments(bundle);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_current_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.title);
        description = view.findViewById(R.id.description);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getArguments() != null){
            SimpleNote note = (SimpleNote) getArguments().getSerializable(ARG_PARAM);
            title.setText(note.getTitle());
            description.setText(note.getDesc());
        }
    }

    private void saveText(View v){


    }


}