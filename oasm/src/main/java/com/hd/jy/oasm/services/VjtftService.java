package com.hd.jy.oasm.services;

import java.util.List;

import com.hd.jy.oasm.domain.Sjjtft;
import com.hd.jy.oasm.domain.Vjtft;

public interface VjtftService {
	
	public List<Vjtft> getJtft(Vjtft vjtft);
	
	public int addJtft();
	
	public int saveJtft(Sjjtft sjjtft);
	
	public Sjjtft getJtft(String id);

}
