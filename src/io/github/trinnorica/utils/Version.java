package io.github.trinnorica.utils;

public class Version {
	public String major = "0";
	public String minor = "0";
	public String distro = "0";
	
	public Version(String major, String minor, String distro){
		this.major = major;
		this.minor = minor;
		this.distro = distro;
	}
	
	public String getMajorVersion(){
		return major;
	}
	public String getMinorVersion(){
		return minor;
	}
	public String getDistroVersion(){
		return distro;
	}

	public String getVersion() {
		return major+"."+minor+"."+distro;
	}

}
