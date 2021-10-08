package com.fball.service;

import com.fball.dto.AccountDTO;
import com.fball.dto.PlayerDTO;

public interface PlayerService {

	PlayerDTO getPlayerByEmail(String email);

	String updateProfile(String email, PlayerDTO playerDTO);

	String changePassword(AccountDTO accountDTO);

}
