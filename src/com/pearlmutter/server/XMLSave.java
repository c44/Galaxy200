package com.pearlmutter.server;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pearlmutter.shared.Cell;
import com.pearlmutter.shared.User;

public class XMLSave {
	Document doc;
//	User[] users;
//	Cell[] cells;
	ArrayList<User> users;
	ArrayList<Cell> cells;

//	public XMLSave(User[] users, Cell[] cells) {
//		this.users = users;
//		this.cells = cells;
//
//		createDoc();
//		save();
//	}

	public XMLSave(ArrayList<User> users, ArrayList<Cell> cells) {
		this.users = users;
		this.cells = cells;

		createDoc();
		save();
	}

	public void createDoc() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("db");
			Attr attr1 = doc.createAttribute("xmlns:xsi");
			attr1.setValue("http://www.w3.org/2001/XMLSchema-instance");
			Attr attr2 = doc.createAttribute("xsi:noNamespaceSchemaLocation");
			attr2.setValue("db.xsd");
			rootElement.setAttributeNode(attr1);
			rootElement.setAttributeNodeNS(attr2);
			doc.appendChild(rootElement);

			Element usersElement = doc.createElement("users");
			rootElement.appendChild(usersElement);

			for (int i = 0; i < users.size(); i++) {
				// user element
				Element userElement = doc.createElement("user");
				usersElement.appendChild(userElement);

				// firstName element
				Element firstNameElement = doc.createElement("firstName");
				firstNameElement.appendChild(doc.createTextNode(users.get(i).getFirstName()));
				userElement.appendChild(firstNameElement);

				// lastName element
				Element lastNameElement = doc.createElement("lastName");
				lastNameElement.appendChild(doc.createTextNode(users.get(i).getLastName()));
				userElement.appendChild(lastNameElement);

				// id element
				Element idElement = doc.createElement("id");
				idElement.appendChild(doc.createTextNode(users.get(i).getId()));
				userElement.appendChild(idElement);

				// birthday element
				Element birthdayElement = doc.createElement("birthday");
				userElement.appendChild(birthdayElement);

				// birthday day element
				Element dayElement = doc.createElement("day");
				dayElement.appendChild(doc.createTextNode(String.valueOf(users.get(i).getBirthDay().getDate())));
				birthdayElement.appendChild(dayElement);

				// birthday month element
				Element monthElement = doc.createElement("month");
				monthElement.appendChild(doc.createTextNode(String.valueOf(users.get(i).getBirthDay().getMonth() + 1)));
				birthdayElement.appendChild(monthElement);

				// birthday year element
				Element yearElement = doc.createElement("year");
				yearElement.appendChild(doc.createTextNode(String.valueOf(users.get(i).getBirthDay().getYear() + 1900)));
				birthdayElement.appendChild(yearElement);

				
				// workdays element
				Element workDaysElement = doc.createElement("workDays");
				userElement.appendChild(workDaysElement);

				// workday elements
				for (int j = 0; j < users.get(i).getWorkDays().size(); j++) {
					Element workDayElement = doc.createElement("workDay");
					workDaysElement.appendChild(workDayElement);

					// workday type element
					Element typeElement = doc.createElement("type");
					typeElement.appendChild(doc.createTextNode(users.get(i).getWorkDays().get(j).getType()));
					workDayElement.appendChild(typeElement);

					// workday date element
					Element dateElement = doc.createElement("date");
					dateElement.appendChild(doc.createTextNode(""));
					workDayElement.appendChild(dateElement);
					
					// workday approval element
					Element approvalElement = doc.createElement("approval");
					approvalElement.appendChild(doc.createTextNode(String.valueOf(users.get(i).getWorkDays().get(j).isApproved())));
					workDayElement.appendChild(approvalElement);
				}
				

				// branch element
				Element branchElement = doc.createElement("branch");
				branchElement.appendChild(doc.createTextNode(users.get(i).getBranch()));
				userElement.appendChild(branchElement);

				// cell element
				Element cellElement = doc.createElement("cell");
				cellElement.appendChild(doc.createTextNode(users.get(i).getCell()));
				userElement.appendChild(cellElement);

			}

			Element cellsElement = doc.createElement("cells");
			rootElement.appendChild(cellsElement);

			for (int i = 0; i < cells.size(); i++) {
				// cell element
				Element cellElement = doc.createElement("cell");
				cellsElement.appendChild(cellElement);

				// name element
				Element nameElement = doc.createElement("name");
				nameElement.appendChild(doc.createTextNode(cells.get(i).getName()));
				cellElement.appendChild(nameElement);
			}

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
	}

	public void save() {
		try {
			String filepath = "Resources/db.xml";

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);

			System.out.println("Done");

		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}
