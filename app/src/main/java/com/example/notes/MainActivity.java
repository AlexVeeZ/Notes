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

    private void addOnLongClickListener(){
        
    }

    private void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    private void closeDrawer(DrawerLayout drawerLayout) {
       drawerLayout.closeDrawer(GravityCompat.START);
    }


}