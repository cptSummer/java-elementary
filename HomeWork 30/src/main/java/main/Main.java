package main;

import com.template.User;
import service.CacheImpl;
//testing
public class Main {
    public static void main(String[] args) {
        User user = new User(1,"Sasha","53564574");
        CacheImpl cache = new CacheImpl();
        System.out.println(cache.isCacheExist("1"));
        cache.put("1","1",user);
        cache.put("1","2","ssss");
        System.out.println(cache.isCacheExist("1"));
        System.out.println(cache.get("1", "1"));
    }
}
