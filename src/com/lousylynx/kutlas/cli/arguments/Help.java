package com.lousylynx.kutlas.cli.arguments;

import com.lousylynx.kutlas.Kutlas;
import com.lousylynx.kutlas.cli.Arguments;
import com.lousylynx.kutlas.cli.CLIHandler;

import java.util.List;

public class Help implements Argument
{
    @Override
    public String getLongName()
    {
        return "help";
    }

    @Override
    public String getShortName()
    {
        return "h";
    }

    @Override
    public String getHelp()
    {
        return "Print this help";
    }

    @Override
    public void execute(String[] args)
    {
        Run.checkForKutlas();
        CLIHandler.log("Kutlas v" + Kutlas.getVersion() + " help");
        CLIHandler.log("Usage: kutlas <argument> [options]");
        int size = getLengthOfHelpArguments(CLIHandler.arguments);
        for(Arguments arg : CLIHandler.arguments)
        {
            String helpArg = arg.getLongName() + " or " + arg.getShortName();
            CLIHandler.log("\t" + helpArg + new String(new char[size-helpArg.length()]).replace("\0", " ") + arg.getHelp());
        }
    }

    public int getLengthOfHelpArguments(List<Arguments> args)
    {
        int ret;
        int longSize = 0;
        for(Arguments arg : args)
        {
            String argHelp = arg.getLongName() + " or " + arg.getShortName();
            if(argHelp.length() > longSize)
            {
                longSize = argHelp.length();
            }
        }
        ret = longSize + 4;
        return ret;
    }
}
