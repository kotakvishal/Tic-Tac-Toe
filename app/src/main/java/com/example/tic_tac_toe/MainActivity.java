package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    boolean gameactive=true;

    boolean win =false;
    public String winnerstr;
    int active_player =0;
   int[] []win_positions={ {0,1,2},{3,4,5,},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
   int[] game_state={2,2,2,2,2,2,2,2,2};
   public void Playertap(View view)
    {
        ImageView img=(ImageView) view;
        if(!gameactive)
        {
            reset();
        }
        int tappedimg=Integer.parseInt(img.getTag().toString());
        if (game_state[tappedimg]==2)
        {
        game_state[tappedimg]=active_player;
        img.setTranslationY(-1000f);
        if(active_player==0)
        {
            img.setImageResource(R.drawable.x);
            active_player=1;
            TextView status= findViewById(R.id.status);
            status.setText("O's turn");
        }
        else
        {
            img.setImageResource(R.drawable.o);
            active_player=0;
            TextView status= findViewById(R.id.status);
            status.setText("x's turn");

        }
            img.animate().translationYBy(1000f).setDuration(3);
        }
        for(int[]win_position:win_positions)
        {
            if(game_state[win_position[0]]==game_state[win_position[1]]
                    && game_state[win_position[1]]==game_state[win_position[2]]&& game_state[win_position[0]]!=2 )
            {

                gameactive=false;
                if(game_state[win_position[0]]==0)
                {
                    winnerstr="x has win.";
                    win =true;

                }
                else
                {
                    winnerstr="O has won.";
                    win =true;
                }

            }
            else if(game_state[0] != 2 && game_state[1] != 2 &&game_state[2] != 2
                    &&game_state[3] != 2  &&game_state[4] != 2  &&game_state[5] != 2
                    &&game_state[6] != 2 &&game_state[7] != 2 &&game_state[8] != 2 && win==false)
            {
               winnerstr="its a tie.";
            }
            TextView status =findViewById(R.id.status);
            status.setText(winnerstr);
        }


    }






    private void reset()
    {
        active_player=0;
        gameactive=true;
        for(int i=0;i<game_state.length;i++)
        {
            game_state[i]=2;
        }
        ((ImageView)findViewById(R.id.image1)).setImageResource(0);
        ((ImageView)findViewById(R.id.image2)).setImageResource(0);
        ((ImageView)findViewById(R.id.image3)).setImageResource(0);
        ((ImageView)findViewById(R.id.image4)).setImageResource(0);
        ((ImageView)findViewById(R.id.image5)).setImageResource(0);
        ((ImageView)findViewById(R.id.image6)).setImageResource(0);
        ((ImageView)findViewById(R.id.image7)).setImageResource(0);
        ((ImageView)findViewById(R.id.image8)).setImageResource(0);
        ((ImageView)findViewById(R.id.image9)).setImageResource(0);
        TextView status= findViewById(R.id.status);
        status.setText("x's turn");

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =(Button)findViewById(R.id.reset);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                active_player=0;
                gameactive=true;
                for(int i=0;i<game_state.length;i++)
                {
                    game_state[i]=2;
                }
                ((ImageView)findViewById(R.id.image1)).setImageResource(0);
                ((ImageView)findViewById(R.id.image2)).setImageResource(0);
                ((ImageView)findViewById(R.id.image3)).setImageResource(0);
                ((ImageView)findViewById(R.id.image4)).setImageResource(0);
                ((ImageView)findViewById(R.id.image5)).setImageResource(0);
                ((ImageView)findViewById(R.id.image6)).setImageResource(0);
                ((ImageView)findViewById(R.id.image7)).setImageResource(0);
                ((ImageView)findViewById(R.id.image8)).setImageResource(0);
                ((ImageView)findViewById(R.id.image9)).setImageResource(0);
                TextView status= findViewById(R.id.status);
                status.setText("x's turn");
            }
        });
    }
}