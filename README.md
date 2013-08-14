[![Build Status](https://travis-ci.org/tklein/gradle-jaxws-plugin.png)](https://travis-ci.org/tklein/gradle-jaxws-plugin)

gradle-jaxws-plugin
===================

Gradle plugin to create Java classes from a WSDL using JAX-WS. This plugin
was heavily influenced by the gradle-jaxb-plugin.

Installation
------------

The plugin is available on Maven Central now, so you simply have to add it to your build dependencies as outlined in the usage section.

Usage
-----

You can just use the _jaxws_ plugin like any other plugin in your build file. The example below uses a url from the web, but there is no reason why you cannot reference a wsdl from the local project.

```groovy
buildscript {
	repositories {
		mavenCentral()
	}
	dependencies {
		classpath "eu.schnuckelig.gradle:gradle-jaxws-plugin:1.0"
	}
}

apply plugin: 'maven'
apply plugin: 'jaxws'

jaxws {
	packageName = 'eu.schnuckelig.gradle.test'
	wsdlURL = 'http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL'
}

repositories {
	mavenCentral()
}
```
