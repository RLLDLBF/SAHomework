package com.nju.mdfs.namenode.NodeTests;

import com.nju.mdfs.namenode.NamenodeApplication;
import com.nju.mdfs.namenode.node.Node;
import com.nju.mdfs.namenode.node.NodeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = NamenodeApplication.class)
public class NodeServiceTests {

    @Autowired
    private NodeService nodeService;

    @Test
    public void testAll(){
        /**
         * 增测试
         */
        if(nodeService==null)
            System.out.println("nodeService=null");
         Node node1 = new Node("/User/junju",true);
         nodeService.addNode(node1);
         Node node2 = new Node("/User/junju/a.txt",false);
         nodeService.addNode(node2);

        /**
         * 查测试
         */
        Node node3 = nodeService.getNodeByName("/User/junju");
        Node node4 = nodeService.getNodeByName("/User/junju/a.txt");
        System.out.println("node3.name = "+node3.getName()+",node3.location="+node3.getLocation());
        System.out.println("node4.name = " + node4.getName()+",node4.location="+node4.getLocation()+",node4.filename="+
        node4.getFilename()+",node4.filetype="+node4.getFiletype());

        /**
         * 删测试
         */
        nodeService.deleteByName("/User/junju/a.txt");
        Node node5 = nodeService.getNodeByName("/User/junju/a.txt");
        if(node5==null){
            System.out.println("删除成功");
        }
        else
            System.out.println("删除失败");
    }
}
