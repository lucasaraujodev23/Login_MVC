package android.lucasaraujo.loginmvc.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.lucasaraujo.loginmvc.datamodel.UsuarioDataModel;

import androidx.annotation.Nullable;

public class AppDataBase extends SQLiteOpenHelper {
    SQLiteDatabase db;
    public static final String DB_NAME = "MVC.sqlite";
    public static int version = 1;
    public AppDataBase(Context context) {
        super(context, DB_NAME, null, version);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsuarioDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
