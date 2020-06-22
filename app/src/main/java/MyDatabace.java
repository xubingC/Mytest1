import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabace extends SQLiteOpenHelper {


    public MyDatabace(Context context) {
        super(context, "my_provider.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student(id integer primary key autoincrement,name varchar(20),age integer)");
        for(int i=0; i<50; i++){
            ContentValues values = new ContentValues();
            values.put("displayName",+i);
            values.put("number",+i);
            values.put("sex",i);
            db.insert("student",null,values);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
