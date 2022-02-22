package com.example.mobilemall.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobilemall.R
import com.example.mobilemall.data.database.MallDataBase
import com.example.mobilemall.data.entity.Item
import com.example.mobilemall.databinding.FragmentListBinding
import com.example.mobilemall.ui.adapter.ItemAdapter
import java.util.*
//商品列表页面
class FragmentList : BaseFragment() {
    private lateinit var fragmentListBinding: FragmentListBinding
    var keyWords //搜索关键词
            : String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadItems(null)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        fragmentListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        return fragmentListBinding.getRoot()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var items: List<Item> = ArrayList()

    //加载商品列表
    fun loadItems(keyWords: String?) {
        Thread(Runnable {
            val key: String?
            key = if (this.keyWords != null) {
                this.keyWords
            } else {
                keyWords
            }
            if (key == null) {
                //没有关键词，查询所有
                items = MallDataBase.mallDataBase.itemDao().findAll()
            } else {
                //依据关键词查询
                items = MallDataBase.mallDataBase.itemDao().findAll(key)
                this.keyWords = null
            }
            parentActivity.handler.post {
                try {
                    val layoutManager = LinearLayoutManager(activity)
                    fragmentListBinding!!.recyclerView.layoutManager = layoutManager
                    fragmentListBinding!!.recyclerView.adapter = ItemAdapter(this@FragmentList, fragmentListBinding!!.recyclerView, items)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }).start()
    }
}