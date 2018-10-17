package com.player.noname.onflinggeture;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imgHinh;
    GestureDetector gestureDetector;
    int SWIPE_THRESHOLD = 100;
    int position = 0;
    int SWIPE_VELOCITY_THRESHOLD = 100;
    int[] manHinh = {R.drawable.icon_1, R.drawable.icon_2, R.drawable.icon_3} ;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgHinh = findViewById(R.id.imgHinh);
        imgHinh.setImageResource(manHinh[position]);
        gestureDetector = new GestureDetector(this, new MyGest());

        imgHinh.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }

    class MyGest extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//            Kéo từ trái sang phải
            if(e2.getX() - e1.getX() > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD){
                Toast.makeText(MainActivity.this, "Từ trái sang phải", Toast.LENGTH_SHORT).show();
                position --;
                if(position < 0){
                    position = manHinh.length -1;
                }
                imgHinh.setImageResource(manHinh[position]);
            }
//            Kéo từ phải sáng trái
            if(e1.getX() - e2.getX() > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD){
                Toast.makeText(MainActivity.this, "Từ phải sang trái", Toast.LENGTH_SHORT).show();
                position ++;
                if(position > manHinh.length -1){
                    position = 0;
                }
                imgHinh.setImageResource(manHinh[position]);
            }
//            Kéo từ trên xuống dưới
            if(e2.getY() - e1.getY() > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD){
                Toast.makeText(MainActivity.this, "Từ trên xuống dưới", Toast.LENGTH_SHORT).show();
            }
//            Kéo từ dưới lên trên
            if(e1.getY() - e2.getY() > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD){
                Toast.makeText(MainActivity.this, "Từ dưới lên trên", Toast.LENGTH_SHORT).show();
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
