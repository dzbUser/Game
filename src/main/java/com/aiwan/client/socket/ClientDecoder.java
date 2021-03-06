package com.aiwan.client.socket;
import com.aiwan.client.service.ClientReceiveMap;
import com.aiwan.server.publicsystem.protocol.DecodeData;
import com.aiwan.server.util.JsonUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

/**
 * @author dengzebiao
 * 解码器
 * **/
public class ClientDecoder extends ByteToMessageDecoder implements Serializable {
    private DecodeData decodeData;
    Logger logger = LoggerFactory.getLogger(ClientDecoder.class);
    private final int MINSIZE = 6;
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        /*
         * 分四部步
         * 1.读类型
         * 2.读长度
         * 3.读数据
         * 4.转化为DecodeData
         * */
        if (byteBuf.readableBytes()>=MINSIZE){
            //标记当前为读索引
            byteBuf.markReaderIndex();
            decodeData = new DecodeData();
            int type = byteBuf.readInt();
            int length = byteBuf.readInt();
            if (byteBuf.readableBytes() < length) {
                //包长度小于指定长度，把包存在缓存中????
                byteBuf.resetReaderIndex();
                return;
            } else {
                //若有分片标记，清除分片标记
                byte[] data = new byte[length];
                byteBuf.readBytes(data);
                decodeData.setType(type);
                decodeData.setLength(length);
                if (ClientReceiveMap.getClass(type) == null){
                    //错误编码
                    logger.debug("错误编码："+type);
                    return;
                }
                decodeData.setObject(JsonUtil.bytes2Object(data, ClientReceiveMap.getClass(type)));
                list.add(decodeData);
            }
        }
    }
}
