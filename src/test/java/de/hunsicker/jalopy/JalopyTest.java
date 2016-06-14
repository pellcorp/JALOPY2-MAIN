package de.hunsicker.jalopy;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import de.hunsicker.jalopy.Jalopy.State;
import junit.framework.Assert;

public class JalopyTest extends Assert {
	private Jalopy jalopy = new Jalopy();
	
	@Test
	public void testIllegal() throws Exception {
		String crap = "classz myclass { }";
		try {
			format(crap);
			fail("failed");
		} catch(IllegalStateException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testAssertEquals() throws Exception {
		String check = "/**\n" + 
				" * Some comment\n" + 
				" *\n" + 
				" * Some other comment!\n" + 
				" */\n" + 
				"package com.pellcorp;\n" + 
				"\n" + 
				"import javax.xml.bind.annotation.*;\n" + 
				"\n" + 
				"\n" + 
				"@XmlAccessorType(XmlAccessType.FIELD)\n" + 
				"public class Applicant {\n" + 
				"	\n" + 
				"	@XmlElement(required=true)\n" + 
				"	protected Person person;\n" + 
				"	\n" + 
				"	@XmlElement(required=true)\n" + 
				"	protected java.math.BigDecimal salary;\n" + 
				"	\n" + 
				"	@XmlElement(required=true)\n" + 
				"	protected java.math.BigDecimal expenses;\n" + 
				"	\n" + 
				"	@XmlElement(required=true)\n" + 
				"	protected java.lang.String employment;\n" + 
				"	\n" + 
				"	\n" + 
				"	public Person getPerson() {\n" + 
				"		return person;\n" + 
				"	}\n" + 
				"	\n" + 
				"	public void setPerson(Person value) {\n" + 
				"		this.person = value;\n" + 
				"	}\n" + 
				"	\n" + 
				"	public java.math.BigDecimal getSalary() {\n" + 
				"		return salary;\n" + 
				"	}\n" + 
				"	\n" + 
				"	public void setSalary(java.math.BigDecimal value) {\n" + 
				"		this.salary = value;\n" + 
				"	}\n" + 
				"	\n" + 
				"	public java.math.BigDecimal getExpenses() {\n" + 
				"		return expenses;\n" + 
				"	}\n" + 
				"	\n" + 
				"	public void setExpenses(java.math.BigDecimal value) {\n" + 
				"		this.expenses = value;\n" + 
				"	}\n" + 
				"	\n" + 
				"	public java.lang.String getEmployment() {\n" + 
				"		return employment;\n" + 
				"	}\n" + 
				"	\n" + 
				"	public void setEmployment(java.lang.String value) {\n" + 
				"		this.employment = value;\n" + 
				"	}\n" + 
				"}";
		
		String expected = "/**\n" + 
				" * Some comment\n" + 
				" *\n" + 
				" * Some other comment!\n" + 
				" */\n" + 
				"package com.pellcorp;\n" + 
				"\n" + 
				"import javax.xml.bind.annotation.*;\n" + 
				"\n" + 
				"\n" + 
				"@XmlAccessorType(XmlAccessType.FIELD)\n" + 
				"public class Applicant {\n" + 
				"    @XmlElement(required = true)\n" + 
				"    protected Person person;\n" + 
				"    @XmlElement(required = true)\n" + 
				"    protected java.math.BigDecimal salary;\n" + 
				"    @XmlElement(required = true)\n" + 
				"    protected java.math.BigDecimal expenses;\n" + 
				"    @XmlElement(required = true)\n" + 
				"    protected java.lang.String employment;\n" + 
				"\n" + 
				"    public Person getPerson() {\n" + 
				"        return person;\n" + 
				"    }\n" + 
				"\n" + 
				"    public void setPerson(Person value) {\n" + 
				"        this.person = value;\n" + 
				"    }\n" + 
				"\n" + 
				"    public java.math.BigDecimal getSalary() {\n" + 
				"        return salary;\n" + 
				"    }\n" + 
				"\n" + 
				"    public void setSalary(java.math.BigDecimal value) {\n" + 
				"        this.salary = value;\n" + 
				"    }\n" + 
				"\n" + 
				"    public java.math.BigDecimal getExpenses() {\n" + 
				"        return expenses;\n" + 
				"    }\n" + 
				"\n" + 
				"    public void setExpenses(java.math.BigDecimal value) {\n" + 
				"        this.expenses = value;\n" + 
				"    }\n" + 
				"\n" + 
				"    public java.lang.String getEmployment() {\n" + 
				"        return employment;\n" + 
				"    }\n" + 
				"\n" + 
				"    public void setEmployment(java.lang.String value) {\n" + 
				"        this.employment = value;\n" + 
				"    }\n" + 
				"}\n";
		
		assertEquals(format(expected), format(check));
	}
	
	private static String format(final String source) throws IOException {
		File sourceFile = File.createTempFile("source", ".java");
		File destFile = File.createTempFile("dest", ".java");
		try {
    		Jalopy jalopy = new Jalopy();
    		FileUtils.writeStringToFile(sourceFile, source);
    		jalopy.setInput(sourceFile);
    		jalopy.setOutput(destFile);
    		jalopy.format(true);
    		if (jalopy.getState() == State.OK) {
    			String result = FileUtils.readFileToString(destFile);
    			return result;
    		} else {
    			throw new IllegalStateException("Failed to parse file - see log output");
    		}
		} finally {
			FileUtils.forceDelete(sourceFile);
			FileUtils.forceDelete(destFile);
		}
	}
}
