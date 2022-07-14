package jdme.member.dao;

import java.util.List;
import jdme.member.vo.JDMEMemberVO;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Repository
public class JDMEMemberDAOImpl implements JDMEMemberDAO {
	
	//로그선언
	Logger logger = LogManager.getLogger(JDMEMemberDAOImpl.class);
	
	//DI 필드, SqlSession
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	
	//I
	@Override
	public int jdmeMemberInsert(JDMEMemberVO jmvo) {
		logger.info("멤버DAO 멤버DAO 멤버DAO :  IIIIII ");			
		return (Integer)sqlSession.insert("jdmeMemberInsert",jmvo);
	}
	
	//ID중복체크
	@Override
	public List<JDMEMemberVO> jdmeIdCheck(JDMEMemberVO jmvo) {
		logger.info("멤버DAO 멤버DAO 멤버DAO :  LCK LCK LCK LCK ");	
		return sqlSession.selectList("jdmeIdCheck", jmvo);
	}
}
