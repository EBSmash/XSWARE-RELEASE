package me.xss6.xsware.util.logview;


public class Threads extends Thread {

    @Override
    public void run(){
        Gui gui = new Gui();
        RefreshLog refreshLog = new RefreshLog(gui);
        refreshLog.start();
        gui.setThead(refreshLog);
    }
}
