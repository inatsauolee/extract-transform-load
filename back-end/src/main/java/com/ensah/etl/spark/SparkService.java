package com.ensah.etl.spark;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensah.constant.Constant;
import com.ensah.etl.bean.Aggregation;

@Component
public class SparkService {
	@Autowired
	private SparkSession sparkSession;

	public String[] getHeaders(String fileName) {
		Dataset<Row> csv = sparkSession.read().format("csv").option("header","true").load(Constant.DATA_PATH+fileName);
		csv.show();
		return csv.columns()[0].split(";");
	}

	public List<String> getFiles() {
		List<String> results = new ArrayList<String>();

		File[] files = new File(Constant.DATA_PATH).listFiles();

		for (File file : files) {
			if (file.isFile()) {
				results.add(file.getName());
			}
		}

		return results;
	}

	public List<String> select(String fileName, String query) throws AnalysisException {

		Dataset<Row> df = sparkSession.read().option("header", "true").option("delimiter", ";").csv(Constant.DATA_PATH+fileName);
		df.createOrReplaceTempView(fileName.replace(Constant.CSV_EX, ""));

		Dataset<Row> sqlDF = sparkSession.sql(query);
		System.err.println(sqlDF.toJSON().collectAsList());

		return sqlDF.toJSON().collectAsList();
	}


	public List<String> groupBy(String fileName, List<Aggregation> aggs, List<String>list) throws AnalysisException {

		Dataset<Row> df = sparkSession.read().option("header", "true").csv(Constant.DATA_PATH+fileName);

		df.createOrReplaceTempView(fileName.replace(Constant.CSV_EX, ""));
		
		Dataset<Row> sqlDF = null;
		
		switch (aggs.get(0).getID()) {
		case Constant.AVG:
			sqlDF = df.groupBy(getGroupByColumns(list)).agg(org.apache.spark.sql.functions.avg(aggs.get(0).getColumn()));
			break;
		case Constant.MAX:
			sqlDF = df.groupBy(getGroupByColumns(list)).agg(org.apache.spark.sql.functions.max(aggs.get(0).getColumn()));
			break;
		case Constant.MIN:
			sqlDF = df.groupBy(getGroupByColumns(list)).agg(org.apache.spark.sql.functions.min(aggs.get(0).getColumn()));
			break;
		case Constant.FIRST:
			sqlDF = df.groupBy(getGroupByColumns(list)).agg(org.apache.spark.sql.functions.first(aggs.get(0).getColumn()));
			break;
		case Constant.LAST:
			sqlDF = df.groupBy(getGroupByColumns(list)).agg(org.apache.spark.sql.functions.last(aggs.get(0).getColumn()));
			break;
		default:
			break;
		}
		
		for (int i = 1; i < aggs.size(); i++) {
			switch (aggs.get(i).getID()) {
			case Constant.AVG:
				sqlDF.agg(org.apache.spark.sql.functions.avg(aggs.get(i).getColumn()));
				break;
			case Constant.MAX:
				sqlDF.agg(org.apache.spark.sql.functions.avg(aggs.get(i).getColumn()));
				break;
			case Constant.MIN:
				sqlDF.agg(org.apache.spark.sql.functions.avg(aggs.get(i).getColumn()));
				break;
			case Constant.FIRST:
				sqlDF.agg(org.apache.spark.sql.functions.avg(aggs.get(i).getColumn()));
				break;
			case Constant.LAST:
				sqlDF.agg(org.apache.spark.sql.functions.avg(aggs.get(i).getColumn()));
				break;
			default:
				break;
			}
		}
		
		sqlDF.show();

		return sqlDF.toJSON().collectAsList();

	}
	private Column[] getGroupByColumns(List<String> list) {
		Column[] groupByColumns = new Column[list.size()];
		for (int i = 0; i < list.size(); i++) {
			groupByColumns[i] = org.apache.spark.sql.functions.col(list.get(i));
		}
		return groupByColumns;
	}

	public List<String> combine(String file1, String file2, String query) {

		Dataset<Row> tableOneDF = sparkSession.read().option("delimiter", ";").option("header", "true").csv(Constant.DATA_PATH+file1);
		Dataset<Row> tableTwoDF = sparkSession.read().option("delimiter", ";").option("header", "true").csv(Constant.DATA_PATH+file2);


		tableOneDF.createOrReplaceTempView(file1.replace(Constant.CSV_EX, ""));
		tableTwoDF.createOrReplaceTempView(file2.replace(Constant.CSV_EX, ""));

		Dataset<Row> sqlDF = sparkSession.sql(query);
		sqlDF.show();

		return sqlDF.toJSON().collectAsList();
	}



}
