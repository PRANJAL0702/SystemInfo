package devd.SystemInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class SystemInfo extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_info);
        textView=(TextView) findViewById(R.id.textView);
        textView.setText(
                "\u2022 MODEL:"+ Build.MODEL+ "\n"
                        + "\u2022 MANUFACTURER:"+ Build.MANUFACTURER+ "\n"
                        + "\u2022 ID:"+ Build.ID+ "\n"
                        + "\u2022 HOST:"+ Build.HOST+ "\n"
                        + "\u2022 HARDWARE:"+ Build.HARDWARE+ "\n"
                        + "\u2022 FINGERPRINT:"+ Build.FINGERPRINT+ "\n"
                        + "\u2022 DISPLAY:"+ Build.DISPLAY+ "\n"
                        + "\u2022 DEVICE:"+ Build.DEVICE+ "\n"
                        + "\u2022 BOOTLOADER:"+ Build.BOOTLOADER+ "\n"
                        + "\u2022 BRAND:"+ Build.BRAND+ "\n"
                        + "\u2022 BOARD:"+ Build.BOARD+ "\n"
                        + "\u2022 PRODUCT:"+ Build.PRODUCT+ "\n"
                        + "\u2022 TAGS:"+ Build.TAGS+ "\n"
                        + "\u2022 TYPE:"+ Build.TYPE+ "\n"
        );
    }
}
