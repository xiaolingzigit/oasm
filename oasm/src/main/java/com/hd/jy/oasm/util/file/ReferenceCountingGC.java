package com.hd.jy.oasm.util.file;

import java.lang.ref.WeakReference;

public class ReferenceCountingGC {
 private Object instance=null;
 private static final int _1MB=1024*1024;
 
 private byte[] bigSize = new byte[2*_1MB];
 
 public static void main(String[] args) {
	ReferenceCountingGC countingGCA = new ReferenceCountingGC();
	ReferenceCountingGC countingGCB = new ReferenceCountingGC();
	countingGCA.instance=countingGCB;
	countingGCB.instance=countingGCA;
	
	WeakReference wr = new WeakReference(countingGCA);
	
	countingGCA=null;
	wr=null;
//	countingGCB=null;
	try {
		System.gc();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
