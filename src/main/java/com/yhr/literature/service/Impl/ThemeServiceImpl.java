package com.yhr.literature.service.Impl;

import com.yhr.literature.IdWorker;
import com.yhr.literature.dao.ThemeMapper;
import com.yhr.literature.pojo.Paper;
import com.yhr.literature.pojo.Theme;
import com.yhr.literature.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ThemeServiceImpl implements ThemeService{
    @Autowired
    private ThemeMapper themeMapper;

    @Override
    public void add(Theme theme) {
        IdWorker idWorker=new IdWorker();
        if(theme.getId()==null || theme.getId()==""){
            theme.setCreateTime(new Date());
            theme.setId(String.valueOf(idWorker.nextId()));
            theme.setUserId("admin");
        }
        theme.setLastTime(new Date());
        themeMapper.insert(theme);
    }

    @Override
    public void delete(String id) {
        themeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Theme theme) {
        themeMapper.updateByPrimaryKeySelective(theme);
    }

    @Override
    public List<Theme> findList(Map<String, Object> searchMap) {
        Example example=createExample(searchMap);
        List<Theme> list=themeMapper.selectByExample(example);
        System.out.println(list.get(0).getCreateTime());
        return list;
    }

    public Theme findById(String id) {
        return themeMapper.selectByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Theme.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 主题id
            if(searchMap.get("id")!=null && !"".equals(searchMap.get("id"))){
                criteria.andLike("id","%"+searchMap.get("id")+"%");
            }
            // 主题名
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
            // 关键词
            if(searchMap.get("keyWord")!=null && !"".equals(searchMap.get("keyWord"))){
                criteria.andLike("keyWord","%"+searchMap.get("keyWord")+"%");
            }
            // 主题说明
            if(searchMap.get("message")!=null && !"".equals(searchMap.get("message"))){
                criteria.andLike("message","%"+searchMap.get("message")+"%");
            }
            // 用户id
            if(searchMap.get("userId")!=null && !"".equals(searchMap.get("userId"))){
                criteria.andLike("userId","%"+searchMap.get("userId")+"%");
            }

            // 主题编号
            if(searchMap.get("no")!=null ){
                criteria.andEqualTo("no",searchMap.get("no"));
            }

        }
        return example;
    }
}
