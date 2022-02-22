package com.example.mobilemall.ui.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilemall.R
import com.example.mobilemall.data.entity.Item
import com.example.mobilemall.data.tools.ShoppingCartUtil
import com.example.mobilemall.databinding.IndexItemBinding
import com.example.mobilemall.ui.activity.ItemDetailActivity
import com.example.mobilemall.ui.adapter.holder.IndexHolder
import com.example.mobilemall.ui.fragment.FragmentIndex

/**
 * 主页商品列表适配器
 */
class IndexAdapter(private val fragment: FragmentIndex, private val recyclerView: RecyclerView, private val list: List<Item>) : RecyclerView.Adapter<IndexHolder>(), View.OnClickListener {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndexHolder {
        val goodItemBinding: IndexItemBinding = DataBindingUtil.inflate(LayoutInflater.from(fragment.parentActivity), R.layout.index_item, parent, false)
        return IndexHolder(goodItemBinding.root, goodItemBinding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: IndexHolder, position: Int) {
        holder.setData(list[position], this)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btnAddShoppingCart) {
            val item = v.tag as Item
            Thread(Runnable {

                //添加购物车
                ShoppingCartUtil.addShoppingCart(item)
                fragment.parentActivity.toast("添加购物车成功")
            }).start()
        } else {
            val position = recyclerView.getChildAdapterPosition(v)
            //查看商品详情
            val intent = Intent(fragment.parentActivity, ItemDetailActivity::class.java)
            intent.putExtra("uuid", list[position].uuid)
            fragment.startActivity(intent)
        }
    }

}