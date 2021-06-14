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
		String gubun = null;
		if (pmap.get("gubun") != null) {
			gubun = pmap.get("gubun").toString();
		}
		if (gubun != null && "detail".equals(gubun)) {
			int bm_no = 0;
			bm_no = Integer.parseInt(pmap.get("bm_no").toString());
			boardMDao.hitCount(bm_no);
		}
		boardList = boardMDao.getBoardList(pmap);
		return boardList;
	}
	
	//=>board/boardInsert.sp4?bm_no=100&bm_title=%EC%96%B5&bs_file=a.txt&bm_writer=%EC%9D%B4%EC%88%9C%EC%8B%A0&bm_email=test@hot.com&bm_content=%EC%97%B0%EC%8A%B5&bm_pw=123
	public int boardInsert(Map<String, Object> pmap) {
		logger.info("Board41Logic - boardInsert 호출 성공");
		int result = 0;
		int bm_no = 0;
		int bm_group = 0;
		if (pmap.get("bm_group") != null) { // read.jsp에서 눌렀다.
			bm_group = Integer.parseInt(pmap.get("bm_group").toString());
		}
		// 댓글이야?
		if (bm_group > 0) { // 조건에 맞지 않으면 처리가 생략될 수 있다.
			boardMDao.bmStepUpdate(pmap);
			pmap.put("bm_pos", Integer.parseInt(pmap.get("bm_pos").toString()) + 1);
			pmap.put("bm_step", Integer.parseInt(pmap.get("bm_step").toString()) + 1);
		} 
		// 넌 새글이구나.
		else {
			bm_group = boardMDao.getBmGroup();
			bm_no = Integer.parseInt(pmap.get("bm_no").toString());
			pmap.put("bm_group", bm_group);
			pmap.put("bm_pos", 0);
			pmap.put("bm_step", 0);
		}
		int fileOK = 0;
		// 첨부파일이 있어?
		if ((pmap.get("bs_file") != null) & (pmap.get("bs_file").toString().length() > 0)) {
			pmap.put("bm_no", bm_no);
			pmap.put("bm_seq", 1);
			fileOK = boardSDao.boardSInsert(pmap);
		}
//		List<Map<String, Object>> boardInsert = null;
		logger.info("1111111111111111111111111111111111111111");
		boardMDao.boardMInsert(pmap);
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
