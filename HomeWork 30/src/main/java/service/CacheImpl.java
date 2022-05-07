package service;

import java.util.HashMap;
import java.util.Set;
/*
* @param-> cache #user_id
* @param -> o User
* @param -> key
*
* */
public class CacheImpl implements ICache{
    private HashMap<String,HashMap<String,Object>> cacheMap = new HashMap<>();

    @Override
    public boolean put(String cache, String key, Object o) {

        if(!isCacheExist(cache)){
            HashMap<String,Object> objectHashMap = new HashMap<>();
            objectHashMap.put(key,o);
            cacheMap.put(cache,objectHashMap);
        }else {
            cacheMap.put(cache, (HashMap<String, Object>) new HashMap().put(key, o));
        }
        return true;
    }

    @Override
    public Object get(String cache, String key) { //get object from object map
        return this.cacheMap.get(cache).get(key);
    }

    @Override
    public void clear() { //full clear
        cacheMap = new HashMap<>();

    }

    @Override
    public void clear(String cache) { //object map clear
        cacheMap.remove(cache);
    }

    @Override
    public boolean isCacheExist(String cache) {
      return cacheMap.containsKey(cache);
    }
}
