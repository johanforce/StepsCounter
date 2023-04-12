package com.example.stepscounter.presentation.recognition

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.stepscounter.databinding.ActivityRecognitionPermissionBinding
import com.example.stepscounter.presentation.base.BaseActivity
import com.example.stepscounter.presentation.main.MainActivity

@RequiresApi(Build.VERSION_CODES.Q)
class RecognitionPermissionActivity :
    BaseActivity<ActivityRecognitionPermissionBinding>(ActivityRecognitionPermissionBinding::inflate) {

    private val requestPermissionLauncher = registerForActivityResult(RequestPermission()) {
        when (ContextCompat.checkSelfPermission(
            this, Manifest.permission.ACTIVITY_RECOGNITION
        )) {
            PackageManager.PERMISSION_GRANTED -> openMainActivity()
            PackageManager.PERMISSION_DENIED -> openPermissionSettings()
        }
    }

    private fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        finish()
        startActivity(intent)
    }

    private fun openPermissionSettings() {
        startActivity(Intent().apply {
            action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            data = Uri.fromParts("package", packageName, null)
        })
    }

    override fun setUpViews() {
        super.setUpViews()

        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.ACTIVITY_RECOGNITION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            openMainActivity()
        }

        binding.buttonContinue.setOnClickListener {
            requestPermission()
        }
    }

    private fun requestPermission() {
        requestPermissionLauncher.launch(Manifest.permission.ACTIVITY_RECOGNITION)
    }
}