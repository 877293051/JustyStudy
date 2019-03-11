package justy.com.justystudys.architectureComponents;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import justy.com.justystudy.R;

/**
 * 1.1、Android Architecture Components 介绍
 Android Architecture Components 是谷歌在Google I/O 2017发布一套帮助开发者解决Android 架构设计的方案。里面包含了两大块内容：
 生命周期相关的 Lifecycle-aware Components
 数据库解决方案 Room
 1.2、组件功能
 官方给予 Google 组件的功能：A collection of libraries that help you design robust, testable, and maintainable apps. Start with classes for managing your UI component lifecycle and handling data persistence。
 使用Google 提供的处理数据持久化和管理组件生命周期的类，有助于应用开发者们构建更加鲁棒性，可测的，稳定可靠的应用。
 提供主要的组件有：
 Lifecycle：管理组件生命周期
 Room: 持久化数据结构
 作者：玉刚说
 链接：https://juejin.im/post/5b30e39bf265da599423510a
 来源：掘金
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MvpActivity extends AppCompatActivity implements LifecycleOwner{

    private LifecycleRegistry mLifecycleRegistry;
    private TextView mTv;
    private Button mBt;
    private UserViewModel   mUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        mTv = findViewById(R.id.textView);
        mBt = findViewById(R.id.button);
        mLifecycleRegistry = new LifecycleRegistry(this);
        // 注册需要监听的 Observer
        mLifecycleRegistry.addObserver(new ActivityLifeObserver());
        studyLiveData();
    }

    private void studyLiveData() {
        mUserViewModel  = ViewModelProviders.of(this).get(UserViewModel.class);
        mUserViewModel.getData().observe(this, new Observer<MyUser>() {
            @Override
            public void onChanged(@Nullable MyUser myUser) {
                if(myUser != null){
                    mTv.setText(myUser.toString());
                }
            }
        });
        //	改变 MyUser 内容
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mUserViewModel != null && mUserViewModel.getData() != null){
                    mUserViewModel.changeData();
                }
            }
        });
//	setValue
    }

    private void studyRoom() {
    }


    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }
}
