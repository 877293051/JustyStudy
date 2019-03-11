package justy.com.justystudys.architectureComponents;

/**
 * authot justy .
 * Date 2019/2/25 .
 * Time 8:45 PM .
 */
public class MyUser {
    public String userId;

    public String name;

    public String phone;

    @Override
    public String toString() {
        return "MyUser{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
