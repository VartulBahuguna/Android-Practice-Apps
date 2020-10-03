package com.example.quikblox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class StandaloneToolbar extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone_toolbar);

        toolbar = findViewById(R.id.toolbar) ;
        toolbar.setTitle("TITLE HERE");
        toolbar.setSubtitle("SUBTITLE HERE");
        toolbar.setNavigationIcon(R.drawable.navigation_back);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
           // toolbar.setElevation(20f);

            toolbar.inflateMenu(R.menu.menu_main);

            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    String msg = item.getTitle().toString();

                    switch (item.getItemId())
                    {
                        case R.id.save :
                            Toast.makeText(StandaloneToolbar.this, msg + "Toast unavailable for you", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.mail :
                            Toast.makeText(StandaloneToolbar.this,  "Toast unavailable for you", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(StandaloneToolbar.this, msg + " click!!", Toast.LENGTH_SHORT).show();
                    }

                    return true;
                }
            });
        }


    }
}