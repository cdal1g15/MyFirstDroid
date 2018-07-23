package lyradroids.myfirstdroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GamePlayArea extends AppCompatActivity {

    protected int rightCount = 0;
    protected int wrongCount = 0;

    protected ArrayList<Integer> cards = new ArrayList<>();
    protected ArrayList<Integer> discarded = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play_area);
        // Add all cards to an array
        cards.addAll(Arrays.asList(
                R.drawable.ac, R.drawable.ad,R.drawable.ah,R.drawable.as,
                R.drawable.kc,R.drawable.kd,R.drawable.kh,R.drawable.ks,
                R.drawable.qc,R.drawable.qd,R.drawable.qh,R.drawable.qs,
                R.drawable.jc,R.drawable.jd,R.drawable.jh,R.drawable.js,
                R.drawable.card10c,R.drawable.card10d,R.drawable.card10h,R.drawable.card10s,
                R.drawable.card9c,R.drawable.card9d,R.drawable.card9h,R.drawable.card9s,
                R.drawable.card8c,R.drawable.card8d,R.drawable.card8h,R.drawable.card8s,
                R.drawable.card7c,R.drawable.card7d,R.drawable.card7h,R.drawable.card7s,
                R.drawable.card6c,R.drawable.card6d,R.drawable.card6h,R.drawable.card6s,
                R.drawable.card5c,R.drawable.card5d,R.drawable.card5h,R.drawable.card5s,
                R.drawable.card4c,R.drawable.card4d,R.drawable.card4h,R.drawable.card4s,
                R.drawable.card3c,R.drawable.card3d,R.drawable.card3h,R.drawable.card3s,
                R.drawable.card2c,R.drawable.card2d,R.drawable.card2h,R.drawable.card2s));
        ImageView imageView2 = findViewById(R.id.imageView2);
        int a = chooseCard();
        //Show random card and remove it from deck
        imageView2.setImageResource(cards.get(a));
        cards.remove(a);
    }

    protected void onButtonTapWrong(View view){
        wrongCount++;
        ImageView imageView2 = findViewById(R.id.imageView2);
        int a = chooseCard();
        //Show random card and remove it from deck
        imageView2.setImageResource(cards.get(a));
        cards.remove(a);

    }

    protected void onButtonTapRight(View view){
        rightCount++;
        ImageView imageView2 = findViewById(R.id.imageView2);
        int a = chooseCard();
        //Show random card and remove it from deck
        imageView2.setImageResource(cards.get(a));
        cards.remove(a);

    }

    protected void onButtonTapLeave(View view){
        //Show current score and if the user wants to quit
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("End Game?");
        builder.setMessage("Well done, you got " + rightCount +
                " correct, and " + wrongCount + " incorrect");
        builder.setPositiveButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public int chooseCard(){
        //Show message to explain deck is empty
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Deck Empty");
        builder.setMessage("New deck of cards, you current have " + rightCount
                + " correct answers");
        AlertDialog dialog = builder.create();
        if(cards.isEmpty()){
            //refill card deck
           cards.addAll(discarded);
           discarded.removeAll(discarded);

           dialog.show();
        }

        //random number generator for choosing card
        Random random = new Random();
        int  n = random.nextInt(cards.size());
        discarded.add(cards.get(n));
        return n;
    }
}
