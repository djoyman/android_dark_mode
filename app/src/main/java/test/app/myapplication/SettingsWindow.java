package test.app.myapplication;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingsWindow extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_window);

        Switch darkModeSwitch = findViewById(R.id.dark_mode_switch);
        darkModeSwitch.setChecked(MainApplication.getInstance().getCurrentNightMode());
        darkModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                MainApplication.getInstance().setCurrentNightMode(b);
                recreate();
            }
        });
    }
}
