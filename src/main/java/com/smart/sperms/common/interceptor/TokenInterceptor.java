package com.smart.sperms.common.interceptor;

import com.smart.sperms.utils.DateUtils;
import com.smart.sperms.utils.RsaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        try {
            String decryptToken = new String(RsaUtil.decryptBASE64(token),"UTF-8");
            if(!decryptToken.matches("^sperms:\\d{14}$")) {
                return false;
            }

            String timeStr = decryptToken.replaceFirst("sperms:","");
            Date reqTime = DateUtils.parseStrToDate(timeStr, "yyyyMMddHHmmss");

            long curTimeStamp = System.currentTimeMillis()/1000;
            long reqTimeStamp = reqTime.getTime()/1000;

            // 如果请求间隔超过 10秒，则认为是无效请求
            if((curTimeStamp - reqTimeStamp) > 10) {
                return false;
            }
        } catch (Exception e) {
            logger.error("token author error...", e);
            return false;
        }
        return true;
    }
}
