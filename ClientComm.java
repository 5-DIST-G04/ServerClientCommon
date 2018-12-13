package com.distributed.common;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public final class ClientComm {
    private ClientComm(){}

    public static void setPrevNeigbhour(Node prevNode, Node nodeToSet){
        Client c = ClientBuilder.newClient();
        WebTarget target = c.target("http://" + nodeToSet.getIpAddress() + ":8080/");
        Response response  = target.path("Neighbours/prevNode/").request().post(Entity.entity(prevNode,
                MediaType.APPLICATION_JSON));
        //throw new NotImplementedException();
    }

    public static void setNextNeighbour(Node nextNode, Node nodeToSet){
        Client c = ClientBuilder.newClient();
        WebTarget target = c.target("http://" + nodeToSet.getIpAddress() + ":8080/");
        Response response  = target.path("Neighbours/nextvNode/").request().post(Entity.entity(nextNode,
                MediaType.APPLICATION_JSON));
    }


    public static void replicate(FileData fileData, Node replicationNode) {

    }
}
