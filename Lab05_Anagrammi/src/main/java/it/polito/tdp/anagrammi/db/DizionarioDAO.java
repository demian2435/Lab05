package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DizionarioDAO {

	public boolean esisteParola(String parola) {
		final String sql = "SELECT * FROM parola WHERE nome = ?";

		Boolean result = false;

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parola);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				result = true;
			}

			conn.close();

			return result;
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

	public Map<String, Boolean> esisteParole(Set<String> parole) {
		final String sql = "SELECT * FROM parola WHERE nome = ?";

		Map<String, Boolean> result = new HashMap<String, Boolean>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			for (String s : parole) {
				st.setString(1, s);
				ResultSet rs = st.executeQuery();
				result.put(s, rs.next());
			}

			conn.close();

			return result;
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

}
