package com.github.ant2.exceedvote.dao;

import org.junit.Test;

import com.github.ant2.exceedvote.dao.memory.EbeanDaoFactory;
import com.github.ant2.exceedvote.dao.memory.MemoryDaoFactory;

import static org.junit.Assert.*;

public class MemoryDaoTest {

	@Test
	public void test() {
		new DaoTest().testDaoFactory(new MemoryDaoFactory());
	}

}
