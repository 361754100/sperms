package com.smart.sperms.common.interceptor;

import com.smart.sperms.utils.DateUtils;
import com.smart.sperms.utils.RsaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.Date;

/**
 * HTTP请求拦截器---校验token
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        String reqUri = request.getRequestURI();
        if(reqUri.contains("/swagger") || reqUri.contains("/v2") || reqUri.contains("/webjars")) {
            return true;
        }
        try {
            String decryptToken = new String(RsaUtil.decryptData(Base64.getDecoder().decode(token)));
            if(!decryptToken.matches("^sperms:\\d{14}$")) {
                logger.error("token author uncorrect... decryptToken ={}", decryptToken);
                return false;
            }

            logger.debug("token author success... decryptToken ={}", decryptToken);

            /*String timeStr = decryptToken.replaceFirst("sperms:","");
            Date reqTime = DateUtils.parseStrToDate(timeStr, "yyyyMMddHHmmss");

            long curTimeStamp = System.currentTimeMillis()/1000;
            long reqTimeStamp = reqTime.getTime()/1000;

            // 如果请求间隔超过 10秒，则认为是无效请求
            long timeCut = curTimeStamp - reqTimeStamp;
            if(timeCut <0l || timeCut > 20l) {
                logger.error("token author timeover... timeCut ={}", timeCut);
                return false;
            }*/
        } catch (Exception e) {
            logger.error("token author error...reqUri ="+ reqUri, e);
            return false;
        }
        return true;
    }
}
