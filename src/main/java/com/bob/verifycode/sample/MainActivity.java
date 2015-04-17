package com.bob.verifycode.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bob.verifycode.R;
import com.bob.verifycode.utils.BaseVerify;


public class MainActivity extends Activity {

    private Button bt_change;
    private ImageView verify_img;
    private BaseVerify bCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_change= (Button)findViewById(R.id.bt_change);
        verify_img=(ImageView)findViewById(R.id.verify_img);
        bCode= BaseVerify.getInstance();

        verify_img.setImageBitmap(bCode.createBitmap());

        bt_change.setOnClickListener(new View.OnClickListener() {//重新选一张
            @Override
            public void onClick(View view) {
                verify_img.setImageBitmap(bCode.createBitmap());
            }
        });
    }
}
