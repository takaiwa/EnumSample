package net.takaiwa.enumsample;

import android.content.res.Resources;

public enum ResultCode {

    // エラーコード,エラーメッセージのID
    OK(200, R.string.result_code_ok),
    ERROR_FORBIDDEN(403, R.string.result_error_fobidden),
    ERROR_NOTFOUND(404, R.string.result_error_notfound),
    ERROR_INTERNAL_SERVER(503, R.string.result_error_internalserver),
    ERROR_UNKNOWN(999, R.string.result_error_unknown),;

    int code,id;
    ResultCode(int code, int id) {
        this.code = code;
        this.id = id;
    }

    // idからエラーメッセージを取得して返す
    public String getMessage(Resources r) {
        return r.getString(id);
    }

    // エラーコードを返す
    public int getErrorCode() {
        return this.code;
    }
}
