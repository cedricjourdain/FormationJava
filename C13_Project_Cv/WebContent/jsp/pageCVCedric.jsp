<%@page import="cj.metier.ListeExperience"%>
<%@page import="cj.metier.ListeCompetence"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cj.metier.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Identification Administrateur</title>
<link href="http://www.activconsult-ing.com/Home.css" rel="stylesheet"
	type="text/css">
<style type="text/css">
#formationLyon {
	position: relative;
	left: 5px;
	top: 0px;
	width: 700px;
	height: 600px;
	text-align: center;
}

table, td, th {
	border: 1px solid black;
	border-spacing: 0px;
	border-collapse: collapse;
}

th {
	text-align: center;
}

.rTable {
	display: block;
	width: 100%;
}

.rTableCompetence {
	display: block;
	width: 70%;
}

.rTableHeading, .rTableBody, .rTableFoot, .rTableRow {
	clear: both;
}

.rTableHead, .rTableFoot {
	background-color: #DDD;
	font-weight: bold;
}

.rTableCell, .rTableHead {
	border: 1px solid #999999;
	float: left;
	height: 17px;
	overflow: hidden;
	padding: 3px 0;
	width: 28%;
}

.rTable:after {
	visibility: hidden;
	display: block;
	font-size: 0;
	content: " ";
	clear: both;
	height: 0;
}

#info2 {
	width: 700px;
	height: 500px;
}
</style>
</head>

