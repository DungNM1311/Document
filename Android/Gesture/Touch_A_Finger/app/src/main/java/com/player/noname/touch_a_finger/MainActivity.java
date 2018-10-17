package com.player.noname.touch_a_finger;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imgHinh;
    TextView txtText;
    GestureDetector gestureDetector;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        gestureDetector = new GestureDetector(this, new MyGesture());

        imgHinh.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

    }

    private void initView() {
        imgHinh = findViewById(R.id.imgHinh);
        txtText = findViewById(R.id.txtText);
    }

    class MyGesture extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onDown(MotionEvent e) {
            txtText.setText("onDown" + e.toString());
            return super.onDown(e);
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            txtText.setText("onSingleTapUp" + e.toString());
            return super.onSingleTapUp(e);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            txtText.setText("onShowPress" + e.toString());

            super.onShowPress(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            txtText.setText("onLongPress" + e.toString());

            super.onLongPress(e);
        }
    }
}
