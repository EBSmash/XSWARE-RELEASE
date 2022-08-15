package me.xss6.xsware.manager;

import me.xss6.xsware.util.Globals;
import me.xss6.xsware.util.elements.XswarePlayer;

import java.util.ArrayList;
import java.util.List;

public class FriendManager implements Globals {

    private List<XswarePlayer> friends;

    public FriendManager() {
         this.friends = new ArrayList<>();
    }

    public void addFriend(String name) {
        if (!this.isFriend(name)) {
            this.friends.add(new XswarePlayer(name));
        }
    }

    public void removeFriend(String name) {
        this.friends.removeIf(player -> player.getName().equalsIgnoreCase(name));
    }

    public boolean isFriend(String name) {
        for (XswarePlayer player : this.friends) {
            if (player.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasFriends() {
        return !this.friends.isEmpty();
    }

    public List<XswarePlayer> getFriends() {
        return this.friends;
    }

    public void toggleFriend(String name) {
        if (this.isFriend(name)) {
            this.removeFriend(name);
        } else {
            this.addFriend(name);
        }
    }

    public void clear() {
        this.friends.clear();
    }

    public void setFriends(List<XswarePlayer> list) {
        this.friends = list;
    }

}
