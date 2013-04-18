package com.example.quoteplugin;

import java.io.InputStream;
import java.net.URL;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.forge.shell.ShellColor;
import org.jboss.forge.shell.ShellPrintWriter;
import org.jboss.forge.shell.events.Startup;
import org.jboss.forge.shell.plugins.Alias;
import org.jboss.forge.shell.plugins.DefaultCommand;
import org.jboss.forge.shell.plugins.Plugin;

@Alias("qotd")
public class QuotePlugin implements Plugin
{

   @Inject
   private ShellPrintWriter out;

   public void observeStartup(@Observes Startup startup) throws Exception
   {
      defaultCommand();
   }

   @DefaultCommand
   public void defaultCommand() throws Exception
   {
      URL get = new URL("http://www.iheartquotes.com/api/v1/random");
      InputStream is = get.openStream();
      try
      {
         out.println();
         byte[] b = new byte[is.available()];
         int total = is.read(b);
         String msg = new String(b, 0, total);
         out.println(ShellColor.ITALIC, msg.replaceAll("&quot;", "\""));
      }
      finally
      {
         if (is != null)
            is.close();
      }
   }
}
