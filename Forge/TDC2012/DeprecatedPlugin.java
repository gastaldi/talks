package com.forge.plug;

import java.io.IOException;

import javax.inject.Inject;

import org.jboss.forge.parser.java.JavaSource;
import org.jboss.forge.parser.java.Method;
import org.jboss.forge.project.Project;
import org.jboss.forge.project.facets.JavaSourceFacet;
import org.jboss.forge.resources.Resource;
import org.jboss.forge.resources.java.JavaMethodResource;
import org.jboss.forge.resources.java.JavaResource;
import org.jboss.forge.shell.Shell;
import org.jboss.forge.shell.plugins.Alias;
import org.jboss.forge.shell.plugins.Current;
import org.jboss.forge.shell.plugins.DefaultCommand;
import org.jboss.forge.shell.plugins.PipeOut;
import org.jboss.forge.shell.plugins.Plugin;
import org.jboss.forge.shell.plugins.RequiresProject;
import org.jboss.forge.shell.plugins.RequiresResource;

/**
 *
 */
@Alias("deprecatedplugin")
@RequiresProject
@RequiresResource({ JavaResource.class, JavaMethodResource.class })
public class DeprecatedPlugin implements Plugin {
	@Inject
	private Shell shell;

	@Inject
	@Current
	private Resource<?> resource;

	@Inject
	private Project project;

	/**
	 * Deprecia se for uma classe ou metodo
	 * 
	 * @param out
	 * @throws IOException
	 */
	@DefaultCommand
	public void defaultCommand(PipeOut out) throws IOException {
		JavaSource<?> javaSource;
		if (resource instanceof JavaResource) {
			javaSource = ((JavaResource) resource).getJavaSource();
			javaSource.addAnnotation(Deprecated.class);
		} else if (resource instanceof JavaMethodResource) {
			Method<? extends JavaSource<?>> m = ((JavaMethodResource) resource).getUnderlyingResourceObject();
			m.addAnnotation(Deprecated.class);
			javaSource = m.getOrigin();
		} else {
			throw new RuntimeException("Escopo invalido para o recurso " + resource);
		}

		// Salvando recurso usando o facet
		JavaSourceFacet javaSourceFacet = project.getFacet(JavaSourceFacet.class);
		javaSourceFacet.saveJavaSource(javaSource);
	}
}
