<h2><strong>Spring Data for Apache Solr</strong></h2>

The primary goal of the Spring Data project is to make it easier to build Spring-powered applications that use new data access technologies such as non-relational databases, map-reduce frameworks, and cloud based data services.

The Spring Data for Apache Solr project provides integration with the Apache Solr search engine

Providing its own extensible MappingSolrConverter as alternative to DocumentObjectBinder Spring Data for Apache Solr handles inheritance as well as usage of custom Types such as Point or DateTime

<h3><strong>Features</strong></h3>

<ul>
  <li>High level repository abstractions with multicore support</li>
  <li>Annotations for Boost-, Facet- and Highlighting</li>
  <li>Customizable type mappings and type conversions</li>
  <li>Solr template supporting fluent query api</li>
  <li>Exception translation to Spring’s portable Data Access exception hierarchy</li>
</ul>

<h2><strong>Getting Started</strong></h2>

Maven configuration

Add the Maven dependency:

&lt;dependency&gt;

  &lt;groupId&gt;org.springframework.data&lt;/groupId&gt;
  
  &lt;artifactId&gt;spring-data-solr&lt;/artifactId&gt;
  
  &lt;version&gt;${version}.RELEASE&lt;/version&gt;
  
&lt;/dependency&gt;

<h3><strong>Getting Help</strong></h3>

Having trouble with Spring Data? We’d love to help!

Check the reference documentation, and Javadocs.

Learn the Spring basics – Spring Data builds on Spring Framework, check the spring.io web-site for a wealth of reference documentation. If you are just starting out with Spring, try one of the guides.

<strong>Examples</strong>

Spring Data Examples contains example projects that explain specific features in more detail.

<strong>License</strong>

Spring Data for Apache Solr is Open Source software released under the Apache 2.0 license.
