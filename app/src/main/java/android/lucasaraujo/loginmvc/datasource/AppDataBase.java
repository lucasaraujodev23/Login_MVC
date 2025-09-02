package android.lucasaraujo.loginmvc.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.lucasaraujo.loginmvc.datamodel.UsuarioDataModel;

import androidx.annotation.Nullable;

public class AppDataBase extends SQLiteOpenHelper {
    SQLiteDatabase sqLiteDatabase;
    public static final String NAME = "app.sqlite";
    public static int version = 1;
    public AppDataBase(Context context) {
        super(context, NAME, null, version);
        sqLiteDatabase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(UsuarioDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
