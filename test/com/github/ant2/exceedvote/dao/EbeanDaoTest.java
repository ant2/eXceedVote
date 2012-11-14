package com.github.ant2.exceedvote.dao;

import org.junit.Test;

import com.github.ant2.exceedvote.dao.memory.EbeanDaoFactory;

import static org.junit.Assert.*;

public class EbeanDaoTest {

	@Test
	public void test() {
		new DaoTest().testDaoFactory(new EbeanDaoFactory());
	}

}
