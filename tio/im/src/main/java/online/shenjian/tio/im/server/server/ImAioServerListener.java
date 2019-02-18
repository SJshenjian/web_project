package online.shenjian.tio.im.server.server;

import cn.hutool.core.io.FileUtil;
import online.shenjian.lionsoul.ip2region.DbSearcher;
import online.shenjian.lionsoul.ip2region.DbSearcherFactory;
import online.shenjian.lionsoul.ip2region.DataBlock;
import online.shenjian.tio.im.common.CommandStat;
import online.shenjian.tio.im.common.ImPacket;
import online.shenjian.tio.im.common.ImSessionContext;
import online.shenjian.tio.im.common.util.ImUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;
import org.tio.monitor.RateLimiterWrap;
import org.tio.server.intf.ServerAioListener;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/3
 */
public class ImAioServerListener implements ServerAioListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImAioServerListener.class);
    private static final Logger IP_LOGGER = LoggerFactory.getLogger("tio-ip-trace-log");

    static Map<String, AtomicLong> ipMap = new ConcurrentHashMap<>();
    static AtomicLong accessCount = new AtomicLong();


    @Override
    public void onAfterConnected(ChannelContext channelContext, boolean isConnected, boolean isReconnect) throws Exception {
        ImSessionContext imSessionContext = new ImSessionContext();

        int permitsPerSecond = ImServerStarter.config.getInt("request.permitsPerSecond");
        int warnClearInterval = ImServerStarter.config.getInt("request.warnClearInterval");
        int maxWarnCount = ImServerStarter.config.getInt("request.maxWarnCount");
        int maxAllWarnCount = ImServerStarter.config.getInt("request.maxAllWarnCount");
        RateLimiterWrap rateLimiterWrap = new RateLimiterWrap(permitsPerSecond, warnClearInterval, maxWarnCount, maxAllWarnCount);

        imSessionContext.setRateLimiterWrap(rateLimiterWrap);

        if (isConnected) {
            String ip = channelContext.getClientNode().getIp();

            DbSearcher dbSearcher = null;
            DataBlock dataBlock = null;
            try {
                String dbPath = FileUtil.getAbsolutePath("config/ip2region/ip2region.db");
                dbSearcher = DbSearcherFactory.getDbSearcher(dbPath);
                if (dbSearcher == null) {
                    LOGGER.error("请检查一下文件是否存在:{}", dbPath);
                }
                dataBlock = dbSearcher.memorySearch(ip);

                dataBlock.setRegion(ImUtils.formatRegion(dataBlock.getRegion()));

            } catch (Exception e) {
                LOGGER.error(e.toString(), e);
            } finally {
                if (dataBlock == null) {
                    dataBlock = new DataBlock(0, "未知", 0);
                }
                imSessionContext.setDataBlock(dataBlock);
            }

            ImUtils.setClient(channelContext);

            AtomicLong ipcount = ipMap.get(ip);
            if (ipcount == null) {
                ipcount = new AtomicLong();
                ipMap.put(ip, ipcount);
            }
            ipcount.incrementAndGet();
            String region = StringUtils.leftPad(dataBlock.getRegion(), 12);
            String accessCountStr = StringUtils.leftPad(accessCount.incrementAndGet() + "", 9);
            String ipCountStr = StringUtils.leftPad(ipMap.size() + "", 9);
            String ipStr = StringUtils.leftPad(ip, 15);
            //地区，所有的访问次数，有多少个不同的ip， ip， 这个ip连接的次数
            IP_LOGGER.info("地区: {}\n所有的访问次数: {}\n有多少个不同的ip: {}\n ip: {}\n 这个ip连接的次数: {}\n", region, accessCountStr, ipCountStr, ipStr, ipcount);
        }

        channelContext.setAttribute(imSessionContext);
    }

    @Override
    public void onAfterDecoded(ChannelContext channelContext, Packet packet, int packetSize) throws Exception {
        ImPacket imPacket = (ImPacket) packet;
        CommandStat.getCount(imPacket.getCommand()).received.incrementAndGet();
    }

    @Override
    public void onAfterReceivedBytes(ChannelContext channelContext, int receivedBytes) throws Exception {

    }

    @Override
    public void onAfterSent(ChannelContext channelContext, Packet packet, boolean isSentSuccess) throws Exception {
        ImPacket imPacket = (ImPacket) packet;
        if (isSentSuccess) {
            CommandStat.getCount(imPacket.getCommand()).sent.incrementAndGet();
        }
    }

    @Override
    public void onAfterHandled(ChannelContext channelContext, Packet packet, long cost) throws Exception {

    }

    @Override
    public void onBeforeClose(ChannelContext channelContext, Throwable throwable, String remark, boolean isRemove) throws Exception {

    }
}
