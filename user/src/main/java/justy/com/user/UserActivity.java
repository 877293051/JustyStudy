package justy.com.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import justy.com.base.common.Constant;
import justy.com.myUser.R;

@Route(path= Constant.ACTIVITY_USER)
public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ARouter.getInstance().inject(this);
    }
}