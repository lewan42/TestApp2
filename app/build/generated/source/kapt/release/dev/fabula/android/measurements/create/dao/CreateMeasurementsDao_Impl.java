package dev.fabula.android.measurements.create.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import dev.fabula.android.measurements.model.Measurement;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CreateMeasurementsDao_Impl implements CreateMeasurementsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Measurement> __insertionAdapterOfMeasurement;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFlagCreated;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePhotoZamer;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFlagEdited;

  private final SharedSQLiteStatement __preparedStmtOfUpdateMeasurementOfCanopy;

  private final SharedSQLiteStatement __preparedStmtOfUpdateMeasurementOfDimension;

  public CreateMeasurementsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMeasurement = new EntityInsertionAdapter<Measurement>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `measurement` (`uid`,`gipotinuza`,`ugol_naklona`,`vertical_gabarit`,`horizontal_gabarit`,`lat`,`lng`,`km_way`,`way_number`,`picket`,`radius`,`vozvishenie`,`comment`,`photo1`,`photo2`,`parent_platform_uid`,`parent_gabarit_naves_uid`,`parent_gabarit_tor_uid`,`parent_main_wire_uid`,`parent_contact_wire_uid`,`parent_most_perehod_uid`,`type_measurement_uid`,`flag_created`,`flag_edited`,`created_at`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Measurement value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
        if (value.getGipotinuza() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGipotinuza());
        }
        if (value.getUgol_naklona() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUgol_naklona());
        }
        if (value.getVertical_gabarit() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getVertical_gabarit());
        }
        if (value.getHorizontal_gabarit() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getHorizontal_gabarit());
        }
        if (value.getLat() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLat());
        }
        if (value.getLng() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLng());
        }
        if (value.getKm_way() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getKm_way());
        }
        if (value.getWay_number() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getWay_number());
        }
        if (value.getPicket() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getPicket());
        }
        stmt.bindLong(11, value.getRadius());
        stmt.bindLong(12, value.getVozvishenie());
        if (value.getComment() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getComment());
        }
        if (value.getPhoto1() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getPhoto1());
        }
        if (value.getPhoto2() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getPhoto2());
        }
        if (value.getParent_platform_uid() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getParent_platform_uid());
        }
        if (value.getParent_gabarit_naves_uid() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getParent_gabarit_naves_uid());
        }
        if (value.getParent_gabarit_tor_uid() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getParent_gabarit_tor_uid());
        }
        if (value.getParent_main_wire_uid() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getParent_main_wire_uid());
        }
        if (value.getParent_contact_wire_uid() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getParent_contact_wire_uid());
        }
        if (value.getParent_most_perehod_uid() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getParent_most_perehod_uid());
        }
        if (value.getType_measurement_uid() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getType_measurement_uid());
        }
        final Integer _tmp;
        _tmp = value.getFlag_created() == null ? null : (value.getFlag_created() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindLong(23, _tmp);
        }
        final Integer _tmp_1;
        _tmp_1 = value.getFlag_edited() == null ? null : (value.getFlag_edited() ? 1 : 0);
        if (_tmp_1 == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindLong(24, _tmp_1);
        }
        stmt.bindLong(25, value.getCreated_at());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM measurement";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM measurement WHERE uid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFlagCreated = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE measurement SET flag_created = ? WHERE uid =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdatePhotoZamer = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE measurement SET photo1 = ? WHERE uid =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFlagEdited = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE measurement SET flag_edited = ? WHERE uid =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateMeasurementOfCanopy = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE measurement SET vertical_gabarit = ?,horizontal_gabarit = ? ,flag_edited = ?  WHERE uid =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateMeasurementOfDimension = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE measurement SET vertical_gabarit = ?,horizontal_gabarit = ?,flag_edited = ?  WHERE parent_gabarit_tor_uid =?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Measurement measurement) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMeasurement.insert(measurement);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final List<Measurement> measurements) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMeasurement.insert(measurements);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateMeasurementOfCanopy(final String uid1, final String v1, final String h1,
      final String uid2, final String v2, final String h2, final String uid3, final String v3,
      final String h3) {
    __db.beginTransaction();
    try {
      CreateMeasurementsDao.DefaultImpls.updateMeasurementOfCanopy(CreateMeasurementsDao_Impl.this, uid1, v1, h1, uid2, v2, h2, uid3, v3, h3);
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
  public void updatePhotoZamer(final String uid, final String photo1) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePhotoZamer.acquire();
    int _argIndex = 1;
    if (photo1 == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, photo1);
    }
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
      __preparedStmtOfUpdatePhotoZamer.release(_stmt);
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
  public void updateMeasurementOfCanopy(final String uid, final String v, final String h,
      final boolean flag_edited) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateMeasurementOfCanopy.acquire();
    int _argIndex = 1;
    if (v == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, v);
    }
    _argIndex = 2;
    if (h == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, h);
    }
    _argIndex = 3;
    final int _tmp;
    _tmp = flag_edited ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 4;
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
      __preparedStmtOfUpdateMeasurementOfCanopy.release(_stmt);
    }
  }

  @Override
  public void updateMeasurementOfDimension(final String uid, final String v, final String h,
      final boolean flag_edited) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateMeasurementOfDimension.acquire();
    int _argIndex = 1;
    if (v == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, v);
    }
    _argIndex = 2;
    if (h == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, h);
    }
    _argIndex = 3;
    final int _tmp;
    _tmp = flag_edited ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 4;
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
      __preparedStmtOfUpdateMeasurementOfDimension.release(_stmt);
    }
  }

  @Override
  public int countIsNotSyncCreated(final boolean flag_created) {
    final String _sql = "SELECT count(uid) FROM measurement WHERE flag_created=?";
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
  public int countIsNotSyncEdited(final boolean flag_edited) {
    final String _sql = "SELECT count(uid) FROM measurement WHERE flag_edited=?";
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
  public List<Measurement> getMeasurements() {
    final String _sql = "SELECT * FROM measurement";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfGipotinuza = CursorUtil.getColumnIndexOrThrow(_cursor, "gipotinuza");
      final int _cursorIndexOfUgolNaklona = CursorUtil.getColumnIndexOrThrow(_cursor, "ugol_naklona");
      final int _cursorIndexOfVerticalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "vertical_gabarit");
      final int _cursorIndexOfHorizontalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "horizontal_gabarit");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "lng");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfRadius = CursorUtil.getColumnIndexOrThrow(_cursor, "radius");
      final int _cursorIndexOfVozvishenie = CursorUtil.getColumnIndexOrThrow(_cursor, "vozvishenie");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfParentPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_platform_uid");
      final int _cursorIndexOfParentGabaritNavesUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_naves_uid");
      final int _cursorIndexOfParentGabaritTorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_tor_uid");
      final int _cursorIndexOfParentMainWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_main_wire_uid");
      final int _cursorIndexOfParentContactWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_contact_wire_uid");
      final int _cursorIndexOfParentMostPerehodUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_most_perehod_uid");
      final int _cursorIndexOfTypeMeasurementUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_measurement_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final List<Measurement> _result = new ArrayList<Measurement>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Measurement _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpGipotinuza;
        _tmpGipotinuza = _cursor.getString(_cursorIndexOfGipotinuza);
        final String _tmpUgol_naklona;
        _tmpUgol_naklona = _cursor.getString(_cursorIndexOfUgolNaklona);
        final String _tmpVertical_gabarit;
        _tmpVertical_gabarit = _cursor.getString(_cursorIndexOfVerticalGabarit);
        final String _tmpHorizontal_gabarit;
        _tmpHorizontal_gabarit = _cursor.getString(_cursorIndexOfHorizontalGabarit);
        final String _tmpLat;
        _tmpLat = _cursor.getString(_cursorIndexOfLat);
        final String _tmpLng;
        _tmpLng = _cursor.getString(_cursorIndexOfLng);
        final Double _tmpKm_way;
        if (_cursor.isNull(_cursorIndexOfKmWay)) {
          _tmpKm_way = null;
        } else {
          _tmpKm_way = _cursor.getDouble(_cursorIndexOfKmWay);
        }
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final int _tmpRadius;
        _tmpRadius = _cursor.getInt(_cursorIndexOfRadius);
        final int _tmpVozvishenie;
        _tmpVozvishenie = _cursor.getInt(_cursorIndexOfVozvishenie);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final String _tmpParent_platform_uid;
        _tmpParent_platform_uid = _cursor.getString(_cursorIndexOfParentPlatformUid);
        final String _tmpParent_gabarit_naves_uid;
        _tmpParent_gabarit_naves_uid = _cursor.getString(_cursorIndexOfParentGabaritNavesUid);
        final String _tmpParent_gabarit_tor_uid;
        _tmpParent_gabarit_tor_uid = _cursor.getString(_cursorIndexOfParentGabaritTorUid);
        final String _tmpParent_main_wire_uid;
        _tmpParent_main_wire_uid = _cursor.getString(_cursorIndexOfParentMainWireUid);
        final String _tmpParent_contact_wire_uid;
        _tmpParent_contact_wire_uid = _cursor.getString(_cursorIndexOfParentContactWireUid);
        final String _tmpParent_most_perehod_uid;
        _tmpParent_most_perehod_uid = _cursor.getString(_cursorIndexOfParentMostPerehodUid);
        final String _tmpType_measurement_uid;
        _tmpType_measurement_uid = _cursor.getString(_cursorIndexOfTypeMeasurementUid);
        final Boolean _tmpFlag_created;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagCreated)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagCreated);
        }
        _tmpFlag_created = _tmp == null ? null : _tmp != 0;
        final Boolean _tmpFlag_edited;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp_1 == null ? null : _tmp_1 != 0;
        final long _tmpCreated_at;
        _tmpCreated_at = _cursor.getLong(_cursorIndexOfCreatedAt);
        _item = new Measurement(_tmpUid,_tmpGipotinuza,_tmpUgol_naklona,_tmpVertical_gabarit,_tmpHorizontal_gabarit,_tmpLat,_tmpLng,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpRadius,_tmpVozvishenie,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpParent_platform_uid,_tmpParent_gabarit_naves_uid,_tmpParent_gabarit_tor_uid,_tmpParent_main_wire_uid,_tmpParent_contact_wire_uid,_tmpParent_most_perehod_uid,_tmpType_measurement_uid,_tmpFlag_created,_tmpFlag_edited,_tmpCreated_at);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Measurement> getMeasurementsOfPlatform(final String uidPlatform) {
    final String _sql = "SELECT * FROM measurement WHERE parent_platform_uid=?";
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
      final int _cursorIndexOfGipotinuza = CursorUtil.getColumnIndexOrThrow(_cursor, "gipotinuza");
      final int _cursorIndexOfUgolNaklona = CursorUtil.getColumnIndexOrThrow(_cursor, "ugol_naklona");
      final int _cursorIndexOfVerticalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "vertical_gabarit");
      final int _cursorIndexOfHorizontalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "horizontal_gabarit");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "lng");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfRadius = CursorUtil.getColumnIndexOrThrow(_cursor, "radius");
      final int _cursorIndexOfVozvishenie = CursorUtil.getColumnIndexOrThrow(_cursor, "vozvishenie");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfParentPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_platform_uid");
      final int _cursorIndexOfParentGabaritNavesUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_naves_uid");
      final int _cursorIndexOfParentGabaritTorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_tor_uid");
      final int _cursorIndexOfParentMainWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_main_wire_uid");
      final int _cursorIndexOfParentContactWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_contact_wire_uid");
      final int _cursorIndexOfParentMostPerehodUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_most_perehod_uid");
      final int _cursorIndexOfTypeMeasurementUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_measurement_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final List<Measurement> _result = new ArrayList<Measurement>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Measurement _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpGipotinuza;
        _tmpGipotinuza = _cursor.getString(_cursorIndexOfGipotinuza);
        final String _tmpUgol_naklona;
        _tmpUgol_naklona = _cursor.getString(_cursorIndexOfUgolNaklona);
        final String _tmpVertical_gabarit;
        _tmpVertical_gabarit = _cursor.getString(_cursorIndexOfVerticalGabarit);
        final String _tmpHorizontal_gabarit;
        _tmpHorizontal_gabarit = _cursor.getString(_cursorIndexOfHorizontalGabarit);
        final String _tmpLat;
        _tmpLat = _cursor.getString(_cursorIndexOfLat);
        final String _tmpLng;
        _tmpLng = _cursor.getString(_cursorIndexOfLng);
        final Double _tmpKm_way;
        if (_cursor.isNull(_cursorIndexOfKmWay)) {
          _tmpKm_way = null;
        } else {
          _tmpKm_way = _cursor.getDouble(_cursorIndexOfKmWay);
        }
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final int _tmpRadius;
        _tmpRadius = _cursor.getInt(_cursorIndexOfRadius);
        final int _tmpVozvishenie;
        _tmpVozvishenie = _cursor.getInt(_cursorIndexOfVozvishenie);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final String _tmpParent_platform_uid;
        _tmpParent_platform_uid = _cursor.getString(_cursorIndexOfParentPlatformUid);
        final String _tmpParent_gabarit_naves_uid;
        _tmpParent_gabarit_naves_uid = _cursor.getString(_cursorIndexOfParentGabaritNavesUid);
        final String _tmpParent_gabarit_tor_uid;
        _tmpParent_gabarit_tor_uid = _cursor.getString(_cursorIndexOfParentGabaritTorUid);
        final String _tmpParent_main_wire_uid;
        _tmpParent_main_wire_uid = _cursor.getString(_cursorIndexOfParentMainWireUid);
        final String _tmpParent_contact_wire_uid;
        _tmpParent_contact_wire_uid = _cursor.getString(_cursorIndexOfParentContactWireUid);
        final String _tmpParent_most_perehod_uid;
        _tmpParent_most_perehod_uid = _cursor.getString(_cursorIndexOfParentMostPerehodUid);
        final String _tmpType_measurement_uid;
        _tmpType_measurement_uid = _cursor.getString(_cursorIndexOfTypeMeasurementUid);
        final Boolean _tmpFlag_created;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagCreated)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagCreated);
        }
        _tmpFlag_created = _tmp == null ? null : _tmp != 0;
        final Boolean _tmpFlag_edited;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp_1 == null ? null : _tmp_1 != 0;
        final long _tmpCreated_at;
        _tmpCreated_at = _cursor.getLong(_cursorIndexOfCreatedAt);
        _item = new Measurement(_tmpUid,_tmpGipotinuza,_tmpUgol_naklona,_tmpVertical_gabarit,_tmpHorizontal_gabarit,_tmpLat,_tmpLng,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpRadius,_tmpVozvishenie,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpParent_platform_uid,_tmpParent_gabarit_naves_uid,_tmpParent_gabarit_tor_uid,_tmpParent_main_wire_uid,_tmpParent_contact_wire_uid,_tmpParent_most_perehod_uid,_tmpType_measurement_uid,_tmpFlag_created,_tmpFlag_edited,_tmpCreated_at);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Measurement> getCountLastMeasurementsOfPlatform(final String uidPlatform,
      final int count) {
    final String _sql = "select * from (select distinct DATE(created_at, 'unixepoch') as date from measurement WHERE parent_platform_uid=? order by date desc limit ?) sub join measurement m on sub.date = DATE(m.created_at, 'unixepoch')";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uidPlatform == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uidPlatform);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, count);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfGipotinuza = CursorUtil.getColumnIndexOrThrow(_cursor, "gipotinuza");
      final int _cursorIndexOfUgolNaklona = CursorUtil.getColumnIndexOrThrow(_cursor, "ugol_naklona");
      final int _cursorIndexOfVerticalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "vertical_gabarit");
      final int _cursorIndexOfHorizontalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "horizontal_gabarit");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "lng");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfRadius = CursorUtil.getColumnIndexOrThrow(_cursor, "radius");
      final int _cursorIndexOfVozvishenie = CursorUtil.getColumnIndexOrThrow(_cursor, "vozvishenie");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfParentPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_platform_uid");
      final int _cursorIndexOfParentGabaritNavesUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_naves_uid");
      final int _cursorIndexOfParentGabaritTorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_tor_uid");
      final int _cursorIndexOfParentMainWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_main_wire_uid");
      final int _cursorIndexOfParentContactWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_contact_wire_uid");
      final int _cursorIndexOfParentMostPerehodUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_most_perehod_uid");
      final int _cursorIndexOfTypeMeasurementUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_measurement_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final List<Measurement> _result = new ArrayList<Measurement>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Measurement _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpGipotinuza;
        _tmpGipotinuza = _cursor.getString(_cursorIndexOfGipotinuza);
        final String _tmpUgol_naklona;
        _tmpUgol_naklona = _cursor.getString(_cursorIndexOfUgolNaklona);
        final String _tmpVertical_gabarit;
        _tmpVertical_gabarit = _cursor.getString(_cursorIndexOfVerticalGabarit);
        final String _tmpHorizontal_gabarit;
        _tmpHorizontal_gabarit = _cursor.getString(_cursorIndexOfHorizontalGabarit);
        final String _tmpLat;
        _tmpLat = _cursor.getString(_cursorIndexOfLat);
        final String _tmpLng;
        _tmpLng = _cursor.getString(_cursorIndexOfLng);
        final Double _tmpKm_way;
        if (_cursor.isNull(_cursorIndexOfKmWay)) {
          _tmpKm_way = null;
        } else {
          _tmpKm_way = _cursor.getDouble(_cursorIndexOfKmWay);
        }
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final int _tmpRadius;
        _tmpRadius = _cursor.getInt(_cursorIndexOfRadius);
        final int _tmpVozvishenie;
        _tmpVozvishenie = _cursor.getInt(_cursorIndexOfVozvishenie);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final String _tmpParent_platform_uid;
        _tmpParent_platform_uid = _cursor.getString(_cursorIndexOfParentPlatformUid);
        final String _tmpParent_gabarit_naves_uid;
        _tmpParent_gabarit_naves_uid = _cursor.getString(_cursorIndexOfParentGabaritNavesUid);
        final String _tmpParent_gabarit_tor_uid;
        _tmpParent_gabarit_tor_uid = _cursor.getString(_cursorIndexOfParentGabaritTorUid);
        final String _tmpParent_main_wire_uid;
        _tmpParent_main_wire_uid = _cursor.getString(_cursorIndexOfParentMainWireUid);
        final String _tmpParent_contact_wire_uid;
        _tmpParent_contact_wire_uid = _cursor.getString(_cursorIndexOfParentContactWireUid);
        final String _tmpParent_most_perehod_uid;
        _tmpParent_most_perehod_uid = _cursor.getString(_cursorIndexOfParentMostPerehodUid);
        final String _tmpType_measurement_uid;
        _tmpType_measurement_uid = _cursor.getString(_cursorIndexOfTypeMeasurementUid);
        final Boolean _tmpFlag_created;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagCreated)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagCreated);
        }
        _tmpFlag_created = _tmp == null ? null : _tmp != 0;
        final Boolean _tmpFlag_edited;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp_1 == null ? null : _tmp_1 != 0;
        final long _tmpCreated_at;
        _tmpCreated_at = _cursor.getLong(_cursorIndexOfCreatedAt);
        _item = new Measurement(_tmpUid,_tmpGipotinuza,_tmpUgol_naklona,_tmpVertical_gabarit,_tmpHorizontal_gabarit,_tmpLat,_tmpLng,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpRadius,_tmpVozvishenie,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpParent_platform_uid,_tmpParent_gabarit_naves_uid,_tmpParent_gabarit_tor_uid,_tmpParent_main_wire_uid,_tmpParent_contact_wire_uid,_tmpParent_most_perehod_uid,_tmpType_measurement_uid,_tmpFlag_created,_tmpFlag_edited,_tmpCreated_at);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Measurement> getCountLastMeasurementsOfBridge(final String uidBridge,
      final int count) {
    final String _sql = "select * from (select distinct DATE(created_at, 'unixepoch') as date from measurement WHERE parent_most_perehod_uid=? order by date desc limit ?) sub join measurement m on sub.date = DATE(m.created_at, 'unixepoch')";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uidBridge == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uidBridge);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, count);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfGipotinuza = CursorUtil.getColumnIndexOrThrow(_cursor, "gipotinuza");
      final int _cursorIndexOfUgolNaklona = CursorUtil.getColumnIndexOrThrow(_cursor, "ugol_naklona");
      final int _cursorIndexOfVerticalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "vertical_gabarit");
      final int _cursorIndexOfHorizontalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "horizontal_gabarit");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "lng");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfRadius = CursorUtil.getColumnIndexOrThrow(_cursor, "radius");
      final int _cursorIndexOfVozvishenie = CursorUtil.getColumnIndexOrThrow(_cursor, "vozvishenie");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfParentPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_platform_uid");
      final int _cursorIndexOfParentGabaritNavesUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_naves_uid");
      final int _cursorIndexOfParentGabaritTorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_tor_uid");
      final int _cursorIndexOfParentMainWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_main_wire_uid");
      final int _cursorIndexOfParentContactWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_contact_wire_uid");
      final int _cursorIndexOfParentMostPerehodUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_most_perehod_uid");
      final int _cursorIndexOfTypeMeasurementUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_measurement_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final List<Measurement> _result = new ArrayList<Measurement>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Measurement _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpGipotinuza;
        _tmpGipotinuza = _cursor.getString(_cursorIndexOfGipotinuza);
        final String _tmpUgol_naklona;
        _tmpUgol_naklona = _cursor.getString(_cursorIndexOfUgolNaklona);
        final String _tmpVertical_gabarit;
        _tmpVertical_gabarit = _cursor.getString(_cursorIndexOfVerticalGabarit);
        final String _tmpHorizontal_gabarit;
        _tmpHorizontal_gabarit = _cursor.getString(_cursorIndexOfHorizontalGabarit);
        final String _tmpLat;
        _tmpLat = _cursor.getString(_cursorIndexOfLat);
        final String _tmpLng;
        _tmpLng = _cursor.getString(_cursorIndexOfLng);
        final Double _tmpKm_way;
        if (_cursor.isNull(_cursorIndexOfKmWay)) {
          _tmpKm_way = null;
        } else {
          _tmpKm_way = _cursor.getDouble(_cursorIndexOfKmWay);
        }
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final int _tmpRadius;
        _tmpRadius = _cursor.getInt(_cursorIndexOfRadius);
        final int _tmpVozvishenie;
        _tmpVozvishenie = _cursor.getInt(_cursorIndexOfVozvishenie);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final String _tmpParent_platform_uid;
        _tmpParent_platform_uid = _cursor.getString(_cursorIndexOfParentPlatformUid);
        final String _tmpParent_gabarit_naves_uid;
        _tmpParent_gabarit_naves_uid = _cursor.getString(_cursorIndexOfParentGabaritNavesUid);
        final String _tmpParent_gabarit_tor_uid;
        _tmpParent_gabarit_tor_uid = _cursor.getString(_cursorIndexOfParentGabaritTorUid);
        final String _tmpParent_main_wire_uid;
        _tmpParent_main_wire_uid = _cursor.getString(_cursorIndexOfParentMainWireUid);
        final String _tmpParent_contact_wire_uid;
        _tmpParent_contact_wire_uid = _cursor.getString(_cursorIndexOfParentContactWireUid);
        final String _tmpParent_most_perehod_uid;
        _tmpParent_most_perehod_uid = _cursor.getString(_cursorIndexOfParentMostPerehodUid);
        final String _tmpType_measurement_uid;
        _tmpType_measurement_uid = _cursor.getString(_cursorIndexOfTypeMeasurementUid);
        final Boolean _tmpFlag_created;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagCreated)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagCreated);
        }
        _tmpFlag_created = _tmp == null ? null : _tmp != 0;
        final Boolean _tmpFlag_edited;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp_1 == null ? null : _tmp_1 != 0;
        final long _tmpCreated_at;
        _tmpCreated_at = _cursor.getLong(_cursorIndexOfCreatedAt);
        _item = new Measurement(_tmpUid,_tmpGipotinuza,_tmpUgol_naklona,_tmpVertical_gabarit,_tmpHorizontal_gabarit,_tmpLat,_tmpLng,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpRadius,_tmpVozvishenie,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpParent_platform_uid,_tmpParent_gabarit_naves_uid,_tmpParent_gabarit_tor_uid,_tmpParent_main_wire_uid,_tmpParent_contact_wire_uid,_tmpParent_most_perehod_uid,_tmpType_measurement_uid,_tmpFlag_created,_tmpFlag_edited,_tmpCreated_at);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Measurement> getCountLastMeasurementsOfCanopy(final String uidCanopy,
      final int count) {
    final String _sql = "select * from (select distinct DATE(created_at, 'unixepoch') as date from measurement WHERE parent_gabarit_naves_uid=? order by date desc limit ?) sub join measurement m on sub.date = DATE(m.created_at, 'unixepoch')";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uidCanopy == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uidCanopy);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, count);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfGipotinuza = CursorUtil.getColumnIndexOrThrow(_cursor, "gipotinuza");
      final int _cursorIndexOfUgolNaklona = CursorUtil.getColumnIndexOrThrow(_cursor, "ugol_naklona");
      final int _cursorIndexOfVerticalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "vertical_gabarit");
      final int _cursorIndexOfHorizontalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "horizontal_gabarit");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "lng");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfRadius = CursorUtil.getColumnIndexOrThrow(_cursor, "radius");
      final int _cursorIndexOfVozvishenie = CursorUtil.getColumnIndexOrThrow(_cursor, "vozvishenie");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfParentPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_platform_uid");
      final int _cursorIndexOfParentGabaritNavesUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_naves_uid");
      final int _cursorIndexOfParentGabaritTorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_tor_uid");
      final int _cursorIndexOfParentMainWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_main_wire_uid");
      final int _cursorIndexOfParentContactWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_contact_wire_uid");
      final int _cursorIndexOfParentMostPerehodUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_most_perehod_uid");
      final int _cursorIndexOfTypeMeasurementUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_measurement_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final List<Measurement> _result = new ArrayList<Measurement>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Measurement _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpGipotinuza;
        _tmpGipotinuza = _cursor.getString(_cursorIndexOfGipotinuza);
        final String _tmpUgol_naklona;
        _tmpUgol_naklona = _cursor.getString(_cursorIndexOfUgolNaklona);
        final String _tmpVertical_gabarit;
        _tmpVertical_gabarit = _cursor.getString(_cursorIndexOfVerticalGabarit);
        final String _tmpHorizontal_gabarit;
        _tmpHorizontal_gabarit = _cursor.getString(_cursorIndexOfHorizontalGabarit);
        final String _tmpLat;
        _tmpLat = _cursor.getString(_cursorIndexOfLat);
        final String _tmpLng;
        _tmpLng = _cursor.getString(_cursorIndexOfLng);
        final Double _tmpKm_way;
        if (_cursor.isNull(_cursorIndexOfKmWay)) {
          _tmpKm_way = null;
        } else {
          _tmpKm_way = _cursor.getDouble(_cursorIndexOfKmWay);
        }
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final int _tmpRadius;
        _tmpRadius = _cursor.getInt(_cursorIndexOfRadius);
        final int _tmpVozvishenie;
        _tmpVozvishenie = _cursor.getInt(_cursorIndexOfVozvishenie);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final String _tmpParent_platform_uid;
        _tmpParent_platform_uid = _cursor.getString(_cursorIndexOfParentPlatformUid);
        final String _tmpParent_gabarit_naves_uid;
        _tmpParent_gabarit_naves_uid = _cursor.getString(_cursorIndexOfParentGabaritNavesUid);
        final String _tmpParent_gabarit_tor_uid;
        _tmpParent_gabarit_tor_uid = _cursor.getString(_cursorIndexOfParentGabaritTorUid);
        final String _tmpParent_main_wire_uid;
        _tmpParent_main_wire_uid = _cursor.getString(_cursorIndexOfParentMainWireUid);
        final String _tmpParent_contact_wire_uid;
        _tmpParent_contact_wire_uid = _cursor.getString(_cursorIndexOfParentContactWireUid);
        final String _tmpParent_most_perehod_uid;
        _tmpParent_most_perehod_uid = _cursor.getString(_cursorIndexOfParentMostPerehodUid);
        final String _tmpType_measurement_uid;
        _tmpType_measurement_uid = _cursor.getString(_cursorIndexOfTypeMeasurementUid);
        final Boolean _tmpFlag_created;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagCreated)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagCreated);
        }
        _tmpFlag_created = _tmp == null ? null : _tmp != 0;
        final Boolean _tmpFlag_edited;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp_1 == null ? null : _tmp_1 != 0;
        final long _tmpCreated_at;
        _tmpCreated_at = _cursor.getLong(_cursorIndexOfCreatedAt);
        _item = new Measurement(_tmpUid,_tmpGipotinuza,_tmpUgol_naklona,_tmpVertical_gabarit,_tmpHorizontal_gabarit,_tmpLat,_tmpLng,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpRadius,_tmpVozvishenie,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpParent_platform_uid,_tmpParent_gabarit_naves_uid,_tmpParent_gabarit_tor_uid,_tmpParent_main_wire_uid,_tmpParent_contact_wire_uid,_tmpParent_most_perehod_uid,_tmpType_measurement_uid,_tmpFlag_created,_tmpFlag_edited,_tmpCreated_at);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Measurement> getMeasurementsOfBridge(final String uidBridge) {
    final String _sql = "SELECT * FROM measurement WHERE parent_most_perehod_uid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uidBridge == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uidBridge);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfGipotinuza = CursorUtil.getColumnIndexOrThrow(_cursor, "gipotinuza");
      final int _cursorIndexOfUgolNaklona = CursorUtil.getColumnIndexOrThrow(_cursor, "ugol_naklona");
      final int _cursorIndexOfVerticalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "vertical_gabarit");
      final int _cursorIndexOfHorizontalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "horizontal_gabarit");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "lng");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfRadius = CursorUtil.getColumnIndexOrThrow(_cursor, "radius");
      final int _cursorIndexOfVozvishenie = CursorUtil.getColumnIndexOrThrow(_cursor, "vozvishenie");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfParentPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_platform_uid");
      final int _cursorIndexOfParentGabaritNavesUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_naves_uid");
      final int _cursorIndexOfParentGabaritTorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_tor_uid");
      final int _cursorIndexOfParentMainWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_main_wire_uid");
      final int _cursorIndexOfParentContactWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_contact_wire_uid");
      final int _cursorIndexOfParentMostPerehodUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_most_perehod_uid");
      final int _cursorIndexOfTypeMeasurementUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_measurement_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final List<Measurement> _result = new ArrayList<Measurement>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Measurement _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpGipotinuza;
        _tmpGipotinuza = _cursor.getString(_cursorIndexOfGipotinuza);
        final String _tmpUgol_naklona;
        _tmpUgol_naklona = _cursor.getString(_cursorIndexOfUgolNaklona);
        final String _tmpVertical_gabarit;
        _tmpVertical_gabarit = _cursor.getString(_cursorIndexOfVerticalGabarit);
        final String _tmpHorizontal_gabarit;
        _tmpHorizontal_gabarit = _cursor.getString(_cursorIndexOfHorizontalGabarit);
        final String _tmpLat;
        _tmpLat = _cursor.getString(_cursorIndexOfLat);
        final String _tmpLng;
        _tmpLng = _cursor.getString(_cursorIndexOfLng);
        final Double _tmpKm_way;
        if (_cursor.isNull(_cursorIndexOfKmWay)) {
          _tmpKm_way = null;
        } else {
          _tmpKm_way = _cursor.getDouble(_cursorIndexOfKmWay);
        }
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final int _tmpRadius;
        _tmpRadius = _cursor.getInt(_cursorIndexOfRadius);
        final int _tmpVozvishenie;
        _tmpVozvishenie = _cursor.getInt(_cursorIndexOfVozvishenie);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final String _tmpParent_platform_uid;
        _tmpParent_platform_uid = _cursor.getString(_cursorIndexOfParentPlatformUid);
        final String _tmpParent_gabarit_naves_uid;
        _tmpParent_gabarit_naves_uid = _cursor.getString(_cursorIndexOfParentGabaritNavesUid);
        final String _tmpParent_gabarit_tor_uid;
        _tmpParent_gabarit_tor_uid = _cursor.getString(_cursorIndexOfParentGabaritTorUid);
        final String _tmpParent_main_wire_uid;
        _tmpParent_main_wire_uid = _cursor.getString(_cursorIndexOfParentMainWireUid);
        final String _tmpParent_contact_wire_uid;
        _tmpParent_contact_wire_uid = _cursor.getString(_cursorIndexOfParentContactWireUid);
        final String _tmpParent_most_perehod_uid;
        _tmpParent_most_perehod_uid = _cursor.getString(_cursorIndexOfParentMostPerehodUid);
        final String _tmpType_measurement_uid;
        _tmpType_measurement_uid = _cursor.getString(_cursorIndexOfTypeMeasurementUid);
        final Boolean _tmpFlag_created;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagCreated)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagCreated);
        }
        _tmpFlag_created = _tmp == null ? null : _tmp != 0;
        final Boolean _tmpFlag_edited;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp_1 == null ? null : _tmp_1 != 0;
        final long _tmpCreated_at;
        _tmpCreated_at = _cursor.getLong(_cursorIndexOfCreatedAt);
        _item = new Measurement(_tmpUid,_tmpGipotinuza,_tmpUgol_naklona,_tmpVertical_gabarit,_tmpHorizontal_gabarit,_tmpLat,_tmpLng,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpRadius,_tmpVozvishenie,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpParent_platform_uid,_tmpParent_gabarit_naves_uid,_tmpParent_gabarit_tor_uid,_tmpParent_main_wire_uid,_tmpParent_contact_wire_uid,_tmpParent_most_perehod_uid,_tmpType_measurement_uid,_tmpFlag_created,_tmpFlag_edited,_tmpCreated_at);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Measurement getMeasurementById(final String uid) {
    final String _sql = "SELECT * FROM measurement WHERE uid=?";
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
      final int _cursorIndexOfGipotinuza = CursorUtil.getColumnIndexOrThrow(_cursor, "gipotinuza");
      final int _cursorIndexOfUgolNaklona = CursorUtil.getColumnIndexOrThrow(_cursor, "ugol_naklona");
      final int _cursorIndexOfVerticalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "vertical_gabarit");
      final int _cursorIndexOfHorizontalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "horizontal_gabarit");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "lng");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfRadius = CursorUtil.getColumnIndexOrThrow(_cursor, "radius");
      final int _cursorIndexOfVozvishenie = CursorUtil.getColumnIndexOrThrow(_cursor, "vozvishenie");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfParentPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_platform_uid");
      final int _cursorIndexOfParentGabaritNavesUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_naves_uid");
      final int _cursorIndexOfParentGabaritTorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_tor_uid");
      final int _cursorIndexOfParentMainWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_main_wire_uid");
      final int _cursorIndexOfParentContactWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_contact_wire_uid");
      final int _cursorIndexOfParentMostPerehodUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_most_perehod_uid");
      final int _cursorIndexOfTypeMeasurementUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_measurement_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final Measurement _result;
      if(_cursor.moveToFirst()) {
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpGipotinuza;
        _tmpGipotinuza = _cursor.getString(_cursorIndexOfGipotinuza);
        final String _tmpUgol_naklona;
        _tmpUgol_naklona = _cursor.getString(_cursorIndexOfUgolNaklona);
        final String _tmpVertical_gabarit;
        _tmpVertical_gabarit = _cursor.getString(_cursorIndexOfVerticalGabarit);
        final String _tmpHorizontal_gabarit;
        _tmpHorizontal_gabarit = _cursor.getString(_cursorIndexOfHorizontalGabarit);
        final String _tmpLat;
        _tmpLat = _cursor.getString(_cursorIndexOfLat);
        final String _tmpLng;
        _tmpLng = _cursor.getString(_cursorIndexOfLng);
        final Double _tmpKm_way;
        if (_cursor.isNull(_cursorIndexOfKmWay)) {
          _tmpKm_way = null;
        } else {
          _tmpKm_way = _cursor.getDouble(_cursorIndexOfKmWay);
        }
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final int _tmpRadius;
        _tmpRadius = _cursor.getInt(_cursorIndexOfRadius);
        final int _tmpVozvishenie;
        _tmpVozvishenie = _cursor.getInt(_cursorIndexOfVozvishenie);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final String _tmpParent_platform_uid;
        _tmpParent_platform_uid = _cursor.getString(_cursorIndexOfParentPlatformUid);
        final String _tmpParent_gabarit_naves_uid;
        _tmpParent_gabarit_naves_uid = _cursor.getString(_cursorIndexOfParentGabaritNavesUid);
        final String _tmpParent_gabarit_tor_uid;
        _tmpParent_gabarit_tor_uid = _cursor.getString(_cursorIndexOfParentGabaritTorUid);
        final String _tmpParent_main_wire_uid;
        _tmpParent_main_wire_uid = _cursor.getString(_cursorIndexOfParentMainWireUid);
        final String _tmpParent_contact_wire_uid;
        _tmpParent_contact_wire_uid = _cursor.getString(_cursorIndexOfParentContactWireUid);
        final String _tmpParent_most_perehod_uid;
        _tmpParent_most_perehod_uid = _cursor.getString(_cursorIndexOfParentMostPerehodUid);
        final String _tmpType_measurement_uid;
        _tmpType_measurement_uid = _cursor.getString(_cursorIndexOfTypeMeasurementUid);
        final Boolean _tmpFlag_created;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagCreated)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagCreated);
        }
        _tmpFlag_created = _tmp == null ? null : _tmp != 0;
        final Boolean _tmpFlag_edited;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp_1 == null ? null : _tmp_1 != 0;
        final long _tmpCreated_at;
        _tmpCreated_at = _cursor.getLong(_cursorIndexOfCreatedAt);
        _result = new Measurement(_tmpUid,_tmpGipotinuza,_tmpUgol_naklona,_tmpVertical_gabarit,_tmpHorizontal_gabarit,_tmpLat,_tmpLng,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpRadius,_tmpVozvishenie,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpParent_platform_uid,_tmpParent_gabarit_naves_uid,_tmpParent_gabarit_tor_uid,_tmpParent_main_wire_uid,_tmpParent_contact_wire_uid,_tmpParent_most_perehod_uid,_tmpType_measurement_uid,_tmpFlag_created,_tmpFlag_edited,_tmpCreated_at);
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
  public Measurement getMeasurementOfDimensionsFence(final String uidDimension) {
    final String _sql = "SELECT * FROM measurement WHERE parent_gabarit_tor_uid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uidDimension == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uidDimension);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfGipotinuza = CursorUtil.getColumnIndexOrThrow(_cursor, "gipotinuza");
      final int _cursorIndexOfUgolNaklona = CursorUtil.getColumnIndexOrThrow(_cursor, "ugol_naklona");
      final int _cursorIndexOfVerticalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "vertical_gabarit");
      final int _cursorIndexOfHorizontalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "horizontal_gabarit");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "lng");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfRadius = CursorUtil.getColumnIndexOrThrow(_cursor, "radius");
      final int _cursorIndexOfVozvishenie = CursorUtil.getColumnIndexOrThrow(_cursor, "vozvishenie");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfParentPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_platform_uid");
      final int _cursorIndexOfParentGabaritNavesUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_naves_uid");
      final int _cursorIndexOfParentGabaritTorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_tor_uid");
      final int _cursorIndexOfParentMainWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_main_wire_uid");
      final int _cursorIndexOfParentContactWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_contact_wire_uid");
      final int _cursorIndexOfParentMostPerehodUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_most_perehod_uid");
      final int _cursorIndexOfTypeMeasurementUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_measurement_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final Measurement _result;
      if(_cursor.moveToFirst()) {
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpGipotinuza;
        _tmpGipotinuza = _cursor.getString(_cursorIndexOfGipotinuza);
        final String _tmpUgol_naklona;
        _tmpUgol_naklona = _cursor.getString(_cursorIndexOfUgolNaklona);
        final String _tmpVertical_gabarit;
        _tmpVertical_gabarit = _cursor.getString(_cursorIndexOfVerticalGabarit);
        final String _tmpHorizontal_gabarit;
        _tmpHorizontal_gabarit = _cursor.getString(_cursorIndexOfHorizontalGabarit);
        final String _tmpLat;
        _tmpLat = _cursor.getString(_cursorIndexOfLat);
        final String _tmpLng;
        _tmpLng = _cursor.getString(_cursorIndexOfLng);
        final Double _tmpKm_way;
        if (_cursor.isNull(_cursorIndexOfKmWay)) {
          _tmpKm_way = null;
        } else {
          _tmpKm_way = _cursor.getDouble(_cursorIndexOfKmWay);
        }
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final int _tmpRadius;
        _tmpRadius = _cursor.getInt(_cursorIndexOfRadius);
        final int _tmpVozvishenie;
        _tmpVozvishenie = _cursor.getInt(_cursorIndexOfVozvishenie);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final String _tmpParent_platform_uid;
        _tmpParent_platform_uid = _cursor.getString(_cursorIndexOfParentPlatformUid);
        final String _tmpParent_gabarit_naves_uid;
        _tmpParent_gabarit_naves_uid = _cursor.getString(_cursorIndexOfParentGabaritNavesUid);
        final String _tmpParent_gabarit_tor_uid;
        _tmpParent_gabarit_tor_uid = _cursor.getString(_cursorIndexOfParentGabaritTorUid);
        final String _tmpParent_main_wire_uid;
        _tmpParent_main_wire_uid = _cursor.getString(_cursorIndexOfParentMainWireUid);
        final String _tmpParent_contact_wire_uid;
        _tmpParent_contact_wire_uid = _cursor.getString(_cursorIndexOfParentContactWireUid);
        final String _tmpParent_most_perehod_uid;
        _tmpParent_most_perehod_uid = _cursor.getString(_cursorIndexOfParentMostPerehodUid);
        final String _tmpType_measurement_uid;
        _tmpType_measurement_uid = _cursor.getString(_cursorIndexOfTypeMeasurementUid);
        final Boolean _tmpFlag_created;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagCreated)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagCreated);
        }
        _tmpFlag_created = _tmp == null ? null : _tmp != 0;
        final Boolean _tmpFlag_edited;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp_1 == null ? null : _tmp_1 != 0;
        final long _tmpCreated_at;
        _tmpCreated_at = _cursor.getLong(_cursorIndexOfCreatedAt);
        _result = new Measurement(_tmpUid,_tmpGipotinuza,_tmpUgol_naklona,_tmpVertical_gabarit,_tmpHorizontal_gabarit,_tmpLat,_tmpLng,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpRadius,_tmpVozvishenie,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpParent_platform_uid,_tmpParent_gabarit_naves_uid,_tmpParent_gabarit_tor_uid,_tmpParent_main_wire_uid,_tmpParent_contact_wire_uid,_tmpParent_most_perehod_uid,_tmpType_measurement_uid,_tmpFlag_created,_tmpFlag_edited,_tmpCreated_at);
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
  public List<Measurement> getMeasurementsOfCanopy(final String uid) {
    final String _sql = "SELECT * FROM measurement WHERE parent_gabarit_naves_uid=?";
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
      final int _cursorIndexOfGipotinuza = CursorUtil.getColumnIndexOrThrow(_cursor, "gipotinuza");
      final int _cursorIndexOfUgolNaklona = CursorUtil.getColumnIndexOrThrow(_cursor, "ugol_naklona");
      final int _cursorIndexOfVerticalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "vertical_gabarit");
      final int _cursorIndexOfHorizontalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "horizontal_gabarit");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "lng");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfRadius = CursorUtil.getColumnIndexOrThrow(_cursor, "radius");
      final int _cursorIndexOfVozvishenie = CursorUtil.getColumnIndexOrThrow(_cursor, "vozvishenie");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfParentPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_platform_uid");
      final int _cursorIndexOfParentGabaritNavesUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_naves_uid");
      final int _cursorIndexOfParentGabaritTorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_tor_uid");
      final int _cursorIndexOfParentMainWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_main_wire_uid");
      final int _cursorIndexOfParentContactWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_contact_wire_uid");
      final int _cursorIndexOfParentMostPerehodUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_most_perehod_uid");
      final int _cursorIndexOfTypeMeasurementUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_measurement_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final List<Measurement> _result = new ArrayList<Measurement>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Measurement _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpGipotinuza;
        _tmpGipotinuza = _cursor.getString(_cursorIndexOfGipotinuza);
        final String _tmpUgol_naklona;
        _tmpUgol_naklona = _cursor.getString(_cursorIndexOfUgolNaklona);
        final String _tmpVertical_gabarit;
        _tmpVertical_gabarit = _cursor.getString(_cursorIndexOfVerticalGabarit);
        final String _tmpHorizontal_gabarit;
        _tmpHorizontal_gabarit = _cursor.getString(_cursorIndexOfHorizontalGabarit);
        final String _tmpLat;
        _tmpLat = _cursor.getString(_cursorIndexOfLat);
        final String _tmpLng;
        _tmpLng = _cursor.getString(_cursorIndexOfLng);
        final Double _tmpKm_way;
        if (_cursor.isNull(_cursorIndexOfKmWay)) {
          _tmpKm_way = null;
        } else {
          _tmpKm_way = _cursor.getDouble(_cursorIndexOfKmWay);
        }
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final int _tmpRadius;
        _tmpRadius = _cursor.getInt(_cursorIndexOfRadius);
        final int _tmpVozvishenie;
        _tmpVozvishenie = _cursor.getInt(_cursorIndexOfVozvishenie);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final String _tmpParent_platform_uid;
        _tmpParent_platform_uid = _cursor.getString(_cursorIndexOfParentPlatformUid);
        final String _tmpParent_gabarit_naves_uid;
        _tmpParent_gabarit_naves_uid = _cursor.getString(_cursorIndexOfParentGabaritNavesUid);
        final String _tmpParent_gabarit_tor_uid;
        _tmpParent_gabarit_tor_uid = _cursor.getString(_cursorIndexOfParentGabaritTorUid);
        final String _tmpParent_main_wire_uid;
        _tmpParent_main_wire_uid = _cursor.getString(_cursorIndexOfParentMainWireUid);
        final String _tmpParent_contact_wire_uid;
        _tmpParent_contact_wire_uid = _cursor.getString(_cursorIndexOfParentContactWireUid);
        final String _tmpParent_most_perehod_uid;
        _tmpParent_most_perehod_uid = _cursor.getString(_cursorIndexOfParentMostPerehodUid);
        final String _tmpType_measurement_uid;
        _tmpType_measurement_uid = _cursor.getString(_cursorIndexOfTypeMeasurementUid);
        final Boolean _tmpFlag_created;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagCreated)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagCreated);
        }
        _tmpFlag_created = _tmp == null ? null : _tmp != 0;
        final Boolean _tmpFlag_edited;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp_1 == null ? null : _tmp_1 != 0;
        final long _tmpCreated_at;
        _tmpCreated_at = _cursor.getLong(_cursorIndexOfCreatedAt);
        _item = new Measurement(_tmpUid,_tmpGipotinuza,_tmpUgol_naklona,_tmpVertical_gabarit,_tmpHorizontal_gabarit,_tmpLat,_tmpLng,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpRadius,_tmpVozvishenie,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpParent_platform_uid,_tmpParent_gabarit_naves_uid,_tmpParent_gabarit_tor_uid,_tmpParent_main_wire_uid,_tmpParent_contact_wire_uid,_tmpParent_most_perehod_uid,_tmpType_measurement_uid,_tmpFlag_created,_tmpFlag_edited,_tmpCreated_at);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Measurement getMeasurementsOfContactWire(final String uid, final String uidType) {
    final String _sql = "SELECT * FROM measurement WHERE type_measurement_uid=? AND parent_contact_wire_uid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uidType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uidType);
    }
    _argIndex = 2;
    if (uid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfGipotinuza = CursorUtil.getColumnIndexOrThrow(_cursor, "gipotinuza");
      final int _cursorIndexOfUgolNaklona = CursorUtil.getColumnIndexOrThrow(_cursor, "ugol_naklona");
      final int _cursorIndexOfVerticalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "vertical_gabarit");
      final int _cursorIndexOfHorizontalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "horizontal_gabarit");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "lng");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfRadius = CursorUtil.getColumnIndexOrThrow(_cursor, "radius");
      final int _cursorIndexOfVozvishenie = CursorUtil.getColumnIndexOrThrow(_cursor, "vozvishenie");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfParentPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_platform_uid");
      final int _cursorIndexOfParentGabaritNavesUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_naves_uid");
      final int _cursorIndexOfParentGabaritTorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_tor_uid");
      final int _cursorIndexOfParentMainWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_main_wire_uid");
      final int _cursorIndexOfParentContactWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_contact_wire_uid");
      final int _cursorIndexOfParentMostPerehodUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_most_perehod_uid");
      final int _cursorIndexOfTypeMeasurementUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_measurement_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final Measurement _result;
      if(_cursor.moveToFirst()) {
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpGipotinuza;
        _tmpGipotinuza = _cursor.getString(_cursorIndexOfGipotinuza);
        final String _tmpUgol_naklona;
        _tmpUgol_naklona = _cursor.getString(_cursorIndexOfUgolNaklona);
        final String _tmpVertical_gabarit;
        _tmpVertical_gabarit = _cursor.getString(_cursorIndexOfVerticalGabarit);
        final String _tmpHorizontal_gabarit;
        _tmpHorizontal_gabarit = _cursor.getString(_cursorIndexOfHorizontalGabarit);
        final String _tmpLat;
        _tmpLat = _cursor.getString(_cursorIndexOfLat);
        final String _tmpLng;
        _tmpLng = _cursor.getString(_cursorIndexOfLng);
        final Double _tmpKm_way;
        if (_cursor.isNull(_cursorIndexOfKmWay)) {
          _tmpKm_way = null;
        } else {
          _tmpKm_way = _cursor.getDouble(_cursorIndexOfKmWay);
        }
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final int _tmpRadius;
        _tmpRadius = _cursor.getInt(_cursorIndexOfRadius);
        final int _tmpVozvishenie;
        _tmpVozvishenie = _cursor.getInt(_cursorIndexOfVozvishenie);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final String _tmpParent_platform_uid;
        _tmpParent_platform_uid = _cursor.getString(_cursorIndexOfParentPlatformUid);
        final String _tmpParent_gabarit_naves_uid;
        _tmpParent_gabarit_naves_uid = _cursor.getString(_cursorIndexOfParentGabaritNavesUid);
        final String _tmpParent_gabarit_tor_uid;
        _tmpParent_gabarit_tor_uid = _cursor.getString(_cursorIndexOfParentGabaritTorUid);
        final String _tmpParent_main_wire_uid;
        _tmpParent_main_wire_uid = _cursor.getString(_cursorIndexOfParentMainWireUid);
        final String _tmpParent_contact_wire_uid;
        _tmpParent_contact_wire_uid = _cursor.getString(_cursorIndexOfParentContactWireUid);
        final String _tmpParent_most_perehod_uid;
        _tmpParent_most_perehod_uid = _cursor.getString(_cursorIndexOfParentMostPerehodUid);
        final String _tmpType_measurement_uid;
        _tmpType_measurement_uid = _cursor.getString(_cursorIndexOfTypeMeasurementUid);
        final Boolean _tmpFlag_created;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagCreated)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagCreated);
        }
        _tmpFlag_created = _tmp == null ? null : _tmp != 0;
        final Boolean _tmpFlag_edited;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp_1 == null ? null : _tmp_1 != 0;
        final long _tmpCreated_at;
        _tmpCreated_at = _cursor.getLong(_cursorIndexOfCreatedAt);
        _result = new Measurement(_tmpUid,_tmpGipotinuza,_tmpUgol_naklona,_tmpVertical_gabarit,_tmpHorizontal_gabarit,_tmpLat,_tmpLng,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpRadius,_tmpVozvishenie,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpParent_platform_uid,_tmpParent_gabarit_naves_uid,_tmpParent_gabarit_tor_uid,_tmpParent_main_wire_uid,_tmpParent_contact_wire_uid,_tmpParent_most_perehod_uid,_tmpType_measurement_uid,_tmpFlag_created,_tmpFlag_edited,_tmpCreated_at);
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
  public Measurement getMeasurementsOfCarrierWire(final String uid, final String uidType) {
    final String _sql = "SELECT * FROM measurement WHERE type_measurement_uid=? AND parent_main_wire_uid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uidType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uidType);
    }
    _argIndex = 2;
    if (uid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfGipotinuza = CursorUtil.getColumnIndexOrThrow(_cursor, "gipotinuza");
      final int _cursorIndexOfUgolNaklona = CursorUtil.getColumnIndexOrThrow(_cursor, "ugol_naklona");
      final int _cursorIndexOfVerticalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "vertical_gabarit");
      final int _cursorIndexOfHorizontalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "horizontal_gabarit");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "lng");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfRadius = CursorUtil.getColumnIndexOrThrow(_cursor, "radius");
      final int _cursorIndexOfVozvishenie = CursorUtil.getColumnIndexOrThrow(_cursor, "vozvishenie");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfParentPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_platform_uid");
      final int _cursorIndexOfParentGabaritNavesUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_naves_uid");
      final int _cursorIndexOfParentGabaritTorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_tor_uid");
      final int _cursorIndexOfParentMainWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_main_wire_uid");
      final int _cursorIndexOfParentContactWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_contact_wire_uid");
      final int _cursorIndexOfParentMostPerehodUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_most_perehod_uid");
      final int _cursorIndexOfTypeMeasurementUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_measurement_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final Measurement _result;
      if(_cursor.moveToFirst()) {
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpGipotinuza;
        _tmpGipotinuza = _cursor.getString(_cursorIndexOfGipotinuza);
        final String _tmpUgol_naklona;
        _tmpUgol_naklona = _cursor.getString(_cursorIndexOfUgolNaklona);
        final String _tmpVertical_gabarit;
        _tmpVertical_gabarit = _cursor.getString(_cursorIndexOfVerticalGabarit);
        final String _tmpHorizontal_gabarit;
        _tmpHorizontal_gabarit = _cursor.getString(_cursorIndexOfHorizontalGabarit);
        final String _tmpLat;
        _tmpLat = _cursor.getString(_cursorIndexOfLat);
        final String _tmpLng;
        _tmpLng = _cursor.getString(_cursorIndexOfLng);
        final Double _tmpKm_way;
        if (_cursor.isNull(_cursorIndexOfKmWay)) {
          _tmpKm_way = null;
        } else {
          _tmpKm_way = _cursor.getDouble(_cursorIndexOfKmWay);
        }
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final int _tmpRadius;
        _tmpRadius = _cursor.getInt(_cursorIndexOfRadius);
        final int _tmpVozvishenie;
        _tmpVozvishenie = _cursor.getInt(_cursorIndexOfVozvishenie);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final String _tmpParent_platform_uid;
        _tmpParent_platform_uid = _cursor.getString(_cursorIndexOfParentPlatformUid);
        final String _tmpParent_gabarit_naves_uid;
        _tmpParent_gabarit_naves_uid = _cursor.getString(_cursorIndexOfParentGabaritNavesUid);
        final String _tmpParent_gabarit_tor_uid;
        _tmpParent_gabarit_tor_uid = _cursor.getString(_cursorIndexOfParentGabaritTorUid);
        final String _tmpParent_main_wire_uid;
        _tmpParent_main_wire_uid = _cursor.getString(_cursorIndexOfParentMainWireUid);
        final String _tmpParent_contact_wire_uid;
        _tmpParent_contact_wire_uid = _cursor.getString(_cursorIndexOfParentContactWireUid);
        final String _tmpParent_most_perehod_uid;
        _tmpParent_most_perehod_uid = _cursor.getString(_cursorIndexOfParentMostPerehodUid);
        final String _tmpType_measurement_uid;
        _tmpType_measurement_uid = _cursor.getString(_cursorIndexOfTypeMeasurementUid);
        final Boolean _tmpFlag_created;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagCreated)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagCreated);
        }
        _tmpFlag_created = _tmp == null ? null : _tmp != 0;
        final Boolean _tmpFlag_edited;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp_1 == null ? null : _tmp_1 != 0;
        final long _tmpCreated_at;
        _tmpCreated_at = _cursor.getLong(_cursorIndexOfCreatedAt);
        _result = new Measurement(_tmpUid,_tmpGipotinuza,_tmpUgol_naklona,_tmpVertical_gabarit,_tmpHorizontal_gabarit,_tmpLat,_tmpLng,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpRadius,_tmpVozvishenie,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpParent_platform_uid,_tmpParent_gabarit_naves_uid,_tmpParent_gabarit_tor_uid,_tmpParent_main_wire_uid,_tmpParent_contact_wire_uid,_tmpParent_most_perehod_uid,_tmpType_measurement_uid,_tmpFlag_created,_tmpFlag_edited,_tmpCreated_at);
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
  public List<Measurement> getMeasurementsCreated(final boolean flag_created) {
    final String _sql = "SELECT * FROM measurement WHERE flag_created=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp;
    _tmp = flag_created ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfGipotinuza = CursorUtil.getColumnIndexOrThrow(_cursor, "gipotinuza");
      final int _cursorIndexOfUgolNaklona = CursorUtil.getColumnIndexOrThrow(_cursor, "ugol_naklona");
      final int _cursorIndexOfVerticalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "vertical_gabarit");
      final int _cursorIndexOfHorizontalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "horizontal_gabarit");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "lng");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfRadius = CursorUtil.getColumnIndexOrThrow(_cursor, "radius");
      final int _cursorIndexOfVozvishenie = CursorUtil.getColumnIndexOrThrow(_cursor, "vozvishenie");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfParentPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_platform_uid");
      final int _cursorIndexOfParentGabaritNavesUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_naves_uid");
      final int _cursorIndexOfParentGabaritTorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_tor_uid");
      final int _cursorIndexOfParentMainWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_main_wire_uid");
      final int _cursorIndexOfParentContactWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_contact_wire_uid");
      final int _cursorIndexOfParentMostPerehodUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_most_perehod_uid");
      final int _cursorIndexOfTypeMeasurementUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_measurement_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final List<Measurement> _result = new ArrayList<Measurement>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Measurement _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpGipotinuza;
        _tmpGipotinuza = _cursor.getString(_cursorIndexOfGipotinuza);
        final String _tmpUgol_naklona;
        _tmpUgol_naklona = _cursor.getString(_cursorIndexOfUgolNaklona);
        final String _tmpVertical_gabarit;
        _tmpVertical_gabarit = _cursor.getString(_cursorIndexOfVerticalGabarit);
        final String _tmpHorizontal_gabarit;
        _tmpHorizontal_gabarit = _cursor.getString(_cursorIndexOfHorizontalGabarit);
        final String _tmpLat;
        _tmpLat = _cursor.getString(_cursorIndexOfLat);
        final String _tmpLng;
        _tmpLng = _cursor.getString(_cursorIndexOfLng);
        final Double _tmpKm_way;
        if (_cursor.isNull(_cursorIndexOfKmWay)) {
          _tmpKm_way = null;
        } else {
          _tmpKm_way = _cursor.getDouble(_cursorIndexOfKmWay);
        }
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final int _tmpRadius;
        _tmpRadius = _cursor.getInt(_cursorIndexOfRadius);
        final int _tmpVozvishenie;
        _tmpVozvishenie = _cursor.getInt(_cursorIndexOfVozvishenie);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final String _tmpParent_platform_uid;
        _tmpParent_platform_uid = _cursor.getString(_cursorIndexOfParentPlatformUid);
        final String _tmpParent_gabarit_naves_uid;
        _tmpParent_gabarit_naves_uid = _cursor.getString(_cursorIndexOfParentGabaritNavesUid);
        final String _tmpParent_gabarit_tor_uid;
        _tmpParent_gabarit_tor_uid = _cursor.getString(_cursorIndexOfParentGabaritTorUid);
        final String _tmpParent_main_wire_uid;
        _tmpParent_main_wire_uid = _cursor.getString(_cursorIndexOfParentMainWireUid);
        final String _tmpParent_contact_wire_uid;
        _tmpParent_contact_wire_uid = _cursor.getString(_cursorIndexOfParentContactWireUid);
        final String _tmpParent_most_perehod_uid;
        _tmpParent_most_perehod_uid = _cursor.getString(_cursorIndexOfParentMostPerehodUid);
        final String _tmpType_measurement_uid;
        _tmpType_measurement_uid = _cursor.getString(_cursorIndexOfTypeMeasurementUid);
        final Boolean _tmpFlag_created;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagCreated)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagCreated);
        }
        _tmpFlag_created = _tmp_1 == null ? null : _tmp_1 != 0;
        final Boolean _tmpFlag_edited;
        final Integer _tmp_2;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp_2 == null ? null : _tmp_2 != 0;
        final long _tmpCreated_at;
        _tmpCreated_at = _cursor.getLong(_cursorIndexOfCreatedAt);
        _item = new Measurement(_tmpUid,_tmpGipotinuza,_tmpUgol_naklona,_tmpVertical_gabarit,_tmpHorizontal_gabarit,_tmpLat,_tmpLng,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpRadius,_tmpVozvishenie,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpParent_platform_uid,_tmpParent_gabarit_naves_uid,_tmpParent_gabarit_tor_uid,_tmpParent_main_wire_uid,_tmpParent_contact_wire_uid,_tmpParent_most_perehod_uid,_tmpType_measurement_uid,_tmpFlag_created,_tmpFlag_edited,_tmpCreated_at);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Measurement> getMeasurementsEdited(final boolean flag_edited) {
    final String _sql = "SELECT * FROM measurement WHERE flag_edited=? and flag_created is null";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp;
    _tmp = flag_edited ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfGipotinuza = CursorUtil.getColumnIndexOrThrow(_cursor, "gipotinuza");
      final int _cursorIndexOfUgolNaklona = CursorUtil.getColumnIndexOrThrow(_cursor, "ugol_naklona");
      final int _cursorIndexOfVerticalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "vertical_gabarit");
      final int _cursorIndexOfHorizontalGabarit = CursorUtil.getColumnIndexOrThrow(_cursor, "horizontal_gabarit");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "lng");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfRadius = CursorUtil.getColumnIndexOrThrow(_cursor, "radius");
      final int _cursorIndexOfVozvishenie = CursorUtil.getColumnIndexOrThrow(_cursor, "vozvishenie");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfParentPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_platform_uid");
      final int _cursorIndexOfParentGabaritNavesUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_naves_uid");
      final int _cursorIndexOfParentGabaritTorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_gabarit_tor_uid");
      final int _cursorIndexOfParentMainWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_main_wire_uid");
      final int _cursorIndexOfParentContactWireUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_contact_wire_uid");
      final int _cursorIndexOfParentMostPerehodUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_most_perehod_uid");
      final int _cursorIndexOfTypeMeasurementUid = CursorUtil.getColumnIndexOrThrow(_cursor, "type_measurement_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final List<Measurement> _result = new ArrayList<Measurement>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Measurement _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpGipotinuza;
        _tmpGipotinuza = _cursor.getString(_cursorIndexOfGipotinuza);
        final String _tmpUgol_naklona;
        _tmpUgol_naklona = _cursor.getString(_cursorIndexOfUgolNaklona);
        final String _tmpVertical_gabarit;
        _tmpVertical_gabarit = _cursor.getString(_cursorIndexOfVerticalGabarit);
        final String _tmpHorizontal_gabarit;
        _tmpHorizontal_gabarit = _cursor.getString(_cursorIndexOfHorizontalGabarit);
        final String _tmpLat;
        _tmpLat = _cursor.getString(_cursorIndexOfLat);
        final String _tmpLng;
        _tmpLng = _cursor.getString(_cursorIndexOfLng);
        final Double _tmpKm_way;
        if (_cursor.isNull(_cursorIndexOfKmWay)) {
          _tmpKm_way = null;
        } else {
          _tmpKm_way = _cursor.getDouble(_cursorIndexOfKmWay);
        }
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final int _tmpRadius;
        _tmpRadius = _cursor.getInt(_cursorIndexOfRadius);
        final int _tmpVozvishenie;
        _tmpVozvishenie = _cursor.getInt(_cursorIndexOfVozvishenie);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final String _tmpParent_platform_uid;
        _tmpParent_platform_uid = _cursor.getString(_cursorIndexOfParentPlatformUid);
        final String _tmpParent_gabarit_naves_uid;
        _tmpParent_gabarit_naves_uid = _cursor.getString(_cursorIndexOfParentGabaritNavesUid);
        final String _tmpParent_gabarit_tor_uid;
        _tmpParent_gabarit_tor_uid = _cursor.getString(_cursorIndexOfParentGabaritTorUid);
        final String _tmpParent_main_wire_uid;
        _tmpParent_main_wire_uid = _cursor.getString(_cursorIndexOfParentMainWireUid);
        final String _tmpParent_contact_wire_uid;
        _tmpParent_contact_wire_uid = _cursor.getString(_cursorIndexOfParentContactWireUid);
        final String _tmpParent_most_perehod_uid;
        _tmpParent_most_perehod_uid = _cursor.getString(_cursorIndexOfParentMostPerehodUid);
        final String _tmpType_measurement_uid;
        _tmpType_measurement_uid = _cursor.getString(_cursorIndexOfTypeMeasurementUid);
        final Boolean _tmpFlag_created;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagCreated)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagCreated);
        }
        _tmpFlag_created = _tmp_1 == null ? null : _tmp_1 != 0;
        final Boolean _tmpFlag_edited;
        final Integer _tmp_2;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp_2 == null ? null : _tmp_2 != 0;
        final long _tmpCreated_at;
        _tmpCreated_at = _cursor.getLong(_cursorIndexOfCreatedAt);
        _item = new Measurement(_tmpUid,_tmpGipotinuza,_tmpUgol_naklona,_tmpVertical_gabarit,_tmpHorizontal_gabarit,_tmpLat,_tmpLng,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpRadius,_tmpVozvishenie,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpParent_platform_uid,_tmpParent_gabarit_naves_uid,_tmpParent_gabarit_tor_uid,_tmpParent_main_wire_uid,_tmpParent_contact_wire_uid,_tmpParent_most_perehod_uid,_tmpType_measurement_uid,_tmpFlag_created,_tmpFlag_edited,_tmpCreated_at);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
