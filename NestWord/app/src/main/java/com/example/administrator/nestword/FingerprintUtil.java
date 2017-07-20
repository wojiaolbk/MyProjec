package com.example.administrator.nestword;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.os.CancellationSignal;
import android.support.v4.app.ActivityCompat;

/**
 * Created by leafact on 2016/12/21.
 */

class FingerprintUtil {
    private static CancellationSignal cancellationSignal;

    static void callFingerPrint(final OnCallBackListenr listener) {
//        FingerprintManagerCompat managerCompat = FingerprintManagerCompat.from(MyApplication.context);
        FingerprintManager managerCompat = (FingerprintManager) MyApplication.context.getSystemService(MyApplication.context.FINGERPRINT_SERVICE);
        if (ActivityCompat.checkSelfPermission(MyApplication.context, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        if (!managerCompat.isHardwareDetected()) {
            //判断设备是否支持
            if (listener != null)
                listener.onSupportFailed();
            return;
        }
        KeyguardManager keyguardManager = (KeyguardManager) MyApplication.context.getSystemService(MyApplication.context.KEYGUARD_SERVICE);
        if (!keyguardManager.isKeyguardSecure()) {
            // /判断设备是否处于安全保护中
            if (listener != null)
                listener.onInsecurity();
            return;
        }
        if (!managerCompat.hasEnrolledFingerprints()) {
            //判断设备是否已经注册过指纹
            if (listener != null)
                listener.onEnrollFailed(); //未注册
            return;
        }
        if (listener != null)
            listener.onAuthenticationStart();
        //开始指纹识别
        cancellationSignal = new CancellationSignal();
        //必须重新实例化，否则cancel 过一次就不能再使用了
        managerCompat.authenticate(null, cancellationSignal, 0, new AuthenticationCallback() {
            @Override
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                if (listener != null)
                    listener.onAuthenticationSucceeded(result);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                if (listener != null)
                    listener.onAuthenticationFailed();
            }
        }, null);


//        managerCompat.authenticate(null, 0, cancellationSignal, new AuthenticationCallback() {
////            // 当出现错误的时候回调此函数，比如多次尝试都失败了的时候，errString是错误信息，比如华为的提示就是：尝试次数过多，请稍后再试。
////            @Override
////            public void onAuthenticationError(int errMsgId, CharSequence errString) {
////                if (listener != null)
////                    listener.onAuthenticationError(errMsgId, errString);
////            }
////
////            // 当指纹验证失败的时候会回调此函数，失败之后允许多次尝试，失败次数过多会停止响应一段时间然后再停止sensor的工作
////            @Override
////            public void onAuthenticationFailed() {
////                if (listener != null)
////                    listener.onAuthenticationFailed();
////            }
////
////            @Override
////            public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
////                if (listener != null)
////                    listener.onAuthenticationHelp(helpMsgId, helpString);
////            }
////
////            // 当验证的指纹成功时会回调此函数，然后不再监听指纹sensor
////            @Override
////            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
////                if (listener != null)
////                    listener.onAuthenticationSucceeded(result);
////            }
//
//
//        }, null);

    }

    interface OnCallBackListenr {
        void onSupportFailed();

        void onInsecurity();

        void onEnrollFailed();

        void onAuthenticationStart();

        void onAuthenticationError(int errMsgId, CharSequence errString);

        void onAuthenticationFailed();

        void onAuthenticationHelp(int helpMsgId, CharSequence helpString);

        void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result);
    }

    static void cancel() {
        if (cancellationSignal != null)
            cancellationSignal.cancel();
    }
}
