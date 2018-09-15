package com.curiousca.styletoast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

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
}
