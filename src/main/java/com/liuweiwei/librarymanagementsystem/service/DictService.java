package com.liuweiwei.librarymanagementsystem.service;

import com.liuweiwei.librarymanagementsystem.common.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.liuweiwei.librarymanagementsystem.common.service.GenericService;

import com.liuweiwei.librarymanagementsystem.entity.Dict;
import com.liuweiwei.librarymanagementsystem.entity.QueryDict;
import com.liuweiwei.librarymanagementsystem.dao.DictDao;

/**
 *@author liuweiwei
 **/
@Service("dictService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class DictService extends GenericService<Dict, QueryDict> {
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private DictDao dictDao;
	@Override
	protected GenericDao<Dict, QueryDict> getDao() {
		return dictDao;
	}
}