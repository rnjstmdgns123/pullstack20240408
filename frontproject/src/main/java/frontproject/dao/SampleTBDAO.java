package frontproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import frontproject.vo.SampleTBVO;

public class SampleTBDAO {

	private final String url = "jdbc:mysql://localhost:3306/sample";
	private final String id = "root";
	private final String pw = "ezen";

	public List<SampleTBVO> selectList() {

		Connection conn = null; // 쿼리를 담는 그릇
		PreparedStatement psmt = null; // 쿼리를 호출하는 객체
		ResultSet rs = null; // 리스트를 조회하기 위해서 필요한 객체

		try {
			// 라이브러리를 사용하겠다고 불러오는 코드
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);

			String sql = "select * from sampleTB";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			List<SampleTBVO> slist = new ArrayList<SampleTBVO>();

			while (rs.next()) {

				SampleTBVO svo = new SampleTBVO();

				svo.setSno(rs.getInt("sno"));
				svo.setTitle(rs.getString("title"));
				svo.setWriter(rs.getString("writer"));
				svo.setRdate(rs.getString("rdate"));
				svo.setBody(rs.getString("body"));

				slist.add(svo);

			}
			
			return slist;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { // 컴파일러 예외처리 떄문에 추가로 try-catch 작성
				if (conn != null)
					conn.close();
				if (psmt != null)
					psmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public SampleTBVO selectOne(int sno) {

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);

			String sql = "select * from sampleTB where sno=?";

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sno);
			rs = psmt.executeQuery();

			SampleTBVO svo = null;
			if (rs.next()) {
				svo = new SampleTBVO();

				svo.setSno(rs.getInt("sno"));
				svo.setTitle(rs.getString("title"));
				svo.setWriter(rs.getString("writer"));
				svo.setRdate(rs.getString("rdate"));
				svo.setBody(rs.getString("body"));

			}
			return svo;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public int update(SampleTBVO svo) { //따로 보내도 상관없음

		Connection conn = null; // 쿼리를 담는 그릇
		PreparedStatement psmt = null; // 쿼리를 호출하는 객체

		
		try {
			// 라이브러리를 사용하겠다고 불러오는 코드
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);

			String sql = " update sampleTB " + " set title   = ? " + " , writer    = ? " + " , body      = ? "
					+ " where  sno  = ? ";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, svo.getTitle());
			psmt.setString(2, svo.getWriter());
			psmt.setString(3, svo.getBody());
			psmt.setInt(4, svo.getSno());

			int result = psmt.executeUpdate();

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { // 컴파일러 예외처리 떄문에 추가로 try-catch 작성
				if (conn != null)
					conn.close();
				if (psmt != null)
					psmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	
	public int insert(SampleTBVO svo) {
		
		Connection conn = null; // 쿼리를 담는 그릇
		PreparedStatement psmt = null; // 쿼리를 호출하는 객체

		
		try {
			// 라이브러리를 사용하겠다고 불러오는 코드
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);

			String sql = "insert into sampleTB(title,writer,body,rdate) values(?,?,?,now())";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, svo.getTitle());
			psmt.setString(2, svo.getWriter());
			psmt.setString(3, svo.getBody());

			int result = psmt.executeUpdate();

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { // 컴파일러 예외처리 떄문에 추가로 try-catch 작성
				if (conn != null)
					conn.close();
				if (psmt != null)
					psmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
		
		
		
	}
	
	
	
	
}
