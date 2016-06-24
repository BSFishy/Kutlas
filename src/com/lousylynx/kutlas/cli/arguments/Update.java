package com.lousylynx.kutlas.cli.arguments;

public class Update implements Argument
{
    @Override
    public String getLongName()
    {
        return "update";
    }

    @Override
    public String getShortName()
    {
        return "u";
    }

    @Override
    public String getHelp() {
        return "Update plugins for Kutlas, or Kutlas itself";
    }

    @Override
    public void execute(String[] args)
    {
        Run.checkForKutlas();
        return;
    }
}
