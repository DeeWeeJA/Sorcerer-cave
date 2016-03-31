/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kareem_Nathan
 */
class Artifact extends Cave {
	private int creatureByIndex;

	/***
	 * 
	 * @param index
	 * @param type
	 * @param creatureIndex
	 */
	public Artifact(int index, String type, int creatureIndex) {
		super(type, index);
		this.setCreatureByIndex(creatureIndex);
	}

	@Override
	public String toString() {
		return "[Artifact]: \n\tOwner Index = "
				+ Integer.toString(getCreatureByIndex())
				+ " \n\tArtifact Type = " + this.getType();
	}

	/**
	 * @return the creatureByIndex
	 */
	public int getCreatureByIndex() {
		return creatureByIndex;
	}

	/**
	 * @param creatureByIndex the creatureByIndex to set
	 */
	public void setCreatureByIndex(int creatureByIndex) {
		this.creatureByIndex = creatureByIndex;
	}
}
