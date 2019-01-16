package com.distributed.common;

import java.util.HashMap;

public class FileData {
    private String name;
    private boolean isFileOwner;
    private boolean shutdown;

    public boolean isDownloaded() {
        return downloaded;
    }

    public void setDownloaded(boolean downloaded) {
        this.downloaded = downloaded;
    }

    private boolean downloaded;
    private HashMap<Node,Integer> fileLog;

    public HashMap<Node, Integer> getFileLog() {
        return fileLog;
    }

    public boolean isShutdown() {
        return shutdown;
    }

    public void setShutdown(boolean shutdown) {
        this.shutdown = shutdown;
    }

    public boolean isFileOwner() {
        return isFileOwner;
    }

    public void setFileOwner(boolean fileOwner) {
        isFileOwner = fileOwner;
    }

    public FileData(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHash() {
        return Math.abs(name.hashCode()) % 32768;
    }

}
