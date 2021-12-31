package jdbc;

import java.io.BufferedReader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.sql.DataSource;


public class SqlExecute{

	private String jndiName = "";
	private String schemaPattern = "";
	private String tableNamePattern = "";	
	private DataSource ds = null;

	/*
	 * SQL 결과 조회
	 */
	public HashMap<String, Object> executeQuery(String sql, int limit, String lobCheck)throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		
		BufferedReader br = null;
		
		HashMap<String, Object> map = new HashMap();
		List<String> data_header = new ArrayList();
		List<String> data_type = new ArrayList();
		List<HashMap<String, Object>> data_list = new ArrayList();
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			long startTm = System.currentTimeMillis();
			
			rs = pstmt.executeQuery();
			
			long endTm = System.currentTimeMillis();
			
			//ResultSetMeta 정보로 Column Header 세팅
			ResultSetMetaData rsmd = rs.getMetaData();
			int dataHeaderCnt = rsmd.getColumnCount();
			
			for(int i=1; i <= dataHeaderCnt; i++) {
				data_header.add(rsmd.getColumnName(i));
				data_type.add(rsmd.getColumnTypeName(i));
			}
			
			//Column Body 세팅 (row 단위)
			HashMap<String, Object> rowMap = new HashMap();
			
			//요청받은 limit 시점이나 ResultSet 에 없을때 까지 꺼낸다 
			for(int row=1; row <= limit && rs.next(); row++) {
				rowMap = new HashMap();
				
				//row처리
				for(int index=1; index <= dataHeaderCnt; index++) {
					
					Object columnObj = rs.getObject(index) == null ? "" : rs.getObject(index);					
					
					//Clob 처리
					if(columnObj instanceof Clob) {
						
						//Clob 데이터 보기 옵션이 Y일 때만 String 으로 parsing
						if("Y".equals(lobCheck)) {
							Clob clob = null;
							try {
								clob = rs.getClob(index);

								br = new BufferedReader(clob.getCharacterStream());
								StringBuffer sb = new StringBuffer();
								String tmpStr = null;
								
								while((tmpStr = br.readLine())!=null) {
									sb.append(tmpStr);
								}
								//현재 관리콘솔 버전에서는 html 페이지 렌더링 전에 호출 되므로 HTML Character Entity 변환을 해서 보내준다.
								rowMap.put(rsmd.getColumnName(index), convertHtmlChars(sb.toString()));
								
							}catch(Exception e) {
								throw e;
							}finally {
								if(clob != null) {
									clob.free();
								}
							}
						}else {
							rowMap.put(rsmd.getColumnName(index), rsmd.getColumnTypeName(index));	
						}
					}
					else if(columnObj instanceof String) {
						rowMap.put(rsmd.getColumnName(index), convertHtmlChars(rs.getString(index)));
					}
					else {
						rowMap.put(rsmd.getColumnName(index), columnObj);						
					}
				}
				data_list.add(rowMap);				
			}
			
			long dataLoadEndTm = System.currentTimeMillis();
			long query_interval = endTm - startTm;
			long dataLoad_interval = dataLoadEndTm - startTm;
			
			map.put("query_interval", query_interval);
			map.put("dataLoad_interval", dataLoad_interval);
			map.put("data_header", data_header);
			map.put("data_type", data_type);
			map.put("data_list", data_list);
			
			return map;			

		}catch(Exception e) {
			throw e;
			
		}finally {
			try {if(rs != null) {rs.close();}}catch(Exception se) {}
			try {if(pstmt != null) {pstmt.close();}}catch(Exception se) {}
			try {if(conn != null) {conn.close();}}catch(Exception se) {}
		}
	}
	
	/*
	 * 테이블 목록 조회 ( TABLE_NAME LIKE 'NJF%')
	 */	
	public List<String> getNjfTables()throws Exception{
		
		Connection conn = null;
		ResultSet rs = null;
		
		List<String> tableList = new ArrayList();
		
		try {
			conn = ds.getConnection();			
			DatabaseMetaData dbmd = conn.getMetaData();
			rs = dbmd.getTables(null, schemaPattern, tableNamePattern, new String[]{"TABLE"});
			
			while(rs.next()) {
				tableList.add(rs.getString(3));
			}
			return tableList;
					
		}catch(Exception e) {
			throw e;
			
		}finally {
			try {if(rs != null) {rs.close();}}catch(Exception se) {}
			try {if(conn != null) {conn.close();}}catch(Exception se) {}
		}
	}	
	
	
    public void setDataSource() throws Exception{

		if(null == jndiName) {
			jndiName = "jdbc/app name";
		}
		if(null == schemaPattern) {
			schemaPattern = "OWNER Name%";
		}					
		if(null == tableNamePattern) {
			tableNamePattern = "table name%";
		}
		
		InitialContext context = new InitialContext();
		ds = (DataSource)context.lookup(jndiName);
    }	
    
	/*
	 *  HTML Character Entity 변환
	 */
    public String convertHtmlChars(String htmlstr)throws Exception{
		
    	if(htmlstr == null || "".equals(htmlstr)) {
    		return "";
    	}
    	String rtnStr = htmlstr;
    	rtnStr = rtnStr.replaceAll("<", "&lt;");
    	rtnStr = rtnStr.replaceAll(">", "&gt;");
    	rtnStr = rtnStr.replaceAll("\"", "&quot;");
    	rtnStr = rtnStr.replaceAll("&nbsp;", "&amp;nbsp;");
    	
        return rtnStr;
    }
}
