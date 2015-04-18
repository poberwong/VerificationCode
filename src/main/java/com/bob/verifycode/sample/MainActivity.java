package com.bob.verifycode.sample;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bob.verifycode.R;
import com.bob.verifycode.utils.BaseVerify;
import com.bob.verifycode.utils.IVerify;


public class MainActivity extends Activity implements OnClickListener {

    private Button bt_change;
    private View bt_check;
    private EditText et_verify;
    private ImageView verify_img;
    private TextView tv_check;
    private IVerify vCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_change = (Button) findViewById(R.id.bt_change);
        bt_check = (Button) findViewById(R.id.bt_check);
        verify_img = (ImageView) findViewById(R.id.img_verify);
        et_verify = (EditText) findViewById(R.id.et_verify);
        tv_check = (TextView) findViewById(R.id.tv_Check);
        vCode = BaseVerify.getInstance();

        verify_img.setImageBitmap(vCode.createBitmap());

        bt_change.setOnClickListener(this);
        bt_check.setOnClickListener(this);
        et_verify.addTextChangedListener(new TextWatcher() {//对EditText进行监听,监听改变tv_check状态
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tv_check.setVisibility(View.GONE);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_change://更换一张验证码
                verify_img.setImageBitmap(vCode.createBitmap());
                break;
            case R.id.bt_check: {//校验
                if (vCode.checkCode(et_verify.getText().toString())) {
                    tv_check.setTextColor(Color.GREEN);
                    tv_check.setText("验证成功");
                    tv_check.setVisibility(View.VISIBLE);
                } else {
                    tv_check.setTextColor(Color.RED);
                    tv_check.setText("验证码错误");
                    tv_check.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}
