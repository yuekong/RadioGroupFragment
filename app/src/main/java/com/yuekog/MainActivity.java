package com.yuekog;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;

import com.yuekog.ui.fragment.FragOperManager;
import com.yuekog.ui.fragment.Fragment01;
import com.yuekog.ui.fragment.Fragment02;
import com.yuekog.ui.fragment.Fragment03;
import com.yuekog.ui.fragment.Fragment04;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    private FragOperManager manager;
    private RadioGroup rdoBtn;
    private Fragment01 fragment01;
    private Fragment02 fragment02;
    private Fragment03 fragment03;
    private Fragment04 fragment04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment01 = new Fragment01();
        fragment02 = new Fragment02();
        fragment03 = new Fragment03();
        fragment04 = new Fragment04();
        manager = new FragOperManager(this, R.id.fragment_container);
        manager.chReplaceFrag(fragment01, "fragment01", false);
        rdoBtn = (RadioGroup) findViewById(R.id.main_rg);
        rdoBtn.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb0:
                manager.chReplaceFrag(fragment01, "fragment01", false);
                break;
            case R.id.rb1:
                manager.chReplaceFrag(fragment02, "fragment02", false);
                break;
            case R.id.rb2:
                manager.chReplaceFrag(fragment03, "fragment03", false);
                break;
            case R.id.rb3:
                manager.chReplaceFrag(fragment04, "fragment04", false);
                break;
        }
    }


}
