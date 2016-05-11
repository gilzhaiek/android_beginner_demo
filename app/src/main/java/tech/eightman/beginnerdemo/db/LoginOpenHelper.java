package tech.eightman.beginnerdemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LoginOpenHelper extends SQLiteOpenHelper {
    public static final String TAG = LoginOpenHelper.class.getSimpleName();

    public static final String DATABASE_NAME = "Login.db";
    public static final int DATABASE_VERSION = 3;

    public static final String TABLE_REGISTRATION = "registration";
    public static final String COLUMN_ID = "regid";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_MOBILE = "mobile";

    // Creates the Database
    public LoginOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create the tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String.format(
                "create table %s (%s integer primary key autoincrement, %s text, %s text, %s text)",
                TABLE_REGISTRATION,
                COLUMN_ID,
                COLUMN_EMAIL,
                COLUMN_PASSWORD,
                COLUMN_MOBILE);

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTRATION);
        onCreate(db);
    }
}
