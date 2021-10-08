package com.fball.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fball.dao.ManagerDAO;
import com.fball.dto.ClubDTO;
import com.fball.dto.MatchSTTClub;
import com.fball.dto.STTClubDTO;
import com.fball.service.ManagerService;

@Repository
public class ManagerServiceImp implements  ManagerService {

	@Autowired
	private ManagerDAO managerDAO;
	
	@Override
	public List<STTClubDTO> getListSTTClubByEmail(String email) {
		List<STTClubDTO>  sttClub = managerDAO.getListSTTClubByEmail(email);
		return sttClub;
	}

	@Override
	public ClubDTO getClubByEmail(String email) {
		ClubDTO clubDTO = managerDAO.getClubByEmail(email);
		return clubDTO;
	}

	@Override
	public String addSTTClub(STTClubDTO sttClubDTO) {
		
		List<STTClubDTO> list = managerDAO.getListSTTClubByEmail(sttClubDTO.getEmail());
		for(var i :list) {
			if(i.getName().equals(sttClubDTO.getName())) {
				return "nameFail";
			}
		}
		String rs = managerDAO.addSTTClub(sttClubDTO);
		return rs;
	}

	@Override
	public void setTimeAllManager() {
		List<STTClubDTO> clubs = managerDAO.getAllListSTTClub();
		for(var i :clubs) {
			managerDAO.addMatchSTTClub(i.getId());
		}
	}

	@Override
	public List<MatchSTTClub> getMatchSTTClubById(int id) {
		List<MatchSTTClub> rs = managerDAO.getMatchSTTClubById(id);
		return rs;
	}

}
