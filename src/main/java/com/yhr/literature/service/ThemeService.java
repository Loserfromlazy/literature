package com.yhr.literature.service;

import com.yhr.literature.pojo.Paper;
import com.yhr.literature.pojo.Theme;

import java.util.List;
import java.util.Map;

public interface ThemeService {
    public void add(Theme theme);

    public void delete(String id);

    public void update(Theme theme);

    public List<Theme> findList(Map<String, Object> searchMap);

    public Theme findById(String id);
}
