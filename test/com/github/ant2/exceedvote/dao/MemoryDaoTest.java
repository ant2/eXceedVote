package com.github.ant2.exceedvote.dao;

import org.junit.Test;

import com.github.ant2.exceedvote.dao.memory.MemoryDaoFactory;

public class MemoryDaoTest {

	@Test
	public void test() {
		new DaoTest().testDaoFactory(new MemoryDaoFactory());
	}

}
