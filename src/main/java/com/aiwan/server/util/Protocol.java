package com.aiwan.server.util;

/**
 * @author dengzebiao
 * 包头协议
 * */
public class Protocol {
    //登录
    public final static int LOGIN = 1;
    //注册
    public final static int REGIST = 2;
    //登录成功
    public final static int LOGINSUCCESS = 3;
    //注册成功
    public final static int REGISTSUCCESS = 4;
    //登录失败
    public final static int LOGINFAIL = 5;
    //注册失败
    public final static int REGISTDAIL = 6;
    //注销
    public final static int LOGOUT = 7;
    //注销用户成功
    public final static int LOGOUTSUCCESS = 8;
    //注销用户失败
    public final static int LOGOUTFAIL = 9;
    //用户移动
    public final static int MOVE = 10;
    //移动成功
    public final static int MOVESUCCESS = 11;
    //移动失败
    public final static int MOVEFAIL = 12;
    //跳转
    public final static int SHIFT = 13;
    //跳转成功
    public final static int SHIFTSUCCESS = 14;
    //跳转失败
    public final static int SHIFTFAIL = 15;
    //高级登录
    public final static int HLOGIN = 16;
    //退出游戏
    public final static int EXIT = 17;
    //心跳
    public final static int HEART = 18;
    //返回个人信息
    public final static int  USERMESSAGE = 19;
    //创建角色
    public final static int CREATEROLE = 20;
    //获取角色信息
    public final static int GETROLEMESSAGE = 21;
    //获取道具
    public final static int OBTAINPROP = 22;
    //查看背包
    public final static int VIEWBACKPACK = 23;
    //道具使用
    public final static int PROPUSER = 24;
    //装备协议
    public final static int VIEWQEUIP = 25;
    //查看坐骑信息
    public final static int VIEWMOUNT = 26;
    //查看用户属性
    public final static int VIEWATTRIBUTES = 27;
    //使用坐骑升阶丹
    public final static int MOUNTUPGRADE = 28;
    //心跳（测试）
    public final static int HEARTNEW = 29;
    /**
     * 卸装备
     */
    public final static int UNLOADEQUIP = 30;

    /**
     * 丢弃道具
     */
    public final static int DROPPROP = 31;

    /**
     * 装备
     */
    public final static int EQUIP = 32;

    /**
     * 学习技能
     */
    public final static int LEAENSKILL = 33;

    /**
     * 查看所学技能
     */
    public final static int VIEWLEARNSKILL = 34;

    /**
     * 技能升级
     */
    public final static int UPGRADESKILL = 35;

    /**
     * 技能位置移动
     */
    public final static int MOVESKILL = 36;

    /**
     * 查看技能栏
     */
    public static final int VIEWSKILLBAR = 37;

    /**
     * 查看buff
     */
    public static final int VIEW_BUFF = 38;
}
