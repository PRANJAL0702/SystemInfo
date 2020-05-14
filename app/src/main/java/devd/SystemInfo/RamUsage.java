//RAM USAGE
package devd.SystemInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;

public class RamUsage extends AppCompatActivity {
    private TextView battery;

    private BroadcastReceiver batterylevelReciever=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            battery.setText("\u2022 Battery Usage:"+String.valueOf(level)+"%");

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ram_usage);
        battery = (TextView) findViewById(R.id.batteryLevel);
        this.registerReceiver(this.batterylevelReciever,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        final TextView txt=(TextView) findViewById(R.id.memInfo);
        txt.setText(getMemoryInfo());

    }



    private String getMemoryInfo() {
        ActivityManager.MemoryInfo memoryInfo=new ActivityManager.MemoryInfo();
        ActivityManager activityManager=(ActivityManager) getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(memoryInfo);
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        float refreshRating = display.getRefreshRate();
        String str="\u2022 Available RAM in GB: "+String.valueOf(memoryInfo.availMem/ 1073741824L)+
                "\n\u2022 Total RAM in GB: "+String.valueOf(memoryInfo.totalMem/ 1073741824L+
                "\n\u2022 Display Rate: "+String.valueOf(refreshRating));
        return str;
    }

}
