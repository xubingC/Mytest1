import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyContentProvider extends ContentProvider {
    SQLiteDatabase database;
    static final String TABLE_NAME="contacts";


    @Override
    public boolean onCreate() {
        MyDatabace myHelper = new MyDatabace(getContext());
        database = myHelper.getWritableDatabase();
        if(database==null){
            return  false;
        }else{
            return true;
        }
    }

    //查询
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor query = database.query(TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
        return query;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    //增加
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        database.insert(TABLE_NAME,null,values);
        return uri;
    }

    //删除
    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return database.delete(TABLE_NAME,selection,selectionArgs);
    }

    //修改
    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return database.update(TABLE_NAME,values,selection,selectionArgs);
    }
}
