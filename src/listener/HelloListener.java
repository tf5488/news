package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HelloListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("开始关闭!");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("开始启动!");
	}

}
