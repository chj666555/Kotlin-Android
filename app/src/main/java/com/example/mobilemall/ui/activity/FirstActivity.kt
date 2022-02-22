package com.example.mobilemall.ui.activity

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.mobilemall.R
import com.example.mobilemall.data.database.MallDataBase
import com.example.mobilemall.data.entity.Item
import com.example.mobilemall.databinding.ActivityFirstBinding
import com.stx.xhb.xbanner.XBanner
import java.text.DecimalFormat
import java.util.*

/**
 * 引导页面
 */
class FirstActivity : BaseActivity(), View.OnClickListener {
    private var activityFirstBinding: ActivityFirstBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityFirstBinding = DataBindingUtil.setContentView(this, R.layout.activity_first)
        initRandomItems()
        if (isFirst) {
            //如果进过引导页了,下次就不展示了
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        } else {
            initBanner()
        }
    }

    /*
     * 按钮单击事件
     * */
    override fun onClick(v: View) {
        saveHistory()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private val isFirst: Boolean
        private get() = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("not_fist", false)

    /*
     * 引导页的轮播图片
     * */
    private fun initBanner() {
        val banners: MutableList<Int?> = ArrayList()
        banners.add(R.drawable.fist1)
        banners.add(R.drawable.first2)
        banners.add(R.drawable.first4)
        banners.add(R.drawable.first3)
        activityFirstBinding!!.banner.setData(banners, null)
        activityFirstBinding!!.banner.loadImage { banner: XBanner?, model: Any?, view: View, position: Int -> (view as ImageView).setImageResource(banners[position]!!) }
    }

    /*
     * 保存记录,下次启动不再显示引导页面
     * */
    private fun saveHistory() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = sharedPreferences.edit()
        editor.putBoolean("not_fist", true).apply()
    }

    /*
     * 初始化随机商品
     * */
    private fun initRandomItems() {
        Thread(Runnable {
            if (MallDataBase.mallDataBase.itemDao().findAll().isEmpty()) {
                val title = "测试商品，图片来自网络"
                val content = "这是商品的描述内容\n展示描述的内容\n品牌：测试\n型号：Test\n进本信息：测试商品\n保修：3年"
                var i = 0
                while (i < 35) {
                    val item = Item()
                    item.uuid = UUID.randomUUID().toString()
                    item.add_datetime = System.currentTimeMillis()
                    item.content = content
                    item.title = i.toString() + title
                    item.picture = "item_demo" + (i + 1)
                    //保留两位小数
                    item.price = DecimalFormat("0.00").format(Random(1000).nextFloat() * 1000).toFloat()
                    MallDataBase.mallDataBase.itemDao().addItem(item)
                    i++
                }
            }
        }).start()
    }
}