package com.example.mobilemall.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mobilemall.util.Constant
import java.util.*

/**
 * 评论
 */
@Entity(tableName = "comments")
class Comment {
    @PrimaryKey
    var uuid //主键
            : String = ""
    var uid //用户唯一标识
            : String= ""
    var item_id //商品id
            : String= ""
    var comment //内容
            : String= ""
    var publish_datetime //发表时间
            : Long = 0

    constructor() {}
    constructor(comment: String, item: Item) {
        uuid = UUID.randomUUID().toString()
        uid = Constant.account!!.uid
        item_id = item.uuid
        this.comment = comment
        publish_datetime = System.currentTimeMillis()
    }
}