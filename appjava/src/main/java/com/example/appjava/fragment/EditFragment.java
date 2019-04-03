package com.example.appjava.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.appjava.R;

public class EditFragment extends BaseFragment {

    private int cnt = 0;

    public static EditFragment newInstance(int count){
        // EditFragment インスタンス生成
        EditFragment editFragment = new EditFragment();

        // Bundleにパラメータを設定
        Bundle barg = new Bundle();
        barg.putInt("Counter", count);
        editFragment.setArguments(barg);

        return editFragment;
    }

    // FragmentのViewを生成して返す
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return  inflater.inflate(R.layout.fragment_edit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if(args != null){
            int count = args.getInt("Counter");
            String str = "EditFragment:" + String.valueOf(count);
            cnt = count +1;

            TextView textView = view.findViewById(R.id.textview_02);
            textView.setText(str);
        }

        Button button02 = view.findViewById(R.id.button_02);
        button02.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                FragmentManager fragmentManager = getFragmentManager();
                if(fragmentManager != null){
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // BackStackを設定
                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.replace(R.id.container, ListFragment.newInstance(cnt));
                    fragmentTransaction.commit();
                }
            }
        });

        // BackStackで1つ戻す
        Button pop2 = view.findViewById(R.id.pop_02);
        pop2.setOnClickListener(new View.OnClickListener(){
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
