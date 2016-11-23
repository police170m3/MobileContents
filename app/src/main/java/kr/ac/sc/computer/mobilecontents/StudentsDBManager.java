package kr.ac.sc.computer.mobilecontents;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by MSI on 2016-10-26.
 */

public class StudentsDBManager {
    static final String DB_STUDENTS = "Students.db";
    static final String TABLE_STUDENTS = "Students";
    static final int DB_VERSION = 1;

    Context mContext = null;

    private static StudentsDBManager mDbManager = null;
    private SQLiteDatabase mDatabase = null;

    public static StudentsDBManager getInstance(Context context) {
        if (mDbManager == null) {
            mDbManager = new StudentsDBManager(context);
        }
        return mDbManager;
    }

    private StudentsDBManager(Context context) {
        mContext = context;
        mDatabase = context.openOrCreateDatabase(DB_STUDENTS, Context.MODE_PRIVATE, null);
        mDatabase.execSQL("create table if not exists " + TABLE_STUDENTS + "(" + "_id integer primary key autoincrement, " + "number text, " +
                            "name text, " + "department text, " + "grade integer );");
    }

    public long insert(ContentValues addRowValue) {
        return mDatabase.insert(TABLE_STUDENTS, null, addRowValue);
    }

    public Cursor query(String[] columns, String selection, String[] selectionArgs, String groupsBy, String having, String orderBy) {
        return mDatabase.query(TABLE_STUDENTS, columns, selection, selectionArgs, groupsBy, having, orderBy);
    }

}
