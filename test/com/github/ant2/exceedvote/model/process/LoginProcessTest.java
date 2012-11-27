package com.github.ant2.exceedvote.model.process;

import org.junit.Test;

import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.model.domain.Voter;
import com.github.ant2.exceedvote.stub.StubContext;
import com.github.ant2.exceedvote.stub.StubDaoFactory;

import static org.junit.Assert.*;

public class LoginProcessTest {

	@Test
	public void test() {
		
		StubDaoFactory sdf = context.getDaoFactory();
		UserDao dao = sdf.getUserDao();
		VoterDao voterDao = sdf.getVoterDao();
		
		User user = new User("maariisan", "kikikikiki");
		Voter voter = sdf.V2;
		voter.setUser(user);
		voterDao.save(voter);
		dao.save(user);
		
		LoginProcess process = new LoginProcess(sdf);

		LoginResult result = process.login("maariisan", "kikikikiki");
		assertEquals(LoginResult.Status.SUCCESS, result.getStatus());
		assertEquals(User.Role.VOTER, result.getRole());
		assertEquals(sdf.V2, result.getVoter());

		result = process.login("maariisan", "kikikikikiz");
		assertEquals(LoginResult.Status.FAILURE, result.getStatus());
		assertEquals(null, result.getRole());
		assertEquals(null, result.getVoter());
		
	}

}
