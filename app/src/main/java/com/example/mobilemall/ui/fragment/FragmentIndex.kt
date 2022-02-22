package com.example.mobilemall.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.example.mobilemall.R
import com.example.mobilemall.data.database.MallDataBase
import com.example.mobilemall.data.entity.Item
import com.example.mobilemall.databinding.FragmentIndexBinding
import com.example.mobilemall.ui.adapter.IndexAdapter
import com.stx.xhb.xbanner.XBanner
import java.util.*

/**
 * 首页
 */
class FragmentIndex : BaseFragment(), OnRefreshListener {
    private var fragmentIndexBinding: FragmentIndexBinding? = null
    private var itemList: List<Item> = ArrayList() //商品列表
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        fragmentIndexBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_index, container, false)
        return fragmentIndexBinding!!.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentIndexBinding!!.swipeRefreshLayout.setOnRefreshListener(this) //下拉刷新监听
        initBanner() //初始化banner
        fillItems()
    }

    //banner初始化
    private fun initBanner() {
        val banners: MutableList<Int?> = ArrayList()
        banners.add(R.drawable.banner_1)
        banners.add(R.drawable.banner_2)
        banners.add(R.drawable.banner_3)
        banners.add(R.drawable.banner_4)
        fragmentIndexBinding!!.banner.setData(banners, null)
        fragmentIndexBinding!!.banner.loadImage { banner: XBanner?, model: Any?, view: View?, position: Int -> (view as ImageView).setImageResource(banners[position]!!) }
    }

    /*
     * 商品列表
     * */
    private fun fillItems() {
        Thread(Runnable {
            itemList = MallDataBase.mallDataBase.itemDao().findAll() //所有商品
            Collections.shuffle(itemList) //乱序
            fragmentIndexBinding!!.recyclerView.post {
                try {
                    //实现瀑布流效果
                    val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                    fragmentIndexBinding!!.recyclerView.layoutManager = layoutManager //设置布局管理器
                    //设置适配器
                    fragmentIndexBinding!!.recyclerView.adapter = IndexAdapter(this@FragmentIndex, fragmentIndexBinding!!.recyclerView, itemList)
                    fragmentIndexBinding!!.swipeRefreshLayout.isRefreshing = false //取消下拉刷新状态
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }).start()
    }

    override fun onRefresh() {
        fragmentIndexBinding!!.swipeRefreshLayout.isRefreshing = true
        fillItems()
    }
}