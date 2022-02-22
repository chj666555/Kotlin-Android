package com.example.mobilemall.ui.activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.example.mobilemall.R
import com.example.mobilemall.data.database.MallDataBase
import com.example.mobilemall.data.entity.Comment
import com.example.mobilemall.data.entity.Favorite
import com.example.mobilemall.data.entity.Item
import com.example.mobilemall.data.tools.ShoppingCartUtil
import com.example.mobilemall.databinding.ActivityItemDetailBinding
import com.example.mobilemall.ui.adapter.CommentAdapter
import com.example.mobilemall.ui.adapter.holder.BaseHolder
import com.example.mobilemall.util.Constant
import java.util.*

class ItemDetailActivity : BaseActivity(), Toolbar.OnMenuItemClickListener {
    private lateinit var activityItemDetailBinding: ActivityItemDetailBinding
    private lateinit var item //当前商品
            : Item
    private lateinit var toolbar //工具栏
            : Toolbar
    private var isFavorite = false //是否收藏状态
    private var comments: List<Comment> = ArrayList() //评价列表
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityItemDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_item_detail)
        toolbar = activityItemDetailBinding.titlebar
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.inflateMenu(R.menu.menu_item_detail) //溢出菜单
        toolbar.setOnMenuItemClickListener(this)
        val uuid = intent.getStringExtra("uuid")!!
        Thread(Runnable {
            //查询商品
            item = MallDataBase.mallDataBase.itemDao().find(uuid)
            val isFavorite = isFavorite(Constant.account.uid, item.uuid)
            //填充页面
            loadComments() //获取评价
            handler.post {
                initView()
                activityItemDetailBinding.chkFavorite.isChecked = isFavorite
            }

        }).start()
    }

    @SuppressLint("SetTextI18n")
    private fun initView() {
        toolbar.title = item.title
        activityItemDetailBinding.content.text = item.content
        activityItemDetailBinding.price.text = "￥ " + item.price
        activityItemDetailBinding.image.setImageResource(BaseHolder.getDrawableId(item.picture))
        activityItemDetailBinding.title.text = item.title
        initFavoriteState()
    }

    /**
     * 初始化收藏状态
     */
    private fun initFavoriteState() {
        toolbar.menu.getItem(1).title = if (isFavorite) "取消收藏" else "收藏"
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btnAddShoppingCart -> {
                Thread(Runnable {

                    //添加购物车
                    ShoppingCartUtil.addShoppingCart(item)
                    toast("添加购物车成功")
                }).start()
            }
            R.id.btnBack -> {

                //返回
                finish()
            }
            R.id.chkFavorite -> {

                //收藏/取消收藏
                Thread(Runnable {
                    try {
                        if (isFavorite) {
                            delete(Constant.account.uid, item.uuid)
                        } else {
                            //新增收藏
                            val favorite = Favorite()
                            favorite.item = item
                            favorite.time = System.currentTimeMillis()
                            favorite.item_id = item.uuid
                            favorite.uid = Constant.account.uid
                            add(favorite)
                        }
                        isFavorite = isFavorite(Constant.account.uid, item.uuid)
                        toast(if (isFavorite) "收藏成功" else "取消收藏成功")
                        handler.post { initFavoriteState() }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }).start()
            }
            R.id.btnPublish -> {

                //发布评价
                val content = activityItemDetailBinding.etComment.text.toString()
                if (content.length > 0) {
                    Thread(Runnable {
                        MallDataBase.mallDataBase.commentDao().insert(Comment(content, item))
                        handler.post { loadComments() }
                        toast("发布成功")
                    }).start()
                }
            }
        }
    }

    /*
     * 加载评论
     * */
    private fun loadComments() {
        Thread(Runnable {
            comments = MallDataBase.mallDataBase.commentDao().getCommentByItemId(item.uuid)
            handler.post { activityItemDetailBinding.listView.adapter = CommentAdapter(this, comments) }
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
            }
            handler.post {
                var totalHeight = 0
                for (i in comments.indices) {
                    val listItem = activityItemDetailBinding.listView.adapter.getView(i, null, activityItemDetailBinding.listView)
                    listItem.measure(0, 0)
                    totalHeight += listItem.measuredHeight
                }
                val layoutParams = activityItemDetailBinding.listView.layoutParams as LinearLayout.LayoutParams
                layoutParams.height = totalHeight + activityItemDetailBinding.listView.dividerHeight * (comments.size - 1)
                activityItemDetailBinding.listView.layoutParams = layoutParams
            }
        }).start()
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_add_shoppingcart -> {
                activityItemDetailBinding.btnAddShoppingCart.performClick()
            }
            R.id.menu_back -> {
                activityItemDetailBinding.btnBack.performClick()
            }
            R.id.menu_favorite -> {
                activityItemDetailBinding.chkFavorite.performClick()
            }
        }
        return false
    }

    /**
     * 查询商品收藏状态
     */
    private fun isFavorite(username: String, good_id: String): Boolean {
        return MallDataBase.mallDataBase.favoriteDao().find(username, good_id) != null
    }

    /**
     * 收藏
     */
    private fun add(favorite: Favorite) {
        MallDataBase.mallDataBase.favoriteDao().insert(favorite)
    }

    /**
     * 取消收藏
     */
    private fun delete(username: String, good_id: String) {
        MallDataBase.mallDataBase.favoriteDao().delete(username, good_id)
    }
}