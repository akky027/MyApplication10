package com.example.appjava.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.appjava.DetailActivity;
import com.example.appjava.ListItem;
import com.example.appjava.R;
import com.example.appjava.adapter.ListItemAdapter;

import java.util.ArrayList;

public class ListFragment extends BaseFragment {

    private int cnt = 0;

    public static ListFragment newInstance(int count){
        // Fragment インスタンス生成
        ListFragment listFragment = new ListFragment();

        // Bundle にパラメータを設定
        Bundle args = new Bundle();
        args.putInt("Counter", count);
        listFragment.setArguments(args);

        return listFragment;
    }

    // FragmentのViewを生成して返す
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public  void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if(args != null){
            int count = args.getInt("Counter");
            String str = "ListFragment:" + String.valueOf(count);
            cnt = count + 1;

            TextView textView = view.findViewById(R.id.textview_01);
            textView.setText(str);
        }

        // ListViewに表示するデータ
        final ArrayList<ListItem> items = new ArrayList<>();

        for(int i=1; i<20; i++){
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);  // 今回はサンプルなのでデフォルトのAndroid Iconを利用
            ListItem item = new ListItem(bmp, "title" + i);
            items.add(item);
        }

        // ListViewをセット
        final ListItemAdapter adapter = new ListItemAdapter(this.getContext(), R.layout.list_items, items);
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        // セルを選択されたら詳細画面フラグメント呼び出す
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Log.d("TEST_TEST", "position:" + position + " id :" + id);

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("ITEM_DATA", Integer.toString(position));
                startActivity(intent);

//                // 詳細画面へ値を渡す
//                DetailFragment fragment = new DetailFragment();
//                Bundle bundle = new Bundle();
//                bundle.putInt("selected",position);
//                fragment.setArguments(bundle);
//
//                // 詳細画面を呼び出す
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                transaction.
//
//                // 戻るボタンで戻ってこれるように
//                transaction.addToBackStack(null);
//                transaction.commit();
            }
        });



        Button button01 = view.findViewById(R.id.button_01);
        button01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                FragmentManager fragmentManager = getFragmentManager();

                if(fragmentManager != null){
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    // BackStackを設定
                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.replace(R.id.container, EditFragment.newInstance(cnt));
                    fragmentTransaction.commit();
                }
            }
        });

        // BackStackで1つ戻す
        Button pop01 = view.findViewById(R.id.pop_01);
        pop01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentManager fragmentManager = getFragmentManager();
                if(fragmentManager != null){
                    fragmentManager.popBackStack();
                }
            }
        });
    }
}
