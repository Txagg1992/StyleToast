package com.curiousca.styletoast;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
        
        StyleableToast sToast = null;
        sToast.makeText(this, "YEAH TOAST!", R.style.exampleToast).show();
    }

    public void showToast2(View view) {
        Toast toast = Toast.makeText(this, "MORE TOAST", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    public void showToast3(View view) {

        Toast toast2 = Toasty.error(this, "Answer incorrect", Toast.LENGTH_SHORT);
        toast2.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast2.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.contact:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"curiousaps@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Capitals");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                try {
                    startActivity(Intent.createChooser(intent, "Send email..."));
                }catch (ActivityNotFoundException ex){
                    Toast.makeText(this, "There are no email clients available for this device.",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_TEXT,
                        "https://play.google.com/store/apps/details?id=com.curiousca.statecapitals");
                startActivity(Intent.createChooser(sharingIntent, "Share via..."));
                break;
            case R.id.about:
                Intent i = new Intent(this, AboutActivity.class);
                this.startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
