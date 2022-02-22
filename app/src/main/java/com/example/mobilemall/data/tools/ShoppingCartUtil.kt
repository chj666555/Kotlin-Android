package com.example.mobilemall.data.tools

import com.example.mobilemall.data.database.MallDataBase
import com.example.mobilemall.data.entity.Item
import com.example.mobilemall.data.entity.ShoppingCart
import com.example.mobilemall.util.Constant

object ShoppingCartUtil {
    /**
     * 添加购物车
     */
    fun addShoppingCart(item: Item) {
        var shoppingCart = MallDataBase.mallDataBase.shoppingCartDao().findItem(Constant.account!!.uid, item.uuid)
        if (shoppingCart == null) {
            //购物车中不存在此商品，增加记录
            shoppingCart = ShoppingCart()
            shoppingCart.quantity = 1
            shoppingCart.item = item
            shoppingCart.item_uuid = item.uuid
            shoppingCart.add_datetime = System.currentTimeMillis()
            shoppingCart.uid = Constant.account.uid
            MallDataBase.mallDataBase.shoppingCartDao().addShoppingCart(shoppingCart)
        } else {
            //购物车中存在此商品，修改数量
            if (shoppingCart.quantity == 50) {
                return
            }
            shoppingCart.quantity++
            MallDataBase.mallDataBase.shoppingCartDao().update(shoppingCart)
        }
    }

    /**
     * 更新商品在购物车中的数量
     */
    fun setShoppingCart(item: Item, count: Int) {
        if (count == 0) {
            //设置数量为0，从购物车移除商品
            MallDataBase.mallDataBase.shoppingCartDao().delete(Constant.account!!.uid, item.uuid)
            return
        }
        if (count < 50) {
            var shoppingCart = MallDataBase.mallDataBase.shoppingCartDao().findItem(Constant.account!!.uid, item.uuid)
            if (shoppingCart == null) {
                //此商品在购物车中的记录不存在
                shoppingCart = ShoppingCart()
                shoppingCart.quantity = count
                shoppingCart.item = item
                shoppingCart.item_uuid = item.uuid
                shoppingCart.add_datetime = System.currentTimeMillis()
                shoppingCart.uid = Constant.account!!.uid
                MallDataBase.mallDataBase.shoppingCartDao().addShoppingCart(shoppingCart)
            } else {
                //此商品已在购物车中已存在，只增加数量
                shoppingCart.quantity = count
                MallDataBase.mallDataBase.shoppingCartDao().update(shoppingCart)
            }
        }
    }
}