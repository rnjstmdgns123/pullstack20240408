package frontproject.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frontproject.dao.SampleTBDAO;
import frontproject.vo.SampleTBVO;

public class SampleTBController {

	
	public void getAction(HttpServletRequest request, HttpServletResponse response, String[] uris) throws ServletException, IOException {
		//frontcontroller에서 sampleTB관련 모든 요청을 받아서
		//각 목적에 맞는 메소드로 분기하는 영역
		
		if(uris[1].equals("list.do")) {
			list(request, response);
		}else if(uris[1].equals("view.do")) {
			view(request, response);
		}else if(uris[1].equals("modify.do")) {
			modify(request, response);
		}else if(uris[1].equals("write.do")) {
			insert(request, response);
		}
		
		
		
	}
	
	public void postAction(HttpServletRequest request, HttpServletResponse response, String[] uris) throws ServletException, IOException {
		//frontcontroller에서 sampleTB관련 모든 요청을 받아서
		//각 목적에 맞는 메소드로 분기하는 영역
		
		if(uris[1].equals("modify.do")) {
			modifyOk(request, response);
		}else if(uris[1].equals("write.do")) {
			insertOk(request, response);
		}
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SampleTBDAO sampleTBDao = new SampleTBDAO();
		
		List<SampleTBVO> slist = sampleTBDao.selectList();
		
		//System.out.println(sampleTBDao.selectList()+"??????????????????????????");
		
		request.setAttribute("slist", slist);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/list.jsp");
		rd.forward(request, response);
		
	}
	
	private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String snoParam = request.getParameter("sno");
		System.out.println(snoParam);
		int sno = 0;
		
		if(snoParam != null && !snoParam.equals("")) {
			sno = Integer.parseInt(snoParam);
		}else {
			response.sendRedirect("list.do");
		}
		System.out.println(sno + "2222222222222222222222222");
		SampleTBDAO sampleTBDao = new SampleTBDAO();
		
		SampleTBVO svo = sampleTBDao.selectOne(sno);
		System.out.println(svo + "111111111111111111111111111111111111111");
		request.setAttribute("svo", svo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/view.jsp");
		rd.forward(request, response);
	}
	
	private void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			System.out.println("2222222222222222222222222");
			String snoParam = request.getParameter("sno");
			System.out.println(snoParam);
			int sno = 0;
			
			if(snoParam != null && !snoParam.equals("")) {
				sno = Integer.parseInt(snoParam);
			}else {
				response.sendRedirect("list.do");
			}
			System.out.println(sno + "2222222222222222222222222");
			SampleTBDAO sampleTBDao = new SampleTBDAO();
			
			SampleTBVO svo = sampleTBDao.selectOne(sno);
			System.out.println(svo + "111111111111111111111111111111111111111");
		
			request.setAttribute("svo", svo);
			
			//RequestDispatcher request에 담긴 정보를 저장하고 있다가 그 다음 페이지 그 다음 페이지에도 해당 정보를
			//볼 수 있게 계속 저장해주는 기능
			//RequestDispathcer 없이 forward를 하게 되면 A.jsp ->Servlet -> B.jsp까지는
			//파라미터 정보가 넘어가지만 그 다음 단계에서 A.jsp의 파라미터를 별도로 저장하지 않으면 소실됨
			//파라미터 정보 유지를 위해 RequestDispatcher를 사용
			//() 안의 페이지로 데이터 전달
			RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/modify.jsp");
			
			//forward A.jsp -> Servlet -> B.jsp로 넘어감에 따라 A.jsp가 가지고 있는 파라미터 정보를
			//B.jsp로 넘겨줌
			rd.forward(request, response);
		
		
		
	}
	
	private void modifyOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String snoParam = request.getParameter("sno");
		int sno = 0;
		if(snoParam != null && !snoParam.equals("")) {
			sno = Integer.parseInt(snoParam);
		}
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String body = request.getParameter("body");
		
		SampleTBVO svo = new SampleTBVO();
		svo.setSno(sno);
		svo.setTitle(title);
		svo.setWriter(writer);
		svo.setBody(body);
		
		SampleTBDAO sampleTBDao = new SampleTBDAO();
		int result = sampleTBDao.update(svo);
		
		if(result>0) {
			//���� ����
			response.sendRedirect("view.do?sno="+sno);
		}else {
			//���� ����
			response.sendRedirect("modify.do?sno="+sno+"&msg=fail");
		}
		
		
		
		
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/write.jsp");
		rd.forward(request, response);


		
		
		
		
		
	}
	private void insertOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.setCharacterEncoding("utf-8");
		String snoParam = request.getParameter("sno");
		int sno = 0;
		if(snoParam != null) {
			sno = Integer.parseInt(snoParam);
		}
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String body = request.getParameter("body");
		
		SampleTBVO svo = new SampleTBVO();
		
		System.out.println(sno+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		svo.setTitle(title);
		svo.setBody(body);
		svo.setWriter(writer);
		
		SampleTBDAO sampleTBDao = new SampleTBDAO();
		
		int result = sampleTBDao.insert(svo);
		int sio = svo.getSno();
		
		if(result > 0) {
			//수정완료
			//서버쪽에 요청하기 떄문에 path부터 다 넣어줘야됨. jsp가 아닌 가상경로로 보냄
			response.sendRedirect(request.getContextPath()+"/sampleTB/view.do?sno="+sio);
		}else {
			//수정 미완료
			response.sendRedirect(request.getContextPath()+"/sampleTB/modify.do?sno="+sno+"&msg=fail");
		}
		
		
		
		
	}
}
