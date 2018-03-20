package com.hd.jy.oasm.services;

import java.util.List;

import com.hd.jy.oasm.domain.Rjpgsj;

public interface RjpgsjService {
	public List<Rjpgsj> selectDistinct();
	
	public List<Rjpgsj> selectByRjpgsjQh(Long qh);
}
