package lyradroids.myfirstdroid;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onButtonTap(View view){
        Intent firstIntent = new Intent(this, GamePlayArea.class);
        startActivity(firstIntent);

    }

    protected void onButtonTapCredits(View view){
        String newline = System.getProperty("line.separator");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Credits");
        builder.setMessage("Company: LyraDroids" + newline +"Developer: Conor Leech"
                + newline + "Image Source: https://acbl.mybigcommerce.com/52-playing-cards/");
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

