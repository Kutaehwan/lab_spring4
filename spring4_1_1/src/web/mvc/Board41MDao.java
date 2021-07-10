package web.mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public class Board41MDao {
	Logger logger = Logger.getLogger(Board41MDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public List<Map<String, Object>> getBoardList(Map<String, Object> pmap) {
		logger.info("Board41MDao-getBoardList 호출 성공");
		List<Map<String, Object>> boardList = null;
		boardList = sqlSessionTemplate.selectList("getBoardList", pmap);
		return boardList;
	}
	public int boardMInsert(Map<String, Object> pmap) {
		logger.info("Board41Mdao - boardMInsert 호출 성공");
		int result = 0;
		result = 1;
		sqlSessionTemplate.insert("boardMInsert",pmap);
		return result;
		
	}
	// 조회수 카운트
	public void hitCount(int bm_no) {
		logger.info("Board41Mdao - hitCount 호출 성공");
		sqlSessionTemplate.update("hitCount",bm_no);
	}
	public void bmStepUpdate(Map<String, Object> pmap) {
		logger.info("Board41Mdao - bmStepUpdate 호출 성공");
		sqlSessionTemplate.insert("bmStepUpdate",pmap);
	}
	public int getBmGroup() {
		logger.info("Board41Mdao - getBmGroup 호출 성공");
		int result = 0;
		result = sqlSessionTemplate.selectOne("getBmGroup");
		return result;
	}
	public int getBmNo(int bm_no) {
		int result = 0;
		result = sqlSessionTemplate.selectOne("getBmNo", bm_no);
		return result;
	}
	public int getBmNo() {
		logger.info("getBmNo 호출 성공");
		int result = 0;
		result = sqlSessionTemplate.selectOne("getBmNo");		
		return result;
	}
	public int boardMUpdate(Map<String, Object> pmap) {
		logger.info("Board41Mdao - boardMUpdate 호출 성공");
		int result = 0;
		result = sqlSessionTemplate.update("boardMUpdate", pmap);
		logger.info("result : " + result);
		return result;
	}
	public int boardMDelete(Map<String, Object> pmap) {
		logger.info("Board41Mdao - boardMDelete 호출 성공");
		int result = 0;
		result = sqlSessionTemplate.delete("boardMDel", pmap);
		logger.info("result : " + result);
		return result;
	}
}
