package com.ensah.constant;

import java.util.Arrays;
import java.util.List;

public class Constant {

	public static final String APP_NAME = "Extract-Transform-Load System";
	
	public static final List<String> OPERATIONS = Arrays.asList("AND", "OR", "NOT", "LIKE", "WHERE", "=", ">", "<", "<>", ">=", "<=",
																"(", "+", "-", "*", "/", ")");
	public static final String AVG = "avg";
	public static final String MAX = "max";
	public static final String MIN = "min";
	public static final String FIRST = "first";
	public static final String LAST = "last";
	
	public static final String DATA_PATH = "src/main/resources/data/";
	public static final CharSequence CSV_EX = ".csv";
}
