package com.wk.access.message;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class MessageDecoder implements Decoder {
    protected static Logger logger = LoggerFactory.getLogger(MessageDecoder.class);
    public final static int MAX_PACKET_LENGTH = 0x0d;

    protected int status;		// 协议解析状态机
    protected int length;		// 数据包长度
    protected int sum;		// 数据包校验
    protected ByteBuf buffer;	// 帧数据缓存

    protected final static Map<Integer, String> codecs = new HashMap<Integer, String>() {
        private static final long serialVersionUID = 4400382043731036880L;
        {

        }
    };



    public MessageDecoder() {
        super();
        this.status = 0;
    }

    @Override
    public Message decode(ByteBuf buf) {
        Message message = null;
        while(buf.readableBytes() > 0) {
            switch(this.status) {
                case 0:
                    // 报文头
                    if(0x4b == buf.readByte()){
                        ++ this.status;
                    }
                    break;
                case 1:
                    // 报文头
                    if(0x48 == buf.readByte()){
                        ++ this.status;
                    }else {
                        this.status=0;
                    }
                    break;
                case 2:
                    //  协议长度
                    this.length = buf.readByte() & 0x00FF;
                    ++ this.status;
                    break;
                case 3:
                    int  b = buf.readByte() & 0x00FF;
                    this.length=this.length <<8 | b;
                    this.buffer=Unpooled.buffer(length-4);
                    ++ this.status;
                    break;
                case 4:
                    int remain = this.length - this.buffer.readableBytes()-4;
                    int buflen = buf.readableBytes();
                    if(buflen >= remain) {
                        buf.readBytes(buffer, remain);
                        try {
                            message = this.decodeMessage(buffer);
                            logger.debug("message received:" +message.code()+":"+ message.toString());
                            this.status = 0;
                            this.buffer.clear();
                            return message;
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            logger.error(ex.getMessage());
                            this.status = 0;
                            this.buffer.clear();
                            break;
                        }
                    } else {
                        buf.readBytes(buffer, buflen);
                    }
                    break;
                default:
                    break;
            }
        }

        return message;
    }

    private Message decodeMessage(ByteBuf buf) {

//
//        String  className = codecs.get(code);
//
//
//        if(className == null) {
//            logger.error("Codec unexisted for code:" + code);
//            return null;
//        }
//        try {
//            Class<?> clazz = Class.forName(className);
//            Message message = (Message) clazz.newInstance();
//
//
//            return message;
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(e.getMessage());
//            return null;
//        }
        return null;
    }



    public static void main(String[] args) {
//        String str1 = "4b48004501920000003030303035393030303030303030393030303032008c0001034331303465306535363432630000000000000000000000000002eeeeeeeeeeee2e7b68";
//        byte[] bytes = CodecHelper.hexStringToBytes(str1);
//        ByteBuf byteBuf = Unpooled.buffer();
//        byteBuf.writeBytes(bytes);
//        BaozeMessageDecoder gmdjMessageDecoder = new BaozeMessageDecoder();
//        Message message = gmdjMessageDecoder.decode(byteBuf);
//        System.out.println(message);
    }
}
