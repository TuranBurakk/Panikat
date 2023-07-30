package com.infos.panikat.ui.intro

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment
import com.infos.panikat.MainActivity
import com.infos.panikat.R

class AppIntroActivity : AppIntro() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addSlide(
            AppIntroFragment.createInstance(
                title = "Politika",
                description = "This is the first slide of the example",
                imageDrawable = R.drawable.custom_thumb,
                titleColorRes = R.color.black,
                descriptionColorRes = R.color.black,
                backgroundColorRes = R.color.lavantai,
            )
        )
        addSlide(
            AppIntroFragment.createInstance(
                title = "Politika",
                description = "This is the last slide, I won't annoy you more :)",
                imageDrawable = R.drawable.custom_thumb,
                titleColorRes = R.color.black,
                descriptionColorRes = R.color.black,
                backgroundColorRes = R.color.lavantai,
            )
        )
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        // Decide what to do when the user clicks on "Skip"
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        // Decide what to do when the user clicks on "Done"
        startActivity(Intent(this, MainActivity::class.java))
        finish()

    }
}