package com.cs.spider;

import java.util.List;

public class Test {

	public void getDatasByClass(){
		Rule rule = new Rule(  
                "http://www1.sxcredit.gov.cn/public/infocomquery.do?method=publicIndexQuery",  
        new String[] { "query.enterprisename","query.registationnumber" }, new String[] { "ะหอ๘","" },  
                "cont_right", Rule.CLASS, Rule.POST);  
        List<LinkTypeData> extracts = ExtractService.extract(rule);  
        printf(extracts);  
	}
	
	public void getDatasByCssQuery()  
    {  
        Rule rule = new Rule("http://www.11315.com/search",  
                new String[] { "name" }, new String[] { "ะหอ๘" },  
                "div.g-mn div.con-model", Rule.SELECTION, Rule.GET);  
        List<LinkTypeData> extracts = ExtractService.extract(rule);  
        printf(extracts);  
    }  
	
	public void printf(List<LinkTypeData> datas) {
		for (LinkTypeData data : datas) {
			System.out.println(data.getLinkText());
			System.out.println(data.getLinkHref());
			System.out.println("***********************************");
		}

	}

	 public static void main(String[] args) {
		new Test().getDatasByClass();
	}
}
