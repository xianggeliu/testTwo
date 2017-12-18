package cn.itcast.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.core.pojo.User;
import cn.itcast.core.service.SolrService;
import cn.itcast.core.solr.SolrDao;

@Service
public class SolrServiceImpl implements SolrService {
	@Autowired
	private SolrDao solrDao;
	
	@Override
	public List<User> getUserList() throws Exception {
		List<User> list = solrDao.getUserIndex();
		return list;
	}

}
