/**
 * 
 */
package com.wk.access.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @author sunsc
 *
 */
public class CodecHelper {
	/**
	 *
	 * @param buf
	 * @param str
	 */
	public static void encodeString(ByteBuf buf, String str, int length) {
		if(str == null) {
			for(int i = 0; i < length; ++i)
				buf.writeByte(0x00);
			return;
		}

		byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
		if(bytes.length > length)
			buf.writeBytes(bytes, 0, length);
		else {
			buf.writeBytes(bytes);
			for(int i = bytes.length; i < length; ++i) {
				buf.writeByte(0x00);
			}
		}
	}

	/**
	 *
	 * @param buf
	 * @param length
	 * @return
	 */
	public static String decodeString(ByteBuf buf, int length) {
		byte[] bytes = new byte[length];
		buf.readBytes(bytes);

		int len = 0;
		while(len < length) {
			if(((bytes[len] >= 'a' ) && (bytes[len] <= 'z'))
					|| ((bytes[len] >= 'A' ) && (bytes[len] <= 'Z'))
					|| ((bytes[len] >= '0') && (bytes[len] <= '9'))
					) {
				++len;
			} else
				break;
		}

		if(len == 0)
			return null;
		else
			return new String(bytes, 0, len, Charset.forName("US-ASCII"));
	}

