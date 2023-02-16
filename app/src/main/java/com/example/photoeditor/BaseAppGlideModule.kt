package com.example.photoeditor

import android.content.Context
import android.util.Log
import androidx.databinding.ktx.BuildConfig
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.executor.GlideExecutor
import com.bumptech.glide.module.AppGlideModule

@GlideModule
class BaseAppGlideModule : AppGlideModule() {
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        if (BuildConfig.DEBUG) {
            builder.setLogLevel(Log.ERROR)
        }
        builder.setAnimationExecutor(GlideExecutor.newUnlimitedSourceExecutor())

        //super.applyOptions(context, builder);
    }
}