package justy.com.android.architectureComponents;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * authot justy .
 * Date 2019/2/26 .
 * Time 7:39 PM .
 */
@Dao
public interface OrderDao {

    @Query("SELECT * FROM orders")
    List<Order> loadAllOrders();

    @Insert
    void insertAll(Order... orders);

    @Query("SELECT * FROM orders WHERE order_id IN (:orderIds)")
    List<Order> queryOrderById(long[] orderIds);

    @Delete
    void deleteOrder(Order... orders);

    @Update
    void updateOrder(Order... orders);
}

