package edu.seedit.common.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private SqlSessionTemplate sqlSession;

	protected void printQueryId(String queryId) {
		if(logger.isDebugEnabled()){
			logger.debug("\t QueryId \t: " + queryId);
		}
	}
	protected void printQueryId(String queryId, Object params) {
		if(logger.isDebugEnabled()){
			logger.debug("\t Query \t: " + params.toString());
		}
	}

	public int insert(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.insert(queryId, params);
	}

	public int update(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.update(queryId, params);
	}

	public int delete(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.delete(queryId, params);
	}

	public Object select(String queryId){
		printQueryId(queryId);
		return sqlSession.selectOne(queryId);
	}

	public Object select(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.selectOne(queryId, params);
	}

	@SuppressWarnings("rawtypes")
	public List list(String queryId){
		printQueryId(queryId);
		return sqlSession.selectList(queryId);
	}

	@SuppressWarnings("rawtypes")
	public List list(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.selectList(queryId,params);
	}
}
