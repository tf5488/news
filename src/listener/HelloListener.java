package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HelloListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("��ʼ�ر�!");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("��ʼ����!");
	}

}
