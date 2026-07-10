/*
 * Copyright (c) 2026 tutosrive. All rights reserved.
 *
 * Author: tutosrive
 * GitHub: https://github.com/tutosrive
 *
 * This source code is PROPRIETARY and CONFIDENTIAL.
 * Unauthorized copying, modification, or distribution of this file,
 * via any medium, is strictly prohibited.
 *
 * This software is provided "as is", without warranty of any kind.
 * In no event shall the author be liable for any claim or damages.
 */

package com.srm.lottiee

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    private lateinit var lottieView: LottieAnimationView
    private lateinit var btnChange: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnChange = findViewById<Button>(R.id.btnChange)
        lottieView = findViewById<LottieAnimationView>(R.id.lottieView)
        var anim = "wh.json"
        lottieView.setAnimation(anim)
        lottieView.playAnimation()
        lottieView.speed = 2.0f
        lottieView.setImageAssetDelegate { image ->
            val drawableId: Int = R.drawable.logo

            BitmapFactory.decodeResource(
                resources,
                drawableId
            )
        }

        btnChange.setOnClickListener { viewModelStore ->
            anim = when (anim) {
                "wh.json" -> "logo2.json"
                "logo2.json" -> "wh.json"
                else -> "wh.json"
            }
            lottieView.setAnimation(anim)
            lottieView.frame = 0
            lottieView.playAnimation()

        }
    }
}