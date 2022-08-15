package me.xss6.xsware.util.elements;

import me.xss6.xsware.util.Globals;
import me.xss6.xsware.util.PlayerUtil;

import java.util.UUID;

public class XswarePlayer implements Globals {

    private final String name;
    private String nickName;

    public XswarePlayer(String name) {
        this.name = name;
        PlayerUtil.getUUIDFromName(name);
    }

    public XswarePlayer(String name, UUID uuid) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String name) {
        this.nickName = name;
    }

}
