import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;

import org.junit.ClassRule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import javaposse.jobdsl.dsl.DslScriptLoader;
import javaposse.jobdsl.plugin.JenkinsJobManagement;

public class JobDslTest {

	@ClassRule
	public static final JenkinsRule jenkinsRule = new JenkinsRule();

	@Test
	public void test() throws Exception {
		Map<String, ?> map = Collections.emptyMap();
		JenkinsJobManagement jobManagement = new JenkinsJobManagement(System.out, map, new File("."));

		DslScriptLoader loader = new DslScriptLoader(jobManagement);

		String script = new String(Files.readAllBytes(Paths.get("test.groovy")));
		System.out.println(script);

		loader.runScript(script);
	}
}
