package com.example.mobilemall.ui.adapter

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilemall.R
import com.example.mobilemall.data.database.MallDataBase
import com.example.mobilemall.data.entity.ShoppingCart
import com.example.mobilemall.data.tools.ShoppingCartUtil
import com.example.mobilemall.databinding.ShoppingcartItemBinding
import com.example.mobilemall.ui.activity.ItemDetailActivity
import com.example.mobilemall.ui.adapter.holder.ShoppingCartItemHolder
import com.example.mobilemall.ui.fragment.FragmentShoppingCart
import com.example.mobilemall.util.Constant

/**
 * 购物车列表适配器
 */
class ShoppingCartAdapter(private val fragment: FragmentShoppingCart, private val recyclerView: RecyclerView, private val shoppingCarts: List<ShoppingCart>) : RecyclerView.Adapter<ShoppingCartItemHolder>(), View.OnClickListener {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCartItemHolder {
        val shoppingcartItemBinding: ShoppingcartItemBinding = DataBindingUtil.inflate(LayoutInflater.from(fragment.parentActivity), R.layout.shoppingcart_item, parent, false)
        return ShoppingCartItemHolder(shoppingcartItemBinding.root, shoppingcartItemBinding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ShoppingCartItemHolder, position: Int) {
        //设置监听事件
        holder.setData(shoppingCarts[position], this)
    }

    override fun getItemCount(): Int {
        return shoppingCarts.size
    }

    @SuppressLint("NonConstantResourceId")
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnAdd -> {

                //添加
                val shoppingcartItemBinding = v.tag as ShoppingcartItemBinding
                val shoppingCart = shoppingcartItemBinding.txtQuantity.tag as ShoppingCart
                if (shoppingCart.quantity < 50) {
                    Thread(Runnable {

                        //添加购物车
                        ShoppingCartUtil.addShoppingCart(shoppingCart.item)
                        //刷新购物车
                        fragment.parentActivity.handler.post { fragment.loadShoppingCarts() }
                    }).start()
                }
            }
            R.id.btnRemove -> {

                //减少
                val shoppingcartItemBinding = v.tag as ShoppingcartItemBinding
                val shoppingCart = shoppingcartItemBinding.txtQuantity.tag as ShoppingCart
                if (shoppingCart.quantity != 1) {
                    Thread(Runnable {

                        //添加购物车
                        ShoppingCartUtil.setShoppingCart(shoppingCart.item, shoppingCart.quantity - 1)
                        //刷新购物车
                        fragment.parentActivity.handler.post { fragment.loadShoppingCarts() }
                    }).start()
                }
            }
            R.id.chkSelect -> {

                //选择
                val shoppingcartItemBinding = v.tag as ShoppingcartItemBinding
                val shoppingCart = shoppingcartItemBinding.txtQuantity.tag as ShoppingCart
                shoppingCart.selected = (v as CheckBox).isChecked
                Thread(Runnable {
                    MallDataBase.mallDataBase.shoppingCartDao().update(shoppingCart)
                    fragment.parentActivity.handler.post { fragment.loadShoppingCarts() } //重新加载购物车
                }).start()
            }
            else -> {

                //行点击事件
                val position = recyclerView.getChildAdapterPosition(v)
                //上下文菜单
                val item = shoppingCarts[position].item
                val items = arrayOf("查看详情", "移除")
                AlertDialog.Builder(fragment.parentActivity).setTitle("操作").setItems(items) { dialog: DialogInterface?, which: Int ->
                    if (which == 0) {
                        //查看
                        val intent = Intent(fragment.parentActivity, ItemDetailActivity::class.java)
                        intent.putExtra("uuid", item.uuid)
                        fragment.startActivity(intent)
                    } else {
                        Thread(Runnable {

                            //移除商品
                            MallDataBase.mallDataBase.shoppingCartDao().delete(Constant.account.uid, item.uuid)
                            fragment.parentActivity.toast("移除成功")
                            fragment.parentActivity.handler.post { fragment.loadShoppingCarts() }
                        }).start()
                    }
                }.show()
            }
        }
    }

}