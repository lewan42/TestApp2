package dev.fabula.android.platform.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import dev.fabula.android.platform.model.Platform;
import java.lang.Boolean;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PlatformDao_Impl implements PlatformDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Platform> __insertionAdapterOfPlatform;

  private final EntityInsertionAdapter<Platform> __insertionAdapterOfPlatform_1;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFlagEdited;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfUpdate;

  public PlatformDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPlatform = new EntityInsertionAdapter<Platform>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `platform` (`uid`,`number`,`station_uid`,`owner`,`way_number`,`km_way`,`picket`,`type1`,`type2`,`comment`,`photo1`,`photo2`,`type_gabarits_uid`,`type_platform_uid`,`flag_edited`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Platform value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
        if (value.getNumber() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNumber());
        }
        if (value.getStation_uid() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStation_uid());
        }
        if (value.getOwner() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOwner());
        }
        if (value.getWay_number() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getWay_number());
        }
        if (value.getKm_way() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getKm_way());
        }
        if (value.getPicket() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPicket());
        }
        if (value.getType1() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getType1());
        }
        if (value.getType2() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getType2());
        }
        if (value.getComment() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getComment());
        }
        if (value.getPhoto1() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getPhoto1());
        }
        if (value.getPhoto2() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getPhoto2());
        }
        if (value.getType_gabarits_uid() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getType_gabarits_uid());
        }
        if (value.getType_platform_uid() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getType_platform_uid());
        }
        final Integer _tmp;
        _tmp = value.getFlag_edited() == null ? null : (value.getFlag_edited() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, _tmp);
        }
      }
    };
    this.__insertionAdapterOfPlatform_1 = new EntityInsertionAdapter<Platform>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `platform` (`uid`,`number`,`station_uid`,`owner`,`way_number`,`km_way`,`picket`,`type1`,`type2`,`comment`,`photo1`,`photo2`,`type_gabarits_uid`,`type_platform_uid`,`flag_edited`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Platform value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
        if (value.getNumber() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNumber());
        }
        if (value.getStation_uid() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStation_uid());
        }
        if (value.getOwner() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOwner());
        }
        if (value.getWay_number() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getWay_number());
        }
        if (value.getKm_way() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getKm_way());
        }
        if (value.getPicket() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPicket());
        }
        if (value.getType1() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getType1());
        }
        if (value.getType2() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getType2());
        }
        if (value.getComment() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getComment());
        }
        if (value.getPhoto1() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getPhoto1());
        }
        if (value.getPhoto2() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getPhoto2());
        }
        if (value.getType_gabarits_uid() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getType_gabarits_uid());
        }
        if (value.getType_platform_uid() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getType_platform_uid());
        }
        final Integer _tmp;
        _tmp = value.getFlag_edited() == null ? null : (value.getFlag_edited() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, _tmp);
        }
      }
    };
    this.__preparedStmtOfUpdateFlagEdited = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE platform SET flag_edited = ? WHERE uid =?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM platform WHERE uid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM platform";
        return _query;
      }
    };
    this.__preparedStmtOfUpdate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE platform SET way_number = ?, km_way = ?, picket = ?,type1=?, type2=?, photo1=?, photo2=?, comment=?,flag_edited=? WHERE uid =?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Platform platform) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPlatform.insert(platform);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final Platform platform) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPlatform_1.insert(platform);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateFlagEdited(final String uid, final boolean flag) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFlagEdited.acquire();
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
      __preparedStmtOfUpdateFlagEdited.release(_stmt);
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
  public void update(final String uidPlatform, final String numberWay, final String kmWay,
      final String picket, final String type1, final String type2, final String photo1,
      final String photo2, final String comment, final boolean flag_edited) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdate.acquire();
    int _argIndex = 1;
    if (numberWay == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, numberWay);
    }
    _argIndex = 2;
    if (kmWay == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, kmWay);
    }
    _argIndex = 3;
    if (picket == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, picket);
    }
    _argIndex = 4;
    if (type1 == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, type1);
    }
    _argIndex = 5;
    if (type2 == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, type2);
    }
    _argIndex = 6;
    if (photo1 == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, photo1);
    }
    _argIndex = 7;
    if (photo2 == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, photo2);
    }
    _argIndex = 8;
    if (comment == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, comment);
    }
    _argIndex = 9;
    final int _tmp;
    _tmp = flag_edited ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 10;
    if (uidPlatform == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uidPlatform);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdate.release(_stmt);
    }
  }

  @Override
  public Flow<List<Platform>> getAllPlatforms() {
    final String _sql = "SELECT * FROM platform";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"platform"}, new Callable<List<Platform>>() {
      @Override
      public List<Platform> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "number");
          final int _cursorIndexOfStationUid = CursorUtil.getColumnIndexOrThrow(_cursor, "station_uid");
          final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
          final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
          final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
          final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
          final int _cursorIndexOfType1 = CursorUtil.getColumnIndexOrThrow(_cursor, "type1");
          final int _cursorIndexOfType2 = CursorUtil.getColumnIndexOrThrow(_cursor, "type2");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
          final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
          final int _cursorIndexOfTypeGabaritsUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_gabarits_uid");
          final int _cursorIndexOfTypePlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_platform_uid");
          final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
          final List<Platform> _result = new ArrayList<Platform>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Platform _item;
            final String _tmpUid;
            _tmpUid = _cursor.getString(_cursorIndexOfUid);
            final String _tmpNumber;
            _tmpNumber = _cursor.getString(_cursorIndexOfNumber);
            final String _tmpStation_uid;
            _tmpStation_uid = _cursor.getString(_cursorIndexOfStationUid);
            final String _tmpOwner;
            _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
            final String _tmpWay_number;
            _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
            final String _tmpKm_way;
            _tmpKm_way = _cursor.getString(_cursorIndexOfKmWay);
            final String _tmpPicket;
            _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
            final String _tmpType1;
            _tmpType1 = _cursor.getString(_cursorIndexOfType1);
            final String _tmpType2;
            _tmpType2 = _cursor.getString(_cursorIndexOfType2);
            final String _tmpComment;
            _tmpComment = _cursor.getString(_cursorIndexOfComment);
            final String _tmpPhoto1;
            _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
            final String _tmpPhoto2;
            _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
            final String _tmpType_gabarits_uid;
            _tmpType_gabarits_uid = _cursor.getString(_cursorIndexOfTypeGabaritsUid);
            final String _tmpType_platform_uid;
            _tmpType_platform_uid = _cursor.getString(_cursorIndexOfTypePlatformUid);
            final Boolean _tmpFlag_edited;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfFlagEdited);
            }
            _tmpFlag_edited = _tmp == null ? null : _tmp != 0;
            _item = new Platform(_tmpUid,_tmpNumber,_tmpStation_uid,_tmpOwner,_tmpWay_number,_tmpKm_way,_tmpPicket,_tmpType1,_tmpType2,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpType_gabarits_uid,_tmpType_platform_uid,_tmpFlag_edited);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<Platform> getPlatformsOfStationOrPeregon(final String uidStationPeregon) {
    final String _sql = "SELECT * FROM platform WHERE station_uid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uidStationPeregon == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uidStationPeregon);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "number");
      final int _cursorIndexOfStationUid = CursorUtil.getColumnIndexOrThrow(_cursor, "station_uid");
      final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfType1 = CursorUtil.getColumnIndexOrThrow(_cursor, "type1");
      final int _cursorIndexOfType2 = CursorUtil.getColumnIndexOrThrow(_cursor, "type2");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfTypeGabaritsUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_gabarits_uid");
      final int _cursorIndexOfTypePlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_platform_uid");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final List<Platform> _result = new ArrayList<Platform>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Platform _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpNumber;
        _tmpNumber = _cursor.getString(_cursorIndexOfNumber);
        final String _tmpStation_uid;
        _tmpStation_uid = _cursor.getString(_cursorIndexOfStationUid);
        final String _tmpOwner;
        _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpKm_way;
        _tmpKm_way = _cursor.getString(_cursorIndexOfKmWay);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final String _tmpType1;
        _tmpType1 = _cursor.getString(_cursorIndexOfType1);
        final String _tmpType2;
        _tmpType2 = _cursor.getString(_cursorIndexOfType2);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final String _tmpType_gabarits_uid;
        _tmpType_gabarits_uid = _cursor.getString(_cursorIndexOfTypeGabaritsUid);
        final String _tmpType_platform_uid;
        _tmpType_platform_uid = _cursor.getString(_cursorIndexOfTypePlatformUid);
        final Boolean _tmpFlag_edited;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp == null ? null : _tmp != 0;
        _item = new Platform(_tmpUid,_tmpNumber,_tmpStation_uid,_tmpOwner,_tmpWay_number,_tmpKm_way,_tmpPicket,_tmpType1,_tmpType2,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpType_gabarits_uid,_tmpType_platform_uid,_tmpFlag_edited);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Platform> getEditedPlatforms(final boolean flag) {
    final String _sql = "SELECT * FROM platform WHERE flag_edited=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp;
    _tmp = flag ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "number");
      final int _cursorIndexOfStationUid = CursorUtil.getColumnIndexOrThrow(_cursor, "station_uid");
      final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfType1 = CursorUtil.getColumnIndexOrThrow(_cursor, "type1");
      final int _cursorIndexOfType2 = CursorUtil.getColumnIndexOrThrow(_cursor, "type2");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfTypeGabaritsUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_gabarits_uid");
      final int _cursorIndexOfTypePlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_platform_uid");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final List<Platform> _result = new ArrayList<Platform>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Platform _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpNumber;
        _tmpNumber = _cursor.getString(_cursorIndexOfNumber);
        final String _tmpStation_uid;
        _tmpStation_uid = _cursor.getString(_cursorIndexOfStationUid);
        final String _tmpOwner;
        _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpKm_way;
        _tmpKm_way = _cursor.getString(_cursorIndexOfKmWay);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final String _tmpType1;
        _tmpType1 = _cursor.getString(_cursorIndexOfType1);
        final String _tmpType2;
        _tmpType2 = _cursor.getString(_cursorIndexOfType2);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final String _tmpType_gabarits_uid;
        _tmpType_gabarits_uid = _cursor.getString(_cursorIndexOfTypeGabaritsUid);
        final String _tmpType_platform_uid;
        _tmpType_platform_uid = _cursor.getString(_cursorIndexOfTypePlatformUid);
        final Boolean _tmpFlag_edited;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp_1 == null ? null : _tmp_1 != 0;
        _item = new Platform(_tmpUid,_tmpNumber,_tmpStation_uid,_tmpOwner,_tmpWay_number,_tmpKm_way,_tmpPicket,_tmpType1,_tmpType2,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpType_gabarits_uid,_tmpType_platform_uid,_tmpFlag_edited);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Platform> getListMeasurementOfPlatform(final String uidStationPeregon) {
    final String _sql = "SELECT * FROM platform WHERE station_uid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uidStationPeregon == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uidStationPeregon);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "number");
      final int _cursorIndexOfStationUid = CursorUtil.getColumnIndexOrThrow(_cursor, "station_uid");
      final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfType1 = CursorUtil.getColumnIndexOrThrow(_cursor, "type1");
      final int _cursorIndexOfType2 = CursorUtil.getColumnIndexOrThrow(_cursor, "type2");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfTypeGabaritsUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_gabarits_uid");
      final int _cursorIndexOfTypePlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_platform_uid");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final List<Platform> _result = new ArrayList<Platform>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Platform _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpNumber;
        _tmpNumber = _cursor.getString(_cursorIndexOfNumber);
        final String _tmpStation_uid;
        _tmpStation_uid = _cursor.getString(_cursorIndexOfStationUid);
        final String _tmpOwner;
        _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpKm_way;
        _tmpKm_way = _cursor.getString(_cursorIndexOfKmWay);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final String _tmpType1;
        _tmpType1 = _cursor.getString(_cursorIndexOfType1);
        final String _tmpType2;
        _tmpType2 = _cursor.getString(_cursorIndexOfType2);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final String _tmpType_gabarits_uid;
        _tmpType_gabarits_uid = _cursor.getString(_cursorIndexOfTypeGabaritsUid);
        final String _tmpType_platform_uid;
        _tmpType_platform_uid = _cursor.getString(_cursorIndexOfTypePlatformUid);
        final Boolean _tmpFlag_edited;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp == null ? null : _tmp != 0;
        _item = new Platform(_tmpUid,_tmpNumber,_tmpStation_uid,_tmpOwner,_tmpWay_number,_tmpKm_way,_tmpPicket,_tmpType1,_tmpType2,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpType_gabarits_uid,_tmpType_platform_uid,_tmpFlag_edited);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Platform getPlatformById(final String uidPlatform) {
    final String _sql = "SELECT * FROM platform WHERE uid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uidPlatform == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uidPlatform);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "number");
      final int _cursorIndexOfStationUid = CursorUtil.getColumnIndexOrThrow(_cursor, "station_uid");
      final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfType1 = CursorUtil.getColumnIndexOrThrow(_cursor, "type1");
      final int _cursorIndexOfType2 = CursorUtil.getColumnIndexOrThrow(_cursor, "type2");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfTypeGabaritsUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_gabarits_uid");
      final int _cursorIndexOfTypePlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_platform_uid");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final Platform _result;
      if(_cursor.moveToFirst()) {
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpNumber;
        _tmpNumber = _cursor.getString(_cursorIndexOfNumber);
        final String _tmpStation_uid;
        _tmpStation_uid = _cursor.getString(_cursorIndexOfStationUid);
        final String _tmpOwner;
        _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpKm_way;
        _tmpKm_way = _cursor.getString(_cursorIndexOfKmWay);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final String _tmpType1;
        _tmpType1 = _cursor.getString(_cursorIndexOfType1);
        final String _tmpType2;
        _tmpType2 = _cursor.getString(_cursorIndexOfType2);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final String _tmpType_gabarits_uid;
        _tmpType_gabarits_uid = _cursor.getString(_cursorIndexOfTypeGabaritsUid);
        final String _tmpType_platform_uid;
        _tmpType_platform_uid = _cursor.getString(_cursorIndexOfTypePlatformUid);
        final Boolean _tmpFlag_edited;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp == null ? null : _tmp != 0;
        _result = new Platform(_tmpUid,_tmpNumber,_tmpStation_uid,_tmpOwner,_tmpWay_number,_tmpKm_way,_tmpPicket,_tmpType1,_tmpType2,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpType_gabarits_uid,_tmpType_platform_uid,_tmpFlag_edited);
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
  public int countIsNotSyncEdited(final boolean flag_edited) {
    final String _sql = "SELECT count(uid) FROM platform WHERE flag_edited=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp;
    _tmp = flag_edited ? 1 : 0;
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
  public String getPlatformName(final String uidPlatform) {
    final String _sql = "SELECT number FROM platform WHERE uid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uidPlatform == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uidPlatform);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getString(0);
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
