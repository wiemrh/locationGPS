package com.wiem.testloc

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PermissionGps : AppCompatActivity() {
    private fun createGpsDisabledAlert() {
        val localBuilder = AlertDialog.Builder(this)
        localBuilder
                .setMessage("Le GPS est inactif, voulez-vous l'activer ?")
                .setCancelable(false)
                .setPositiveButton("Activer GPS "
                ) { paramDialogInterface, paramInt -> showGpsOptions() }
        localBuilder.setNegativeButton("Ne pas l'activer "
        ) { paramDialogInterface, paramInt ->
            paramDialogInterface.cancel()
            finish()
        }
        localBuilder.create().show()
    }

    private fun showGpsOptions() {
        startActivity(Intent("android.settings.LOCATION_SOURCE_SETTINGS"))
        finish()
    }

    override fun onCreate(paramBundle: Bundle?) {
        super.onCreate(paramBundle)
        createGpsDisabledAlert()
    }
}