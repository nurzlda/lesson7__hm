package com.example.lesson7_month3

import android.app.AlertDialog
import android.content.ContentProvider
import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment

fun AppCompatActivity.addFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().add(R.id.container, fragment).commit()
}

fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}


fun Fragment.showToast(msg: String) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
}

fun Fragment.showDialog(pos : String) {
    val alertDialog = AlertDialog.Builder(requireContext())
    alertDialog.setTitle("Удалить?")
    alertDialog.setMessage("Вы точно хотите удалить?")
    alertDialog.setNegativeButton("No") { alert, _ ->
        alert.cancel()
    }
    alertDialog.setPositiveButton("Yes") { alert, _ ->

        showToast("Вы удалили айтем номер $pos")
        alert.cancel()
    }
    alertDialog.create().show()
}






