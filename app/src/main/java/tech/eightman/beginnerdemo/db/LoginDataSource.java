package tech.eightman.beginnerdemo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import tech.eightman.beginnerdemo.model.Registration;

public class LoginDataSource {
    SQLiteOpenHelper dbhelper;
    SQLiteDatabase database;

    private static final String TAG = LoginDataSource.class.getSimpleName();

    public LoginDataSource(Context context) {
        dbhelper = new LoginOpenHelper(context);
    }

    public void open() {
        database = dbhelper.getWritableDatabase();
    }

    public void close() {
        dbhelper.close();
    }

    public Registration create(Registration registration) {
        ContentValues values = new ContentValues();
        values.put(LoginOpenHelper.COLUMN_EMAIL, registration.getEmail());
        values.put(LoginOpenHelper.COLUMN_PASSWORD, registration.getPassword());
        values.put(LoginOpenHelper.COLUMN_MOBILE, registration.getMobile());

        long insertId = database.insert(LoginOpenHelper.TABLE_REGISTRATION, null, values);
        registration.setRegID(insertId);

        return registration;
    }

    public boolean checkLogin(String email, String password) {
        String query = "SELECT * FROM " + LoginOpenHelper.TABLE_REGISTRATION +
                " WHERE email == '"+email+"' AND password == '"+password+"'";

        Cursor cursor = database.rawQuery(query,null);

        if(cursor.getCount() > 0) {
            return true;
        }

        return false;
    }
}
