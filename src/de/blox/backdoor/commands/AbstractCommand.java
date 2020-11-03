package de.blox.backdoor.commands;

public abstract class AbstractCommand implements ICommand {

    private final String description;
    private final String usage;
    private final String[] aliases;

    public AbstractCommand(String description, String usage, String... aliases) {
        this.description = description;
        this.usage = usage;
        this.aliases = aliases;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public String usage() {
        return "*" + usage;
    }

    @Override
    public String[] aliases() {
        return aliases;
    }

}
