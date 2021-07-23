package dev.fabula.android.wire.carrier.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import dev.fabula.android.wire.carrier.model.CarrierWire;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CarrierWireDao_Impl implements CarrierWireDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CarrierWire> __insertionAdapterOfCarrierWire;

  private final EntityInsertionAdapter<CarrierWire> __insertionAdapterOfCarrierWire_1;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFlagCreated;

  public CarrierWireDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCarrierWire = new EntityInsertionAdapter<CarrierWire>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `carrier_wire` (`uid`,`opora_uid`,`type_height_wire_uid`,`type_zigzag_wire_uid`,`flag_created`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CarrierWire value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
        if (value.getOpora_uid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getOpora_uid());
        }
        if (value.getType_height_wire_uid() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getType_height_wire_uid());
        }
        if (value.getType_zigzag_wire_uid() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getType_zigzag_wire_uid());
        }
        final Integer _tmp;
        _tmp = value.getFlag_created() == null ? null : (value.getFlag_created() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp);
        }
      }
    };
    this.__insertionAdapterOfCarrierWire_1 = new EntityInsertionAdapter<CarrierWire>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `carrier_wire` (`uid`,`opora_uid`,`type_height_wire_uid`,`type_zigzag_wire_uid`,`flag_created`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CarrierWire value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
        if (value.getOpora_uid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getOpora_uid());
        }
        if (value.getType_height_wire_uid() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getType_height_wire_uid());
        }
        if (value.getType_zigzag_wire_uid() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getType_zigzag_wire_uid());
        }
        final Integer _tmp;
        _tmp = value.getFlag_created() == null ? null : (value.getFlag_created() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp);
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM carrier_wire";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM carrier_wire WHERE uid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFlagCreated = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE carrier_wire SET flag_created = ? WHERE uid =?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final CarrierWire carrierWire) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCarrierWire.insert(carrierWire);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final CarrierWire carrierWire) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCarrierWire_1.insert(carrierWire);
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
  public void deleteById(final String uid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteById.acquire();
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
      __preparedStmtOfDeleteById.release(_stmt);
    }
  }

  @Override
  public void updateFlagCreated(final String uid, final boolean flag) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFlagCreated.acquire();
    int _argIndex = 1;
    final int _tmp;
    _tmp = flag ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
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
      __preparedStmtOfUpdateFlagCreated.release(_stmt);
    }
  }

  @Override
  public int getCountCarrierWireOfSupport(final String uidParent) {
    final String _sql = "SELECT count(uid) FROM carrier_wire WHERE opora_uid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uidParent == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uidParent);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int countIsNotSync(final boolean flag_created) {
    final String _sql = "SELECT count(uid) FROM carrier_wire WHERE flag_created=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp;
    _tmp = flag_created ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public CarrierWire getCarrierWireOfSupport(final String uidParent) {
    final String _sql = "SELECT * FROM carrier_wire WHERE opora_uid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uidParent == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uidParent);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfOporaUid = CursorUtil.getColumnIndexOrThrow(_cursor, "opora_uid");
      final int _cursorIndexOfTypeHeightWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_height_wire_uid");
      final int _cursorIndexOfTypeZigzagWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_zigzag_wire_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final CarrierWire _result;
      if(_cursor.moveToFirst()) {
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpOpora_uid;
        _tmpOpora_uid = _cursor.getString(_cursorIndexOfOporaUid);
        final String _tmpType_height_wire_uid;
        _tmpType_height_wire_uid = _cursor.getString(_cursorIndexOfTypeHeightWireUid);
        final String _tmpType_zigzag_wire_uid;
        _tmpType_zigzag_wire_uid = _cursor.getString(_cursorIndexOfTypeZigzagWireUid);
        final Boolean _tmpFlag_created;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagCreated)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagCreated);
        }
        _tmpFlag_created = _tmp == null ? null : _tmp != 0;
        _result = new CarrierWire(_tmpUid,_tmpOpora_uid,_tmpType_height_wire_uid,_tmpType_zigzag_wire_uid,_tmpFlag_created);
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
  public List<CarrierWire> getCarrierWireCreated(final boolean flag_created) {
    final String _sql = "SELECT * FROM carrier_wire WHERE flag_created=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp;
    _tmp = flag_created ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfOporaUid = CursorUtil.getColumnIndexOrThrow(_cursor, "opora_uid");
      final int _cursorIndexOfTypeHeightWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_height_wire_uid");
      final int _cursorIndexOfTypeZigzagWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_zigzag_wire_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final List<CarrierWire> _result = new ArrayList<CarrierWire>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CarrierWire _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpOpora_uid;
        _tmpOpora_uid = _cursor.getString(_cursorIndexOfOporaUid);
        final String _tmpType_height_wire_uid;
        _tmpType_height_wire_uid = _cursor.getString(_cursorIndexOfTypeHeightWireUid);
        final String _tmpType_zigzag_wire_uid;
        _tmpType_zigzag_wire_uid = _cursor.getString(_cursorIndexOfTypeZigzagWireUid);
        final Boolean _tmpFlag_created;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagCreated)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagCreated);
        }
        _tmpFlag_created = _tmp_1 == null ? null : _tmp_1 != 0;
        _item = new CarrierWire(_tmpUid,_tmpOpora_uid,_tmpType_height_wire_uid,_tmpType_zigzag_wire_uid,_tmpFlag_created);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
