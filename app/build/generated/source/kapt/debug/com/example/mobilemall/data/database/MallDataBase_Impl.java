package com.example.mobilemall.data.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.mobilemall.data.database.dao.AccountDao;
import com.example.mobilemall.data.database.dao.AccountDao_Impl;
import com.example.mobilemall.data.database.dao.CommentDao;
import com.example.mobilemall.data.database.dao.CommentDao_Impl;
import com.example.mobilemall.data.database.dao.FavoriteDao;
import com.example.mobilemall.data.database.dao.FavoriteDao_Impl;
import com.example.mobilemall.data.database.dao.ItemDao;
import com.example.mobilemall.data.database.dao.ItemDao_Impl;
import com.example.mobilemall.data.database.dao.ShoppingCartDao;
import com.example.mobilemall.data.database.dao.ShoppingCartDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MallDataBase_Impl extends MallDataBase {
  private volatile ItemDao _itemDao;

  private volatile AccountDao _accountDao;

  private volatile CommentDao _commentDao;

  private volatile ShoppingCartDao _shoppingCartDao;

  private volatile FavoriteDao _favoriteDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `items` (`uuid` TEXT NOT NULL, `title` TEXT NOT NULL, `content` TEXT NOT NULL, `price` REAL NOT NULL, `picture` TEXT NOT NULL, `add_datetime` INTEGER NOT NULL, PRIMARY KEY(`uuid`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `accounts` (`mobile` TEXT NOT NULL, `uid` TEXT NOT NULL, `password` TEXT NOT NULL, PRIMARY KEY(`mobile`, `uid`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `shopping_carts` (`uid` TEXT NOT NULL, `item_uuid` TEXT NOT NULL, `item` TEXT NOT NULL, `quantity` INTEGER NOT NULL, `add_datetime` INTEGER NOT NULL, `selected` INTEGER NOT NULL, PRIMARY KEY(`uid`, `item_uuid`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `favorites` (`uid` TEXT NOT NULL, `item_id` TEXT NOT NULL, `item` TEXT NOT NULL, `time` INTEGER NOT NULL, PRIMARY KEY(`uid`, `item_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `comments` (`uuid` TEXT NOT NULL, `uid` TEXT NOT NULL, `item_id` TEXT NOT NULL, `comment` TEXT NOT NULL, `publish_datetime` INTEGER NOT NULL, PRIMARY KEY(`uuid`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '66ab213c065e714e2fda1a321604d330')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `items`");
        _db.execSQL("DROP TABLE IF EXISTS `accounts`");
        _db.execSQL("DROP TABLE IF EXISTS `shopping_carts`");
        _db.execSQL("DROP TABLE IF EXISTS `favorites`");
        _db.execSQL("DROP TABLE IF EXISTS `comments`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsItems = new HashMap<String, TableInfo.Column>(6);
        _columnsItems.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItems.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItems.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItems.put("price", new TableInfo.Column("price", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItems.put("picture", new TableInfo.Column("picture", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItems.put("add_datetime", new TableInfo.Column("add_datetime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysItems = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesItems = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoItems = new TableInfo("items", _columnsItems, _foreignKeysItems, _indicesItems);
        final TableInfo _existingItems = TableInfo.read(_db, "items");
        if (! _infoItems.equals(_existingItems)) {
          return new RoomOpenHelper.ValidationResult(false, "items(com.example.mobilemall.data.entity.Item).\n"
                  + " Expected:\n" + _infoItems + "\n"
                  + " Found:\n" + _existingItems);
        }
        final HashMap<String, TableInfo.Column> _columnsAccounts = new HashMap<String, TableInfo.Column>(3);
        _columnsAccounts.put("mobile", new TableInfo.Column("mobile", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAccounts.put("uid", new TableInfo.Column("uid", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAccounts.put("password", new TableInfo.Column("password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAccounts = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAccounts = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAccounts = new TableInfo("accounts", _columnsAccounts, _foreignKeysAccounts, _indicesAccounts);
        final TableInfo _existingAccounts = TableInfo.read(_db, "accounts");
        if (! _infoAccounts.equals(_existingAccounts)) {
          return new RoomOpenHelper.ValidationResult(false, "accounts(com.example.mobilemall.data.entity.Account).\n"
                  + " Expected:\n" + _infoAccounts + "\n"
                  + " Found:\n" + _existingAccounts);
        }
        final HashMap<String, TableInfo.Column> _columnsShoppingCarts = new HashMap<String, TableInfo.Column>(6);
        _columnsShoppingCarts.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingCarts.put("item_uuid", new TableInfo.Column("item_uuid", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingCarts.put("item", new TableInfo.Column("item", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingCarts.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingCarts.put("add_datetime", new TableInfo.Column("add_datetime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingCarts.put("selected", new TableInfo.Column("selected", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysShoppingCarts = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesShoppingCarts = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoShoppingCarts = new TableInfo("shopping_carts", _columnsShoppingCarts, _foreignKeysShoppingCarts, _indicesShoppingCarts);
        final TableInfo _existingShoppingCarts = TableInfo.read(_db, "shopping_carts");
        if (! _infoShoppingCarts.equals(_existingShoppingCarts)) {
          return new RoomOpenHelper.ValidationResult(false, "shopping_carts(com.example.mobilemall.data.entity.ShoppingCart).\n"
                  + " Expected:\n" + _infoShoppingCarts + "\n"
                  + " Found:\n" + _existingShoppingCarts);
        }
        final HashMap<String, TableInfo.Column> _columnsFavorites = new HashMap<String, TableInfo.Column>(4);
        _columnsFavorites.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavorites.put("item_id", new TableInfo.Column("item_id", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavorites.put("item", new TableInfo.Column("item", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavorites.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFavorites = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFavorites = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFavorites = new TableInfo("favorites", _columnsFavorites, _foreignKeysFavorites, _indicesFavorites);
        final TableInfo _existingFavorites = TableInfo.read(_db, "favorites");
        if (! _infoFavorites.equals(_existingFavorites)) {
          return new RoomOpenHelper.ValidationResult(false, "favorites(com.example.mobilemall.data.entity.Favorite).\n"
                  + " Expected:\n" + _infoFavorites + "\n"
                  + " Found:\n" + _existingFavorites);
        }
        final HashMap<String, TableInfo.Column> _columnsComments = new HashMap<String, TableInfo.Column>(5);
        _columnsComments.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComments.put("uid", new TableInfo.Column("uid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComments.put("item_id", new TableInfo.Column("item_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComments.put("comment", new TableInfo.Column("comment", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComments.put("publish_datetime", new TableInfo.Column("publish_datetime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysComments = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesComments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoComments = new TableInfo("comments", _columnsComments, _foreignKeysComments, _indicesComments);
        final TableInfo _existingComments = TableInfo.read(_db, "comments");
        if (! _infoComments.equals(_existingComments)) {
          return new RoomOpenHelper.ValidationResult(false, "comments(com.example.mobilemall.data.entity.Comment).\n"
                  + " Expected:\n" + _infoComments + "\n"
                  + " Found:\n" + _existingComments);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "66ab213c065e714e2fda1a321604d330", "68b89c00d11b60cddf2d0972fb393569");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "items","accounts","shopping_carts","favorites","comments");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `items`");
      _db.execSQL("DELETE FROM `accounts`");
      _db.execSQL("DELETE FROM `shopping_carts`");
      _db.execSQL("DELETE FROM `favorites`");
      _db.execSQL("DELETE FROM `comments`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public ItemDao itemDao() {
    if (_itemDao != null) {
      return _itemDao;
    } else {
      synchronized(this) {
        if(_itemDao == null) {
          _itemDao = new ItemDao_Impl(this);
        }
        return _itemDao;
      }
    }
  }

  @Override
  public AccountDao accountDao() {
    if (_accountDao != null) {
      return _accountDao;
    } else {
      synchronized(this) {
        if(_accountDao == null) {
          _accountDao = new AccountDao_Impl(this);
        }
        return _accountDao;
      }
    }
  }

  @Override
  public CommentDao commentDao() {
    if (_commentDao != null) {
      return _commentDao;
    } else {
      synchronized(this) {
        if(_commentDao == null) {
          _commentDao = new CommentDao_Impl(this);
        }
        return _commentDao;
      }
    }
  }

  @Override
  public ShoppingCartDao shoppingCartDao() {
    if (_shoppingCartDao != null) {
      return _shoppingCartDao;
    } else {
      synchronized(this) {
        if(_shoppingCartDao == null) {
          _shoppingCartDao = new ShoppingCartDao_Impl(this);
        }
        return _shoppingCartDao;
      }
    }
  }

  @Override
  public FavoriteDao favoriteDao() {
    if (_favoriteDao != null) {
      return _favoriteDao;
    } else {
      synchronized(this) {
        if(_favoriteDao == null) {
          _favoriteDao = new FavoriteDao_Impl(this);
        }
        return _favoriteDao;
      }
    }
  }
}
