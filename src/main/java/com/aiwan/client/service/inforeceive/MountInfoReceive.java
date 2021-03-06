package com.aiwan.client.service.inforeceive;

import com.aiwan.client.anno.InfoReceiveMethod;
import com.aiwan.client.anno.InfoReceiveObject;
import com.aiwan.client.service.ClientResourceManager;
import com.aiwan.client.service.InterfaceManager;
import com.aiwan.client.swing.clientinterface.GameInterface;
import com.aiwan.server.user.role.attributes.model.AttributeElement;
import com.aiwan.server.user.role.attributes.model.AttributeType;
import com.aiwan.server.user.role.mount.protocol.SM_ViewMount;
import com.aiwan.server.util.StatusCode;

import java.util.Map;

/**
 * @author dengzebiao
 * @since 2019.6.13
 * 坐骑信息接收
 * */
@InfoReceiveObject
public class MountInfoReceive {

    /** 查看坐骑信息 */
    @InfoReceiveMethod(status = StatusCode.VIEWMOUNT)
    public void viewMount(SM_ViewMount sm_viewMount){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("名字：" + ClientResourceManager.getContent("mount", sm_viewMount.getLevel()));
        stringBuffer.append(" 经验："+sm_viewMount.getExperience());
        stringBuffer.append(" 阶数：" + sm_viewMount.getLevel());
        stringBuffer.append(" 升级所需经验："+sm_viewMount.getNeedExperience()+"\n");
        for (Map.Entry<AttributeType, AttributeElement> elementEntry:sm_viewMount.getAttributes().entrySet()){
            stringBuffer.append(elementEntry.getValue().toString()+" ");
        }
        GameInterface gameInterface = (GameInterface) InterfaceManager.getFrame("game");
        gameInterface.printOtherMessage(stringBuffer.toString());
    }
}
