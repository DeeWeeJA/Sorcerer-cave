/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kareem_Nathan
 */
import java.util.ArrayList;

public class Party extends Cave {
	public String location;
	public ArrayList<Creature> creaturesList;

	/***
	 * Constructor
	 * @param index
	 * @param name
	 */
	public Party(int index, String name) {
		super(index, name);
		creaturesList = new ArrayList<Creature>();
	}

	/***
	 * Add Creature 
	 * @param c
	 */
	public void addCreature(Creature c) {
		if (c != null && c instanceof Creature) {
			this.creaturesList.add(c);
		}
	}

	@Override
	public String toString() {
		String output = "";
		output += "Party: \nName = " + this.getName() + " \nIndex = "
				+ Integer.toString(this.getIndex());
		output += "\n---------Creatures Details---------\n";
		for (Creature c : this.creaturesList)
			output += "\n\t" + c.toString();
		output += "\n----------------------------------\n";
		return output;
	}
}

