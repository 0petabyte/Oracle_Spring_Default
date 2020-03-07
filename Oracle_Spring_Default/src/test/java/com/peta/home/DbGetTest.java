package com.peta.home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DbGetTest {
	@Inject
	private DataSource ds;

	private PreparedStatement pstmt;
	
	@Test
	public void testConection()throws Exception{
		try(Connection con = ds.getConnection()){
			System.out.println("디비연결성공");
			String query = "select * from tab";
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			while(rs.next()) {
				String id = rs.getString("TNAME");
				System.out.println(id);
			}
			
		}catch(Exception e) {
			System.out.println("디비연결실패");
			e.printStackTrace();
		}
		
	}
	
}
