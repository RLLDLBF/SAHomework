package info.nemoworks.mdfs.config;


import java.util.List;


public class NameNode {
    Node root;

    public NameNode(){
        root = new Node("user1");
    }
    public String getPathTree(){
        String ret = "";
        ret += "/"+root.getName()+"\n";
        if(root.getChildnodes()!=null) {
            for (Node node : root.getChildnodes()) {
                ret += " /" + node.getName() + "\n";
            }
        }
        return ret;
    }
    public void addNode(Node node){
        root.addChild(node);
    }
    public void deleteNode(Node node){
        root.deleteNode(node);
    }
}
