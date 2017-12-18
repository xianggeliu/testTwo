package cn.itcast.core.solr;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.itcast.core.pojo.User;

@Repository
public class SolrDaoImpl implements SolrDao {

	@Autowired
	private SolrServer solrServer;

	@Override
	public List<User> getUserIndex() throws Exception {
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.set("q", "*:*");
		QueryResponse query = solrServer.query(solrQuery);
		SolrDocumentList results = query.getResults();
		List<User> list = new ArrayList<>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		for (SolrDocument solrDocument : results) {
			User user = new User();
			Integer id = Integer.parseInt(solrDocument.get("id").toString());
			user.setId(id);
			user.setName((String) solrDocument.get("user_name"));
			solrDocument.get("user_birthday");
			Date date = simpleDateFormat.parse(solrDocument.get("user_birthday").toString());
			 user.setBirthday(date);
			list.add(user);
		}
		return list;
	}

}
