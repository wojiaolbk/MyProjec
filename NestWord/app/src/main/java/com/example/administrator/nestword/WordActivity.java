package com.example.administrator.nestword;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

public class WordActivity extends AppCompatActivity {

    private EditText mEditText;
    private ListView mListView;
    String url = "http://api.avatardata.cn/ChengYu/Search?key=b4b297263d4d495cad409f615e6c8035";
    private List<WordBean.ResultBean> mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        initView();
    }

    private void initView() {
        mEditText = (EditText) findViewById(R.id.input_text);
        mListView = (ListView) findViewById(R.id.listview);
    }

    public void search(View view) {

        mEditText.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(WordActivity.this.getCurrentFocus().getWindowToken(),

                InputMethodManager.HIDE_NOT_ALWAYS);
        if (!TextUtils.isEmpty(mEditText.getText().toString())) {
            String s = mEditText.getText().toString();
            Map<String, String> params = new HashMap<>();
            params.put("keyWord", s);
            OkGo.post(url).params(params).execute(new StringCallback() {
                @Override
                public void onSuccess(String s, Call call, Response response) {
                    System.out.println(s);
                    parseJson(s);
                }

                @Override
                public void onError(Call call, Response response, Exception e) {
                    super.onError(call, response, e);
                    Toast.makeText(WordActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    private void parseJson(String data) {

        Gson gson = new Gson();
        WordBean wordBean = gson.fromJson(data, WordBean.class);
        mResult = wordBean.getResult();
        if (mResult == null || mResult.size() == 0) {
            Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
        } else {
            setAdapter();
        }
    }

    private void setAdapter() {
        MyAdapter myAdapter = new MyAdapter();
        mListView.setAdapter(myAdapter);
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mResult.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            if (convertView == null) {
                convertView = View.inflate(WordActivity.this, R.layout.item, null);
                holder = new Holder();
                holder.item_text = (TextView) convertView.findViewById(R.id.item_text);
                convertView.setTag(holder);

            } else {
                holder = (Holder) convertView.getTag();
            }
            holder.item_text.setText(mResult.get(position).getName());
            return convertView;
        }

        private class Holder {
            TextView item_text;
        }
    }

}
