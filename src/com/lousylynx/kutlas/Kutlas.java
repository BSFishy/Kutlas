package com.lousylynx.kutlas;

import com.lousylynx.kutlas.cli.CLIHandler;

public class Kutlas
{

    private static CLIHandler handler;

    public static void main(String[] args)
    {
        handler = new CLIHandler();

        handler.handle(args);
    }

    public static String getVersion()
    {
        return "0.1.0";
    }
}
