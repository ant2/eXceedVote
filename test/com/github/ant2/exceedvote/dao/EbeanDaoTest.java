package com.github.ant2.exceedvote.dao;

import org.junit.Test;

import com.github.ant2.exceedvote.dao.ebean.EbeanDaoFactory;

public class EbeanDaoTest {

	@Test
	public void test() {
		new DaoTest().testDaoFactory(new EbeanDaoFactory());
	}

}
