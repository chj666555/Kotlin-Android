package com.example.mobilemall.data.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.mobilemall.data.database.convert.ItemConvert;
import com.example.mobilemall.data.entity.Item;
import com.example.mobilemall.data.entity.ShoppingCart;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ShoppingCartDao_Impl implements ShoppingCartDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ShoppingCart> __insertionAdapterOfShoppingCart;

  private final EntityDeletionOrUpdateAdapter<ShoppingCart> __updateAdapterOfShoppingCart;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  private final SharedSQLiteStatement __preparedStmtOfDelete_1;

  public ShoppingCartDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfShoppingCart = new EntityInsertionAdapter<ShoppingCart>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `shopping_carts` (`uid`,`item_uuid`,`item`,`quantity`,`add_datetime`,`selected`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ShoppingCart value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
        if (value.getItem_uuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItem_uuid());
        }
        final String _tmp;
        _tmp = ItemConvert.fromArrayList(value.getItem());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp);
        }
        stmt.bindLong(4, value.getQuantity());
        stmt.bindLong(5, value.getAdd_datetime());
        final int _tmp_1;
        _tmp_1 = value.getSelected() ? 1 : 0;
        stmt.bindLong(6, _tmp_1);
      }
    };
    this.__updateAdapterOfShoppingCart = new EntityDeletionOrUpdateAdapter<ShoppingCart>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `shopping_carts` SET `uid` = ?,`item_uuid` = ?,`item` = ?,`quantity` = ?,`add_datetime` = ?,`selected` = ? WHERE `uid` = ? AND `item_uuid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ShoppingCart value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
        if (value.getItem_uuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItem_uuid());
        }
        final String _tmp;
        _tmp = ItemConvert.fromArrayList(value.getItem());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp);
        }
        stmt.bindLong(4, value.getQuantity());
        stmt.bindLong(5, value.getAdd_datetime());
        final int _tmp_1;
        _tmp_1 = value.getSelected() ? 1 : 0;
        stmt.bindLong(6, _tmp_1);
        if (value.getUid() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUid());
        }
        if (value.getItem_uuid() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getItem_uuid());
        }
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from shopping_carts where uid=?";
        return _query;
      }
    };
    this.__preparedStmtOfDelete_1 = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from shopping_carts where uid=? and item_uuid=?";
        return _query;
      }
    };
  }

  @Override
  public void addShoppingCart(final ShoppingCart shoppingCart) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfShoppingCart.insert(shoppingCart);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ShoppingCart shoppingCart) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfShoppingCart.handle(shoppingCart);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final String uid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    int _argIndex = 1;
    if (uid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uid);
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
  public void delete(final String uid, final String item_uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete_1.acquire();
    int _argIndex = 1;
    if (uid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uid);
    }
    _argIndex = 2;
    if (item_uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, item_uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDelete_1.release(_stmt);
    }
  }

  @Override
  public List<ShoppingCart> getShoppingCarts(final String uid) {
    final String _sql = "select `shopping_carts`.`uid` AS `uid`, `shopping_carts`.`item_uuid` AS `item_uuid`, `shopping_carts`.`item` AS `item`, `shopping_carts`.`quantity` AS `quantity`, `shopping_carts`.`add_datetime` AS `add_datetime`, `shopping_carts`.`selected` AS `selected` from shopping_carts where uid=? order by add_datetime desc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfItemUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "item_uuid");
      final int _cursorIndexOfItem = CursorUtil.getColumnIndexOrThrow(_cursor, "item");
      final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
      final int _cursorIndexOfAddDatetime = CursorUtil.getColumnIndexOrThrow(_cursor, "add_datetime");
      final int _cursorIndexOfSelected = CursorUtil.getColumnIndexOrThrow(_cursor, "selected");
      final List<ShoppingCart> _result = new ArrayList<ShoppingCart>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ShoppingCart _item;
        _item = new ShoppingCart();
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        _item.setUid(_tmpUid);
        final String _tmpItem_uuid;
        _tmpItem_uuid = _cursor.getString(_cursorIndexOfItemUuid);
        _item.setItem_uuid(_tmpItem_uuid);
        final Item _tmpItem;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfItem);
        _tmpItem = ItemConvert.fromString(_tmp);
        _item.setItem(_tmpItem);
        final int _tmpQuantity;
        _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
        _item.setQuantity(_tmpQuantity);
        final long _tmpAdd_datetime;
        _tmpAdd_datetime = _cursor.getLong(_cursorIndexOfAddDatetime);
        _item.setAdd_datetime(_tmpAdd_datetime);
        final boolean _tmpSelected;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfSelected);
        _tmpSelected = _tmp_1 != 0;
        _item.setSelected(_tmpSelected);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public ShoppingCart findItem(final String uid, final String item_uuid) {
    final String _sql = "select `shopping_carts`.`uid` AS `uid`, `shopping_carts`.`item_uuid` AS `item_uuid`, `shopping_carts`.`item` AS `item`, `shopping_carts`.`quantity` AS `quantity`, `shopping_carts`.`add_datetime` AS `add_datetime`, `shopping_carts`.`selected` AS `selected` from shopping_carts where uid=? and item_uuid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uid);
    }
    _argIndex = 2;
    if (item_uuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, item_uuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfItemUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "item_uuid");
      final int _cursorIndexOfItem = CursorUtil.getColumnIndexOrThrow(_cursor, "item");
      final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
      final int _cursorIndexOfAddDatetime = CursorUtil.getColumnIndexOrThrow(_cursor, "add_datetime");
      final int _cursorIndexOfSelected = CursorUtil.getColumnIndexOrThrow(_cursor, "selected");
      final ShoppingCart _result;
      if(_cursor.moveToFirst()) {
        _result = new ShoppingCart();
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        _result.setUid(_tmpUid);
        final String _tmpItem_uuid;
        _tmpItem_uuid = _cursor.getString(_cursorIndexOfItemUuid);
        _result.setItem_uuid(_tmpItem_uuid);
        final Item _tmpItem;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfItem);
        _tmpItem = ItemConvert.fromString(_tmp);
        _result.setItem(_tmpItem);
        final int _tmpQuantity;
        _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
        _result.setQuantity(_tmpQuantity);
        final long _tmpAdd_datetime;
        _tmpAdd_datetime = _cursor.getLong(_cursorIndexOfAddDatetime);
        _result.setAdd_datetime(_tmpAdd_datetime);
        final boolean _tmpSelected;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfSelected);
        _tmpSelected = _tmp_1 != 0;
        _result.setSelected(_tmpSelected);
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
