package com.example.android.courtcounter;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AlertDialogLayout;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
int scoreA=0 , scoreB=0, tempA= scoreA, tempB=scoreB;
String lastUpdate = "";

boolean resetRecently=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
// 3 points
    public void updatePoint3A(View view){
        tempA =scoreA;
        scoreA=scoreA+3;
        updateScoreA(scoreA);
        lastUpdate="a";

    }
    public void updatePoint3B(View view){
        tempB =scoreB;
        scoreB=scoreB+3;
        updateScoreB(scoreB);
        lastUpdate="b";
    }

    // 2 points
    public void updatePoint2A(View view){
        tempA = scoreA;
        scoreA=scoreA+2;
        updateScoreA(scoreA);
        lastUpdate="a";
    }
    public void updatePoint2B(View view){
        tempB = scoreB;
        scoreB=scoreB+2;
        updateScoreB(scoreB);
        lastUpdate="b";
    }

    // 3 points
    public void updatePoint1A(View view){
        tempA= scoreA;
        scoreA=scoreA+1;
        updateScoreA(scoreA);
        lastUpdate="a";
    }
    public void updatePoint1B(View view){
        tempB = scoreB;
        scoreB=scoreB+1;
        updateScoreB(scoreB);
        lastUpdate="b";
    }



    // update the socre
    public void updateScoreA(int score){
        TextView scoreTextView = (TextView) findViewById(R.id.scoreA);
        scoreTextView.setText(""+score);
    }
    public void updateScoreB(int score){
        TextView scoreTextView = (TextView) findViewById(R.id.scoreB);
        scoreTextView.setText(""+score);
    }

    //REset scores to 0
    public void reset(View view){
        tempA=scoreA;
        tempB =scoreB;
        scoreA = scoreB =0;
        updateScoreA(scoreA);
        updateScoreB(scoreB);
        resetRecently=true;
    }

    // undo
    public void undo(View view){
        //testing array undo
        scoreA = tempA;
        scoreB= tempB;
       //if(resetRecently==false ){
        if(resetRecently==true){
            scoreA=tempA;
            scoreB=tempB;
            updateScoreA(scoreA);
            updateScoreB(scoreB);
            resetRecently=false;
        } else if(lastUpdate =="a"){
            updateScoreA(scoreA);
        }else if(lastUpdate=="b"){
            updateScoreB(scoreB);
        }else{
            //do nothing.
        }
       // }else{
         //   resetRecently=false;
        //}
    }
}
