package me.xss6.xsware.util;

import net.minecraft.block.Block;


public class WhitelistUtil {
    public static Block findBlock(String name){
        return Block.getBlockFromName(name);
    }
}
