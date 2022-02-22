package com.example.mobilemall.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.example.mobilemall.R
import com.example.mobilemall.data.entity.Comment
import com.example.mobilemall.databinding.CommentItemBinding
import java.text.SimpleDateFormat
import java.util.*

class CommentAdapter(private val context: Context, comments: List<Comment>) : BaseAdapter() {
    private var comments: List<Comment> = ArrayList() //评价列表
    override fun getCount(): Int {
        return comments.size
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @SuppressLint("SimpleDateFormat")
    private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        @SuppressLint("ViewHolder") val commentItemBinding: CommentItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.comment_item, null, false)
        commentItemBinding.txtContent.text = comments[position].comment
        //脱敏
        var uid = comments[position].uid
        uid = uid.substring(0, 4) + "*****" + uid.substring(27)
        commentItemBinding.txtUID.text = uid
        commentItemBinding.txtDateTime.text = "发布于 " + simpleDateFormat.format(Date(comments[position].publish_datetime))
        return commentItemBinding.root
    }

    init {
        this.comments = comments
    }
}