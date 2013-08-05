gradle-jaxws-plugin
===================

Gradle plugin to create Java classes from a WSDL using JAX-WS. This plugin
was heavily influenced by the gradle-jaxb-plugin.

Installation
------------

Currently this project is not hosted in public repository, so you just need to build it locally.

```bash
$ git clone git@github.com:tklein/gradle-jaxws-plugin.git
$ cd gradle-jaxws-plugin
$ gradle build install
```

Usage
-----

You can just use the _jaxws_ plugin like any other plugin in your build file. The example below uses a url from the web, but there is no reason why you cannot reference a wsdl from the local project.

```groovy
buildscript {
	repositories {
		mavenLocal()
		mavenCentral()
	}
	dependencies {
		classpath group: 'eu.schnuckelig.gradle', name: 'gradle-jaxws-plugin', version: '0.1-SNAPSHOT'
	}
}

apply plugin: 'maven'
apply plugin: 'jaxws'

jaxws {
	packageName = 'eu.schnuckelig.gradle.test'
	wsdlURL = 'http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL'
}

repositories {
	mavenLocal()
	mavenCentral()
}
```
