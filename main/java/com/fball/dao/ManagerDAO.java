package com.fball.dao;

import java.util.List;

import com.fball.dto.ClubDTO;
import com.fball.dto.MatchSTTClub;
import com.fball.dto.STTClubDTO;

public interface ManagerDAO {

	List<STTClubDTO> getListSTTClubByEmail(String email);

	ClubDTO getClubByEmail(String email);

	String addSTTClub(STTClubDTO sttClubDTO);

	List<STTClubDTO> getAllListSTTClub();

	String addMatchSTTClub(int id);

	List<MatchSTTClub> getMatchSTTClubById(int id);


}
