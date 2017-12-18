package cn.itcast.core.service;

import java.util.List;

import cn.itcast.core.pojo.User;

public interface SolrService {

	List<User> getUserList() throws Exception;
}
