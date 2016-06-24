package com.lousylynx.kutlas.cli.arguments;

public interface Argument
{

    String getLongName();
    String getShortName();
    String getHelp();

    void execute(String[] args);

}
