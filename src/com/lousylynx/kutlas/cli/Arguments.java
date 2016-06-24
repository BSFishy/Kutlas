package com.lousylynx.kutlas.cli;

import com.lousylynx.kutlas.cli.arguments.*;

public enum Arguments
{
    RUN(new Run()), UPDATE(new Update()), INSTALL(new Install()), HELP(new Help());

    private Argument arg;

    Arguments(Argument t)
    {
        arg = t;
    }

    public String getLongName()
    {
        return arg.getLongName();
    }

    public String getShortName()
    {
        return arg.getShortName();
    }

    public String getHelp()
    {
        return arg.getHelp();
    }

    public void execute(String[] args)
    {
        arg.execute(args);
    }
}
