package com.example.mobilemall.ui.adapter.holder

import android.view.View
import com.example.mobilemall.data.entity.Item
import com.example.mobilemall.databinding.ItemBinding

class ItemHolder(itemView: View, var itemBinding: ItemBinding) : BaseHolder(itemView) {
    fun setData(item: Item, onClickListener: View.OnClickListener?) {
        itemBinding.content.text = item.content
        itemBinding.title.text = item.title
        itemBinding.price.text = item.price.toString() + "元"
        itemBinding.image.setImageResource(getDrawableId(item.picture))
        //设置缓存
        itemBinding.btnAddShoppingCart.tag = item
        itemBinding.btnMore.tag = item
        //设置监听事件
        itemBinding.btnAddShoppingCart.setOnClickListener(onClickListener)
        itemBinding.btnMore.setOnClickListener(onClickListener)
        itemBinding.root.setOnClickListener(onClickListener)
    }

}