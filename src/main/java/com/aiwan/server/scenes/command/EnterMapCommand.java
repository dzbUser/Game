package com.aiwan.server.scenes.command;

import com.aiwan.server.base.executor.scene.impl.AbstractSceneCommand;
import com.aiwan.server.scenes.mapresource.MapResource;
import com.aiwan.server.user.role.player.model.Role;
import com.aiwan.server.util.GetBean;

/**
 * 进入地图命令(需要初始化坐标)
 *
 * @author dengzebiao
 * @since 2019.7.4
 */
public class EnterMapCommand extends AbstractSceneCommand {

    /**
     * 角色
     */
    private Role role;

    @Override
    public void action() {
        //获取地图资源
        MapResource mapResource = GetBean.getMapManager().getMapResource(getKey());

        //初始化化角色坐标
        role.setMap(getKey());
        role.setX(mapResource.getOriginX());
        role.setY(mapResource.getOriginY());
        //添加到地图资源中
        GetBean.getMapManager().putFighterRole(role);
        //写回
        GetBean.getRoleManager().save(role);
        //设置跳转结束
        role.setChangingMap(false);
        //给所有玩家发送消息
        GetBean.getMapManager().sendMessageToUsers(getKey());
    }

    public EnterMapCommand(int mapId, Role role) {
        this.role = role;
        setMapId(mapId);
    }

}
