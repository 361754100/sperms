package com.smart.sperms.threadpool;

import com.smart.sperms.common.SpringContext;
import com.smart.sperms.common.cache.DevStateCache;
import com.smart.sperms.dao.EquipmentDao;
import com.smart.sperms.enums.DevStateEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 设备状态检测任务
 */
public class DevStateCheckTask implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(DevStateCheckTask.class);

    @Override
    public void run() {
        logger.info("DevStateCheckTask execute...");

        refreshState();
    }

    private void refreshState() {
        long curTimeStamp = System.currentTimeMillis();
        EquipmentDao equipmentDao = SpringContext.getBean(EquipmentDao.class);

        Set<Map.Entry<String, Long>> devHeartSet = DevStateCache.getInstance().getSet();
        if(CollectionUtils.isEmpty(devHeartSet)){
            logger.info("there is no dev heart mark in cache...");
            equipmentDao.updateState(null,
                    String.valueOf(DevStateEnum.OFFLINE.getCode()),
                    String.valueOf(DevStateEnum.ONLINE.getCode()), 1);
            return;
        }
        List<String> online_eIds = new ArrayList<>();
        List<String> offline_eIds = new ArrayList<>();

        String tmpEid = null;
        for(Map.Entry<String, Long> devHeart: devHeartSet) {
            long heartStamp = devHeart.getValue();
            long stampCut = (curTimeStamp - heartStamp)/1000;
            tmpEid = devHeart.getKey();
            // 超过两分钟没更新心跳时间戳，则认为是离线
            if(stampCut > 120) {
                offline_eIds.add(tmpEid);
                DevStateCache.getInstance().remove(tmpEid);
            } else {
                online_eIds.add(tmpEid);
            }
        }
        // 更新设备状态为离线
        if(!CollectionUtils.isEmpty(offline_eIds)) {
            equipmentDao.updateState(offline_eIds,
                    String.valueOf(DevStateEnum.OFFLINE.getCode()),
                    String.valueOf(DevStateEnum.ONLINE.getCode()), 1);
        }
        // 更新设备状态为在线
        if(!CollectionUtils.isEmpty(online_eIds)) {
            equipmentDao.updateState(online_eIds,
                    String.valueOf(DevStateEnum.ONLINE.getCode()),
                    String.valueOf(DevStateEnum.OFFLINE.getCode()), 1);
        }
    }
}
