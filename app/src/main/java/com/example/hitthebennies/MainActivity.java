package com.example.test;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements GameDifficultyDialogFragment.OnGameDifficultySelectedListener{

    private CountDownTimer mTimer;
    private TextView score_id;
    private ImageButton button1, button2, button3, button4, button5, button6, button7,button8,button9,button10, button11,button12;
    private Menu mMenu;
    private TextView timer_id;
    private long mTimerLength = 30000;
    int score = 0;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        mMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {

        // Determine which menu option was chosen


        if (item.getItemId() == R.id.action_one)
        {
            GameDifficultyDialogFragment dialog = new GameDifficultyDialogFragment();
            dialog.show(getSupportFragmentManager(), "gameDifficultyDialog");
            return true;
        }
        else if (item.getItemId() == R.id.action_stop)
        {
            mTimer.cancel();
            item.setVisible(false);
            mTimer.onFinish();
            return true;
        }
        else if (item.getItemId() == R.id.action_start)
        {
            gameStart();
            mMenu.findItem(R.id.action_stop).setVisible(true);
            return true;
        }
        else if (item.getItemId() == R.id.action_help)
        {
            Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onHelpClick(View view) {
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }

    private void gameStart() {
        mMenu.findItem(R.id.action_stop).setVisible(false);
        score_id = (TextView) findViewById(R.id.score_id);
        button1 = (ImageButton) findViewById(R.id.button1);
        button2 = (ImageButton) findViewById(R.id.button2);
        button3 = (ImageButton) findViewById(R.id.button3);
        button4 = (ImageButton) findViewById(R.id.button4);
        button5 = (ImageButton) findViewById(R.id.button5);
        button6 = (ImageButton) findViewById(R.id.button6);
        button7 = (ImageButton) findViewById(R.id.button7);
        button8 = (ImageButton) findViewById(R.id.button8);
        button9 = (ImageButton) findViewById(R.id.button9);
        button10 = (ImageButton) findViewById(R.id.button10);
        button11 = (ImageButton) findViewById(R.id.button11);
        button12 = (ImageButton) findViewById(R.id.button12);

        timer_id = (TextView) findViewById(R.id.time_id);
        score = 0;
        score_id.setText("Score: " + score);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                score_id.setText("Score: " + score);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                score_id.setText("Score: " + score);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                score_id.setText("Score: " + score);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                score_id.setText("Score: " + score);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                score_id.setText("Score: " + score);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                score_id.setText("Score: " + score);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                score_id.setText("Score: " + score);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                score_id.setText("Score: " + score);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                score_id.setText("Score: " + score);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                score_id.setText("Score: " + score);
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                score_id.setText("Score: " + score);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                score_id.setText("Score: " + score);
            }
        });


        if (mTimer != null)
        {
            mTimer.cancel();
        }
        mTimer = new CountDownTimer(mTimerLength , 1000)
        {

            public void onTick(long millisUntilFinished)
            {
                timer_id.setText("Time: " + millisUntilFinished/1000);
            }


            public void onFinish()
            {
                mMenu.findItem(R.id.action_stop).setVisible(false);
                button1.setClickable(false);
                button2.setClickable(false);
                button3.setClickable(false);
                button4.setClickable(false);
                button5.setClickable(false);
                button6.setClickable(false);
                button7.setClickable(false);
                button8.setClickable(false);
                button9.setClickable(false);
                button10.setClickable(false);
                button11.setClickable(false);
                button12.setClickable(false);
            }
        }.start();
    }

   @Override
    public void onGameDifficultyClick ( int which)
    {
        mTimerLength = 30000 / (which + 1);
    }

}
