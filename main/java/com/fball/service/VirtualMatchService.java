package com.fball.service;

import java.util.List;

import com.fball.dto.VirtualMatchDTO;

public interface VirtualMatchService {

	List<VirtualMatchDTO> getListVirtualMatchByIdMatch(int id);

	String newVirtualMatchInId(int idVirtual, String string);

	String joinVirtualMatchInId(int id, String string);

	String cancelVirtualMatchInId(int id, String string);

}
