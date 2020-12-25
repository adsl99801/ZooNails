package com.lfo.zoonails.util

import android.content.Context

class CommonUtil {
    fun getImage(context: Context, imageName: String): Int {
        return context.getResources().getIdentifier(imageName, "drawable", context.getPackageName())
    }
}