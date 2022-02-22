package com.example.mobilemall.data.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.mobilemall.data.entity.Comment;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CommentDao_Impl implements CommentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Comment> __insertionAdapterOfComment;

  public CommentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfComment = new EntityInsertionAdapter<Comment>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `comments` (`uuid`,`uid`,`item_id`,`comment`,`publish_datetime`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Comment value) {
        if (value.getUuid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUuid());
        }
        if (value.getUid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUid());
        }
        if (value.getItem_id() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getItem_id());
        }
        if (value.getComment() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getComment());
        }
        stmt.bindLong(5, value.getPublish_datetime());
      }
    };
  }

  @Override
  public void insert(final Comment comment) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfComment.insert(comment);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Comment> getCommentByItemId(final String itemID) {
    final String _sql = "select `comments`.`uuid` AS `uuid`, `comments`.`uid` AS `uid`, `comments`.`item_id` AS `item_id`, `comments`.`comment` AS `comment`, `comments`.`publish_datetime` AS `publish_datetime` from comments where item_id=? order by publish_datetime desc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (itemID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, itemID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPublishDatetime = CursorUtil.getColumnIndexOrThrow(_cursor, "publish_datetime");
      final List<Comment> _result = new ArrayList<Comment>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Comment _item;
        _item = new Comment();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        _item.setUid(_tmpUid);
        final String _tmpItem_id;
        _tmpItem_id = _cursor.getString(_cursorIndexOfItemId);
        _item.setItem_id(_tmpItem_id);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        _item.setComment(_tmpComment);
        final long _tmpPublish_datetime;
        _tmpPublish_datetime = _cursor.getLong(_cursorIndexOfPublishDatetime);
        _item.setPublish_datetime(_tmpPublish_datetime);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
