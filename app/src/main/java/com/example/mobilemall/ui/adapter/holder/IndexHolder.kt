package com.example.mobilemall.ui.adapter.holder

import android.view.View
import com.example.mobilemall.data.entity.Item
import com.example.mobilemall.databinding.IndexItemBinding
import java.util.*

class IndexHolder(itemView: View, var indexItemBinding: IndexItemBinding) : BaseHolder(itemView) {
    fun setData(item: Item, onClickListener: View.OnClickListener?) {
        //填充内容
        indexItemBinding.content.text = item.content
        indexItemBinding.title.text = item.title
        indexItemBinding.price.text = item.price.toString() + "元"
        indexItemBinding.image.setImageResource(BaseHolder.Companion.getDrawableId(item.picture))
        //设置缓存
        indexItemBinding.btnAddShoppingCart.tag = item
        //设置监听事件
        indexItemBinding.btnAddShoppingCart.setOnClickListener(onClickListener)
        indexItemBinding.root.setOnClickListener(onClickListener)
    }

    init {
        val params = indexItemBinding.root.layoutParams
        params.height = params.height + Random().nextInt(321)
        indexItemBinding.root.layoutParams = params
    }
}