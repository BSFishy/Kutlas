package com.lousylynx.kutlas.cli;

import java.util.ArrayList;
import java.util.List;

public class CLIHandler
{

    public static List<Arguments> arguments = new ArrayList<>();
    static{
        arguments.add(Arguments.RUN);
        arguments.add(Arguments.INSTALL);
        arguments.add(Arguments.UPDATE);
        arguments.add(Arguments.HELP);
    }

    public void handle(String[] args)
    {
        if(args.length < 1)
        {
            log("You must have at least 1 argument.");
            log("Use the argument \"help\" to get a list of possible arguments.");
            return;
        }
        for(Arguments a : arguments)
        {
            if(a.getLongName().equalsIgnoreCase(args[0]))
            {
                a.execute(args);
                return;
            }else if(a.getShortName().equalsIgnoreCase(args[0]))
            {
                a.execute(args);
                return;
            }
        }
        log("The argument \"" + args[0] + "\" was not found.");
        log("Use the argument \"help\" to get a list of possible arguments.");
    }

    public static void log(String log)
    {
        System.out.println(log);
    }
}
