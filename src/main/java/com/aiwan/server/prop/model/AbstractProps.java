package com.aiwan.server.prop.model;

import com.aiwan.server.prop.model.impl.Equipment;
import com.aiwan.server.prop.resource.PropsResource;
import com.aiwan.server.publicsystem.model.GameObject;
import com.aiwan.server.util.GetBean;
import com.aiwan.server.util.IDUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * @author dengzebiao
 * @since 2019.6.19
 * 道具抽象类
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS)
public abstract class AbstractProps extends GameObject {
    /**
     * 道具资源唯一id
     */
    protected int resourceId;

    /**
     * 数量
     */
    protected int num;


    /**
     * 道具使用
     * @param accountId 用户账号
     * @param num 道具数量
     */
    public abstract int propUse(String accountId, Long rId, int num);

    /**
     * 初始化
     */
    @JsonIgnore
    public void init(int id) {
        this.resourceId = id;
        this.num = 1;
    }

    /**
     * 初始化
     */
    @JsonIgnore
    public void init(PropsResource propsResource) {
        //设置唯一id
        setObjectId(IDUtil.getId());
        this.resourceId = propsResource.getId();
        this.num = 1;
    }

    /**
     * 是否为装备类型
     */
    @JsonIgnore
    public boolean isEquipment() {
        return this instanceof Equipment;
    }

    /**
     * 获取道具类型
     */
    @JsonIgnore
    public PropsResource getPropsResource() {
        return GetBean.getPropsManager().getPropsResource(getResourceId());
    }

    /**
     * 比较
     */
    @JsonIgnore
    public boolean equals(AbstractProps abstractProps) {
        if (getResourceId() == abstractProps.getResourceId()) {
            return true;
        }
        return false;
    }


    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
