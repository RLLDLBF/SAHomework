package info.nemoworks.mdfs.config;


import com.jcraft.jsch.IO;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.io.IOException;

public class DataNode {
    MultipartFile file;
    byte bytes[];
    public DataNode(MultipartFile file){
        this.file = file;
        try {
            bytes = file.getBytes();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public byte[] getBytes(){
        return bytes;
    }
    public void setFile(MultipartFile file)
    {
        this.file = file;
        try {
            bytes = file.getBytes();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public String getFileName() {
        return file.getName();
    }
    public MultipartFile getFile(){
        return file;
    }
}
