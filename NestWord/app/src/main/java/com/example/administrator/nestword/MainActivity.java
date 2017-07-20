package com.example.administrator.nestword;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.weyye.hipermission.HiPermission;
import me.weyye.hipermission.PermissionCallback;
import me.weyye.hipermission.PermissionItem;


public class MainActivity extends AppCompatActivity {


    private NoScrollGridView mGridView;
    private ArrayList<String> mNames;
    private ArrayList<Integer> mIcons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO: 2017/7/20 0020 heheheh
        // TODO: what are you doing now ? wastring your life?


        initPer();
        mGridView = (NoScrollGridView) findViewById(R.id.gridView);
        mNames = new ArrayList<>();
        mNames.add("成语接龙");
        mNames.add("指纹识别");
        mNames.add("计算器");
        mNames.add("定位");
        mNames.add("天气");
        mIcons = new ArrayList<>();
        mIcons.add(R.drawable.chengyu);
        mIcons.add(R.drawable.finger);
        mIcons.add(R.drawable.jisuanqi);
        mIcons.add(R.drawable.location);
        mIcons.add(R.drawable.tianqi);
        mGridView.setAdapter(new PayAndResultAdapter());
    }

    private void initPer() {
        List<PermissionItem> permissionItems = new ArrayList<PermissionItem>();
        permissionItems.add(new PermissionItem(Manifest.permission.USE_FINGERPRINT, "USE_FINGERPRINT", R.drawable.permission_ic_location));
        permissionItems.add(new PermissionItem(Manifest.permission.ACCESS_COARSE_LOCATION, "USE_FINGERPRINT", R.drawable.permission_ic_location));
        permissionItems.add(new PermissionItem(Manifest.permission.ACCESS_FINE_LOCATION, "USE_FINGERPRINT", R.drawable.permission_ic_location));
        permissionItems.add(new PermissionItem(Manifest.permission.ACCESS_NETWORK_STATE, "USE_FINGERPRINT", R.drawable.permission_ic_location));
        permissionItems.add(new PermissionItem(Manifest.permission.ACCESS_WIFI_STATE, "USE_FINGERPRINT", R.drawable.permission_ic_location));
        permissionItems.add(new PermissionItem(Manifest.permission.INTERNET, "USE_FINGERPRINT", R.drawable.permission_ic_location));
        permissionItems.add(new PermissionItem(Manifest.permission.READ_PHONE_STATE, "USE_FINGERPRINT", R.drawable.permission_ic_location));
        permissionItems.add(new PermissionItem(Manifest.permission.WRITE_EXTERNAL_STORAGE, "USE_FINGERPRINT", R.drawable.permission_ic_location));
        permissionItems.add(new PermissionItem(Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS, "USE_FINGERPRINT", R.drawable.permission_ic_location));
        permissionItems.add(new PermissionItem(Manifest.permission.BLUETOOTH, "USE_FINGERPRINT", R.drawable.permission_ic_location));
        HiPermission.create(MainActivity.this)
                .permissions(permissionItems)
                .checkMutiPermission(new PermissionCallback() {
                    @Override
                    public void onClose() {

                    }

                    @Override
                    public void onFinish() {
                        //Toast.makeText(mContext, "Success", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onDeny(String permission, int position) {

                    }

                    @Override
                    public void onGuarantee(String permission, int position) {

                    }
                });
    }

    private class PayAndResultAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mNames.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final Holder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.easy_scan_item, null);
                holder = new Holder();
                holder.name = (TextView) convertView.findViewById(R.id.itemText);
                holder.childLayout = (LinearLayout) convertView.findViewById(R.id.gridItemId);
                holder.icon = (ImageView) convertView.findViewById(R.id.itemImage);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }
            holder.name.setText(mNames.get(position));
            holder.icon.setImageResource(mIcons.get(position));
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (position) {
                        case 0:
                            startActivity(new Intent(MainActivity.this, WordActivity.class));
                            break;
                        case 1:
                            startActivity(new Intent(MainActivity.this, FingerActivity.class));
                            break;
                        case 2:
                            startActivity(new Intent(MainActivity.this, CountActivity.class));
                            break;
                        case 3:
                            startActivity(new Intent(MainActivity.this, LocationActivity.class));
                            break;
                        case 4:
                            startActivity(new Intent(MainActivity.this, WeatherActivity.class));
                            break;
                    }
                }
            });
            return convertView;
        }

        class Holder {
            TextView name;
            LinearLayout childLayout;
            ImageView icon;
        }
    }

}
