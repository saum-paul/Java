package org.smacknologs.patterns.expressiontree.command;

import java.util.List;

public class MacroCommand extends UserCommand {

	private List<UserCommand> commands;

	@Override
	public void execute() {
		commands.forEach(UserCommand::execute);
	}

}
