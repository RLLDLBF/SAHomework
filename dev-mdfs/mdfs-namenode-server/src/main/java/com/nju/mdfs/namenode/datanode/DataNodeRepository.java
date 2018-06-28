package com.nju.mdfs.namenode.datanode;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataNodeRepository extends CrudRepository<DataNode,String> {

    List<DataNode> findAllByValid(boolean valid);
    DataNode findByUrl(String url);
    void deleteByUrl(String url);
    DataNode findByName(String name);
    void deleteByName(String name);
}
