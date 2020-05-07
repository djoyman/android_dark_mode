package test.app.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private boolean currentMode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentMode = MainApplication.getInstance().getCurrentNightMode();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (MainApplication.getInstance().getCurrentNightMode() != currentMode)
            recreate();
    }
}
