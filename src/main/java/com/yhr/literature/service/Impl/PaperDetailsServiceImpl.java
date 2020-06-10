package com.yhr.literature.service.Impl;

import com.yhr.literature.dao.PaperDetailsMapper;
import com.yhr.literature.pojo.PaperDetails;
import com.yhr.literature.service.PaperDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PaperDetailsServiceImpl implements PaperDetailsService{
    @Autowired
    private PaperDetailsMapper paperDetailsMapper;
    /**
     * 新增
     * @param paperDetails
     */
    public void add(PaperDetails paperDetails) {
        paperDetailsMapper.insert(paperDetails);
    }

    /**
     * 修改
     * @param paperDetails
     */
    public void update(PaperDetails paperDetails) {
        paperDetailsMapper.updateByPrimaryKeySelective(paperDetails);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(String id) {
        paperDetailsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PaperDetails findByWid(String id) {
        Example example=new Example(PaperDetails.class);
        Example.Criteria criteria =example.createCriteria();
        criteria.andEqualTo("wid",id);
        List<PaperDetails> paperDetails = paperDetailsMapper.selectByExample(example);
        PaperDetails paper =paperDetails.get(0);
        return paper;
    }
}
