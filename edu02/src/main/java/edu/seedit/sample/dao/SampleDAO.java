package edu.seedit.sample.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.seedit.common.dao.AbstractDAO;
import edu.seedit.sample.vo.SampleVO;

@Repository("SampleDAO")
public class SampleDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<SampleVO> selectSampleList(SampleVO in) throws Exception {
		return (List<SampleVO>)list("selectSampleList", in);
		//return null;
	}

}
