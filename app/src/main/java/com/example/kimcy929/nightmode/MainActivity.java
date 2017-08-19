package com.example.kimcy929.nightmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    private static int modeTheme = AppCompatDelegate.MODE_NIGHT_AUTO;
    private static int position = 2;
    final String[] mode = new String[] {"Always night", "Always day", "Auto", "Follow system"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setNightMode(savedInstanceState, modeTheme);

        Button btnNightMode = (Button) findViewById(R.id.btnNightMode);

        TextView txtNightMode = (TextView) findViewById(R.id.textView);
        txtNightMode.setText(mode[position]);

        btnNightMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogNightMode();
            }
        });
    }

    private void startNewActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void showDialogNightMode() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose mode")
                .setSingleChoiceItems(mode, position, (dialog, which) -> {
                    switch (which) {
                        case 0:
                            modeTheme = AppCompatDelegate.MODE_NIGHT_YES;
                            break;

                        case 1:
                            modeTheme = AppCompatDelegate.MODE_NIGHT_NO;
                            break;

                        case 2:
                            modeTheme = AppCompatDelegate.MODE_NIGHT_AUTO;
                            break;

                        case 3:
                            modeTheme = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
                            break;
                    }
                    position = which;
                    dialog.dismiss();
                    startNewActivity();
                }).show();
    }
}
