package com.fball.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fball.dto.VirtualMatchDTO;
import com.fball.service.VirtualMatchService;

@Controller
@RequestMapping("/virtual_match")
public class VirtualMatchController {
	
	@Autowired
	private VirtualMatchService virtualMatchService;
	
	@GetMapping
	public String virtualmatch() {
		return "redirect:/club";
	}
	
	@GetMapping("{id}")
	private String viewVirtualMatch(@PathVariable("id") int id, Model model) {
		List<VirtualMatchDTO> virtuals = virtualMatchService.getListVirtualMatchByIdMatch(id);
		model.addAttribute("virtuals", virtuals);
		model.addAttribute("idMatch", id);
		return "virtual_match";
	}
	
	@GetMapping("/new")
	private String newVirtualMatch(@RequestParam int idMatch,HttpSession session, RedirectAttributes rediresAttributes) {
		
		if(session.getAttribute("email")==null) {
			return "redirect:/login";
		}
		String result = virtualMatchService.newVirtualMatchInId(idMatch, session.getAttribute("email").toString());
		if(result.equals("newFail")) {
			rediresAttributes.addFlashAttribute("fail", true);
		}else {
			rediresAttributes.addFlashAttribute("success", true);
		}
		return "redirect:/virtual_match/"+idMatch;
	}
	
	@GetMapping("/join")
	private String joinVirtualMatch(@RequestParam int idMatch, @RequestParam int id,HttpSession session, RedirectAttributes redirectAttributes) {
		
		if(session.getAttribute("email")==null) {
			return "redirect:/login";
		}
		String result = virtualMatchService.joinVirtualMatchInId(id, session.getAttribute("email").toString());
		if(result.equals("joinFail")) {
			redirectAttributes.addFlashAttribute("joinFail", true);
		}else {
			redirectAttributes.addFlashAttribute("joinSuccess", true);
		}
		return "redirect:/virtual_match/"+idMatch;
	}
	
	@GetMapping("/cancel")
	private String cancelVirtualMatch(@RequestParam int idMatch, @RequestParam int id,HttpSession session, RedirectAttributes redirectAttributes) {
		
		if(session.getAttribute("email")==null) {
			return "redirect:/login";
		}
		String result = virtualMatchService.cancelVirtualMatchInId(id, session.getAttribute("email").toString());
		if(result.equals("cancelFail")) {
			redirectAttributes.addFlashAttribute("cancelFail", true);
		}else {
			redirectAttributes.addFlashAttribute("cancelSuccess", true);
		}
		return "redirect:/virtual_match/"+idMatch;
	}
	
}
