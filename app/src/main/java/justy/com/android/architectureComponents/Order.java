package justy.com.android.architectureComponents;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * authot justy .
 * Date 2019/2/26 .
 * Time 7:38 PM .
 */
@Entity(tableName = "orders")
public class Order {

    @PrimaryKey
    @ColumnInfo(name = "order_id")
    public long orderId;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "owner_name")
    public String ownerName;

    @ColumnInfo(name = "owner_phone")
    public String ownerPhone;

    //  指示 Room 需要忽略的字段或方法
    @Ignore
    public String ignoreText;

    @Embedded
    public OwnerAddress ownerAddress;

    static class OwnerAddress {

        public String street;
        public String state;
        public String city;

        @ColumnInfo(name = "post_code")
        public int postCode;
    }
}
