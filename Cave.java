/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kareem_Nathan
 */
public class Cave {
	private int index;
	private String type ;
	private String name ;

    /***
	 * Constructor
	 * @param index
	 */
	public Cave(int index) {
		this.setIndex(index);
	}

	/***
	 * 
	 * @param index
	 * @param type
	 * @param name
	 */
	public Cave(int index, String type, String name) {
		this.setIndex(index);
		this.setType(type);
		this.setName(name);
	}

	
	/***
	 * 
	 * @param index
	 * @param name
	 */
	public Cave(int index, String name) {
		this.setIndex(index);
		this.setName(name);
	}

	/***
	 * 
	 * @param type
	 * @param index
	 */
	public Cave(String type, int index) {
		this.setIndex(index);
		this.setType(type);
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}

