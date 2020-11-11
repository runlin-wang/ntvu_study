package com.example.happylittlesecretary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etId, etTitle, etMessage, etDate;
    private SQLiteDatabase db;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        db = this.openOrCreateDatabase("information", Context.MODE_PRIVATE, null);
        createTable();
    }

    public void createTable() {
        String sql = "create table if not exists information(_id text primary key, title text, message text, date text)";    // 创建数据表的 SQL 语句
        db.execSQL(sql);
    }

    public void init() {
        etId = this.findViewById(R.id.editText);
        etTitle = this.findViewById(R.id.editText2);
        etMessage = this.findViewById(R.id.editText3);
        etDate = this.findViewById(R.id.editText4);
        lv = this.findViewById(R.id.listView);
    }

    public void add(View view) {
        String id = etId.getText().toString();
        String title = etTitle.getText().toString();
        String message = etMessage.getText().toString();
        String date = etDate.getText().toString();
        // 创建 ContentValues，用于存放每条数据的字段值
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("message", message);
        values.put("_id", id);
        values.put("date", date);
        // 调用 insert() 方法插入记录，插入数据成功则返回插入记录在数据表中的行号，插入数据不成功则返回数据值 -1，可以依此来判断是否插入记录成功
        long i = db.insert("information", null, values);
        Toast.makeText(this, i >= 0 ? "添加成功" : "添加失败", Toast.LENGTH_SHORT).show();
    }

    /**
     * 将 information 数据表中的数据信息显示在 listView 组件上
     * @param view 视图
     */
    public void refresh(View view) {
        Cursor c = db.query("information", null, null, null, null, null, null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.item, c, new String[]{"_id", "title", "message", "date"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4});
        lv.setAdapter(adapter);
    }

    public void delete(View view) {
        String id = etId.getText().toString();
        int i = db.delete("information", "_id=?", new String[]{id});
        Toast.makeText(this, i > 0 ? "删除成功" : "删除失败", Toast.LENGTH_SHORT).show();
    }

    public void update(View view) {
        String id = etId.getText().toString();
        String title = etTitle.getText().toString();
        String message = etMessage.getText().toString();
        String date = etDate.getText().toString();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("message", message);
        values.put("date", date);
        db.update("information", values, "_id=?", new String[]{id});
    }

    public void find(View view) {
        String value = etId.getText().toString();
        Cursor c = db.query("information", null, "_id=?", new String[]{value}, null, null, null);
        if (c.getCount() > 0) {
            c.moveToFirst();
            String id = c.getString(c.getColumnIndex("_id"));
            etId.setText(id);
            String title = c.getString(c.getColumnIndex("title"));
            etTitle.setText(title);
            String message = c.getString(c.getColumnIndex("message"));
            etMessage.setText(message);
            String date = c.getString(c.getColumnIndex("date"));
            etDate.setText(date);
        }
    }

}
