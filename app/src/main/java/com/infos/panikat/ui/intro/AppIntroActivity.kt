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
                title = "Faydaları",
                description = "Anksiyete ve Panik atak yaşadığınız anda uygulamamızı kullanarak kısa sürede atağınızı hafifletip kısa süreli kaybettiğiniz dış dünyaya olan bağınızı hızlı bir şekilde tekrar kazanabilirsiniz.",
                imageDrawable = R.drawable.custom_thumb,
                titleColorRes = R.color.black,
                descriptionColorRes = R.color.black,
                backgroundColorRes = R.color.lavantai,
            )
        )
        addSlide(
            AppIntroFragment.createInstance(
                title = "Nasıl Uygulanır?",
                description = "Kulaklığınızı takarak ya da kulaklığınızı takmadan cihaz hoparlörünü kulağınıza yakınlaştırarak “ Sakinleştirici Egzersiz “ menüsündeki beyaz gürültü sesini dinleyerek olumlama cümlelerini okuyabilirsiniz. Ekstra olarak sonrasında nefes egzersizlerini de kullanabilirsiniz.\t",
                imageDrawable = R.drawable.custom_thumb,
                titleColorRes = R.color.black,
                descriptionColorRes = R.color.black,
                backgroundColorRes = R.color.lavantai,
            )
        )
        addSlide(
            AppIntroFragment.createInstance(
                title = "Kullanım Tavsiyeleri",
                description = "Ses düzeyini çok açmamanızı tavsiye ediyoruz.",
                imageDrawable = R.drawable.custom_thumb,
                titleColorRes = R.color.black,
                descriptionColorRes = R.color.black,
                backgroundColorRes = R.color.lavantai,
            )
        )
        addSlide(
            AppIntroFragment.createInstance(
                title = "Amaçlarımız",
                description = "BGO Team x Panikat olarak panik atak, anksiyete vb. psikolojik rahatsızlıklarınızı olabildiğince minimum sürede atlatmanızı amaçlıyoruz.",
                imageDrawable = R.drawable.custom_thumb,
                titleColorRes = R.color.black,
                descriptionColorRes = R.color.black,
                backgroundColorRes = R.color.lavantai,
            )
        )
        addSlide(
            AppIntroFragment.createInstance(
                title = "Uyarı",
                description = "Lütfen uygulama kullanımınızı kendinize en sağlıklı gelecek şekilde tercih ediniz, fazla kullanım ve diğer yan etkilerinden BGO Team sorumlu değildir.",
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