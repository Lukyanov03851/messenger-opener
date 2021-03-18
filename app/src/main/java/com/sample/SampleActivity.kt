package com.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.messengeropener.Opener
import com.sample.databinding.ActivitySampleBinding

class SampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnViber.setOnClickListener{
            Opener.openViber(this, VIBER_ACCOUNT)
        }

        binding.btnTelegram.setOnClickListener{
            Opener.openTelegram(this, TELEGRAM_ACCOUNT)
        }

        binding.btnFacebook.setOnClickListener{
            Opener.openFacebook(this, FACEBOOK_ACCOUNT)
        }

        binding.btnSkype.setOnClickListener{
//            Opener.openSkype(this, SKYPE_ACCOUNT)
        }

        binding.btnWhatsapp.setOnClickListener{
            Opener.openWatsApp(this, WATSAPP_ACCOUNT)
        }

    }
}