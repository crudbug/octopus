package octopus.server.gremlinShell;

import groovy.lang.Closure;
import groovy.lang.Script;

import java.util.Map;


public abstract class OctopusScriptBase extends Script
{

	public void newSessionStep(String name, Closure closure)
	{
		Map<String, Closure> sessionSteps = getSessionSteps();
		sessionSteps.put(name, closure);
	}

	public void deleteSessionStep(String name)
	{
		getSessionSteps().remove(name);
	}

	private Closure getSessionStep(String name)
	{
		return getSessionSteps().get(name);
	}

	private Map<String, Closure> getSessionSteps()
	{
		Map<String, Closure> sessionSteps = (Map<String, Closure>) getBinding().getVariable("sessionSteps");
		return sessionSteps;
	}

}
