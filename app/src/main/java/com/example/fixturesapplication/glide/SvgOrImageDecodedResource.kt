package com.example.fixturesapplication.glide

import android.graphics.Bitmap
import com.caverock.androidsvg.SVG

data class SvgOrImageDecodedResource(
    val svg: SVG? = null,
    val bitmap: Bitmap? = null)