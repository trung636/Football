package com.fball.service.imp;

import java.util.List;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fball.dao.VirtualMatchDAO;
import com.fball.dto.VirtualMatchDTO;
import com.fball.service.VirtualMatchService;

@Service
public class VirtualMatchServiceImp implements VirtualMatchService {
	
	@Autowired
	private VirtualMatchDAO virtualMatchDAO;

	@Override
	public List<VirtualMatchDTO> getListVirtualMatchByIdMatch(int idMatch) {
		
		List<VirtualMatchDTO> virtuals = virtualMatchDAO.getListVirtualMatchByIdMatch(idMatch);
		if(virtuals.isEmpty()) {
			return null;
		}
		return virtuals;
		
	}

	@Override
	public String newVirtualMatchInId(int idMatch, String email) {
		List<VirtualMatchDTO> virtuals = virtualMatchDAO.getListVirtualMatchByIdMatch(idMatch);
		StringJoiner str = new StringJoiner(",");
		for(var i : virtuals) {
			str.add(i.getList());
		}
		String[] check = str.toString().split(",");
		for(var i : check) {
			if(i.equals(email)) {
				return "newFail";
			}
		}
		String result = virtualMatchDAO.newVirtualMatchInId(idMatch, email);
		return result;
	}

	@Override
	public String joinVirtualMatchInId(int id, String email) {
		VirtualMatchDTO virtual = virtualMatchDAO.getVirtualMatchById(id);
		StringJoiner str = new StringJoiner(",");
		String[] b = virtual.getList().split(",");
		for(var i : b) {
			if(i.equals(email)) {
				return "joinFail";
			}else {
				str.add(i);
			}
		}
		str.add(email);
		virtual.setList(str.toString());
		String result = virtualMatchDAO.updateVirtualMatchbyId(virtual);
		return result;
	}

	@Override
	public String cancelVirtualMatchInId(int id, String email) {
		VirtualMatchDTO virtual = virtualMatchDAO.getVirtualMatchById(id);
		StringJoiner str = new StringJoiner(",");
		String[] b = virtual.getList().split(",");
		for(var i : b) {
			if(!i.equals(email)) {
				return "cancelFail";
			}
		}
		if(b.length==1) {
			virtualMatchDAO.deleteVirtualMatch(id);
			return "success";
		}
		for(var j : b) {
			if(j.equals(email)) {
				
			}else {
				str.add(j);
			}
		}
		virtual.setList(str.toString());
		String result = virtualMatchDAO.updateVirtualMatchbyId(virtual);
		return result;
	}

}
