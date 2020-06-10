package com.yhr.literature.service;

import com.yhr.literature.pojo.Paper;
import com.yhr.literature.pojo.PaperDetails;

import java.util.List;
import java.util.Map;

public interface PaperService {

    public void add(Paper paper);

    public void delete(String id);

    public void update(Paper paper);

    public List<Paper> findList(Map<String, Object> searchMap);

    public Paper findById(String id);

    public PaperDetails findmoreById(String id);
}
