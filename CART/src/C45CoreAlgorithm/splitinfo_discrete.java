/**
 * Calculates the information gain of discrete attribute
 */


package C45CoreAlgorithm;

import DataDefination.Attribute;
import DataDefination.Instance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class splitinfo_discrete {
	
	private Attribute attribute;
	private double splitinfo;
	private HashMap<String, ArrayList<Instance>> subset;
	
	/**
	 * Constructor: initialize fields. This class is for calculating the splitinfo for
	 * discrete attribute.
	 * @param target
	 * @param attribute
	 * @param instances
	 * @throws IOException
	 */
	public splitinfo_discrete(Attribute target, Attribute attribute, ArrayList<Instance> instances)
			throws IOException {
		
		
		this.attribute = attribute;
		
		ArrayList<String> valuesOfAttribute = attribute.getValues();
		
		String attributeName = attribute.getName();
		
		subset = new HashMap<String, ArrayList<Instance>>();
		
		for (String s : valuesOfAttribute) {
			subset.put(s, new ArrayList<Instance>());
		}
		
		for (Instance instance : instances) {
			HashMap<String, String> attributeValuePairsOfInstance = instance.getAttributeValuePairs();
			
			String valueOfInstanceAtAttribute = attributeValuePairsOfInstance.get(attributeName);

			if (!subset.containsKey(valueOfInstanceAtAttribute)) 
				throw new IOException("Invalid input data");
			subset.get(valueOfInstanceAtAttribute).add(instance);
		}
		
//		for (String key : subset.keySet()) {
//		    System.out.println(key + subset.get(key).size());
//		}
		

		int totalN = instances.size();
		splitinfo = 0;
		
		
		
	   for (String s : subset.keySet()) {
			ArrayList<Instance> currSubset = subset.get(s);
			int subN = currSubset.size();
			double subRes = ((double) subN) / ((double) totalN);
			 splitinfo -= (double)subRes *(Math.log(subRes));
			
			
		}
	   int x = 0;		
	}
	
	public Attribute getAttribute() {
		return attribute;
	}
	
	public double getSplitInfo() {
		return splitinfo;
	}
	
	public HashMap<String, ArrayList<Instance>> getSubset() {
		return subset;
	}
	
	public String toString() {
		return "Attribute: " + attribute + "\n"  
				+ "splitinfo: " + splitinfo + "\n" + "Subset: " + subset;
	}
	
	
}