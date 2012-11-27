package com.github.ant2.exceedvote.dao.ebean;

import org.junit.Test;

import com.github.ant2.exceedvote.dao.DaoTest;

public class EbeanDaoTest {

	@Test
	public void test() {
		new DaoTest().testDaoFactory(new EbeanDaoFactory());
	}

}
