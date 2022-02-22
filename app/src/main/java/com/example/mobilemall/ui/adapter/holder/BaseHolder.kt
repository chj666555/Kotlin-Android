package com.example.mobilemall.ui.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilemall.MallApplication

open class BaseHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    companion object {
        fun getDrawableId(imageName: String): Int {
            return try {
                val field = Class.forName(MallApplication.mallApplication.packageName + ".R\$drawable").getField(imageName)
                field.getInt(field)
            } catch (e: Exception) {
                -1
            }
        }
    }
}