package com.distributed.common;

public class File {
    private String name;
    private boolean isFileOwner;
    private boolean shutdown;

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

    public File (String name) {
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
