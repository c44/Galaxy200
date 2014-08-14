package com.pearlmutter.client;

import com.pearlmutter.shared.User;

public class UserCreator {
	User a8;

	String firstNames[] = { "Yonatan", "Neta", "Inbar", "Or", "Yoav",
			"Avigail", "Ilana" };
	String lastNames[] = { "Pearlmutter", "Stein", "George", "Cohen",
			"Alhindi", "Rifkin", "Gunt" };

	User users[] = new User[firstNames.length];

	public UserCreator() {
		init();
	}

	void init() {
		for (int i = 0; i < firstNames.length; i++) {
			users[i] = new User(firstNames[i], lastNames[i], String.valueOf(i));
		}
		
		for (int i = 0; i < 4; i++) {
			users[i].setBranch("North");
		}
		
		for (int i = 4; i < 7; i++) {
			users[i].setBranch("South");
		}

		a8 = new User("jo", "blow", "1234");
	}
}
