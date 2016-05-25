package fr.s2re.rest.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import fr.s2re.impl.webservice.ServiceDeviseWebServiceImp;

@ApplicationPath("/services/rest")
public class MyRestApplicationConfig  extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(ServiceDeviseWebServiceImp.class);
		return classes;
	}
}
