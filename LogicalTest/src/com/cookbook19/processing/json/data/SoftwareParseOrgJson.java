package com.cookbook19.processing.json.data;

public class SoftwareParseOrgJson {

	private String name;
	private String version;
	private String description;
	private String className;
	private String[] contributors;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String[] getContributors() {
		return contributors;
	}
	public void setContributors(String[] contributors) {
		this.contributors = contributors;
	}
	
}
