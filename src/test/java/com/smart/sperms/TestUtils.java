package com.smart.sperms;

import com.smart.sperms.utils.RsaUtil;
import com.smart.sperms.utils.XxteaUtils;
import org.junit.Test;

public class TestUtils {

    @Test
    public void testMqttMsg() {
        String message = "hello 123";
        String key = "25fd36gfegl";
        try {
            String encryptData = XxteaUtils.encryptToHexString(message, key);
            System.out.println("encryptPayload = "+ encryptData);

            String decryptData = XxteaUtils.decryptFromHexString(encryptData, key);
            System.out.println("decryptPayload = "+ decryptData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStr() {
        String decryptToken = "sperms:201908301123311";
        boolean isOk = decryptToken.matches("^sperms:\\d{14}$");
        System.out.println("isOk = "+ isOk);
    }
}
