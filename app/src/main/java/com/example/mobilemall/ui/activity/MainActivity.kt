package com.example.mobilemall.ui.activity

import android.annotation.SuppressLint
import android.app.Fragment
import android.app.FragmentManager
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.example.mobilemall.R
import com.example.mobilemall.databinding.ActivityMainBinding
import com.example.mobilemall.ui.fragment.FragmentIndex
import com.example.mobilemall.ui.fragment.FragmentList
import com.example.mobilemall.ui.fragment.FragmentShoppingCart

class
MainActivity : BaseActivity(), View.OnClickListener, Toolbar.OnMenuItemClickListener {
    private lateinit var activityMainBinding: ActivityMainBinding
    private  var currentIndex = 0 //当前页

    private lateinit var fragmentList //商品列表页
            : FragmentList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //fragment管理
        activityMainBinding.titlebar.setTitleTextColor(Color.WHITE)
        //设置标题文字
        activityMainBinding.titlebar.title = "推荐"
        //加载溢出菜单
        activityMainBinding.titlebar.inflateMenu(R.menu.menu_main)
        //设置溢出菜单事件
        activityMainBinding.titlebar.setOnMenuItemClickListener(this)
        //显示主页
        showIndex()
    }

    @SuppressLint("NonConstantResourceId")
    override fun onMenuItemClick(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_signout -> {

                //注销,清除保存的用户信息
                val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
                sharedPreferences.edit().putString("user_info", null).apply()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
            R.id.menu_exit -> {

                //关闭本程序
                finish()
            }
        }
        return false
    }

    /*
     * 根据关键词搜索商品
     * */
    private fun loadItemList(keyWords: String?) {
        if (currentIndex == 1) {
            //当前是商品列表页
            fragmentList!!.loadItems(keyWords)
        } else {
            //不是商品列表页，加载商品列表页后再搜索
            loadList(keyWords)
        }
    }

    /**
     * 显示首页
     */
    private fun showIndex() {
        currentIndex = 0
        showSearch()
        activityMainBinding!!.titlebar.title = "推荐商品"
        val recommendFragment = FragmentIndex()
        fragmentManager!!.beginTransaction().replace(R.id.fragment, recommendFragment).commit()
        activityMainBinding!!.rbIndex.isChecked = true
        activityMainBinding!!.rbList.isChecked = false
        activityMainBinding!!.rbShoppingCart.isChecked = false
    }

    /**
     * 显示商品列表页面
     */
    private fun loadList(keyWords: String?) {
        showSearch()
        currentIndex = 1
        activityMainBinding!!.titlebar.title = "商品列表"
        fragmentList = FragmentList()
        fragmentList!!.keyWords = keyWords
        switchFragment(fragmentList!!)
        activityMainBinding!!.rbIndex.isChecked = false
        activityMainBinding!!.rbList.isChecked = true
        activityMainBinding!!.rbShoppingCart.isChecked = false
    }

    /**
     * 显示购物车
     */
    private fun showCart() {
        activityMainBinding!!.searchParent.visibility = View.GONE
        currentIndex = 2
        activityMainBinding!!.titlebar.title = "购物车"
        switchFragment(FragmentShoppingCart())
        activityMainBinding!!.rbIndex.isChecked = false
        activityMainBinding!!.rbList.isChecked = false
        activityMainBinding!!.rbShoppingCart.isChecked = true
    }

    private fun switchFragment(fragment: Fragment) {
        fragmentManager!!.beginTransaction().replace(R.id.fragment, fragment).commit()
    }

    /*
     * 显示搜索栏
     * */
    private fun showSearch() {
        activityMainBinding!!.searchParent.visibility = View.VISIBLE
    }

    @SuppressLint("NonConstantResourceId")
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnSearchItems -> {

                //搜索按钮
                val keyWords = activityMainBinding!!.etText.text.toString()
                loadItemList(keyWords)
            }
            R.id.btnSearchReset -> {

                //取消搜索
                activityMainBinding!!.etText.setText("")
                if (currentIndex == 1) {
                    loadItemList(null)
                }
            }
            R.id.rbIndex -> {

                //首页
                showIndex()
            }
            R.id.rbList -> {

                //商品列表
                loadList(null)
            }
            R.id.rbShoppingCart -> {

                //购物车
                showCart()
            }
        }
    }
}