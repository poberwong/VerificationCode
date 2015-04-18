package com.bob.verifycode.utils;

import android.graphics.Bitmap;

/**
 * Created by bob on 15-4-18.
 */
public interface IVerify {
    public boolean checkCode(String input);
    public Bitmap createBitmap();
    }
