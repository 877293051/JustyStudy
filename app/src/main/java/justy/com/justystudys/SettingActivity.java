package justy.com.justystudys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import justy.com.justystudy.R;

public class SettingActivity extends BaseActivity {

    @BindView(R.id.button)
    Button mGoBth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_setting);
        super.onCreate(savedInstanceState);
        mGoBth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(SettingActivity.this,MainActivity.class);
                startActivity(i);//如果跳转上一个启动activity，会自动finish
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
