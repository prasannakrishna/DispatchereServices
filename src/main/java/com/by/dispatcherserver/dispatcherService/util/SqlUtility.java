package com.by.dispatcherserver.dispatcherService.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Table;

import com.by.dispatcherserver.dispatcherService.library.SelectExpression;

public class SqlUtility<T> {

	Class<T> m_clsName;
	HashMap<String, Object> m_queryparam;

	/**
	 * @param clsName
	 */
	public SqlUtility(HashMap<String, Object> p_queryparam, Class<T> clsName) {
		this.m_clsName = clsName;
		this.m_queryparam = p_queryparam;
		// getSQLQuery();
	}

	public StringBuffer getSQLQuery() {
		Field[] l_entitymemb = m_clsName.getDeclaredFields();
		StringBuffer l_strSelect = new StringBuffer();
		l_strSelect.append(" select ");
		StringBuffer l_strWhereClause = new StringBuffer();
		l_strWhereClause.append(" where 1=1");

		String string = new String();
		Integer integer = 0;
		Double dbl = 1.0;
		Date date = new Date();

		for (Field field : l_entitymemb) {
			Annotation[] annot = field.getAnnotations();
			int i = 0;
			for (Annotation annotation : annot) {
				if (annotation instanceof SelectExpression) {
					i++;
					l_strSelect.append(((SelectExpression) annotation).Value());
					if (i + 1 < l_entitymemb.length) {
						l_strSelect.append(",");
					}
				}
			}
			String passedarg = "";
			Iterator<String> it = m_queryparam.keySet().iterator();
			while (it.hasNext()) {
				passedarg = it.next().toString();
				if (field.getName().equalsIgnoreCase(passedarg)) {
					for (Annotation annotation : annot) {
						if (annotation instanceof Column) {
							l_strWhereClause.append(" and " + ((Column) annotation).name());
						}
					}
					if (field.getType().isInstance(string)) {
						// here sent param field name matches with database column
						// check if it contains special chars, if yes replace with %
						String strField = (String) m_queryparam.get(passedarg);
						if (strField != null) {
							if (strField.startsWith(";")) {
								String[] strFields = strField.substring(1).split(";");
								l_strWhereClause.append(" IN ( ");
								for (int ifield = 0; ifield < strFields.length; ifield++) {
									l_strWhereClause.append("'" + strFields[ifield] + "'");
									if (ifield + 1 < strFields.length) {
										l_strWhereClause.append(",");
									}
								}
								l_strWhereClause.append(")");
							} else {
								if (strField.contains("*")) {
									l_strWhereClause.append(" like '" + strField.replace('*', '%') + "'");
								} else {
									l_strWhereClause.append(" = '" + strField + "'");
								}
							}
						}
					} else if (field.getType().isInstance(integer) || field.getType().isInstance(dbl)) {
						int intField = Integer.parseInt((String) (m_queryparam.get(passedarg)));
						if (it.next().toString().startsWith(">=")) {
							l_strWhereClause.append(" >= " + Integer.parseInt((String) (m_queryparam.get(passedarg))));

						} else if (it.next().toString().startsWith("<=")) {
							l_strWhereClause.append(" <= " + Integer.parseInt((String) (m_queryparam.get(passedarg))));

						} else if (it.next().toString().startsWith(">")) {
							l_strWhereClause.append(" > " + Integer.parseInt((String) (m_queryparam.get(passedarg))));

						} else if (it.next().toString().startsWith("<")) {
							l_strWhereClause.append(" < " + Integer.parseInt((String) (m_queryparam.get(passedarg))));

						} else {
							l_strWhereClause.append(
									" = " + Integer.parseInt((String) (m_queryparam.get(it.next().toString()))));
						}
					}

					else if (field.getType().isInstance(date)) {

						int intField = Integer.parseInt((String) (m_queryparam.get(passedarg)));
						if (it.next().toString().startsWith(">=")) {
							l_strWhereClause.append(" >= '" + m_queryparam.get(passedarg) + "'");

						} else if (it.next().toString().startsWith("<=")) {
							l_strWhereClause.append(" <= '" + m_queryparam.get(passedarg) + "'");

						} else if (it.next().toString().startsWith(">")) {
							l_strWhereClause.append(" > '" + m_queryparam.get(passedarg) + "'");

						} else if (it.next().toString().startsWith("<")) {
							l_strWhereClause.append(" < '" + m_queryparam.get(passedarg) + "'");

						} else {
							l_strWhereClause.append(" = '" + m_queryparam.get(passedarg) + "'");
						}
					}
				}
			}
		}

		StringBuffer l_strFromTable = new StringBuffer();
		Annotation[] clsAnnotation = m_clsName.getAnnotations();
		for (Annotation annotation : clsAnnotation) {
			if (annotation instanceof Table) {
				l_strFromTable.append(" FROM " + ((Table) annotation).name());
			}
		}
		StringBuffer strSQLstatement = new StringBuffer();
		l_strSelect.deleteCharAt(l_strSelect.length() - 1);
		strSQLstatement.append(l_strSelect);
		strSQLstatement.append(l_strFromTable);
		strSQLstatement.append(l_strWhereClause);
		// add site client tied where clause and order by
		System.out.println("*********SQL*********** \n");
		System.out.println(strSQLstatement);
		return strSQLstatement;

	}

	public Map<String, String> getMapfromObj() {
		// m_clsName
		return null;
	}

}
