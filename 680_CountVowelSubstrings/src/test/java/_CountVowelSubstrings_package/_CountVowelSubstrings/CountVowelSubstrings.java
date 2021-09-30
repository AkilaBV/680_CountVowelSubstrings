package _CountVowelSubstrings_package._CountVowelSubstrings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.testng.annotations.Test;

public class CountVowelSubstrings {
	Map<String,Integer> map=new HashMap<String,Integer>();
	Integer count=0;
	String sub="";
	int total=0;
		
	public /*Map<String,Integer>*/ int countVowels(String in) {
		for(int i=0;i<in.length();i++) {
			if (in.charAt(i) == 'a' || in.charAt(i)=='e'||in.charAt(i)=='i'|| in.charAt(i)=='o'|| in.charAt(i)=='u'){
				
				if(!map.containsKey(String.valueOf(in.charAt(i)))) {
					map.put(String.valueOf(in.charAt(i)), count+1);
					sub=sub+String.valueOf(in.charAt(i));
					
					for(int j=i+1;j<in.length();j++) {
						if (in.charAt(j) == 'a' || in.charAt(j)=='e'||in.charAt(j)=='i'|| in.charAt(j)=='o'|| in.charAt(j)=='u') {
							sub=sub+String.valueOf(in.charAt(j));
							if(!map.containsKey(sub)) {
								map.put(sub, count+1);
						}else {
							count=map.get(sub);
							count=count+1;
							map.put(sub,count);
						}
					}
					else {
						sub="";
							break;
						}
						
					}sub="";
				}else {
			
					count=map.get(String.valueOf(in.charAt(i)));
					count=count+1;
					map.put(String.valueOf(in.charAt(i)),count);
				}
				
			}count=0;
		}
		System.out.println(map);
		/*
		for(Map.Entry<String, Integer> each: map.entrySet()) {
			total=total+each.getValue();
			
		}System.out.println(total);
		*/
		Iterator<Map.Entry<String,Integer>> it=map.entrySet().iterator();
		while(it.hasNext()) {
			total=total+it.next().getValue();
		}
		return total;
	}
	
	
	
	
	@Test
	public void testcase1() {
		//System.out.println(countVowels("codeia"));
		Assert.assertTrue(countVowels("codeia")==7);
	}
	
	@Test
	public void testcase2() {
		//System.out.println(countVowels("codestudio"));
		Assert.assertTrue(countVowels("codestudio")==6);
	}
	
}