	public static byte[] strToBytes(String text, int len) {
		byte[] bytes=new byte[len];
		if(text==null || text.equals("")) {
			for(int i = 0; i < len; i++)
				bytes[i]=0x00;
			return bytes;
		}

		byte[] strBytes = text.getBytes(Charset.forName("UTF-8"));
		if(strBytes.length >=len){
			for(int i = 0; i < len;i++)
				bytes[i]=strBytes[i];
			return bytes;
		}else {
			for(int i = 0; i < strBytes.length; i++)
				bytes[i]=strBytes[i];
			for(int i = strBytes.length; i < len; i++)
				bytes[i]=0x00;
			return bytes;
		}

	}
	public static byte[] intToBytes(int data,int len){
		byte[]  bytes= new byte[len];
		if(len>4){
			for(int i=0; i<len-4;i++){
				bytes[i]=0x00;
			}
			for(int i=4;i<0;i--){
				bytes[len-i]= (byte) (data >> (8*i-8) &0x00FF);
			}
		}else {
			for(int i=len;i>0;i--){
				bytes[len-i]= (byte) (data >> (8*i-8) &0x00FF);
			}
		}
		return bytes;
	}
	public static byte[] longToBytes(long data,int len){
		byte[]  bytes= new byte[len];
		if(len>8){
			for(int i=0; i<len-8;i++){
				bytes[i]=0x00;
			}
			for(int i=8;i<0;i--){
				bytes[len-i]= (byte) (data >> (8*i-8) &0x00FF);
			}
		}else {
			for(int i=len;i<0;i--){
				bytes[len-i]= (byte) (data >> (8*i-8) &0x00FF);
			}
		}
		return bytes;
	}
//	/**
//	 *
//	 * @param str
//	 * @return
//	 */
//	public static String redecode(byte[] bytes) {
//		byte[] bs = new byte[bytes.length / 2];
//		for(int i = 0, j = 0; i < bs.length; ++i) {
//			if(Character.isDigit(bytes[j])) {
//				bs[i] = (byte) (((byte) (bytes[j] - '0')) << 4);
//			} else if(Character.isAlphabetic(bytes[j])) {
//				bs[i] = (byte) ((bytes[j] - 'A') << 4);
//			}
//			++j;
//			if(Character.isDigit(bytes[j])) {
//				bs[i] |= ((byte) (bytes[j] - '0'));
//			} else if(Character.isAlphabetic(bytes[j])) {
//				bs[i] |= (bytes[j] - 'A') ;
//			}
//			++j;
//		}
//
//		return new String(bs, Charset.forName("US-ASCII"));
//	}
	public static String bytesToHex(byte[] bytes){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<bytes.length;i++){
			sb.append(String.format("%02x",bytes[i]));
		}
		return sb.toString();
	}
	public static String strToAsc(String str){
		StringBuilder sb = new StringBuilder();
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			sb.append(String.format("%02x", Integer.valueOf(ch[i]).intValue()));// 加空格
		}
		return sb.toString();
	}
	public static String ascToStr(String hexStr) {
		int len = hexStr.length();
		hexStr = hexStr.toUpperCase();
		byte[] des;
		if (len % 2 != 0 || len == 0) {
			return null;
		} else {
			int halfLen = len / 2;
			des = new byte[halfLen];
			char[] tempChars = hexStr.toCharArray();
			for (int i = 0; i < halfLen; ++i) {
				char c1 = tempChars[i * 2];
				char c2 = tempChars[i * 2 + 1];
				int tempI = 0;
				if (c1 >= '0' && c1 <= '9') {
					tempI += ((c1 - '0') << 4);
				} else if (c1 >= 'A' && c1 <= 'F') {
					tempI += (c1 - 'A' + 10) << 4;
				} else {
					return null;
				}
				if (c2 >= '0' && c2 <= '9') {
					tempI += (c2 - '0');
				} else if (c2 >= 'A' && c2 <= 'F') {
					tempI += (c2 - 'A' + 10);
				} else {
					return null;
				}
				des[i] = (byte) tempI;
				// System.out.println(des[i]);
				//820202010001180111204353
				//820202010001180111204353
				//820202010001180111204353
			}
			return new String(des, Charset.forName("utf-8"));
		}
	}
	/** *
	 * @函数功能: BCD码转为10进制串(阿拉伯数据)
	 * @输入参数: BCD码
	 * @输出结果: 10进制串
	 */
	public static String bcd2Str(byte[] bytes){
		if (null == bytes || bytes.length == 0)
		{
			return "";
		}
		else
		{
			// 存储转码后的字符串
			StringBuilder sb = new StringBuilder();

			// 循环数组解码
			for (int i = 0; i < bytes.length; i++)
			{
				// 转换低字节
				int low = (bytes[i] & 0x0f);
				sb.append(low);

				// 转换高字节
				int high = ((bytes[i] & 0xf0) >> 4);

				// 如果高字节等于0xf说明是补的字节，直接抛掉
				if (high != 0x0f)
				{
					sb.append(high);
				}
			}

			// 返回解码字符串
			return sb.toString();
		}
	}
	public static String bcd2Str2(byte[] bytes){
		if (null == bytes || bytes.length == 0){
			return "";
		}else{
			// 存储转码后的字符串
			StringBuilder sb = new StringBuilder();

			// 循环数组解码
			for (int i = 0, len = bytes.length; i < len; i++){
				// 转换高字节
				int high = ((bytes[i] & 0xf0) >> 4);
				// 如果高字节等于0xf说明是补的字节，直接抛掉
				if (high != 0x0f){
					sb.append(high);
				}
				// 转换低字节
				int low = (bytes[i] & 0x0f);
				sb.append(low);
			}

			// 返回解码字符串
			return sb.toString();
		}
	}
	public static String bcd2Str3(byte[] bytes){
		if (null == bytes || bytes.length == 0){
			return "";
		}else{
			// 存储转码后的字符串
			StringBuilder sb = new StringBuilder();
			// 循环数组解码
			for (int i = 0; i < bytes.length; i++){
				// 转换高字节
				int high = ((bytes[i] & 0xf0) >> 4);
				// 如果高字节等于0xf说明是补的字节，直接抛掉
				if (high != 0x0f){
					sb.append(high);
				}
				// 转换低字节
				int low = (bytes[i] & 0x0f);
				sb.append(low);
			}
			// 返回解码字符串
			return sb.toString();
		}
	}
	/**
	 * @函数功能: 10进制串转为BCD码
	 * @输入参数: 10进制串
	 * @输出结果: BCD码
	 */
	public static byte[] str2Bcd(String asc) {
		int len = asc.length();
		int mod = len % 2;

		if (mod != 0) {
			asc = "0" + asc;
			len = asc.length();
		}

		byte abt[] = new byte[len];
		if (len >= 2) {
			len = len / 2;
		}

		byte bbt[] = new byte[len];
		abt = asc.getBytes();
		int j, k;

		for (int p = 0; p < asc.length()/2; p++) {
			if ( (abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
				j = abt[2 * p] - '0';
			} else if ( (abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
				j = abt[2 * p] - 'a' + 0x0a;
			} else {
				j = abt[2 * p] - 'A' + 0x0a;
			}

			if ( (abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
				k = abt[2 * p + 1] - '0';
			} else if ( (abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
				k = abt[2 * p + 1] - 'a' + 0x0a;
			}else {
				k = abt[2 * p + 1] - 'A' + 0x0a;
			}

			int a = (j << 4) + k;
			byte b = (byte) a;
			bbt[p] = b;
		}
		return bbt;
	}
	public static byte[] hexStringToBytes(String hexString)
	{
		if (hexString == null || hexString.equals(""))
		{
			return null;
		}

		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++)
		{
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}
	public static byte[] DecodeBytes(ByteBuf buf,int length){
		byte[] result=new byte[length];
		for (int i = 0; i < length; i++) {
			result[i] = (byte) (buf.readByte()&0xFF);
		}
		return result;
	}
	public static String DecodeBcdStr(ByteBuf buf,int length){
		byte[] result =DecodeBytes(buf, length);
		return bcd2Str(result);
	}

	public static byte charToByte(char c)
	{
		return (byte) "0123456789ABCDEF".indexOf(c);
	}
	public static void main(String[] args){
//		String cardId=CodecHelper.ascToStr("4731303130333433");
//		System.out.println(cardId);
//		String chargerId=CodecHelper.strToAsc("1000078560");
//		System.out.println(chargerId);
//		byte[] bytes = CodecHelper.str2Bcd("1000079330");
//		System.out.println(bytes.length);
		ByteBuf buffer = Unpooled.buffer();
		buffer.writeByte(1);
		buffer.writeShort(2);
		buffer.writeShort(1);
		buffer.setShort(1,300);
		while (buffer.readableBytes()>0){
            System.out.println(buffer.readByte());
        }
	}
	
}
