package by.epam.carrent.controller;

import java.util.HashMap;
import java.util.Map;

import by.epam.carrent.impl.Registration;
import by.epam.carrent.impl.SignIn;
import by.epam.carrent.impl.SignOut;
import by.epam.carrent.impl.AccountCreating;
import by.epam.carrent.impl.Authorization;
import by.epam.carrent.impl.Localization;
import by.epam.carrent.impl.MainPage;

public class CommandProvider {
	
	private Map<CommandName, iCommand> commands = new HashMap<CommandName, iCommand>();
	
	public CommandProvider() {
		
		commands.put(CommandName.AUTHORIZATION, new Authorization());
		commands.put(CommandName.REGISTRATION, new Registration());
		commands.put(CommandName.MAIN_PAGE, new MainPage());
		commands.put(CommandName.CREATE_ACCOUNT, new AccountCreating());
		commands.put(CommandName.LOCALIZATION, new Localization());
		commands.put(CommandName.SIGN_IN, new SignIn());
		commands.put(CommandName.SIGN_OUT, new SignOut());
		
	}
	
	public iCommand getCommand(String commandName) {
		
		iCommand command;
		command = commands.get(CommandName.valueOf(commandName.toUpperCase()));			
		return command;
	}	
}