package com.smart.sperms.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
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

	private static final String PUBLIC_MODULUS = "MTA4ODc2MzgxOTQ5NTE5MTc3NjQ2NTQ3OTY1OTM3MDUzNDMzNjE4NzkyMzA2NzU2NDc1MTczOTIxMzk5ODAxNTk1OTU3MTU4NTIzNDgyNzEzMjU3MTUzMDIxMjE5NzAwMDI3MjM1NTI1MDQzODE5NDk3NTUzMzA1MzMyMDk1NjUzNjUzMzM5NTAwMzEyNjM1NjE0OTQwMTI3MjY4OTA2MzYxNDg5OTkwMTU3MDk2NjI3OTE2NDkxNTkwNDg5NDgzMTcxOTk0MjkxNDY5NTE5NjUyNDE0MzI4NzYxNjk1MzQwNTIyMTU0NTIyMjE1NDEzMjcxNjYxMzU3MzM5MjgzNjU5ODMzNDc2MjkxMTI4ODk3NzgzMzE0OTQzOTAzOTYwNDQ3NzgyMTc5MzMxOTkyNDEwNjk5";
	private static final String PUBLIC_EXPONENT = "NjU1Mzc=";

//	private static final String PRIVATE_MODULUS = "";
//	private static final String PRIVATE_EXPONENT = "";

	private static PublicKey pubKey = null;
//	private static PrivateKey priKey = null;

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
			BigInteger bigIntPublicExponent = new BigInteger(publicExponent);
			RSAPublicKeySpec keySpec = new RSAPublicKeySpec(bigIntModulus, bigIntPublicExponent);
			KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
			pubKey = keyFactory.generatePublic(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pubKey;
	}

	/**
	 * 根据N、E值 还原私钥
	 *
	 * @param modulus
	 * @param privateExponent
	 * @return

	public static PrivateKey restorePrivateKey(String modulus, String privateExponent) {
		try {
			BigInteger bigIntModulus = new BigInteger(modulus);
			BigInteger bigIntPrivateExponent = new BigInteger(privateExponent);
			RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(bigIntModulus, bigIntPrivateExponent);
			KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
			priKey = keyFactory.generatePrivate(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return priKey;
	}
	 */

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
    		byte[] encryData = RsaClientUtil.encryptData("sperms:2019-08-29 17:26:11");
			String baseEncryData = Base64.getEncoder().encodeToString(encryData);
			logger.info("baseEncryData="+ baseEncryData  );

			/*
			//公钥不具备解密功能
			String data = "gYEWimIFKZQScdFojL4I/Gju9DNtL4XuV/9DeyvMfGR3hvP+4AJ8KbpLddG4I1h+NkKinUZ8rIO4bA8ESZ/0i2mLFXtYrVZnKw2gEDQYViFgesqCF+9QfwImjbj5kxkcnzmSxwm0KNTzvTSFnbiwX8PFljJejT6OmZLhxpK7AuM=";
			String decryData = new String(RsaClientUtil.decryptData(Base64.getDecoder().decode(data)));
			logger.info("decryData ="+ decryData);
			*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
