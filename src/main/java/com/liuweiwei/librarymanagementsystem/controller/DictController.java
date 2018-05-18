package com.liuweiwei.librarymanagementsystem.controller;

import javax.inject.Inject;

import com.liuweiwei.librarymanagementsystem.common.service.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.liuweiwei.librarymanagementsystem.common.controller.GenericController;

import com.liuweiwei.librarymanagementsystem.entity.Dict;
import com.liuweiwei.librarymanagementsystem.entity.QueryDict;
import com.liuweiwei.librarymanagementsystem.service.DictService;

/**
 *@author liuweiwei
 **/
@Controller
@RequestMapping("/dict")
public class DictController extends GenericController<Dict, QueryDict> {
	@Inject
	private DictService dictService;
	@Override
	protected GenericService<Dict, QueryDict> getService() {
		return dictService;
	}
}