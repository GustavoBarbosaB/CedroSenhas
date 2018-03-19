package com.example.gustavobarbosab.minhassenhas.util.validator;

import com.example.gustavobarbosab.minhassenhas.R;

/**
 * Created by gustavobarbosab on 19/03/18.
 */

public enum EnumUserPassValidator {
    PASSWORD(R.string.error_incorrect_password),
    USERNAME(R.string.error_invalid_email),
    OK(R.string.bemVindo);

    private int val;

    public int getVal() {
        return val;
    }

     EnumUserPassValidator(int val) {
        this.val = val;
    }
}
