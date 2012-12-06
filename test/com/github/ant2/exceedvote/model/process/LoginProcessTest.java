package com.github.ant2.exceedvote.model.process;

import org.junit.Test;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.UserDao;
import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.model.LoginResult;
import com.github.ant2.exceedvote.model.domain.User;
import com.github.ant2.exceedvote.stub.StubDaoFactory;

import static org.junit.Assert.assertEquals;

public class LoginProcessTest {

	@Test
	public void test() {

		StubDaoFactory sdf = new StubDaoFactory();
		DaoFactory df = sdf;
		UserDao dao = df.getUserDao();
		VoterDao voterDao = df.getVoterDao();

		LoginProcess process = new LoginProcess(sdf);

		LoginResult result = process.login("voter2", "pass");
		assertEquals(LoginResult.Status.SUCCESS, result.getStatus());
		assertEquals(User.Role.VOTER, result.getRole());
		assertEquals(sdf.V2, result.getVoter());

		result = process.login("voter1", "pass5");
		assertEquals(LoginResult.Status.FAILURE, result.getStatus());
		assertEquals(null, result.getRole());
		assertEquals(null, result.getVoter());

		result = process.login("com1", "pass");
		assertEquals(LoginResult.Status.SUCCESS, result.getStatus());
		assertEquals(User.Role.COMMISSION, result.getRole());
		assertEquals(sdf.COM1, result.getCommissioner());
	}

}
