package org.lunjz;

import java.util.List;

public class Difference {
	
	public void diff(String war1, String war2) {
		Viewer viewer = new Viewer();
		List<EntryInfo> infos1 = viewer.extract(war1);
		List<EntryInfo> infos2 = viewer.extract(war2);
		
		int n = 0;
		System.out.println("file should be removed");
		for (EntryInfo e : infos1) {
			if (findNameEqualEntryInfo(e, infos2) < 0) {
				//System.out.println(e.name);
				n++;
			}
		}
		System.out.println(n);
		
		int s = 0;
		System.out.println("file should be replaced");
		for (EntryInfo e : infos1) {
			if (findEqualEntryInfo(e, infos2) < 0) {
				//System.out.println(e.name);
				s++;
			}
		}
		System.out.println(s);
		
	}
	
	private int findNameEqualEntryInfo(EntryInfo theOne, List<EntryInfo> anotherWar) {
		for (int a = 0; a < anotherWar.size(); a++) {
			if (theOne.name.equals(anotherWar.get(a).name)) {
				return a;
			}
		}
		
		return -1;
	}
	
	private int findEqualEntryInfo(EntryInfo theOne, List<EntryInfo> anotherWar) {
		for (int b = 0; b < anotherWar.size(); b++) {
			if (theOne.name.equals(anotherWar.get(b).name) && theOne.size == anotherWar.get(b).size) {
				return b;
			}
		}
		return -1;
	}
	
	

	public static void main(String[] args) {
		String war1 = "/home/jack/Downloads/vocchio_F0825/ovp.war";
		String war2 = "/home/jack/Downloads/ovp.war";
		new Difference().diff(war1, war2);
	}
}
