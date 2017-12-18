package cn.itcast.core.solr;

import java.util.List;

import cn.itcast.core.pojo.User;

public interface SolrDao {

	List<User> getUserIndex() throws Exception;
}
