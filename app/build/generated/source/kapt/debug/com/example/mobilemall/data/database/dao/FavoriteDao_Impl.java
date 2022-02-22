package com.example.mobilemall.data.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.mobilemall.data.database.convert.ItemConvert;
import com.example.mobilemall.data.entity.Favorite;
import com.example.mobilemall.data.entity.Item;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FavoriteDao_Impl implements FavoriteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Favorite> __insertionAdapterOfFavorite;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public FavoriteDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFavorite = new EntityInsertionAdapter<Favorite>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `favorites` (`uid`,`item_id`,`item`,`time`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Favorite value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
        if (value.getItem_id() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItem_id());
        }
        final String _tmp;
        _tmp = ItemConvert.fromArrayList(value.getItem());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp);
        }
        stmt.bindLong(4, value.getTime());
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from favorites where uid=? and item_id=?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Favorite favorite) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFavorite.insert(favorite);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final String uid, final String item_id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    int _argIndex = 1;
    if (uid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uid);
    }
    _argIndex = 2;
    if (item_id == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, item_id);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  @Override
  public Favorite find(final String uid, final String item_id) {
    final String _sql = "select `favorites`.`uid` AS `uid`, `favorites`.`item_id` AS `item_id`, `favorites`.`item` AS `item`, `favorites`.`time` AS `time` from favorites  where uid=? and item_id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uid);
    }
    _argIndex = 2;
    if (item_id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, item_id);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfItem = CursorUtil.getColumnIndexOrThrow(_cursor, "item");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final Favorite _result;
      if(_cursor.moveToFirst()) {
        _result = new Favorite();
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        _result.setUid(_tmpUid);
        final String _tmpItem_id;
        _tmpItem_id = _cursor.getString(_cursorIndexOfItemId);
        _result.setItem_id(_tmpItem_id);
        final Item _tmpItem;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfItem);
        _tmpItem = ItemConvert.fromString(_tmp);
        _result.setItem(_tmpItem);
        final long _tmpTime;
        _tmpTime = _cursor.getLong(_cursorIndexOfTime);
        _result.setTime(_tmpTime);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
