package me.xss6.xsware.manager;

import me.xss6.xsware.util.Globals;
import me.xss6.xsware.util.elements.XswarePlayer;

import java.util.ArrayList;
import java.util.List;

public class EnemyManager implements Globals {

    private List<XswarePlayer> enemies;

    public EnemyManager() {
        this.enemies = new ArrayList<>();
    }

    public void addEnemy(String name) {
        if (!this.isEnemy(name)) {
            this.enemies.add(new XswarePlayer(name));
        }
    }

    public void removeEnemy(String name) {
        this.enemies.removeIf(player -> player.getName().equalsIgnoreCase(name));
    }

    public boolean isEnemy(String name) {
        for (XswarePlayer player : this.enemies) {
            if (player.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasEnemies() {
        return !this.enemies.isEmpty();
    }

    public List<XswarePlayer> getEnemies() {
        return this.enemies;
    }

    public void clear() {
        this.enemies.clear();
    }

    public void setEnemies(List<XswarePlayer> list) {
        this.enemies = list;
    }

}
