package online.shenjian.tio.showcase.common.intf;

import com.alibaba.fastjson.JSON;
import online.shenjian.tio.showcase.common.Const;
import online.shenjian.tio.showcase.common.ShowcasePacket;
import online.shenjian.tio.showcase.common.packet.BaseBody;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;

import java.io.UnsupportedEncodingException;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/30
 */
public abstract class AbsShowcaseBsHandler<T extends BaseBody> implements ShowcaseBsHandlerIntf {

    public abstract Class<T> bodyClass();

    public void handler(ShowcasePacket packet, ChannelContext channelContext) {
        T bsBody = null;
        if (packet.getBody() != null) {
            String jsonStr = null;
            try {
                jsonStr = new String(packet.getBody(), Const.CHARSET);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            bsBody = JSON.parseObject(jsonStr, bodyClass());
        }
        handler(packet, bsBody, channelContext);
    }

    public abstract void handler(Packet packet, T bsBody, ChannelContext channelContext) ;
}
