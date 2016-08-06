package ex.oyyj.simpleffmpegdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.oyyj.media.ffmpeg.FFCodecController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {

                FFCodecController controller = new FFCodecController();
               if(controller.ffcodec_decodefile_h264_to_yuv("/mnt/sdcard/hand.h264","/mnt/sdcard/out.yuv")>=0 )
               {
                   runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                          TextView msg = (TextView) findViewById(R.id.text_msg);
                           msg.setText("解码成功");
                       }
                   });
               }

            }
        }).start();
    }
}
