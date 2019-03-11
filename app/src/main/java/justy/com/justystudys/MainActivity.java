package justy.com.justystudys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import justy.com.justystudy.R;
import justy.com.justystudys.observability.ui.UserActivity;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bth_go)
    Button mGoBth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        mGoBth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,UserActivity.class);
                startActivity(i);
              //  ARouter.getInstance().build(Constant.ACTIVITY_USER).navigation();
            }
        });
    }

    private void studyBrodcast(){

    }

}
