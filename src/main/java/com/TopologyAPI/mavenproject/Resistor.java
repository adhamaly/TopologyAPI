package com.TopologyAPI.mavenproject;


public class Resistor extends Component
{
	public Resistance resistance;
	public NetList netList;

	
	
	public Resistor(String id,String type,Resistance resistance,NetList netList) {
		this.id  = id;
		this.type = type;
		this.resistance = resistance;
		this.netList = netList;
		
	}
	
}
