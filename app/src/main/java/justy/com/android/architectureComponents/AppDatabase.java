/*
package justy.com.justystudy.architectureComponents;

import android.annotation.SuppressLint;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import android.support.annotation.NonNull;

import com.facebook.stetho.common.LogUtil;

import java.util.ArrayList;
import java.util.List;

import StudyApplication;

*/
/**
 * authot justy .
 * Date 2019/2/26 .
 * Time 7:39 PM .
 *//*

@Database(entities = {Order.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase implements OrderDao{
    private static  AppDatabase DB_INSTANCE  ;
    private static String TAG = AppDatabase.class.getSimpleName();

    public abstract OrderDao getOrderDao();

    public AppDatabase() {
        buildDb();
    }

    // 实现类
    public static void buildDb() {
        DB_INSTANCE = Room.
                databaseBuilder(StudyApplication.getIns(), AppDatabase.class, "troy_db")   //  指定数据库名称
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);  //  数据库创建回调；
                        LogUtil.i(TAG, "onCreate");
                    }

                    @Override
                    public void onOpen(@NonNull SupportSQLiteDatabase db) {
                        super.onOpen(db);   //  数据库使用回调；
                        LogUtil.i(TAG, "onOpen");
                    }
                })
                .allowMainThreadQueries()   // 数据库操作可运行在主线程
                .build();

    }


    //  2、插入接口实现
    @Override
    public void insertAll(Order... orders) {
        DB_INSTANCE.beginTransaction();
        try {
            __insertionAdapterOfOrder.insert(orders);
            DB_INSTANCE.setTransactionSuccessful();
        } finally {
            DB_INSTANCE.endTransaction();
        }
    }


    //	2、删除接口实现
    @Override
    public void deleteOrder(Order... orders) {
        DB_INSTANCE.beginTransaction();
        try {
            __deletionAdapterOfOrder.handleMultiple(orders);
            DB_INSTANCE.setTransactionSuccessful();
        } finally {
            DB_INSTANCE.endTransaction();
        }
    }
    //	2、修改接口实现
    @Override
    public void updateOrder(Order... orders) {
        DB_INSTANCE.beginTransaction();
        try {
            __updateAdapterOfOrder.handleMultiple(orders);
            DB_INSTANCE.setTransactionSuccessful();
        } finally {
            DB_INSTANCE.endTransaction();
        }
    }


    //	2、查询接口实现
    @SuppressLint("RestrictedApi")
    @Override
    public List<Order> loadAllOrders() {
        final String _sql = "SELECT * FROM orders";
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
        final Cursor _cursor = DB_INSTANCE.query(_statement);
        try {
            final int _cursorIndexOfOrderId = _cursor.getColumnIndexOrThrow("order_id");
            final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("address");
            final int _cursorIndexOfOwnerName = _cursor.getColumnIndexOrThrow("owner_name");
            final int _cursorIndexOfOwnerPhone = _cursor.getColumnIndexOrThrow("owner_phone");
            final int _cursorIndexOfStreet = _cursor.getColumnIndexOrThrow("street");
            final int _cursorIndexOfState = _cursor.getColumnIndexOrThrow("state");
            final int _cursorIndexOfCity = _cursor.getColumnIndexOrThrow("city");
            final int _cursorIndexOfPostCode = _cursor.getColumnIndexOrThrow("post_code");
            final List<Order> _result = new ArrayList<Order>(_cursor.getCount());
            while(_cursor.moveToNext()) {
                final Order _item;
                final Order.OwnerAddress _tmpOwnerAddress;
                if (! (_cursor.isNull(_cursorIndexOfStreet) && _cursor.isNull(_cursorIndexOfState) && _cursor.isNull(_cursorIndexOfCity) && _cursor.isNull(_cursorIndexOfPostCode))) {
                    _tmpOwnerAddress = new Order.OwnerAddress();
                    _tmpOwnerAddress.street = _cursor.getString(_cursorIndexOfStreet);
                    _tmpOwnerAddress.state = _cursor.getString(_cursorIndexOfState);
                    _tmpOwnerAddress.city = _cursor.getString(_cursorIndexOfCity);
                    _tmpOwnerAddress.postCode = _cursor.getInt(_cursorIndexOfPostCode);
                }  else  {
                    _tmpOwnerAddress = null;
                }
                _item = new Order();
                _item.orderId = _cursor.getLong(_cursorIndexOfOrderId);
                _item.address = _cursor.getString(_cursorIndexOfAddress);
                _item.ownerName = _cursor.getString(_cursorIndexOfOwnerName);
                _item.ownerPhone = _cursor.getString(_cursorIndexOfOwnerPhone);
                _item.ownerAddress = _tmpOwnerAddress;
                _result.add(_item);
            }
            return _result;
        } finally {
            _cursor.close();
            _statement.release();
        }
    }

}
*/