<body>
	<div id="background">
		<div id="back2">
			<img src="http://www.activconsult-ing.com/img/Article_fond_bleu.png" />
		</div>
		<div id="back3">
			<img
				src="http://www.activconsult-ing.com/img/shutterstock_106416164.png" />
		</div>
		<div id="logo">
			<a href="http://www.activconsult-ing.com/index.html"><img
				src="http://www.activconsult-ing.com/img/ACI_Logo_quadri_blanc.png"
				width="184" height="185" /></a>
		</div>
		<div id="white">
			<img src="http://www.activconsult-ing.com/img/Article_fond_blanc.png"
				width="782" height="595" />
		</div>
		<div id="logo1">
			<a href="http://www.activconsult-ing.com/qui_sommes_nous.html"><img
				src="http://www.activconsult-ing.com/img/Menu_ancre.png"
				alt="Qui sommes nous ?" /></a>
		</div>
		<div id="logo2">
			<a href="http://www.activconsult-ing.com/le_groupe.html"><img
				src="http://www.activconsult-ing.com/img/Menu_poulpe.png" width="70"
				height="93" alt="Le groupe" /></a>
		</div>
		<div id="logo3">
			<a href="http://www.activconsult-ing.com/centre_formation.html"><img
				src="http://www.activconsult-ing.com/img/Menu_pagaies.png"
				width="71" height="103" alt="Centre de formation" /></a>
		</div>
		<div id="logo4">
			<a href="http://www.activconsult-ing.com/nos_offres1.html"><img
				src="http://www.activconsult-ing.com/img/Menu_rose_des_vents.png"
				width="71" height="93" alt="Nos offres" /></a>
		</div>
		<div id="logo5">
			<a href="http://www.activconsult-ing.com/domaines_activites.html"><img
				src="http://www.activconsult-ing.com/img/Menu_noeuds.png" width="72"
				height="103" alt="Domaines d'activités" /></a>
		</div>
		<div id="logo6">
			<a href="http://www.activconsult-ing.com/recrutement_rh.html"><img
				src="http://www.activconsult-ing.com/img/Menu_capitaine.png"
				width="71" height="103" alt="Recrutement RH" /></a>
		</div>
		<div id="logo8">
			<a href="http://www.activconsult-ing.com/ressources_externes.html"><img
				src="http://www.activconsult-ing.com/img/Menu_bouée.png" width="71"
				height="103" alt="Ressouces externes" /></a>
		</div>
		<div id="logo7">
			<a href="http://www.activconsult-ing.com/contact.html"><img
				src="http://www.activconsult-ing.com/img/Menu_gouvernail.png"
				width="71" height="93" alt="Contact" /></a>
		</div>
		<div id="titre1">ENTREPRISE DE SERVICES DU NUMERIQUE</div>
		<div id="menu3">
			<img
				src="http://www.activconsult-ing.com/img/Objet_dynamique_vectoriel.png"
				width="342" height="57" alt="" />
		</div>
		<div id="logol1">
			<img src="http://www.activconsult-ing.com/img/Menu_pagaies2.png"
				width="71" height="71" alt="" />
		</div>
		<div id="tlogo">CENTRE DE FORMATION</div>
		<div id="info2">
			<%
				Formation formation = (Formation) session.getAttribute("formation");
				int id = Integer.valueOf(request.getParameter("bEtudiant")).intValue();
				Etudiant etudiant = formation.getListeEtudiant().get(id);
				
			%>
			<div style="position: absolute; top: -105px; left: 320px;">
				<h1 style="color: blue;">
					CV
					</h2>
			</div>
			<div style="position: absolute; top: -85px; left: 340px;">
				<h2 style="color: blue;"><%= etudiant.getNom()%></h2>
			</div>
			<div style="position: absolute; top: -65px; left: 340px;">
				<h2 style="color: blue;"><%=etudiant.getPrenom()%></h2>
			</div>
			<div style="position: absolute; top: -35px; left: 360px;">
				<p><%=etudiant.getMail()%></p>
			</div>
			<div id="formationLyon">
				<div style="width: 500px; height: 200px; overflow: auto">
					<h3>Compétences</h3>
					<div class="rTable">
						<div class="rTableRow">
							<div class="rTableHead" style="width: 20%">
								<strong>Type</strong>
							</div>
							<div class="rTableHead" style="width: 39%">
								<span style="font-weight: bold;">Précision</span>
							</div>
							<div class="rTableHead" style="width: 39%">Niveau</div>
						</div>
						<%
						for (int i = 0; i < etudiant.getListeCompetence().size(); i++) {  
							Competence competence = etudiant.getListeCompetence().get(i);
						%>
						<div class="rTableRow">
							<div class="rTableCell" style="width: 20%"><%= competence.getType() %></div>
							<div class="rTableCell" style="width: 39%"><%= competence.getDetail() %></div>
							<div class="rTableCell" style="width: 39%"><%= competence.getNiveau() %></div>
						</div>
						<%} %>
					</div>
				</div>
				<div style="width: 700px; height: 200px; overflow: auto">
					<h3>Expériences</h3>
					<div class="rTable">
						<div class="rTableRow">
							<div class="rTableHead" style="width: 20%">
								<strong>Date</strong>
							</div>
							<div class="rTableHead" style="width: 20%">
								<span style="font-weight: bold;">Entreprise</span>
							</div>
							<div class="rTableHead" style="width: 20%">Poste</div>
							<div class="rTableHead" style="width: 38%">Description</div>
						</div>
						<%
						for (int i = 0; i < etudiant.getListeExperience().size(); i++){
							Experience experience = etudiant.getListeExperience().get(i);
						
						%>
						<div class="rTableRow">
							<div class="rTableCell" style="width: 20%"><%= experience.getDateExp() %></div>
							<div class="rTableCell" style="width: 20%"><%= experience.getEntreprise() %></div>
							<div class="rTableCell" style="width: 20%"><%= experience.getPoste() %></div>
							<div class="rTableCell" style="width: 38%"><%= experience.getDescription() %></div>
						</div>
						<% }%>
					</div>
				</div>
				<div style="width: 700px; height: 200px; overflow: auto">
					<h3>Formations</h3>
					<div class="rTable">
						<div class="rTableRow">
							<div class="rTableHead" style="width: 20%">
								<strong>Date</strong>
							</div>
							<div class="rTableHead" style="width: 39%">
								<span style="font-weight: bold;">Diplôme</span>
							</div>
							<div class="rTableHead" style="width: 39%">Ecole</div>
						</div>
						<div class="rTableRow">
							<%
							for (int i = 0; i < etudiant.getListeFormationScolaire().size(); i++){
								FormationScolaire formationScolaire = etudiant.getListeFormationScolaire().get(i);
							%>
							<div class="rTableCell" style="width: 20%"><%= formationScolaire.getDate() %></div>
							<div class="rTableCell" style="width: 39%"><%= formationScolaire.getDiplome() %></div>
							<div class="rTableCell" style="width: 39%"><%= formationScolaire.getEcole() %></div>
							<%
							}
							%>
						</div>
					</div>
				</div>
			</div>

		</div>
		<div id="fpage2">
			<img
				src="http://www.activconsult-ing.com/img/Article_fond_blanc_double_copie.png" />
			<div id="Facebook2">
				<img src="http://www.activconsult-ing.com/img/Facebook.png" />
			</div>
			<div id="linkedin2">
				<img src="http://www.activconsult-ing.com/img/Linkedin.png" />
			</div>
			<div id="viadeo2">
				<img src="http://www.activconsult-ing.com/img/Viadeo.png" />
			</div>
			<div id="droit2">©1997-2012 - Tous droits de reproduction et de
				représentation réservés | Mentions légales</div>
		</div>
</body>
</html>