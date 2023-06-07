package com.example.kidsdrawing

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_brush_size.*

class MainActivity : AppCompatActivity() {
    private var mImageButtonCurrentPaint : ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        drawing_view?.setSizeForBrush(20F)

        mImageButtonCurrentPaint = llPaintColors[1] as ImageButton
        mImageButtonCurrentPaint!!.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.pallet_pressed)
        )

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

    fun paintClicked(view: View){
        if (view !== mImageButtonCurrentPaint){
            val imageButton = view as ImageButton
            val colorTag = imageButton.tag.toString()
            drawing_view?.setColor(colorTag)

            imageButton.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.pallet_pressed)
            )
            mImageButtonCurrentPaint?.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.pallet_normal)
            )
            mImageButtonCurrentPaint = view
        }

    }
}