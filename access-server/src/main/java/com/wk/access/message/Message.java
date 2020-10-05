package com.wk.access.message;

import com.wk.access.server.transfer.UnresendTransfer;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

public abstract class Message {
    private int size;


    private int startMark = 0x63;
    private int dataLen;
    private int index;
    private int protocolVersion = 1;
    private int messageType;
    private String equipmentId;
    private int encryptEnable = 0;

    public void encode(ByteBuf byteBuf){
        byteBuf.writeByte(startMark);
        byteBuf.writeShort(dataLen);
        index = UnresendTransfer.getIndex();
        byteBuf.writeInt(index);
        byteBuf.writeByte(protocolVersion);
        byteBuf.writeByte(messageType);
        byteBuf.writeBytes(str2Bcd(equipmentId));
        byteBuf.writeByte(encryptEnable);
        encode0(byteBuf);
        dataLen = byteBuf.readableBytes()-1;
        byteBuf.setShort(1, dataLen);

        size = byteBuf.readableBytes();
    }

    public void decode(ByteBuf byteBuf){
        decode0(byteBuf);
    }

    public abstract void encode0(ByteBuf byteBuf);

    public abstract void decode0(ByteBuf byteBuf);

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

    public static String bcd2Str(byte[] bytes){
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


    public static void encodeString(ByteBuf buf, String str, int length) {
        if(str==null){
            str="";
        }
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        if(bytes.length > length) {
            buf.writeBytes(bytes, 0, length);
        } else {
            buf.writeBytes(bytes);
            for(int i = bytes.length; i < length; ++i) {
                buf.writeByte(0x00);
            }
        }
    }
    public static String decodeString(ByteBuf buf, int length) {
        byte[] bytes = new byte[length];
        buf.readBytes(bytes);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if(bytes[i]!=0){
                sb.append((char) bytes[i]);
            }

        }
        return sb.toString();
    }

    public abstract int code();
    public int size(){
        return size;
    };
    public int getStartMark() {
        return startMark;
    }

    public void setStartMark(int startMark) {
        this.startMark = startMark;
    }

    public int getDataLen() {
        return dataLen;
    }

    public void setDataLen(int dataLen) {
        this.dataLen = dataLen;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(int protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public int getEncryptEnable() {
        return encryptEnable;
    }

    public void setEncryptEnable(int encryptEnable) {
        this.encryptEnable = encryptEnable;
    }
}
