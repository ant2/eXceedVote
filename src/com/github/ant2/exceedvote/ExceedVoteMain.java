package com.github.ant2.exceedvote;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.ant2.exceedvote.controller.LoginController;
import com.github.ant2.exceedvote.controller.admin.ViewResultController;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.process.LoginProcess;
import com.github.ant2.exceedvote.model.process.admin.ViewResultProcess;
import com.github.ant2.exceedvote.stub.StubDaoFactory;
import com.github.ant2.exceedvote.util.UIUtility;
import com.github.ant2.exceedvote.view.LoginWindow;
import com.github.ant2.exceedvote.view.admin.ViewResultWindow;

/**
 * eXceed Vote Main Class
 * 
 * @author dtinth
 */
public class ExceedVoteMain {

	private static Logger logger = LogManager.getLogger(ExceedVoteMain.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		logger.info("eXceed Vote Starting...");

		UIUtility.setTheme();

		StubDaoFactory sdf = new StubDaoFactory();
		DaoFactory df = (DaoFactory)sdf;
		
		LoginProcess loginProcess = new LoginProcess(df);
		LoginWindow window = new LoginWindow();

		LoginController controller = new LoginController(loginProcess, window);
		controller.run();

	}

}
