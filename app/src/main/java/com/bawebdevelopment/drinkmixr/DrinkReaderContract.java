package com.bawebdevelopment.drinkmixr;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;
import android.view.ContextThemeWrapper;

/**
 * Created by Bill on 3/21/17.
 */

public final class DrinkReaderContract
{
    private static final String DATABASE_NAME = "drinks.db";
    private static final int DATABASE_VERSION = 1;

    private DrinkReaderContract() {}

    public static class DrinkEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "drinks";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_NAME = "name";
//        public static final String COLUMN_NAME_INGREDIENTS = "ingredients";
        public static final String COLUMN_INSTRUCTIONS = "instructions";
    }

    public static class IngredientEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "ingredients";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_INGREDIENT = "ingredient";
        public static final String COLUMN_DRINK_ID = "drink_id";
    }

    public class DrinkSQLiteHelper extends SQLiteOpenHelper
    {
        private static final String SQL_TABLE_CREATE =
                "CREATE TABLE " + DrinkEntry.TABLE_NAME + " (" +
                    DrinkEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DrinkEntry.COLUMN_NAME + " TEXT NOT NULL" +
                    DrinkEntry.COLUMN_INSTRUCTIONS + " TEXT NULL" +
                ");";

        private static final String SQL_TABLE_DROP =
                "DROP TABLE IF EXISTS " + DrinkEntry.TABLE_NAME;

        public DrinkSQLiteHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(SQL_TABLE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(DrinkSQLiteHelper.class.getName(),
                    "Upgrading database from version " + oldVersion + " to " +
                        newVersion + ", will destroy all old data.");

            db.execSQL(SQL_TABLE_DROP);
            onCreate(db);
        }

        @Override
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            onUpgrade(db, oldVersion, newVersion);
        }
    }

    public class IngredientSQLiteHelper extends SQLiteOpenHelper
    {
        private static final String SQL_TABLE_CREATE =
                "CREATE TABLE " + IngredientEntry.TABLE_NAME + " (" +
                        IngredientEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        IngredientEntry.COLUMN_INGREDIENT + " TEXT NOT NULL" +
                        IngredientEntry.COLUMN_DRINK_ID + " INTEGER NOT NULL" +
                ");";

        private static final String SQL_TABLE_DROP =
                "DROP TABLE IF EXISTS " + IngredientEntry.TABLE_NAME;

        public IngredientSQLiteHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(SQL_TABLE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(DrinkSQLiteHelper.class.getName(),
                    "Upgrading database from version " + oldVersion + " to " +
                            newVersion + ", will destroy all old data.");

            db.execSQL(SQL_TABLE_DROP);
            onCreate(db);
        }

        @Override
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            onUpgrade(db, oldVersion, newVersion);
        }
    }
}
