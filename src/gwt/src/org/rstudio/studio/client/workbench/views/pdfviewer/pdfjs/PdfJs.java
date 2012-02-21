/*
 * PdfJs.java
 *
 * Copyright (C) 2009-11 by RStudio, Inc.
 *
 * This program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */
package org.rstudio.studio.client.workbench.views.pdfviewer.pdfjs;

import com.google.gwt.user.client.Command;
import org.rstudio.core.client.ExternalJavaScriptLoader;
import org.rstudio.core.client.ExternalJavaScriptLoader.Callback;

public class PdfJs
{
   public static void preload()
   {
      load(null);
   }

   public static void load(final Command command)
   {
      pdfjs_.addCallback(new Callback()
      {
         public void onLoaded()
         {
            if (command != null)
               command.execute();
         }
      });
   }

   private static final ExternalJavaScriptLoader pdfjs_ = new ExternalJavaScriptLoader(
         PdfJsResources.INSTANCE.pdfjs().getSafeUri().asString());
}
