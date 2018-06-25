package info.nemoworks.mdfs.config;

import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private List<Node> childnodes;
    private DataNode dataNode;
    public Node(String name){
        this.name = name;
        childnodes = new ArrayList<>();
        dataNode = null;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addChild(Node node){
        childnodes.add(node);
    }
    public List<Node> getChildnodes(){
        return childnodes;
    }
    public void setData(MultipartFile file)
        throws Exception
    {
        dataNode = new DataNode(file);
    }
    public DataNode getDataNode()
    {
        return dataNode;
    }
    public void deleteNode(Node node){
        childnodes.remove(node);
    }
}
