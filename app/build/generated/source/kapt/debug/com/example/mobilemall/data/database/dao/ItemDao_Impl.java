package com.example.mobilemall.data.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.mobilemall.data.entity.Item;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ItemDao_Impl implements ItemDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Item> __insertionAdapterOfItem;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ItemDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfItem = new EntityInsertionAdapter<Item>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `items` (`uuid`,`title`,`content`,`price`,`picture`,`add_datetime`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Item value) {
        if (value.getUuid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUuid());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getContent() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getContent());
        }
        stmt.bindDouble(4, value.getPrice());
        if (value.getPicture() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPicture());
        }
        stmt.bindLong(6, value.getAdd_datetime());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from items";
        return _query;
      }
    };
  }

  @Override
  public void addItem(final Item items) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfItem.insert(items);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<Item> findAll() {
    final String _sql = "select `items`.`uuid` AS `uuid`, `items`.`title` AS `title`, `items`.`content` AS `content`, `items`.`price` AS `price`, `items`.`picture` AS `picture`, `items`.`add_datetime` AS `add_datetime` from items order by add_datetime desc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfPicture = CursorUtil.getColumnIndexOrThrow(_cursor, "picture");
      final int _cursorIndexOfAddDatetime = CursorUtil.getColumnIndexOrThrow(_cursor, "add_datetime");
      final List<Item> _result = new ArrayList<Item>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Item _item;
        _item = new Item();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        _item.setTitle(_tmpTitle);
        final String _tmpContent;
        _tmpContent = _cursor.getString(_cursorIndexOfContent);
        _item.setContent(_tmpContent);
        final float _tmpPrice;
        _tmpPrice = _cursor.getFloat(_cursorIndexOfPrice);
        _item.setPrice(_tmpPrice);
        final String _tmpPicture;
        _tmpPicture = _cursor.getString(_cursorIndexOfPicture);
        _item.setPicture(_tmpPicture);
        final long _tmpAdd_datetime;
        _tmpAdd_datetime = _cursor.getLong(_cursorIndexOfAddDatetime);
        _item.setAdd_datetime(_tmpAdd_datetime);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Item find(final String uuid) {
    final String _sql = "select `items`.`uuid` AS `uuid`, `items`.`title` AS `title`, `items`.`content` AS `content`, `items`.`price` AS `price`, `items`.`picture` AS `picture`, `items`.`add_datetime` AS `add_datetime` from items where uuid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfPicture = CursorUtil.getColumnIndexOrThrow(_cursor, "picture");
      final int _cursorIndexOfAddDatetime = CursorUtil.getColumnIndexOrThrow(_cursor, "add_datetime");
      final Item _result;
      if(_cursor.moveToFirst()) {
        _result = new Item();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _result.setUuid(_tmpUuid);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        _result.setTitle(_tmpTitle);
        final String _tmpContent;
        _tmpContent = _cursor.getString(_cursorIndexOfContent);
        _result.setContent(_tmpContent);
        final float _tmpPrice;
        _tmpPrice = _cursor.getFloat(_cursorIndexOfPrice);
        _result.setPrice(_tmpPrice);
        final String _tmpPicture;
        _tmpPicture = _cursor.getString(_cursorIndexOfPicture);
        _result.setPicture(_tmpPicture);
        final long _tmpAdd_datetime;
        _tmpAdd_datetime = _cursor.getLong(_cursorIndexOfAddDatetime);
        _result.setAdd_datetime(_tmpAdd_datetime);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Item> findAll(final String keywords) {
    final String _sql = "select `items`.`uuid` AS `uuid`, `items`.`title` AS `title`, `items`.`content` AS `content`, `items`.`price` AS `price`, `items`.`picture` AS `picture`, `items`.`add_datetime` AS `add_datetime` from items where title like '%'|| ?|| '%' or content like '%'|| ?|| '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (keywords == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keywords);
    }
    _argIndex = 2;
    if (keywords == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keywords);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfPicture = CursorUtil.getColumnIndexOrThrow(_cursor, "picture");
      final int _cursorIndexOfAddDatetime = CursorUtil.getColumnIndexOrThrow(_cursor, "add_datetime");
      final List<Item> _result = new ArrayList<Item>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Item _item;
        _item = new Item();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        _item.setTitle(_tmpTitle);
        final String _tmpContent;
        _tmpContent = _cursor.getString(_cursorIndexOfContent);
        _item.setContent(_tmpContent);
        final float _tmpPrice;
        _tmpPrice = _cursor.getFloat(_cursorIndexOfPrice);
        _item.setPrice(_tmpPrice);
        final String _tmpPicture;
        _tmpPicture = _cursor.getString(_cursorIndexOfPicture);
        _item.setPicture(_tmpPicture);
        final long _tmpAdd_datetime;
        _tmpAdd_datetime = _cursor.getLong(_cursorIndexOfAddDatetime);
        _item.setAdd_datetime(_tmpAdd_datetime);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
