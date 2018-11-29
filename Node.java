package com.distributed.common;

public class Node {
    private String ipAddress;
    private String name;
    private int hash;

    public Node(){ }

    public Node(String name, String ip){
        this.ipAddress = ip;
        this.name = name;
        calcHash();
    }

    public Node(int hash, String ip){
        this.ipAddress = ip;
        this.hash = hash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        calcHash();
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getHash(){
        return hash;
    }

    private void calcHash(){
        this.hash = Math.abs(this.name.hashCode()) % 32768;
    }
}
