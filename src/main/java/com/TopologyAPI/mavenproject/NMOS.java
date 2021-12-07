package com.TopologyAPI.mavenproject;


public class NMOS  extends Component{

	public Resistance ml;
	public NmosNetList netList;
	

	
	public NMOS(String id,String type,Resistance resistance,NmosNetList netList) {
		super();
		this.id  = id;
		this.type = type;
		this.ml = resistance;
		this.netList = netList;
		
	}
	
}
