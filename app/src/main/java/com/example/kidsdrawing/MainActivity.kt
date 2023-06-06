package com.example.kidsdrawing

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_brush_size.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        drawing_view?.setSizeForBrush(20F)

        ibBrush.setOnClickListener {
            showBrushSizeChooserDialog()
        }
    }




    private fun showBrushSizeChooserDialog(){
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Brush size: ")
        val smallBtn = brushDialog.ibSmallBrush
        smallBtn.setOnClickListener {
            drawing_view?.setSizeForBrush(10F)
            brushDialog.dismiss()
        }
        val mediumBtn = brushDialog.ibMediumBrush
        mediumBtn.setOnClickListener {
            drawing_view?.setSizeForBrush(20F)
            brushDialog.dismiss()
        }
        val largeBtn = brushDialog.ibLargeBrush
        largeBtn.setOnClickListener {
            drawing_view?.setSizeForBrush(30F)
            brushDialog.dismiss()
        }

        brushDialog.show()
    }
}