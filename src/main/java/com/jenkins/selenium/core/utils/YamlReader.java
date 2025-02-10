package com.jenkins.selenium.core.utils;

import java.io.IOException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;

import com.jenkins.selenium.core.browserhandler.BrowserStackConfig;

public class YamlReader {

	private BrowserStackConfig browserstackconfig;
	Yaml yaml;

	public YamlReader() {
		yaml = new Yaml();
		try (InputStream inputstream = YamlReader.class.getClassLoader().getResourceAsStream("browserstack.yml")) {
			browserstackconfig = yaml.loadAs(inputstream, BrowserStackConfig.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public BrowserStackConfig getBroserstackConfig() {
		return browserstackconfig;
	}

}
