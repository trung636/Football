package com.fball.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fball.dto.ClubDTO;
import com.fball.dto.MatchSTTClub;
import com.fball.dto.STTClubDTO;
import com.fball.service.ManagerService;

@Controller
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@GetMapping("/club")
	private String managerClub(HttpSession session,Model model ) {
		if(session.getAttribute("email")==null) {
			return "redirect:/login";
		}
		ClubDTO clubDTO = managerService.getClubByEmail(session.getAttribute("email").toString());
		
		List<STTClubDTO> sttClubs = managerService.getListSTTClubByEmail(session.getAttribute("email").toString());

		model.addAttribute("clubDTO", clubDTO);
		model.addAttribute("sttClubs", sttClubs);
		return "club";
	}
	
	@GetMapping("/view_add_sttClub")
	private String viewAddSTTClub() {
		return "view_add_sttClub";
	}
	
	@PostMapping("/add_sttClub")
	private String addSTTClub(@ModelAttribute STTClubDTO sttClubDTO, HttpSession session, RedirectAttributes redirectAttributes) {
		
		if(session.getAttribute("email")==null) {
			return "redirect:/login";
		}
		sttClubDTO.setEmail(session.getAttribute("email").toString());
		String rs = managerService.addSTTClub(sttClubDTO);
		if(rs.equals("nameFail")) {
			redirectAttributes.addFlashAttribute("nameFail", true);
			return "redirect:/view_add_sttClub";
		}
		
		redirectAttributes.addFlashAttribute("addSuccess", true);
		return"redirect:/club";
	}
	
	@GetMapping("match_stt_club/{id}")
	public String viewMatchSTTClub(@PathVariable("id") int id, Model model) {
		List<MatchSTTClub> matchClubs = managerService.getMatchSTTClubById(id);
		model.addAttribute("matchClubs", matchClubs);
		return	"match";
	}
	
	@GetMapping("/set_time")
	public String setTimeAllManager() {
		managerService.setTimeAllManager();
		return "redirect:/notifi";
	}
	
}
