package com.yuekog.ui.fragment;
import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
/**
 * @author chenj
 * @create by 2015/11/25 15:45
 * @Description
 */
public class FragOperManager {

    /**
     * FragmentActivity 实例
     */
    private FragmentActivity context;

    /**
     * Fragment 管理器
     */
    private FragmentManager fManager;

    /**
     * 装Fragment的容器
     */
    private int containerId;

    /**
     * 该Activity所有fragment的集合
     */
    private List<Fragment> fragments;

    /**
     * @param context     FragmentActivity 实例
     * @param containerId 容器Id
     */
    public FragOperManager(FragmentActivity context, int containerId) {
        super();
        this.context = context;
        this.containerId = containerId;
        fManager = this.context.getSupportFragmentManager();
        fragments = new ArrayList<Fragment>();
    }

    /**
     * @param fragment    要替换的 fragment
     * @param tag         fragment 标签
     * @param isBackStack 是否要回滚
     */
    public void chReplaceFrag(Fragment fragment, String tag, boolean isBackStack) {
        fragments.add(fragment);
        FragmentTransaction fTransaction = fManager.beginTransaction();
        fTransaction.replace(containerId, fragment, tag);
        if (isBackStack) {
            fTransaction.addToBackStack(tag);
        }
        fTransaction.commit();
    }

    /**
     * @param fragment    要替换的 fragment
     * @param tag         fragment 标签
     * @param isBackStack 是否要回滚
     */
    public void chAddFrag(Fragment fragment, String tag, boolean isBackStack) {
        fragments.add(fragment);
        FragmentTransaction fTransaction = fManager.beginTransaction();
        fTransaction.add(containerId, fragment, tag);
        if (isBackStack) {
            fTransaction.addToBackStack(tag);
        }
        fTransaction.commit();
    }

    /**
     * 模拟按下返回键
     *
     * @param name  返回到的Fragment的名字
     * @param flags 模式
     *              FragmentManager.POP_BACK_STACK_INCLUSIVE
     *              if name is null,flags is zero
     */
    public void goBack(String name, int flags) {
        fManager.popBackStack(name, flags);
    }

    /**
     * 通过tag获取到某个Fragment
     *
     * @param tag 标签
     * @return
     */
    public Fragment getAllFragment(String tag) {
        return fManager.findFragmentByTag(tag);
    }

    /**
     * 删除某个Fragment
     *
     * @param fragment 实例
     */
    public void chRemoveFrag(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = fManager.beginTransaction();
            transaction.remove(fragment);
            transaction.commit();
        }
    }

    /**
     * 隐藏Fragment 没有删除view
     *
     * @param fragment
     */
    public void chHideFrag(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = fManager.beginTransaction();
            transaction.hide(fragment);
            transaction.commit();
        }
    }

    /**
     * 显示Fragment
     *
     * @param fragment
     */
    public void chShowFrag(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = fManager.beginTransaction();
            transaction.show(fragment);
            transaction.commit();
        }
    }

    /**
     * 获取所有的Fragment
     *
     * @return
     */
    public List<Fragment> getFragList() {
        return fragments;
    }

    /**
     * 获取Fragment管理器
     *
     * @return
     */
    public FragmentManager getFragManager() {
        return fManager;
    }

    /**
     * 设置容器的Id
     *
     * @param containerId
     */
    public void setContainerId(int containerId) {
        this.containerId = containerId;
    }
}
