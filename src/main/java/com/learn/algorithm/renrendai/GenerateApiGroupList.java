package com.learn.algorithm.renrendai;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class GenerateApiGroupList {
	
	
	public static void main(String[] args){
		
		String arguments = "a=&b=b&c=c";
		List<String> list = listAllRequestArgs(requestSingleArgumentsOption(arguments));
		
		System.out.printf("group size: %d",list.size());
		
		for(String line : list)
		{
			System.out.println(line);
		}
		
		
		
		
	}
	
	
	
	/**
	 * 
	 * @param requestArgs  format: key=value&key2=value2&key3=&key4
	 * @return
	 */
	public static List<List<String>> requestSingleArgumentsOption(String requestArgs)
	{
		
		List<List<String>> allarggroups = new ArrayList<>();
		
		String[] args = requestArgs.split("&");
		
		for (String arg : args)			
		{
			
			List<String> newarggroups =new ArrayList<>(); 
			
			String[] keysandvalue = arg.split("=");
			
			newarggroups.add("");
			newarggroups.add(keysandvalue[0]+"=");
			//newarggroups.add(keysandvalue[0]+"=null");
						
			if(keysandvalue.length > 1 && !StringUtils.isEmpty(keysandvalue[1])) {
				
				newarggroups.add(arg);
			}
			
			allarggroups.add(newarggroups);
			
		}
		
		return allarggroups;
	}
	
	
	public static List<String> listAllRequestArgs(List<List<String>> argumentOptions){
		
		if(argumentOptions.size() == 1)
		{
			return argumentOptions.get(0);
		}
		
		else {
			
			argumentOptions.add(0, mergeTwoArgumentsToOneRequestString(argumentOptions.remove(0),argumentOptions.remove(0)));
			return listAllRequestArgs(argumentOptions);
		}
		
		
	}
	
	
	public static List<String>  mergeTwoArgumentsToOneRequestString(List<String> left , List<String> right) {
		
		
		List<String> newArguments = new ArrayList<>();
		
		for(String leftString : left) {
			
			for(String rightString: right)
			{
				
				if(StringUtils.isEmpty(leftString))
					newArguments.add(rightString);
				else
					newArguments.add(leftString+ (StringUtils.isEmpty(rightString)?"":"&"+rightString));
									
			}			
			
		}		
		
		return newArguments;
	}
	
	
	
	
	

}
