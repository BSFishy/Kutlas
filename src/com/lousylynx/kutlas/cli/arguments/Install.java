package com.lousylynx.kutlas.cli.arguments;

public class Install implements Argument
{
    @Override
    public String getLongName()
    {
        return "install";
    }

    @Override
    public String getShortName()
    {
        return "i";
    }

    @Override
    public String getHelp() {
        return "Install new Kutlas plugins, or a new version of Kutlas";
    }

    @Override
    public void execute(String[] args)
    {
        Run.checkForKutlas();
        return;
    }
}
