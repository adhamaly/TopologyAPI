package com.TopologyAPI.mavenproject;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Component 
{
	public	String id;
	public	String type;
	public List<Component> components;

	
	public Component(List<Component> item) {
		this.components = item;
		
	}
	public Component() {}
	
	
	
	
}
