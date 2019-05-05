import redis.clients.jedis.Jedis;

public class testRedisUtil {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("47.100.226.134",6379);//创建客户端，设置IP地址和端口号
        jedis.auth("1234");//密码认证
        System.out.println(jedis.get("testKey"));//获取之前存的testKey对应的值
        jedis.set("testKey","test222");//设置值
        System.out.println(jedis.get("testKey"));//再次获取
        jedis.close();//关闭连接释放资源
    }
}
