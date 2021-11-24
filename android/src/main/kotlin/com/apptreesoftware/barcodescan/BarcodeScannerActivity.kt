package com.apptreesoftware.barcodescan

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import android.text.style.ForegroundColorSpan
import android.text.SpannableString
import android.R
import android.graphics.Color
import android.view.WindowManager

class BarcodeScannerActivity : Activity(), ZXingScannerView.ResultHandler {

    lateinit var scannerView: me.dm7.barcodescanner.zxing.ZXingScannerView

    var actionBarColor = Color.WHITE

    companion object {
        const val REQUEST_TAKE_PHOTO_CAMERA_PERMISSION = 100
        const val TOGGLE_FLASH = 200
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = ""
        val p = intent.extras
        val theme = p!!.getString("theme");
        scannerView = ZXingAutofocusScannerView(this)
        scannerView.setAutoFocus(true)
        scannerView.setLaserEnabled(false)
        scannerView.setSquareViewFinder(true)
        scannerView.setAspectTolerance(0.5f)
        if (theme != null && theme.equals("kalium")) {
            actionBarColor = 0xFFFBDD11.toInt()
            scannerView.setBorderColor(0xFFFBDD11.toInt())
            actionBar?.setBackgroundDrawable(ColorDrawable(0xFF212124.toInt()))
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                scannerView.setSystemUiVisibility(0);
            }
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = 0xFF212124.toInt()
            }
        } else if (theme != null && theme.equals("natrium")) {
            actionBarColor = 0xFFA3CDFF.toInt()
            scannerView.setBorderColor(0xFFA3CDFF.toInt())
            actionBar?.setBackgroundDrawable(ColorDrawable(0xFF2A3A4D.toInt()))
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                scannerView.setSystemUiVisibility(0);
            }
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = 0xFF2A3A4D.toInt()
            }
        } else if (theme != null && theme.equals("titanium")) {
            actionBarColor = 0xFF61C6AD.toInt()
            scannerView.setBorderColor(0xFF61C6AD.toInt())
            actionBar?.setBackgroundDrawable(ColorDrawable(0xFF041920.toInt()))
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                scannerView.setSystemUiVisibility(0);
            }
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = 0xFF041920.toInt()
            }
        } else if (theme != null && theme.equals("iridium")) {
            actionBarColor = 0xFF008F53.toInt()
            scannerView.setBorderColor(0xFF008F53.toInt())
            actionBar?.setBackgroundDrawable(ColorDrawable(0xFFFFFFFF.toInt()))
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                scannerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = 0xFFFFFFFF.toInt()
            }
        } else if (theme != null && theme.equals("beryllium")) {
            actionBarColor = 0xFFBDA1FF.toInt()
            scannerView.setBorderColor(0xFFBDA1FF.toInt())
            actionBar?.setBackgroundDrawable(ColorDrawable(0xFF18181A.toInt()))
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                scannerView.setSystemUiVisibility(0);
            }
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = 0xFF18181A.toInt()
            }
        } else if (theme != null && theme.equals("ruthium")) {
            actionBarColor = 0xFFD5727E.toInt()
            scannerView.setBorderColor(0xFFD5727E.toInt())
            actionBar?.setBackgroundDrawable(ColorDrawable(0xFFFFC9D0.toInt()))
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                scannerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = 0xFFFFC9D0.toInt()
            }
        } else if (theme != null && theme.equals("radium")) {
            actionBarColor = 0xFF39E289.toInt()
            scannerView.setBorderColor(0xFF39E289.toInt())
            actionBar?.setBackgroundDrawable(ColorDrawable(0xFF1A0636.toInt()))
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                scannerView.setSystemUiVisibility(0);
            }
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = 0xFF1A0636.toInt()
            }
        } else if (theme != null && theme.equals("indium")) {
            actionBarColor = 0xFF0050BB.toInt()
            scannerView.setBorderColor(0xFF0050BB.toInt())
            actionBar?.setBackgroundDrawable(ColorDrawable(0xFFFFFFFF.toInt()))
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                scannerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = 0xFFFFFFFF.toInt()
            }
        } else if (theme != null && theme.equals("neptunium")) {
            actionBarColor = 0xFF4A90E2.toInt()
            scannerView.setBorderColor(0xFF4A90E2.toInt())
            actionBar?.setBackgroundDrawable(ColorDrawable(0xFF080840.toInt()))
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                scannerView.setSystemUiVisibility(0);
            }
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = 0xFF080840.toInt()
            }
        } else if (theme != null && theme.equals("thorium")) {
            actionBarColor = 0xFF75F3FF.toInt()
            scannerView.setBorderColor(0xFF75F3FF.toInt())
            actionBar?.setBackgroundDrawable(ColorDrawable(0xFF2A1052.toInt()))
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                scannerView.setSystemUiVisibility(0);
            }
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = 0xFF2A1052.toInt()
            }
        } else if (theme != null && theme.equals("carbon")) {
            actionBarColor = 0xFF99C1F0.toInt()
            scannerView.setBorderColor(0xFF99C1F0.toInt())
            actionBar?.setBackgroundDrawable(ColorDrawable(0xFF000000.toInt()))
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                scannerView.setSystemUiVisibility(0);
            }
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = 0xFF000000.toInt()
            }
        } else if (theme != null && theme.equals("uranium")) {
            actionBarColor = 0xFFE4E582.toInt()
            scannerView.setBorderColor(0xFFE4E582.toInt())
            actionBar?.setBackgroundDrawable(ColorDrawable(0xFF000000.toInt()))
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                scannerView.setSystemUiVisibility(0);
            }
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = 0xFF000000.toInt()
            }
        } else if (theme != null && theme.equals("blaise")) {
            actionBarColor = 0xFFF7941F.toInt()
            scannerView.setBorderColor(0xFFF7941F.toInt())
            actionBar?.setBackgroundDrawable(ColorDrawable(0xFFFFFFFF.toInt()))
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                scannerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = 0xFFFFFFFF.toInt()
            }
        } else if (theme != null && theme.equals("blaisedark")) {
            actionBarColor = 0xFF8287B5.toInt()
            scannerView.setBorderColor(0xFF8287B5.toInt())
            actionBar?.setBackgroundDrawable(ColorDrawable(0xFF1C1E21.toInt()))
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                scannerView.setSystemUiVisibility(0);
            }
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = 0xFF1C1E21.toInt()
            }
        } else if (theme != null && theme.equals("copper")) {
            actionBarColor = 0xFFDD8D52.toInt()
            scannerView.setBorderColor(0xFFDD8D52.toInt())
            actionBar?.setBackgroundDrawable(ColorDrawable(0xFF2B2C37.toInt()))
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                scannerView.setSystemUiVisibility(0);
            }
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = 0xFF2B2C37.toInt()
            }
        }
        setContentView(scannerView)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        if (scannerView.flash) {
            val item = menu.add(0,
                    TOGGLE_FLASH, 0, "Flash Off")
            item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
            val spanString = SpannableString(item.title.toString())
            spanString.setSpan(ForegroundColorSpan(actionBarColor), 0, spanString.length, 0)
            item.title = spanString
        } else {
            val item = menu.add(0,
                    TOGGLE_FLASH, 0, "Flash On")
            item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
            val spanString = SpannableString(item.title.toString())
            spanString.setSpan(ForegroundColorSpan(actionBarColor), 0, spanString.length, 0)
            item.title = spanString
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == TOGGLE_FLASH) {
            scannerView.flash = !scannerView.flash
            this.invalidateOptionsMenu()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        scannerView.setResultHandler(this)
        // start camera immediately if permission is already given
        if (!requestCameraAccessIfNecessary()) {
            scannerView.startCamera()
        }
    }

    override fun onPause() {
        super.onPause()
        scannerView.stopCamera()
    }

    override fun handleResult(result: Result?) {
        val intent = Intent()
        intent.putExtra("SCAN_RESULT", result.toString())
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    fun finishWithError(errorCode: String) {
        val intent = Intent()
        intent.putExtra("ERROR_CODE", errorCode)
        setResult(Activity.RESULT_CANCELED, intent)
        finish()
    }

    private fun requestCameraAccessIfNecessary(): Boolean {
        val array = arrayOf(Manifest.permission.CAMERA)
        if (ContextCompat
                .checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, array,
                    REQUEST_TAKE_PHOTO_CAMERA_PERMISSION)
            return true
        }
        return false
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,grantResults: IntArray) {
        when (requestCode) {
            REQUEST_TAKE_PHOTO_CAMERA_PERMISSION -> {
                if (PermissionUtil.verifyPermissions(grantResults)) {
                    scannerView.startCamera()
                } else {
                    finishWithError("PERMISSION_NOT_GRANTED")
                }
            }
            else -> {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            }
        }
    }
}

object PermissionUtil {

    /**
     * Check that all given permissions have been granted by verifying that each entry in the
     * given array is of the value [PackageManager.PERMISSION_GRANTED].

     * @see Activity.onRequestPermissionsResult
     */
    fun verifyPermissions(grantResults: IntArray): Boolean {
        // At least one result must be checked.
        if (grantResults.size < 1) {
            return false
        }

        // Verify that each required permission has been granted, otherwise return false.
        for (result in grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }
}
