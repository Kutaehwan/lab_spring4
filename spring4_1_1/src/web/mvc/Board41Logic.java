package web.mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class Board41Logic {
	Logger logger = Logger.getLogger(Board41Logic.class);
	
	private Board41MDao boardMDao = null;
	private Board41SDao boardSDao = null;
	
	public List<Map<String, Object>> getBoardList(Map<String, Object> pmap) {
		logger.info("Board41Logic - getBoardList 호출 성공");
		List<Map<String, Object>> boardList = null;
		boardList = boardMDao.getBoardList(pmap);
		return boardList;
	}
	
	//=>board/boardInsert.sp4?bm_no=100&bm_title=%EC%96%B5&bs_file=a.txt&bm_writer=%EC%9D%B4%EC%88%9C%EC%8B%A0&bm_email=test@hot.com&bm_content=%EC%97%B0%EC%8A%B5&bm_pw=123
	public int boardInsert(Map<String, Object> pmap) {
		logger.info("Board41Logic - boardInsert 호출 성공");
		int result = 0;
		int fileOK = 0;
//		List<Map<String, Object>> boardInsert = null;
		boardMDao.boardMInsert(pmap);
		// 첨부파일이 있어?
		if (pmap.containsKey("bs_file")) {
			fileOK = boardSDao.boardSInsert(pmap);
		}
		logger.info("fileOk : "+fileOK);
		result = 1;
		return result;
	}
	
	public void setBoardMDao(Board41MDao boardMDao) { // spring-service에서 boardMDao
		this.boardMDao = boardMDao;
	}

	public void setBoardSDao(Board41SDao boardSDao) {
		this.boardSDao = boardSDao;
	}
	
}
