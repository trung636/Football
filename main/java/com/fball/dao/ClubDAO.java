package com.fball.dao;

import javax.servlet.http.HttpSession;

import com.fball.dto.AccountDTO;
import com.fball.dto.ClubDTO;

public interface ClubDAO {

	String checkAccountClub(AccountDTO accountDTO, HttpSession session);

	ClubDTO getClubByEmail(String email);

	String addClub(ClubDTO clubDTO);

}
