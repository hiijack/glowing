package org.lunjz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Viewer {

	public List<EntryInfo> extract(String path) {
		List<EntryInfo> infos = new ArrayList<>();
		
		try (JarFile jar = new JarFile(path)) {
			Enumeration<JarEntry> entries = jar.entries();
			while (entries.hasMoreElements()) {
				JarEntry ele = entries.nextElement();
				if (!ele.isDirectory()) {
					EntryInfo info = new EntryInfo();
					info.name = ele.getName();
					info.size = ele.getSize();
					infos.add(info);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return infos;
	}

	public static void main(String[] args) {
		String path = "/home/jack/Downloads/vocchio_F0825/ovp.war";
		List<EntryInfo> infos = new Viewer().extract(path);
		int i = 0;
		for (EntryInfo entry : infos) {
			System.out.println(i + ", " + entry.name);
			i++;
		}	
	}

}
