package com.messengeropener

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri

object Opener {

    fun openWatsApp(context: Context?, account: String) {
        callMessenger(
            context,
            WATS_APP_ID,
            WATS_APP_URI,
            account
        )
    }

    fun openViber(context: Context?, account: String) {
        callMessenger(
            context,
            VIBER_ID,
            VIBER_URI,
            account
        )
    }

    fun openFacebook(context: Context?, account: String) {
        callMessenger(
            context,
            FACEBOOK_ID,
            FACEBOOK_URI,
            account
        )
    }

    fun openTelegram(context: Context?, account: String) {
        callMessenger(
            context,
            TELEGRAM_ID,
            TELEGRAM_URI,
            account
        )
    }

    private fun callMessenger(context: Context?, messengerId: String, messengerUri: String, account: String){
        if (isPackageInstalled(context, messengerId)) {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(messengerUri + Uri.encode(account)))
                intent.setPackage(messengerId)
                context?.startActivity(intent)
            } catch (e: Exception) {
                context?.showToast(R.string.open_messenger_error)
            }
        }
    }

    private fun isPackageInstalled(context: Context?, packageName: String): Boolean {
        return try {
            context?.packageManager?.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            openAppInPlayStore(context, packageName)
            false
        }
    }

    private fun openAppInPlayStore(context: Context?, packageName: String) {
        try {
            context?.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(MARKET_DETAILS_ID + packageName)))
        } catch (ex: android.content.ActivityNotFoundException) {
            ex.printStackTrace()
            context?.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(HTTPS_PLAY_GOOGLE_COM_STORE_APPS_DETAILS_ID + packageName)
                )
            )
        }
    }
}