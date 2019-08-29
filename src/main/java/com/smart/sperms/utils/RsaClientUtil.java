package com.smart.sperms.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

/**
 * RSA公钥 的工具类
 *
 * RSA是目前最有影响力的公钥加密算法，该算法基于一个十分简单的数论事实：
 * 将两个大素数相乘十分容易，但那时想要对其乘积进行因式分解却极其困难，因此可以将乘积公开作为加密密钥，即公钥，而两个大素数组合成私钥。
 * 公钥是可发布的供任何人使用，私钥则为自己所有，供解密之用。
 *
 * RSA算法实现过程中提到(N,e)是公钥，(N,d)是私钥。既然已经获取到了PublicKey和PrivateKey了，那如何取到N、e、d这三个值呢。
 * 要取到这三个值，首先要将PublicKey和PrivateKey强制转换成RSAPublicKey和RSAPrivateKey。共同的N值可以通过getModulus()获取。
 * 执行RSAPublicKey.getPublicExponent()可以获取到公钥中的e值，执行RSAPrivateKey.getPrivateExponent()可以获取私钥中的d值。
 *
 * 由于程序中动态生成KeyPair对明文加密后生成的密文是不可测的，所以在实际开发中通常在生成一个KeyPair后将公钥和私钥的N、e、d这三个特征值记录下来，在真实的开发中使用这三个特征值再去将PublicKey和PrivateKey还原出来。
 *
 * @author Mojianzhang
 *
 */
public class RsaClientUtil {

	public static final String KEY_ALGORITHM = "RSA";
	private static final String PUBLIC_MODULUS = "MTEzMDMzMzE5MTI5ODIxNDMyNzcwNzQ3NzM1NTcwMjU1OTcxMDI2NDQwNzAxODg1NTcwNDczOTgwOTE5NjE2MTY5NjMyMTQxOTY1Mjc2Mzg1NjUyNjA3NTc0NjU1OTE1MTkxOTg5MzUyODkwNTg1NTg1MjIzMTE1OTgyNzQ4MzA5Mjg0MDIyODg5MzE1MTc0MDU0MzA2MTY3MzAxNTQ4MzY1OTM0MDc1MTA2MTE2NDcyMDk0MjU3NTI3ODg5ODA4NjUzMzU0Nzk0ODc2Mzg3NjEzOTA4NDE4MzQxMjk1MzMyNDkzMjkwODc0NDY4NTkyMzQ1NTc1NjUyNzY3ODY2MjM0MTM4NTA3NTgzNDQ1NjczMzk1MDA1Mjk1NDE2MTAzMDY3MjY0ODgxNDUzNDczMDEyOTQz";
	private static final String PUBLIC_EXPONENT = "NjU1Mzc=";

	private static PublicKey pubKey = null;

	private static Logger logger = LoggerFactory.getLogger(RsaClientUtil.class);

	/**
	 * 解码返回byte
	 *
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64(String key) throws Exception {
		return Base64.getDecoder().decode(key);
	}

	/**
	 * 编码返回字符串
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(byte[] key) throws Exception {
		return new String(Base64.getEncoder().encode(key), "UTF-8");
	}


	/**
	 * 使用指定的公钥加密数据。
	 *
	 * @param pubKey 给定的公钥。
	 * @param data 要加密的数据。
	 * @return 加密后的数据。
	 */
	public static byte[] encryptData(byte[] data, PublicKey pubKey) {
		try {
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			return cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 使用指定的公钥加密数据。
	 *
	 * @param dataStr 要加密的数据。
	 * @return 加密后的数据。
	 */
	public static byte[] encryptData(String dataStr) {
		try {
			byte[] data = dataStr.getBytes("UTF-8");
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);

			if(pubKey == null) {
				//1.根据 N、E、D值还原 公钥
				String modulus_str = new String(Base64.getDecoder().decode(PUBLIC_MODULUS.getBytes("UTF-8")));
				String exponent_str = new String(Base64.getDecoder().decode(PUBLIC_EXPONENT.getBytes("UTF-8")));
				pubKey =  RsaClientUtil.restorePublicKey(modulus_str, exponent_str);
			}

			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			return cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据N、E值 还原公钥
	 *
	 * @param modulus
	 * @param publicExponent
	 * @return
	 */
	public static PublicKey restorePublicKey(String modulus, String publicExponent) {
		try {
			BigInteger bigIntModulus = new BigInteger(modulus);
			BigInteger bigIntPrivateExponent = new BigInteger(publicExponent);
			RSAPublicKeySpec keySpec = new RSAPublicKeySpec(bigIntModulus, bigIntPrivateExponent);
			KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
			pubKey = keyFactory.generatePublic(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pubKey;
	}

	/**
	 * 使用指定的私钥解密数据。
	 *
	 * @param data 要解密的数据。
	 * @return 原数据。
	 */
	public static byte[] decryptData(byte[] data) {
		try {
			if(pubKey == null) {
				//1.根据 N、E、D值还原 公钥
				String modulus_str = new String(Base64.getDecoder().decode(PUBLIC_MODULUS.getBytes("UTF-8")));
				String exponent_str = new String(Base64.getDecoder().decode(PUBLIC_EXPONENT.getBytes("UTF-8")));
				pubKey =  RsaClientUtil.restorePublicKey(modulus_str, exponent_str);
			}
//			RSAPrivateKey priKey = (RSAPrivateKey)KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(data));
			Cipher ci = Cipher.getInstance(KEY_ALGORITHM);
			ci.init(Cipher.DECRYPT_MODE, pubKey);
			return ci.doFinal(data);
		} catch (Exception e) {
			logger.error("======error======", e);
			return null;
		}
	}


	public static void main(String[] args) {
		try {

//    		byte[] encryData = RsaClientUtil.encryptData("Nexwise_opengw_key_111");
//			String baseEncryData = Base64.getEncoder().encodeToString(encryData);
//			logger.info("baseEncryData="+ baseEncryData  );

//			RsaClientUtil.decryptBASE64("fB8zUx77xSJIqyqq/+VTgNwrGqSOM8g0MskP35iCqM0f1BTI9xYuB28kJaDBZ1RkF6fyEN/3V3o+smCuL2zSIn4D68Rn3vxdLr6z8sXQvpjb0K/wpXRkqx7HhfJ7fty/nW1vfLFY0WqsRY4YnUwupIHw7qKM0uNXrnsMwoAODjw=");

			String encryDatas = "UO3HUwVeHommDfUQUZD6FtaruHXq3H3NCatDH7LD7Rmflc2/2sPcVwPN0SKNlZxT6mKCoIBfZoY/K7s7m12opSv1mnSfTn07SpieolMMFUbOLBzt12oE3PFSvG1IKT+YIk5wiWOWqE++ooYd5oTWTmwRoImK4IxbLN20a0NXJB4=";
			//--解密数据
			String decryDatas = new String(RsaClientUtil.decryptBASE64(encryDatas), "UTF-8");
			System.out.println("decryDatas = "+ decryDatas);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
