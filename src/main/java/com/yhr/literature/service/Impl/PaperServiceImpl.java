package com.yhr.literature.service.Impl;

import com.yhr.literature.IdWorker;
import com.yhr.literature.dao.PaperDetailsMapper;
import com.yhr.literature.dao.PaperMapper;
import com.yhr.literature.pojo.Paper;
import com.yhr.literature.pojo.PaperDetails;
import com.yhr.literature.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private PaperDetailsMapper paperDetailsMapper;
    @Override
    public void add(Paper paper) {
        IdWorker idWorker=new IdWorker();
        if(paper.getId()==null || paper.getId()==""){
            paper.setCreateTime(new Date());
            paper.setId(String.valueOf(idWorker.nextId()));
            paper.setUserId("admin");
        }
        paper.setLastTime(new Date());
        PaperDetails paperDetails=new PaperDetails();
        paperDetails.setId(String.valueOf(idWorker.nextId()));
        paperDetails.setWid(paper.getId());
        paperDetailsMapper.insert(paperDetails);
        paperMapper.insert(paper);
    }

    public Paper findById(String id) {
        return paperMapper.selectByPrimaryKey(id);
    }

    @Override
    public PaperDetails findmoreById(String id) {
        return paperDetailsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(String id) {
        paperMapper.deleteByPrimaryKey(id);
        Example example=new Example(PaperDetails.class);
        Example.Criteria criteria =example.createCriteria();
        criteria.andEqualTo("wid",id);
        paperDetailsMapper.deleteByExample(example);
    }

    @Override
    public void update(Paper paper) {
        paperMapper.updateByPrimaryKeySelective(paper);
    }

    @Override
    public List<Paper> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return paperMapper.selectByExample(example);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Paper.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 论文id
            if(searchMap.get("id")!=null && !"".equals(searchMap.get("id"))){
                criteria.andLike("id","%"+searchMap.get("id")+"%");
            }
            // 论文题目
            if(searchMap.get("title")!=null && !"".equals(searchMap.get("title"))){
                criteria.andLike("title","%"+searchMap.get("title")+"%");
            }
            // 作者
            if(searchMap.get("author")!=null && !"".equals(searchMap.get("author"))){
                criteria.andLike("author","%"+searchMap.get("author")+"%");
            }
            // 用户id
            if(searchMap.get("userId")!=null && !"".equals(searchMap.get("userId"))){
                criteria.andLike("userId","%"+searchMap.get("userId")+"%");
            }
            // 工作单位
            if(searchMap.get("company")!=null && !"".equals(searchMap.get("company"))){
                criteria.andLike("company","%"+searchMap.get("company")+"%");
            }
            // 文章概要
            if(searchMap.get("outline")!=null && !"".equals(searchMap.get("outline"))){
                criteria.andLike("outline","%"+searchMap.get("outline")+"%");
            }
            // 关键词
            if(searchMap.get("keyWord")!=null && !"".equals(searchMap.get("keyWord"))){
                criteria.andLike("keyWord","%"+searchMap.get("keyWord")+"%");
            }
            // 主题编号
            if(searchMap.get("nos")!=null && !"".equals(searchMap.get("nos"))){
                criteria.andLike("nos","%"+searchMap.get("nos")+"%");
            }

            // 阅读数
            if(searchMap.get("readNum")!=null ){
                criteria.andEqualTo("readNum",searchMap.get("readNum"));
            }

        }
        return example;
    }
}
