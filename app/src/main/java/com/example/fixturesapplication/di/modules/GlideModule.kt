package com.example.fixturesapplication.di.modules

import android.content.Context
import android.graphics.drawable.PictureDrawable
import com.bumptech.glide.Glide
import com.example.fixturesapplication.glide.SvgSoftwareLayerSetter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class GlideModule {
    @Provides
    @Singleton
    fun provideGlideRequest(app:Context) =
        Glide.with(app)
            .`as`(PictureDrawable::class.java)
                .listener(SvgSoftwareLayerSetter())
}