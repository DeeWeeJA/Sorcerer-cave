/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kareem_Nathan
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Creature extends Cave implements ActionListener {
	private int partyIndex ;
	private int empathyValue;
	private int fearValue;
	private double carryingCapacity;
	private int age;
	private int weight;
	private double height;
	private ArrayList<Treasure> treasuresList ;
	private ArrayList<Artifact> artifactsList ;


	
	/***
	 * Constructor for Creature
	 * @param index
	 * @param type
	 * @param name
	 * @param partyIndex
	 * @param empathyValue
	 * @param fearValue
	 * @param carryingCapacity
	 */
	public Creature(int index, String type, String name, int partyIndex,
			int empathyValue, int fearValue, double carryingCapacity) {
		super(index, type, name);
		treasuresList = new ArrayList<Treasure>();
		artifactsList = new ArrayList<Artifact>();
		this.partyIndex = partyIndex;
		this.empathyValue = empathyValue;
		this.fearValue = fearValue;
		this.carryingCapacity = carryingCapacity;
	}

	
	/***
	 * Constructor for PhysicalCreatures
	 * @param index
	 * @param type
	 * @param name
	 * @param partyIndex
	 * @param empathyValue
	 * @param fearValue
	 * @param carryingCapacity
	 * @param age
	 * @param weight
	 * @param height
	 */
	public Creature(int index, String type, String name, int partyIndex,
			int empathyValue, int fearValue, double carryingCapacity, int age,
			int weight, double height) {
		super(index, type, name);
		this.partyIndex = partyIndex;
		this.empathyValue = empathyValue;
		this.fearValue = fearValue;
		this.carryingCapacity = carryingCapacity;
		this.setAge(age);
		this.setWeight(weight);
		this.setHeight(height);
	}

	/***
	 * Will add Treature into list
	 * @param t
	 */
	public void addTreature(Treasure t) {
		if (t != null && t instanceof Treasure && t.getCreatureByIndex() != 0) {
			this.treasuresList.add(t);
		}
	}

	/***
	 * Will add Artifact into list
	 * @param a
	 */
	public void addArtifact(Artifact a) {
		if (a != null && a instanceof Artifact && a.getCreatureByIndex() != 0) {
			this.artifactsList.add(a);
		}
	}

	@Override
	public String toString() {
		String completeStr = "";
		completeStr += "[Creature]: \n\tType = " + this.getType() + " \n\tName = "
				+ this.getName() + " \n\tParty Index = "
				+ Integer.toString(this.partyIndex) + " \n\tEmpathy Value = "
				+ Integer.toString(this.empathyValue) + " \n\tFear Value = "
				+ Integer.toString(this.fearValue)
				+ " \n\tCarrying Capacity = "
				+ Double.toString(this.carryingCapacity);
		completeStr += "\n\t------Creature By Index------\n";
		for (Treasure t : this.treasuresList){
			completeStr += "\n\t" + t.toString();
		}
		for (Artifact a : this.artifactsList){
			completeStr += "\n\t" + a.toString();
		}
		completeStr += "\n\t-----------------------\n";
		return completeStr;
	}


	/***
	 * 
	 * @return
	 */
	public int getPartyIndex(){
		return partyIndex;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}


	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}


	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}


	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}


	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

