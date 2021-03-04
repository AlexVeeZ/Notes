package com.example.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*Объявление полей*/

    private ImageView save;
    private ImageView share;
    private ImageView menu;
    private LinearLayout home;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        if(savedInstanceState == null){
            initView();
            addOnClickListener();

            ListOfNotes listOfNotes = new ListOfNotes();
            FragmentTransaction list = getSupportFragmentManager().beginTransaction();
            list.replace(R.id.listOfNotes,listOfNotes);
            list.commit();
        }

    }
    /*Инициализация полей*/
    private void initView(){
        drawerLayout = findViewById(R.id.drawer_layout);

        save = findViewById(R.id.save);
        share = findViewById(R.id.share);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.home_linearLayout);

    }
    /*Метод отображения действий*/
    private void addOnClickListener(){
        /*nameOfNoteOne.setOnClickListener(v -> {
            CurrentNoteOne note_one = new CurrentNoteOne();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_container,note_one);
            ft.commit();
            try {
                currentNoteOne.setText(String.valueOf(buffer_note_one.toString()));
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        });
        nameOfNoteTwo.setOnClickListener(v->{
            CurrentNoteTwo note_two = new CurrentNoteTwo();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_container,note_two);
            ft.commit();
            try {
                currentNoteTwo.setText(String.valueOf(buffer_note_two.toString()));
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        });
        nameOfNoteThree.setOnClickListener(v->{
            CurrentNoteThree note_three = new CurrentNoteThree();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_container,note_three);
            ft.commit();
            try {
                currentNoteThree.setText(String.valueOf(buffer_note_three.toString()));
            }catch (NullPointerException e){
                e.printStackTrace();
            }

        });*/
        save.setOnClickListener(v->{

        });
        share.setOnClickListener(v->{
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, "some text");
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent,null));
            startActivity(intent);
        });
        menu.setOnClickListener(v->{
            openDrawer(drawerLayout);
        });
        home.setOnClickListener(v->{
            closeDrawer(drawerLayout);
        });
    }

    private void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    private void closeDrawer(DrawerLayout drawerLayout) {
       drawerLayout.closeDrawer(GravityCompat.START);
    }


}