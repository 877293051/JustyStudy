package justy.com.android.architectureComponents;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.facebook.stetho.common.LogUtil;

/*
 * authot justy .
 * Date 2019/2/25 .
 * Time 8:45 PM .
 */

public class UserViewModel extends ViewModel
        implements BaseViewModel<MyUser> {

    private String TAG = UserViewModel.class.getSimpleName();

    private MutableLiveData<MyUser> liveUser;

    public MutableLiveData<MyUser> getData(){
        if(liveUser == null){
            liveUser = new MutableLiveData<MyUser>();
        }
        return this.liveUser;
    }

    public void changeData(){
        if(liveUser != null){
            liveUser.setValue(loadData());
        }
    }

    @Override
    public MyUser loadData() {
        MyUser myUser = new MyUser();
        myUser.userId = "tang";
        myUser.name = "123";
        myUser.phone = "151";
        LogUtil.i(TAG, "loadData(): " + myUser.toString());
        return myUser;
    }

    @Override
    public void clearData() {

    }
}

