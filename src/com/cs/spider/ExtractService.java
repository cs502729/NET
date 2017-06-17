package com.cs.spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractService {

	public static List<LinkTypeData> extract(Rule rule) {
		// ���ж�rule�ı�ҪУ��
		validateRule(rule);

		List<LinkTypeData> datas = new ArrayList<LinkTypeData>();
		LinkTypeData data = null;
		try {
			/**
			 * ����Rule
			 */
			String url = rule.getUrl();
			String[] params = rule.getParams();
			String[] values = rule.getValues();
			String resultTagName = rule.getResultTagName();
			int type = rule.getType();
			int requestType = rule.getRequestMoethod();

			Connection con = Jsoup.connect(url);
			// ���ò�ѯ����
			if (params != null) {
				for(int i=0; i< params.length;i++){
					con.data(params[i],values[i]);
				}	
			}
			 // ������������  
			Document doc = null;
			switch(requestType){
				case Rule.GET:
					doc = con.timeout(100000).get();
					break;
				case Rule.POST:
					doc = con.timeout(100000).post();
					break;
			}
			//����������  
			Elements results = new Elements();
			switch(type){
				case Rule.ID:
					Element result = doc.getElementById(resultTagName);
					results.add(result);
					break;
				case Rule.CLASS:
					results = doc.getElementsByClass(resultTagName);
					break;
				case Rule.SELECTION:
					results = doc.select(resultTagName);
					break;
				default:
					//��resultTagNameΪ��ʱĬ��ȥbody��ǩ  
					if(resultTagName == null){
						results = doc.getElementsByTag("body");
					}
			}
			
			for(Element result : results){
				Elements links = result.getElementsByTag("a");
				for(Element link : links){
					String linkHref = link.attr("href");
					String linkText = link.text();
					
					data = new LinkTypeData();
					data.setLinkHref(linkHref);
					data.setLinkText(linkText);
					datas.add(data);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return datas;
	}

	private static void validateRule(Rule rule) {
		// TODO Auto-generated method stub
		String url = rule.getUrl();
		if (url == null) {
			throw new RuleException("url����Ϊ�գ�");
		}
		if (!url.startsWith("http://")) {
			throw new RuleException("url�ĸ�ʽ����ȷ��");
		}

		if (rule.getParams() != null && rule.getValues() != null) {
			if (rule.getParams().length != rule.getValues().length) {
				throw new RuleException("�����ļ�ֵ�Ը�����ƥ�䣡");
			}
		}
	}
}
