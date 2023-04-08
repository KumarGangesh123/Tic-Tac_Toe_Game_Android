package com.india.tic_tac_toe_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class fontPage extends AppCompatActivity {

    int activePlayer = 0;

    boolean playerStatus = true;
    int fullStatus = 0;

    int[] gameState = {2,2,2,2,2,2,2,2,2};

    int[][] winningPositions = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
    };


    public void check(View view){

        ImageView image = (ImageView) view;
        TextView text = findViewById(R.id.textView2);
        int tgaOfImage = Integer.parseInt(image.getTag().toString());

        if(!playerStatus){
            gameReset(view);
        }

        if(fullStatus == 9){
            gameReset(view);
        }

        if(gameState[tgaOfImage] == 2){
            gameState[tgaOfImage] = activePlayer;
            image.setTranslationY(-1000f);

            if(activePlayer == 0){
                image.setImageResource(R.drawable.one);
                fullStatus++;
                activePlayer = 1;
                text.setText("X turn Tap to play");
            }else{
                image.setImageResource(R.drawable.two);
                fullStatus++;
                activePlayer = 0;
                text.setText("O turn Tap to play");
            }
            image.animate().translationYBy(1000f).setDuration(100);
        }

        for(int[] winPosition : winningPositions){
            if(gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] != 2){
                playerStatus = false;
                if(gameState[winPosition[0]] == 0){
                    text.setText("Player O has won");
                }else{
                    text.setText("Player X has won");
                }
            }
        }

    }

    public void gameReset(View view){
        playerStatus = true;
        activePlayer = 0;
        fullStatus = 0;

        for(int x=0;x<gameState.length;x++){
            gameState[x] = 2;
        }

        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}