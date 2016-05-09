package Utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.pool.DruidPooledConnection;

public class JdbcUtils {

	/**
	 * ���ӡ�ɾ������
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static boolean updateByPreparedStatement(String sql,
			List<Object> params, DruidPooledConnection connection)
			throws SQLException {
		boolean flag = false;
		int result = -1;
		PreparedStatement pstmt;
		pstmt = connection.prepareStatement(sql);
		int index = 1;
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		result = pstmt.executeUpdate();
		flag = result > 0 ? true : false;
		pstmt.close();
		connection.close();
		return flag;
	}

	/**
	 * ��ѯ������¼
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static Map<String, Object> findSimpleResult(String sql,
			List<Object> params, DruidPooledConnection connection)
			throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		PreparedStatement pstmt;
		ResultSet resultSet;
		int index = 1;
		pstmt = connection.prepareStatement(sql);
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		resultSet = pstmt.executeQuery();// ���ز�ѯ���
		ResultSetMetaData metaData = resultSet.getMetaData();
		int col_len = metaData.getColumnCount();
		while (resultSet.next()) {
			for (int i = 0; i < col_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultSet.getObject(cols_name);
				if (cols_value == null) {
					cols_value = "";
				}
				map.put(cols_name, cols_value);
			}
		}
		pstmt.close();
		resultSet.close();
		connection.close();
		return map;
	}
	
	public static  boolean isExist(String sql, DruidPooledConnection connection) throws SQLException{
		boolean flag = false;
		PreparedStatement pstmt;
		ResultSet resultSet;
		pstmt = connection.prepareStatement(sql);
		resultSet = pstmt.executeQuery();
		if(resultSet != null && resultSet.next()){
			flag = true;
		} else {
			flag = false;
		}
		if(resultSet != null)
			resultSet.close();
		if(pstmt != null)
			pstmt.close();
		connection.close();
		return flag;
	}
	

	/**
	 * ��ѯ������¼
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static List<Map<String, Object>> findModeResult(String sql,
			List<Object> params, DruidPooledConnection connection)
			throws SQLException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		PreparedStatement pstmt;
		ResultSet resultSet;
		int index = 1;
		pstmt = connection.prepareStatement(sql);
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		resultSet = pstmt.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int cols_len = metaData.getColumnCount();
		while (resultSet.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 0; i < cols_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultSet.getObject(cols_name);
				if (cols_value == null) {
					cols_value = "";
				}
				map.put(cols_name, cols_value);
			}
			list.add(map);
		}
		pstmt.close();
		resultSet.close();
		connection.close();
		return list;
	}

}