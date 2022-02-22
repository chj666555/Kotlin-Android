package com.example.mobilemall.ui.adapter.holder

import android.annotation.SuppressLint
import android.view.View
import com.example.mobilemall.data.entity.ShoppingCart
import com.example.mobilemall.databinding.ShoppingcartItemBinding

class ShoppingCartItemHolder(itemView: View, var shoppingcartItemBinding: ShoppingcartItemBinding) : BaseHolder(itemView) {
    @SuppressLint("SetTextI18n")
    fun setData(shoppingCart: ShoppingCart, onClickListener: View.OnClickListener?) {
        //设置监听事件
        shoppingcartItemBinding.btnAdd.setOnClickListener(onClickListener)
        shoppingcartItemBinding.btnRemove.setOnClickListener(onClickListener)
        shoppingcartItemBinding.chkSelect.setOnClickListener(onClickListener)
        shoppingcartItemBinding.chkSelect.isChecked = shoppingCart.selected
        shoppingcartItemBinding.root.setOnClickListener(onClickListener)
        //设置缓存
        shoppingcartItemBinding.txtQuantity.tag = shoppingCart
        shoppingcartItemBinding.btnAdd.tag = shoppingcartItemBinding
        shoppingcartItemBinding.chkSelect.tag = shoppingcartItemBinding
        shoppingcartItemBinding.btnRemove.tag = shoppingcartItemBinding
        //填充内容
        shoppingcartItemBinding.title.text = shoppingCart.item.title
        shoppingcartItemBinding.price.text = shoppingCart.item.price.toString() + "元"
        shoppingcartItemBinding.image.setImageResource(BaseHolder.Companion.getDrawableId(shoppingCart.item.picture))
        shoppingcartItemBinding.txtQuantity.text = shoppingCart.quantity.toString() + ""
    }

}