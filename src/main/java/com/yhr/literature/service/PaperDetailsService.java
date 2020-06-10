package com.yhr.literature.service;

import com.yhr.literature.pojo.PaperDetails;

public interface PaperDetailsService {

    public void add(PaperDetails paperDetails) ;

    public void update(PaperDetails paperDetails) ;

    public void delete(String id);

    public PaperDetails findByWid(String id);
}
