/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kareem_Nathan
 */
class Treasure extends Cave {
	private int creatureByIndex;
	private double weight;
	private double value;

	/***
	 * Constructor
	 * 
	 * @param index
	 * @param type
	 * @param creatureIndex
	 * @param weight
	 * @param value
	 */
	public Treasure(int index, String type, int creatureIndex, double weight,
			double value) {
		super(type, index);
		this.creatureByIndex = creatureIndex;
		this.weight = weight;
		this.value = value;
	}

	@Override
	public String toString() {
		return "[Treasure]: \n\tType = " + this.getType() + " \nCreature By Index = "
				+ Integer.toString(this.creatureByIndex) + " \n\tWeight = "
				+ Double.toString(this.weight) + " \n\tValue = "
				+ Double.toString(this.value);
	}

	/**
	 * @return the creatureByIndex
	 */
	public int getCreatureByIndex() {
		return creatureByIndex;
	}

	/**
	 * @param creatureByIndex
	 *            the creatureByIndex to set
	 */
	public void setCreatureByIndex(int creatureByIndex) {
		this.creatureByIndex = creatureByIndex;
	}
}

