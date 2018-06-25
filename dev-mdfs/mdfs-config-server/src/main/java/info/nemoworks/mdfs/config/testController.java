package info.nemoworks.mdfs.config;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@RestController
public class testController {
    public static NameNode root = new NameNode();

    @RequestMapping(value = "/GET1",method = RequestMethod.POST)
    public String getFilePath(@RequestParam("path") String path) {
        if (path.equals("/"))
            return root.getPathTree();
        else {

            return "SUCCESS";
        }
    }

    @RequestMapping(value = "/GET2",method = RequestMethod.POST)
    public ResponseEntity<byte[]> getFile(@RequestParam("filename") String abfilename) throws Exception
    {

        String[] lines = abfilename.split("/");
        String filename = lines[lines.length-1];



        byte bytes[] = null;
        for(Node node : root.root.getChildnodes())
        {
            if(node.getName().equals(filename))
            {
                bytes = node.getDataNode().getBytes();
                break;
            }
        }

        if(bytes!=null) {
            HttpHeaders httpHeaders = new HttpHeaders(); //设置header
            httpHeaders.add("Accept-Ranges", "bytes");
            httpHeaders.add("Content-Length", bytes.length + "");
            httpHeaders.add("Content-Disposition", "attachment; filename="+filename);
            httpHeaders.add("Content-Type", "multipart/form-data;charset=utf-8");
            return new ResponseEntity<byte[]>(bytes, httpHeaders, HttpStatus.CREATED);
        }
        else
            return null;
    }

    @RequestMapping(value = "/PUT",method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file")MultipartFile file, @RequestParam("systempath") String systempath) {
        String[] paths = systempath.split("/");
        String filename = paths[paths.length-1];
        Node node = new Node(filename);
        try {
            node.setData(file);
        }catch(Exception e){
            e.printStackTrace();
        }
        root.addNode(node);
        return "SUCCESS";
    }

    @RequestMapping(value = "/DEL",method = RequestMethod.POST)
    public String deleteFile(@RequestParam("file") String abfilename){
        String[] lines = abfilename.split("/");
        String filename = lines[lines.length-1];

        for(Node node : root.root.getChildnodes()){
            if(node.getName().equals(filename)){
                root.deleteNode(node);
                return "SUCCESS";
            }
        }
        return "NO SUCH FILE";
    }
}
