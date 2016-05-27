package com.example.dell.tamer_suduko;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.media.MediaPlayer;

public class MainActivity extends ActionBarActivity {
    Button exit,score,myGame;
    MediaPlayer mediaPlayer;
    int current=0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exit = (Button) findViewById(R.id.exit);
        myGame = (Button) findViewById(R.id.newGame);
        score = (Button) findViewById(R.id.scores);

        myGame.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, MainActivity.class);
                a.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(a);
                finish();
            }
        });

        score.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        exit.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
