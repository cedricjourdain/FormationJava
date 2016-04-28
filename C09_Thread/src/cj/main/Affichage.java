package cj.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cj.ascenseur.Asc;
import cj.personne.Personne;

public class Affichage extends JPanel implements WindowListener {
	private static final long serialVersionUID = 1L;
	private int lar = 400;
	private int hau = 600;
	private int[] color = { 0xFFFF0000, 0xFF00FF00, 0xFF0000FF, 0xFFFFFF00, 0xFF00FFFF, 0xFFFF00FF };
	public Main manageur;

	public Affichage(Main manageur) {
		this.manageur = manageur;
	}

	public void init() {
		JFrame frame = new JFrame("Ascenseur");
		frame.setBounds(300, 50, lar, hau + 40);
		frame.setContentPane(this);
		this.setBounds(0, 0, lar, hau);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(this);
		frame.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, lar, hau + 40);
		if (manageur != null && manageur.listeAscenseur != null) {
			for (int i = 0; i < manageur.listeAscenseur.size(); i++) {
				Asc a = manageur.listeAscenseur.get(i);
				g.setColor(new Color(color[i]));
				g.fillRect(Integer.valueOf(a.getName()).intValue() * 60,
						hau - Asc.HAUTEUR_ETAGE - (a.etage * Asc.HAUTEUR_ETAGE + a.progression), 50, Asc.HAUTEUR_ETAGE);
				g.setColor(Color.BLACK);
				g.drawRect(Integer.valueOf(a.getName()).intValue() * 60,
						hau - Asc.HAUTEUR_ETAGE - (a.etage * Asc.HAUTEUR_ETAGE + a.progression), 50, Asc.HAUTEUR_ETAGE);
				if (a.personnAscenseur != null && a.personnAscenseur.etat == Personne.ETAT_MOVE) {
					g.setFont(new Font("Arial", Font.PLAIN, 20));
					g.drawString(a.personnAscenseur.nom, Integer.valueOf(a.getName()).intValue() * 60 + 8,
							hau - Asc.HAUTEUR_ETAGE - (a.etage * Asc.HAUTEUR_ETAGE + a.progression) + 15);
				}
			}
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.out.println("FIN");
		manageur.sortie = true;
		for (Asc a : manageur.listeAscenseur) {
			a.finDeTraitement = true;
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}
}
