/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * File name: Sorcerercave
 * @author Kareem_Nathan
 * 03/28/2016
 * 
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Game extends JFrame implements ActionListener {

	/** File Name */
	private String fileName;
	/** Willsave cave elements */
	private HashMap<Integer, Cave> caveElements = new HashMap<Integer, Cave>();

	private ArrayList<Cave> loners = new ArrayList<Cave>();

	private ArrayList<Party> parties = new ArrayList<Party>();
	Party party;
	Creature creature;
	Treasure treasure;
	Artifact artifact;

	/***/
	private JTextArea output;

	/***/
	private JFileChooser fileChooser;

	/***/
	private JButton loadButton;
	/***/
	private JButton showData;

	/***/
	private JScrollPane completePanel;

	/***/
	private JPanel panel;
	private JButton serachButton;

	/***/

	public Game() {

		panel = new JPanel();
		fileChooser = new JFileChooser(".");
		output = new JTextArea("You can perform following operation:\n"
				+ "1. Search \n" + "2.Show data\n" + "3.Load data\n");
		showData = new JButton("Show Data");
		loadButton = new JButton("Load File");
		serachButton = new JButton("Search Data");
		this.loadButton.addActionListener(this);
		this.showData.addActionListener(this);
		this.serachButton.addActionListener(this);
		completePanel = new JScrollPane(output);
		add(completePanel, BorderLayout.CENTER);
		panel.add(loadButton);
		panel.add(showData);

		panel.add(serachButton);
		add(panel, BorderLayout.PAGE_END);

		setTitle("Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400, 400);
		setVisible(true);

	}

	public Game(String dataFileName) throws IOException {
		this.fileName = dataFileName;
		this.loadFileData(dataFileName);
	}

	/***
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public void setGameElements(String fileName) throws IOException {
		this.loadFileData(fileName);
	}

	/***
	 * 
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/***
	 * 
	 * @return
	 */
	public String getFileName() {
		return this.fileName;
	}

	/****
	 * Laod file data
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	private void loadFileData(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		for (String line : lines) {
			line = line.replaceAll("\\s", "");
			if (!line.startsWith("//") && line.length() > 0) {
				String[] lineparts = line.split(":");
				switch (lineparts[0].charAt(0)) {
				case 'p':
					party = new Party(Integer.parseInt(lineparts[1]),
							lineparts[2]);
					this.caveElements.put(party.getIndex(), party);
					parties.add(party);
					break;

				case 'c':
					creature = new Creature(Integer.parseInt(lineparts[1]),
							lineparts[2], lineparts[3],
							Integer.parseInt(lineparts[4]),
							Integer.parseInt(lineparts[5]),
							Integer.parseInt(lineparts[6]),
							Double.parseDouble(lineparts[7]));
					if (lineparts.length > 8 && lineparts[8] != null) {
						creature.setAge(Integer.parseInt(lineparts[8]));
					}
					if (lineparts.length > 9 && lineparts[9] != null) {
						creature.setHeight(Double.parseDouble(lineparts[9]));
					}
					if (lineparts.length > 10 && lineparts[10] != null) {
						creature.setWeight(Integer.parseInt(lineparts[10]));
					}
					Party creatureParty = (Party) caveElements.get(creature
							.getPartyIndex());
					if (creatureParty == null || creature.getPartyIndex() == 0) {
						this.loners.add(creature);
					} else {
						creatureParty.addCreature(creature);
					}
					this.caveElements.put(creature.getIndex(), creature);
					break;

				case 't':
					treasure = new Treasure(Integer.parseInt(lineparts[1]),
							lineparts[2], Integer.parseInt(lineparts[3]),
							Double.parseDouble(lineparts[4]),
							Double.parseDouble(lineparts[5]));
					Creature treasureCreature = (Creature) caveElements
							.get(treasure.getCreatureByIndex());
					if (treasureCreature == null
							|| treasure.getCreatureByIndex() == 0) {
						this.loners.add(treasure);
					} else {
						treasureCreature.addTreature(treasure);
					}
					this.caveElements.put(treasure.getIndex(), treasure);
					break;

				case 'a':
					artifact = new Artifact(Integer.parseInt(lineparts[1]),
							lineparts[2], Integer.parseInt(lineparts[3]));
					Creature artifactCreature = (Creature) caveElements
							.get(artifact.getCreatureByIndex());
					if (artifactCreature == null
							|| artifact.getCreatureByIndex() == 0) {
						this.loners.add(artifact);
					} else if (artifact.getCreatureByIndex() != 0) {
						artifactCreature.addArtifact(artifact);
					}
					this.caveElements.put(artifact.getIndex(), artifact);
					break;

				default:
					break;
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loadButton) {
			int returnVal = fileChooser.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				try {
					this.setGameElements(file.getAbsolutePath());
					JOptionPane.showMessageDialog(null,
							"Data Successfully Loaded!");
					output.setText("");
				} catch (IOException ex) {
					Logger.getLogger(Game.class.getName()).log(Level.SEVERE,
							null, ex);
				}
			}
		} else if (e.getSource() == showData) {

			String str = "";
			ArrayList<Cave> printElements = new ArrayList<Cave>();
			printElements.addAll(caveElements.values());
			for (Cave cave : printElements) {
				if (cave instanceof Party) {
					Party p = (Party) cave;
					str += p.toString();
				}
			}
			str += "\n-----------------\nLoners\n-----------------\n";
			for (Cave ge : loners) {
				str += "\n" + ge.toString();
			}
			output.setText(str);
		} else if (e.getSource() == serachButton) {
			String str = " ";
			ArrayList<Cave> printElements = new ArrayList<Cave>();
			printElements.addAll(caveElements.values());
			for (Cave cave : printElements) {
				if (cave instanceof Party) {
					Party p = (Party) cave;
					if (p.getName().equals(output.getText())) {

						str += p.toString();
					}
				}
			}
			 if(str.equals(" ")){
				output.setText("Not Found!");
				
			}else{
				if (str != null) {
					output.setText(str);
				}
			}
			
		}
		
	}

	public static void main(String[] args) throws IOException {
		Game p = new Game();
	}

}

