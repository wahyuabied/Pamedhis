package com.mrabid.pamedhisjav.helper;

import android.widget.EditText;

public class Validator {
    public static boolean input(EditText x) {
        if ((x.getText() + "").equalsIgnoreCase("")){
            x.setError("Field tidak boleh kosong");
            return false;
        }
            return true;
    }
}
