package com.github.ant2.exceedvote.dao;

import java.util.List;

import com.github.ant2.exceedvote.dao.jpa.JPADaoFactory;
import com.github.ant2.exceedvote.model.domain.Voter;

public class ConsoleDaoTest {

	private DaoFactory df;

	public ConsoleDaoTest(DaoFactory daoFactory) {
		this.df = daoFactory;
	}

	public static void main(String[] args) {
		ConsoleDaoTest test = new ConsoleDaoTest(new JPADaoFactory());
		test.testVoterDao();
	}

	private void testVoterDao() {
		
		Voter harry = new Voter();
		harry.setName("Harry Potter");
		harry.setStudentId("123456");
		
		VoterDao dao = df.getVoterDao();
		dao.save(harry);
		
		// does harry potter have an id?
		System.out.println("Saved Harry Potter with id " + harry.getId() );
		
		// find Harry!
		Voter voter = dao.find(harry.getId());
		System.out.println( "Found " + voter );
		
		// find all!
		List<Voter> all = dao.findAll();
		System.out.println("Voters in database: " + all.size() ); 
		for (Voter x : all) System.out.println(x);
		
	}
	
}
