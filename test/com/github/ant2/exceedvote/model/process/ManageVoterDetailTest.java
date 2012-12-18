package com.github.ant2.exceedvote.model.process;

import java.util.List;

import org.junit.Test;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.Voter;
import com.github.ant2.exceedvote.model.process.admin.EditVoterProcess;
import com.github.ant2.exceedvote.model.process.admin.ManageVoterProcess;
import com.github.ant2.exceedvote.stub.StubContext;
import com.github.ant2.exceedvote.stub.StubDaoFactory;

import static org.junit.Assert.*;

public class ManageVoterDetailTest {

	

	@Test
	public void test() {
		
		StubContext context = new StubContext();
		StubDaoFactory sdf = context.getDaoFactory();
		
		DaoFactory df = (DaoFactory)sdf;
		
		ManageVoterProcess process = new ManageVoterProcess(df, sdf.EVENT);
		
		List<Voter> voters;
		
		{
			voters = process.getAllVoters();
			assertTrue(voters.contains(sdf.V1));
			assertTrue(voters.contains(sdf.V2));
		}
		
		{
			Voter voter = voters.get(0);
			EditVoterProcess editProcess = process.editVoter(voter);
			editProcess.setName("Ki");
			editProcess.setUsername("KiKi");
			editProcess.setPassword("kikiki");
			editProcess.save();
			assertEquals("Ki", voter.getName());
			assertEquals("KiKi", voter.getUser().getUsername());
			assertEquals("kikiki", voter.getUser().getPass());
		}
		Voter v3;
		{
			Voter voter = v3 = sdf.EVENT.createVoter();
			assertNotNull(voter.getUser());
			EditVoterProcess editProcess = process.editVoter(voter);
			editProcess.setName("Ki2");
			editProcess.setUsername("KiKi2");
			editProcess.setPassword("kikiki2");
			editProcess.save();
			assertEquals("Ki2", voter.getName());
			assertEquals("KiKi2", voter.getUser().getUsername());
			assertEquals("kikiki2", voter.getUser().getPass());
		}
		
		{
			voters = process.getAllVoters();
			assertTrue(voters.contains(sdf.V1));
			assertTrue(voters.contains(sdf.V2));
			assertTrue(voters.contains(v3));
		}
		
	}

}
