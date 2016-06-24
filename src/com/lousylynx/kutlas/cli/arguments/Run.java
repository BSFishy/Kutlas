package com.lousylynx.kutlas.cli.arguments;

import com.lousylynx.kutlas.cli.CLIHandler;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Run implements Argument
{

    static CLIHandler handler;

    @Override
    public String getLongName()
    {
        return "run";
    }

    @Override
    public String getShortName()
    {
        return "r";
    }

    @Override
    public String getHelp() {
        return "Run a Kutlas program";
    }

    @Override
    public void execute(String[] args)
    {
        checkForKutlas();
    }

    public static void checkForKutlas()
    {
        Path rootFolder = Paths.get(System.getProperty("user.home") + "/.kutlas");
        File langFolder = Paths.get(System.getProperty("user.home") + "/.kutlas/lang").toFile();
        if(!Files.exists(rootFolder) || !langFolder.exists())
        {
            rootFolder.toFile().mkdir();
            langFolder.mkdir();
            kutlasNotFound();
            return;
        }

        boolean jars = false;
        for(File f : langFolder.listFiles())
        {
            if(f.isFile() && f.getName().endsWith(".jar"))
            {
                jars = true;
            }
        }
        if(!jars || langFolder.listFiles().length == 0)
        {
            kutlasNotFound();
            return;
        }
    }

    private static void kutlasNotFound()
    {
        handler.log("ERROR: Kutlas was not found. Downloading latest version.");
    }
}
