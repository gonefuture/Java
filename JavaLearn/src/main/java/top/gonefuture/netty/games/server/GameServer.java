package top.gonefuture.netty.games.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


/**
 * @author gonefuture  gonefuture@qq.com
 * time 2018/9/10 11:36
 * @version 1.00
 * Description: 游戏服务端
 */
@Slf4j
@Component
public class GameServer {

    @Resource
    private  ServerHandler serverHandler;

    //绑定端口
    public void bind(int port) throws Exception {
        // 逻辑线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 工作线程
        EventLoopGroup workGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap(); // 启动器
        bootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024) // 最大客户端连接数为1024
                //是否启用心跳保活机制
                .childOption(ChannelOption.SO_KEEPALIVE, true)
        .childHandler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                // 这里添加业务处理handler
                ch.pipeline().addLast( serverHandler);
            }
        });

        try {
            ChannelFuture future = bootstrap.bind(port).sync();
            if (future.isSuccess()) {
                System.out.println("Server starts success at port:"+port);
            }
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8000;
        new GameServer().bind(port);
    }


    @PostConstruct
    public void start() {
        try {
            main("127.0.0.0.1 8000".split(" "));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
