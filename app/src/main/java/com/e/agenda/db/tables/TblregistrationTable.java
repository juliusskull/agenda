package com.e.agenda.db.tables;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class TblregistrationTable {
public static final String TABLE_NAME = "tblregistration";

public static class TblregistrationColumns implements BaseColumns {
public static final String ID="id";
public static final String REGISTRATION_ID="registration_id";

public static  String[] getColumns(){
return new String[] {  _ID,ID,REGISTRATION_ID};


		}

	}


	public static void onCreate(SQLiteDatabase db, Context context) {
    StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE " + TABLE_NAME + " (");
		sb.append(BaseColumns._ID + " INTEGER PRIMARY KEY, ");
		sb.append(TblregistrationColumns.ID + " INTEGER , ");
sb.append(TblregistrationColumns.REGISTRATION_ID + " TEXT  ");


		sb.append(");");
		db.execSQL(sb.toString());
	}

	public static void onUpgrade(SQLiteDatabase db, int oldVersion,
			int newVersion, Context context) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(db, context);
}
	public static void onUpgrade2(SQLiteDatabase db, Context context) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(db, context);
}
}