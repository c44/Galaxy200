package com.pearlmutter.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.pearlmutter.shared.Cell;
import com.pearlmutter.shared.User;
import com.pearlmutter.shared.WorkDay;
import com.pearlmutter.shared.WorkDayType;

public class XMLReader {

	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Cell> cells = new ArrayList<Cell>();

	public XMLReader() {
		create();
	}

	@SuppressWarnings("deprecation")
	public void create() {
		try {
			File file = new File("Resources/db.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			doc.getDocumentElement().normalize();

			Element usersElement = (Element) doc.getElementsByTagName("users").item(0);
			NodeList userNodeList = usersElement.getElementsByTagName("user");

			for (int i = 0; i < userNodeList.getLength(); i++) {
				Node userNode = userNodeList.item(i);
//				System.out.println("\nCurrent Element :" +
//				userNode.getNodeName());

//				if (userNode.getNodeType() == Node.ELEMENT_NODE) {
				Element userElement = (Element) userNode;

				User user = new User();
//				users[i] = new User();

				user.setFirstName(userElement.getElementsByTagName("firstName").item(0).getTextContent());
				user.setLastName(userElement.getElementsByTagName("lastName").item(0).getTextContent());
				user.setId(userElement.getElementsByTagName("id").item(0).getTextContent());

				Date bd = new Date();

//				NodeList bdNodeList =
//				userElement.getElementsByTagName("birthday");
//				Node bdNode = bdNodeList.item(0);
//				Element bdElement = (Element) bdNode;

				Element bdElement = (Element) userElement.getElementsByTagName("birthday").item(0);

				bd.setDate(Integer.parseInt(bdElement.getElementsByTagName("day").item(0).getTextContent()));
				bd.setMonth(Integer.parseInt(bdElement.getElementsByTagName("month").item(0).getTextContent()) - 1);
				bd.setYear(Integer.parseInt(bdElement.getElementsByTagName("year").item(0).getTextContent()) - 1900);

				user.setBirthDay(bd);

				try {
					Element workDaysElement = (Element) userElement.getElementsByTagName("workDays").item(0);
					NodeList workDayNodeList = workDaysElement.getElementsByTagName("workDay");

					for (int j = 0; j < workDayNodeList.getLength(); j++) {
						Element workDayElement = (Element) workDayNodeList.item(j);

						WorkDay workDay = new WorkDay();

						workDay.setType(WorkDayType.valueOf(workDayElement.getElementsByTagName("type").item(0).getTextContent()));
//						workDay.setDate(new Date(workDayElement.getElementsByTagName("type").item(0).getTextContent()));
						workDay.setApproval(Boolean.parseBoolean(workDayElement.getElementsByTagName("approval").item(0).getTextContent()));

						user.addWorkDay(workDay);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				user.setBranch(userElement.getElementsByTagName("branch").item(0).getTextContent());
				user.setCell(userElement.getElementsByTagName("cell").item(0).getTextContent());

				users.add(i, user);

				System.out.println(user.getFirstName());
				System.out.println(user.getLastName());
				System.out.println(user.getId());
				System.out.println(user.getBirthDay());
				for (int k = 0; k < user.getWorkDays().size(); k++) {
					System.out.println("wd: " + user.getWorkDays().get(k).getType() + " " + user.getWorkDays().get(k).getDate() + " "
							+ user.getWorkDays().get(k).isApproved());
				}
				System.out.println(user.getBranch());
				System.out.println(user.getCell());
				
				System.out.println();

//				System.out.println("Staff index: " +
//				userElement.getAttribute("index"));
			}
//			}

			Element cellsElement = (Element) doc.getElementsByTagName("cells").item(0);
			NodeList cellNodeList = cellsElement.getElementsByTagName("cell");

			for (int i = 0; i < cellNodeList.getLength(); i++) {
				Element cellElement = (Element) cellNodeList.item(i);

				Cell cell = new Cell();
//				cells[i] = new Cell();
				cell.setName(cellElement.getElementsByTagName("name").item(0).getTextContent());

				cells.add(i, cell);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<Cell> getCells() {
		return cells;
	}
}
