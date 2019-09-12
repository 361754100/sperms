package com.smart.sperms.common.cache;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 设备状态缓存
 */
public class DevStateCache {

    private static DevStateCache instance = null;

    private static ConcurrentHashMap<String, Long> devHeartMap = new ConcurrentHashMap<>();

    private static class HolderClass {
        private static final DevStateCache cache = new DevStateCache();
    }

    public static DevStateCache getInstance() {
        if(instance == null) {
            instance = HolderClass.cache;
        }
        return instance;
    }

    /**
     *
     * @param eId           设备ID
     * @param heartStamp    心跳时间戳
     */
    public void put(String eId, long heartStamp) {
        devHeartMap.put(eId, heartStamp);
    }

    /**
     * 移除
     * @param eId
     */
    public void remove(String eId) {
        devHeartMap.remove(eId);
    }

    /**
     * 获取所有数据
     * @return
     */
    public Set<Map.Entry<String, Long>> getSet() {
        return devHeartMap.entrySet();
    }

}
