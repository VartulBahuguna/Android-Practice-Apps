package com.codingblocks.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button Reset;
    TextView displayTV;
    static boolean Turn = true;
    static int playerCnt = 0;
    static int[] board = new int[9];
    static Button[] btn = new Button[9];

    @SuppressLint("SetTextI18n")
    private void initializer()
    {
        playerCnt = 0;
        Turn = true;
        for (int i = 0; i < 9; i++) {
            board[i]  = - 1;
            btn[i].setText("");
            btn[i].setEnabled(true);
        }
      //  displayTV.setText("Player X Turn");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn[0] = findViewById(R.id.Btn1);
        btn[1] = findViewById(R.id.Btn2);
        btn[2] = findViewById(R.id.Btn3);
        btn[3] = findViewById(R.id.Btn4);
        btn[4] = findViewById(R.id.Btn5);
        btn[5] = findViewById(R.id.Btn6);
        btn[6] = findViewById(R.id.Btn7);
        btn[7] = findViewById(R.id.Btn8);
        btn[8] = findViewById(R.id.Btn9);

        initializer();

        for (int i = 0; i < 9; i++)
        {
            btn[i].setOnClickListener(this);
        }
        Reset = findViewById(R.id.Reset);
        displayTV = findViewById(R.id.displayTV);

        Reset.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                initializer();
                playerCnt = 0;
                Turn = true;
                displayTV.setText("Player X Turn");
            }
        });

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.Btn1:
                btn[0].setEnabled(false);
                playerCnt++;
                if (Turn) {
                    btn[0].setText("X");
                    board[0] = 1;
                    displayTV.setText("Player O Turn");
                }
                else {
                    btn[0].setText("O");
                    board[0] = 0;
                    displayTV.setText("Player X Turn");
                }
                Turn = !Turn;
                check();
                break;

            case R.id.Btn2:

                btn[1].setEnabled(false);
                playerCnt++;
                if (Turn) {
                    btn[1].setText("X");
                    board[1] = 1;
                    displayTV.setText("Player O Turn");
                } else {
                    btn[1].setText("O");
                    board[1] = 0;
                    displayTV.setText("Player X Turn");
                }
                Turn = !Turn;
                check();
                break;

            case R.id.Btn3:
                btn[2].setEnabled(false);
                playerCnt++;
                if(Turn)
                {
                    btn[2].setText("X");
                    board[2] = 1;
                    displayTV.setText("Player O Turn");
                }
                else
                {
                    btn[2].setText("O");
                    board[2] = 0;
                    displayTV.setText("Player X Turn");
                }
                Turn = !Turn;
                check();
                break;

            case R.id.Btn4:
                btn[3].setEnabled(false);
                playerCnt++;
                if(Turn)
                {
                    btn[3].setText("X");
                    board[3] = 1;
                    displayTV.setText("Player O Turn");
                }
                else
                {
                    btn[3].setText("O");
                    board[3] = 0;
                    displayTV.setText("Player X Turn");
                }
                Turn = !Turn;
                check();
                break;

            case R.id.Btn5:
                btn[4].setEnabled(false);
                playerCnt++;
                if(Turn)
                {
                    btn[4].setText("X");
                    board[4] = 1;
                    displayTV.setText("Player O Turn");
                }
                else
                {
                    btn[4].setText("O");
                    board[4] = 0;
                    displayTV.setText("Player X Turn");
                }
                Turn = !Turn;
                check();
                break;

            case R.id.Btn6:
                btn[5].setEnabled(false);
                playerCnt++;
                if(Turn)
                {
                    btn[5].setText("X");
                    board[5] = 1;
                    displayTV.setText("Player O Turn");
                }
                else
                {
                    btn[5].setText("O");
                    board[5] = 0;
                    displayTV.setText("Player X Turn");
                }
                Turn = !Turn;
                check();
                break;

            case R.id.Btn7:
                btn[6].setEnabled(false);
                playerCnt++;
                if(Turn)
                {
                    btn[6].setText("X");
                    board[6] = 1;
                    displayTV.setText("Player O Turn");
                }
                else
                {
                    btn[6].setText("O");
                    board[6] = 0;
                    displayTV.setText("Player X Turn");
                }
                Turn = !Turn;
                check();
                break;

            case R.id.Btn8:
                btn[7].setEnabled(false);
                playerCnt++;
                if(Turn)
                {
                    btn[7].setText("X");
                    board[7] = 1;
                    displayTV.setText("Player O Turn");
                }
                else
                {
                    btn[7].setText("O");
                    board[7] = 0;
                    displayTV.setText("Player X Turn");
                }
                Turn = !Turn;
                check();
                break;

            case R.id.Btn9:
                btn[8].setEnabled(false);

                playerCnt++;
                if(Turn)
                {
                    btn[8].setText("X");
                    board[8] = 1;
                    displayTV.setText("Player O Turn");
                }
                else
                {
                    btn[8].setText("O");
                    board[8] = 0;
                    displayTV.setText("Player X Turn");
                }
                Turn = !Turn;
                check();
                break;

        }
    }

    @SuppressLint("SetTextI18n")
    private void check()
    {
        boolean win = false;
        String winner = "X";
        for (int i = 0; i < 9; i+=3)
        {
            if(board[i] == board[i+1] && board[i] == board[i+2] && board[i] != -1)
            {
                if(board[i] == 0)
                {
                    winner = "O";
                }

                win = true;
            }
        }
        for (int i = 0; i < 3; i++)
        {
            if(board[i] == board[i+3] && board[i] == board[i+6] && board[i] != -1)
            {
                if(board[i] == 0)
                {
                    winner = "O";
                }
                win = true;
            }
        }

        if(board[0] == board[4] && board[4] == board[8] && board[0] != -1)
        {
            if(board[0] == 0)
            {
                winner = "O";
            }
            win = true;
        }

        if(board[2] == board[4] && board[4] == board[6] && board[2] != -1)
        {
            if(board[2] == 0)
            {
                winner = "O";
            }
            win = true;
        }

        Intent it = new Intent(MainActivity.this, MainActivity2.class);
        if(win)
        {

            for (int i = 0; i < 9; i++) {
                btn[i].setEnabled(false);
            }
            displayTV.setText("Player " + winner + " Wins");
            it.putExtra("result" , "Player " + winner + " Wins");
            startActivity(it);
            displayTV.setText("Player X Turn");
            initializer();
        }
        else if(playerCnt == 9)
        {
            displayTV.setText("Match Draw");
            it.putExtra("result" , "Match Draw");
            startActivity(it);
            displayTV.setText("Player X Turn");
            initializer();
        }
    }
}