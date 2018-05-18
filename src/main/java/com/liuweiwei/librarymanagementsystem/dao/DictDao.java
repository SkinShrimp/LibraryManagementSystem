package com.liuweiwei.librarymanagementsystem.dao;

import com.liuweiwei.librarymanagementsystem.common.dao.GenericDao;

import com.liuweiwei.librarymanagementsystem.entity.Dict;
import com.liuweiwei.librarymanagementsystem.entity.QueryDict;

/**
 *@author liuweiwei
 **/
public interface DictDao extends GenericDao<Dict, QueryDict> {

    Dict get(String code);
}