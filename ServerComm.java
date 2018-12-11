package com.distributed.common;

import com.distributed.common.Node;
import com.distributed.ta.NodeData;
import com.distributed.ta.StatusExeption;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public final class ServerComm { //TODO:implement functions
    private static NodeData nodeData = NodeData.getInstance();
    private ServerComm(){}

    public static String getNodeIp(Node node){
        return "test";
    }

    public static void RemoveOwnNode(){
        Node toRemove = NodeData.getInstance().getThisNode();
        Client c = ClientBuilder.newClient();
        WebTarget target = c.target(nodeData.getServerUri());
        Response response = target.path("NodeName/" + nodeData.getThisNode().getName()).request(MediaType.TEXT_PLAIN).delete(Response.class);
        System.out.println(response.toString());
    }

    public static void getNeigbours(){
        //Todo: send my hash and get my neigbours
    }

    public static Node ReportNodeFailiure(Node node) throws StatusExeption{
        Client c = ClientBuilder.newClient();
        WebTarget target = c.target(nodeData.getServerUri());
        Response response = target.path("nextNodeFail/" + node).request(MediaType.APPLICATION_JSON).get();
        if (response.getStatus() != 200) {
            throw new StatusExeption(response.getStatus());
        }
        return response.readEntity(Node.class);
    }

    public static Node getReplicationNode(int fileHash) {
    return ReplicationNode;
    }


}
