package com.fball.service;

import java.util.List;

import com.fball.dto.ClubDTO;
import com.fball.dto.MatchSTTClub;
import com.fball.dto.STTClubDTO;

public interface ManagerService {

	List<STTClubDTO> getListSTTClubByEmail(String email);

	ClubDTO getClubByEmail(String email);

	String addSTTClub(STTClubDTO sttClubDTO);

	void setTimeAllManager();

	List<MatchSTTClub> getMatchSTTClubById(int id);

}
