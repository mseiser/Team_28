package com.team28.thehiker


import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.team28.thehiker.Constants.Constants
import com.team28.thehiker.Permissions.PermissionHandler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermissions(PermissionHandler())
    }

    fun checkPermissions(permissionHandler: PermissionHandler) {
        if (!permissionHandler.permissionsAlreadyGranted(this)) {
            permissionHandler.askUserForPermissions(this)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            Constants.PermissionConstants.PERMISSION_REQUEST_CODE -> {
                if ((grantResults.isEmpty() ||
                            grantResults[0] == PackageManager.PERMISSION_DENIED)) {
                    finish()
                }
                return
            }
            else -> { }
        }
    }

    fun navigateTo(view: View) {
        val intent :Intent

        when (view.id) {
            R.id.btn_altitude -> {
                intent = Intent(this, TestActivity::class.java)
            }
            R.id.btn_position_on_map -> {
                intent = Intent(this, TestActivity::class.java)
            }
            else -> {
                intent = Intent(this, TestActivity::class.java)
            }
        }

        startActivity(intent)
    }
}