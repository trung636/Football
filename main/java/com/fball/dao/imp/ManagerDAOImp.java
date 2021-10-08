package com.fball.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fball.dao.ManagerDAO;
import com.fball.dto.ClubDTO;
import com.fball.dto.MatchSTTClub;
import com.fball.dto.STTClubDTO;
import com.fball.utils.SetParamaterForDAOUtils;

@Repository
public class ManagerDAOImp implements ManagerDAO {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<STTClubDTO> getListSTTClubByEmail(String email) {
		List<STTClubDTO> clubs = new ArrayList<>();
		String sql ="select * from stt_club \n"
				+ "where email = ?";
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			SetParamaterForDAOUtils.setParamater(ps, email);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					STTClubDTO sttClub = new STTClubDTO();
					sttClub.setId(rs.getInt("id"));
					sttClub.setName(rs.getString("name"));
					sttClub.setEnable(rs.getInt("enable"));
					sttClub.setTime_update(rs.getString("updated_date"));
					clubs.add(sttClub);
				}
			}
			return clubs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ClubDTO getClubByEmail(String email) {
		String sql = "select * from club \n"
				+ "where email = ?";
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			SetParamaterForDAOUtils.setParamater(ps, email);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					ClubDTO club = new ClubDTO();
					club.setNameClub(rs.getString("name_club"));
					club.setEmail(rs.getString("email"));
					club.setAddress(rs.getString("address"));
					club.setWard(rs.getString("ward"));
					club.setDistrict(rs.getString("district"));
					club.setCity(rs.getString("city"));
					club.setTimeStart(rs.getString("time_start"));
					club.setTimeEnd(rs.getString("time_end"));
					return club;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String addSTTClub(STTClubDTO sttClubDTO) {
		String sql = "insert into stt_club(email, name, enable) \n"
				+ "values (?,?,?)";
		
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			SetParamaterForDAOUtils.setParamater(ps, 
							sttClubDTO.getEmail(), 
							sttClubDTO.getName(), 
							sttClubDTO.getEnable());
			ps.executeUpdate();
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "fail";
	}

	@Override
	public List<STTClubDTO> getAllListSTTClub() {
		String sql = "select * from stt_club";
		List<STTClubDTO> clubs = new ArrayList<>();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					STTClubDTO club = new STTClubDTO();
					club.setEmail(rs.getString("email"));
					club.setId(rs.getInt("id"));
					clubs.add(club);
				}
				return clubs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String addMatchSTTClub(int id) {
		String sql = "insert into match_stt_club(id_stt_club, time_start, time_end) \n"
				+ "values "
				+ "( ? , '6:00', '8:00' ), \n"
				+ "( ? , '8:00', '10:00' ), \n"
				+ "( ? , '10:00', '12:00' ), \n"
				+ "( ? , '12:00', '14:00' ), \n"
				+ "( ? , '14:00', '16:00' ), \n"
				+ "( ? , '16:00', '18:00' ), \n"
				+ "( ? , '18:00', '20:00' ), \n"
				+ "( ? , '20:00', '22:00' ), \n"
				+ "( ? , '22:00', '24:00' ) ";
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			SetParamaterForDAOUtils.setParamater(ps, id,id,id,id,id,id,id,id,id);
			System.out.println(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MatchSTTClub> getMatchSTTClubById(int id) {
		String sql = "select * from match_stt_club \n"
				+ "where id_stt_club = ?";
		List<MatchSTTClub> matchClubs = new ArrayList<>();
		try(
				Connection conn =dataSource.getConnection();
				PreparedStatement ps =conn.prepareStatement(sql)){
			SetParamaterForDAOUtils.setParamater(ps, id);
			System.out.println(sql);
				try(ResultSet rs =ps.executeQuery()){
					while(rs.next()) {
						MatchSTTClub matchClub = new MatchSTTClub();
						matchClub.setId(rs.getInt("id"));
						matchClub.setIdSTTClub(rs.getInt("id_stt_club"));
						matchClub.setTimeStart(rs.getString("time_start"));
						matchClub.setTimeEnd(rs.getString("time_end"));
						matchClub.setRs(rs.getString("list_player"));
						matchClub.setState(rs.getInt("state"));
						matchClub.setDate(rs.getString("date"));
						matchClub.setMonth(rs.getString("month"));
						matchClub.setYear(rs.getString("year"));
						matchClubs.add(matchClub);
					}
					return matchClubs;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
