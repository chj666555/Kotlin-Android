package com.example.mobilemall.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobilemall.R
import com.example.mobilemall.data.database.MallDataBase
import com.example.mobilemall.data.entity.ShoppingCart
import com.example.mobilemall.databinding.FragmentCartBinding
import com.example.mobilemall.ui.adapter.ShoppingCartAdapter
import com.example.mobilemall.util.Constant
import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

/*
 * 购物车页
 * */
class FragmentShoppingCart : BaseFragment(), View.OnClickListener {
    private lateinit var fragmentCartBinding: FragmentCartBinding
    private var shoppingCarts: List<ShoppingCart> = ArrayList() //购物车列表
    private val decimalFormat = DecimalFormat("0.00") //保留小数点后两位
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        fragmentCartBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        return fragmentCartBinding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //全选按钮监听事件
        fragmentCartBinding.chkSelectAll.setOnClickListener { v: View? ->
            Thread(Runnable {
                for (shoppingCart in shoppingCarts) {
                    shoppingCart.selected = fragmentCartBinding.chkSelectAll.isChecked
                    MallDataBase.mallDataBase.shoppingCartDao().update(shoppingCart)
                }
                //重新加载购物车列表
                parentActivity.handler.post { loadShoppingCarts() }
            }).start()
        }
        fragmentCartBinding.btnDelete.setOnClickListener(this) //删除
        loadShoppingCarts()
    }

    /**
     * 加载购物车列表
     */
    fun loadShoppingCarts() {
        Thread(Runnable {
            shoppingCarts = MallDataBase.mallDataBase.shoppingCartDao().getShoppingCarts(Constant.account.uid)
            parentActivity.handler.post {
                try {
                    val layoutManager = LinearLayoutManager(activity)
                    fragmentCartBinding.recyclerView.layoutManager = layoutManager
                    fragmentCartBinding.recyclerView.adapter = ShoppingCartAdapter(this@FragmentShoppingCart, fragmentCartBinding.recyclerView, shoppingCarts)
                    setTotalFee()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }).start()
    }

    /**
     * 计算购物车选中商品总额
     */
    @SuppressLint("SetTextI18n")
    private fun setTotalFee() {
        var totalKind = 0 //总商品种类
        var total = 0 //总商品数量
        var sum = BigDecimal(0) //总和
        for (shoppingCart in shoppingCarts) {
            if (shoppingCart.selected) {
                sum = sum.add(BigDecimal(shoppingCart.quantity).multiply(BigDecimal(shoppingCart.item.price.toString())))
                totalKind++
                total += shoppingCart.quantity
            }
        }
        //选中商品总价
        fragmentCartBinding.txtFee.text = total.toString() + "件商品，共计" + decimalFormat.format(sum.toFloat()) + "元"
        //全选按钮选中状态
        fragmentCartBinding.chkSelectAll.isChecked = totalKind != 0 && totalKind == shoppingCarts.size
        //全选按钮选中可见状态
        fragmentCartBinding.chkSelectAll.visibility = if (shoppingCarts.size > 0) View.VISIBLE else View.GONE
        //删除按钮可见
        fragmentCartBinding.btnDelete.visibility = if (totalKind > 0) View.VISIBLE else View.GONE
        //结算按钮状态
        fragmentCartBinding.btnConfirm.isEnabled = totalKind > 0
    }

    override fun onClick(v: View) {
        //批量移除商品
        if (v.id == R.id.btnDelete) {
            Thread(Runnable {
                for (shoppingCart in shoppingCarts) {
                    if (shoppingCart.selected) {
                        MallDataBase.mallDataBase.shoppingCartDao().delete(Constant.account.uid, shoppingCart.item_uuid)
                    }
                }
                //重新加载购物车
                parentActivity.handler.post { loadShoppingCarts() }
            }).start()
        }
    }

    override fun onResume() {
        super.onResume()
        loadShoppingCarts()
    }
}