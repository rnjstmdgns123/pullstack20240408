package frontproject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
  froncontroller는 모든 가상경로를 제일 먼저 받아
  역할에 맞는 컨트롤러로 요청을 분기하는 처리를 한다.
 */
public class FrontController extends HttpServlet {

	
	
	
	
    public FrontController() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//url은 도메인이 포함되어있음
		//url은 도메인을 떈 뒤의 경로
		//서블릿을 시작하고 있기때문에 projectpath는 필요 없음
		String requestURL = request.getRequestURI(); //전체 urI(도메인제외)
		String contextPath = request.getContextPath(); //프로젝트 path
		
		String command = requestURL.substring(contextPath.length()+1); //프로젝트 path를 제외한 uri
		
		String[] uris = command.split("/");
		if(uris[0].equals("sampleTB")) {
			System.out.println("sampleTB 요청!");
			
			SampleTBController sampleTBController = new SampleTBController();
			
			sampleTBController.getAction(request, response, uris);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//url은 도메인이 포함되어있음
				//url은 도메인을 떈 뒤의 경로
				//서블릿을 시작하고 있기때문에 projectpath는 필요 없음
				String requestURL = request.getRequestURI(); //전체 urI(도메인제외)
				String contextPath = request.getContextPath(); //프로젝트 path
				
				String command = requestURL.substring(contextPath.length()+1); //프로젝트 path를 제외한 uri
				
				String[] uris = command.split("/");
				if(uris[0].equals("sampleTB")) {
					System.out.println("sampleTB 요청!");
					
					SampleTBController sampleTBController = new SampleTBController();
					
					sampleTBController.postAction(request, response, uris);
				}
	}

}
