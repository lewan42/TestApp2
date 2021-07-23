package dev.fabula.android.measurements.type.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import dev.fabula.android.measurements.type.model.MeasurementType;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MeasurementTypeDao_Impl implements MeasurementTypeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MeasurementType> __insertionAdapterOfMeasurementType;

  private final EntityInsertionAdapter<MeasurementType> __insertionAdapterOfMeasurementType_1;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public MeasurementTypeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMeasurementType = new EntityInsertionAdapter<MeasurementType>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `type_measurement` (`uid`,`name`,`norma`,`allowableErrorPlus`,`allowableErrorMinus`,`type_of`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MeasurementType value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindDouble(3, value.getNorma());
        stmt.bindDouble(4, value.getAllowableErrorPlus());
        stmt.bindDouble(5, value.getAllowableErrorMinus());
        if (value.getType_of() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getType_of());
        }
      }
    };
    this.__insertionAdapterOfMeasurementType_1 = new EntityInsertionAdapter<MeasurementType>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `type_measurement` (`uid`,`name`,`norma`,`allowableErrorPlus`,`allowableErrorMinus`,`type_of`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MeasurementType value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindDouble(3, value.getNorma());
        stmt.bindDouble(4, value.getAllowableErrorPlus());
        stmt.bindDouble(5, value.getAllowableErrorMinus());
        if (value.getType_of() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getType_of());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM type_measurement";
        return _query;
      }
    };
  }

  @Override
  public void insert(final MeasurementType measurementType) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMeasurementType.insert(measurementType);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final MeasurementType measurementType) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMeasurementType_1.insert(measurementType);
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
  public Flow<List<MeasurementType>> getTypeMeasurements() {
    final String _sql = "SELECT * FROM type_measurement";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"type_measurement"}, new Callable<List<MeasurementType>>() {
      @Override
      public List<MeasurementType> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfNorma = CursorUtil.getColumnIndexOrThrow(_cursor, "norma");
          final int _cursorIndexOfAllowableErrorPlus = CursorUtil.getColumnIndexOrThrow(_cursor, "allowableErrorPlus");
          final int _cursorIndexOfAllowableErrorMinus = CursorUtil.getColumnIndexOrThrow(_cursor, "allowableErrorMinus");
          final int _cursorIndexOfTypeOf = CursorUtil.getColumnIndexOrThrow(_cursor, "type_of");
          final List<MeasurementType> _result = new ArrayList<MeasurementType>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final MeasurementType _item;
            final String _tmpUid;
            _tmpUid = _cursor.getString(_cursorIndexOfUid);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final double _tmpNorma;
            _tmpNorma = _cursor.getDouble(_cursorIndexOfNorma);
            final double _tmpAllowableErrorPlus;
            _tmpAllowableErrorPlus = _cursor.getDouble(_cursorIndexOfAllowableErrorPlus);
            final double _tmpAllowableErrorMinus;
            _tmpAllowableErrorMinus = _cursor.getDouble(_cursorIndexOfAllowableErrorMinus);
            final String _tmpType_of;
            _tmpType_of = _cursor.getString(_cursorIndexOfTypeOf);
            _item = new MeasurementType(_tmpUid,_tmpName,_tmpNorma,_tmpAllowableErrorPlus,_tmpAllowableErrorMinus,_tmpType_of);
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
  public MeasurementType getTypeMeasurementByType(final String type) {
    final String _sql = "SELECT * FROM type_measurement WHERE type_of=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfNorma = CursorUtil.getColumnIndexOrThrow(_cursor, "norma");
      final int _cursorIndexOfAllowableErrorPlus = CursorUtil.getColumnIndexOrThrow(_cursor, "allowableErrorPlus");
      final int _cursorIndexOfAllowableErrorMinus = CursorUtil.getColumnIndexOrThrow(_cursor, "allowableErrorMinus");
      final int _cursorIndexOfTypeOf = CursorUtil.getColumnIndexOrThrow(_cursor, "type_of");
      final MeasurementType _result;
      if(_cursor.moveToFirst()) {
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final double _tmpNorma;
        _tmpNorma = _cursor.getDouble(_cursorIndexOfNorma);
        final double _tmpAllowableErrorPlus;
        _tmpAllowableErrorPlus = _cursor.getDouble(_cursorIndexOfAllowableErrorPlus);
        final double _tmpAllowableErrorMinus;
        _tmpAllowableErrorMinus = _cursor.getDouble(_cursorIndexOfAllowableErrorMinus);
        final String _tmpType_of;
        _tmpType_of = _cursor.getString(_cursorIndexOfTypeOf);
        _result = new MeasurementType(_tmpUid,_tmpName,_tmpNorma,_tmpAllowableErrorPlus,_tmpAllowableErrorMinus,_tmpType_of);
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
