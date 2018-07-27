package xin.gonefuture.java.netty.UsingUDPBroadcastEvent;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @author gonefuture  gonefuture@qq.com
 * @version 1.00
 * Description: JavaLearn
 * @time 2018/7/25 16:20
 */
public class LogEventEncoder extends MessageToMessageEncoder<LogEvent> {
    private final InetSocketAddress remoteAddress;

    /*
    LogEventEncoder创建了即将被发送到指定的InetSocketAddress的DatagramPacket消息
     */
    public LogEventEncoder(InetSocketAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, LogEvent logEvent, List<Object> out) throws Exception {
        byte[] file = logEvent.getLogfile().getBytes(CharsetUtil.UTF_8);
        byte[] msg = logEvent.getMsg().getBytes(CharsetUtil.UTF_8);
        ByteBuf buf = ctx.alloc().buffer(file.length+msg.length+1);
        // 将文件名写入
        buf.writeBytes(file);
        // 在文件名后面添加一个分隔符
        buf.writeByte(LogEvent.SEPARATOR);
        // 将日志消息写入
        buf.writeBytes(msg);
        // 将一个拥有数据和目的地地址的新Datagrampacket添加到出站的消息列表中
        out.add(new DatagramPacket(buf,remoteAddress));

    }
}
