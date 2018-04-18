package dt.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dt.util.ArraySet;

/**
 * Implementation of the decision-tree learning algorithm in AIMA Fig 18.5.
 * This is based on ID3 (AIMA p. 758).
 */
public class DecisionTreeLearner extends AbstractDecisionTreeLearner {
	
	/**
	 * Construct and return a new DecisionTreeLearner for the given Problem.
	 */
	public DecisionTreeLearner(Problem problem) {
		super(problem);
	}
	
	/**
	 * Main recursive decision-tree learning (ID3) method.  
	 * Pseudo-code from AIMA Figure 18.5 Page 702
	 */
	@Override
	protected DecisionTree learn(Set<Example> examples, List<Variable> attributes, Set<Example> parent_examples) {
	    // Must be implemented by you; the following two methods may be useful
		if (examples.size()==0) {
			return new DecisionTree(this.pluralityValue(parent_examples));
		} else if (this.uniqueOutputValue(examples)!=null) {
			return new DecisionTree(this.uniqueOutputValue(examples));
		} else if (attributes.isEmpty()) {
			return new DecisionTree(this.pluralityValue(examples));
		} else {
			Variable A = this.mostImportantVariable(attributes, examples);
			DecisionTree tree = new DecisionTree(A);
			for (String vk : A.domain) {
				Set<Example> exs = null; //?
				attributes.remove(A);
				DecisionTree subtree = learn(exs, attributes, examples);
				tree.children.add(subtree);
			}
			return tree;
		}
	}
	
	/**
	 * Returns the most common output value among a set of Examples,
	 * breaking ties randomly.
	 * I don't do the random part yet.
	 */
	@Override
	protected String pluralityValue(Set<Example> examples) {
	    // Must be implemented by you
		ArrayList<String> outputValues = new ArrayList<String>();
		for (Example e : examples) {
			outputValues.add(e.getOutputValue());
		}
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		for (String s : outputValues) {
			
		}
	}
	
	/**
	 * Returns the single unique output value among the given examples
	 * is there is only one, otherwise null.
	 */
	@Override
	protected String uniqueOutputValue(Set<Example> examples) {
	    // Must be implemented by you
	}
	
	//
	// Utility methods required by the AbstractDecisionTreeLearner
	//

	/**
	 * Return the subset of the given examples for which Variable a has value vk.
	 */
	@Override
	protected Set<Example> examplesWithValueForAttribute(Set<Example> examples, Variable a, String vk) {
	    // Must be implemented by you
		Set<Example> exs = new HashSet<Example>();
		for (Example e : )
	}
	
	/**
	 * Return the number of the given examples for which Variable a has value vk.
	 */
	@Override
	protected int countExamplesWithValueForAttribute(Set<Example> examples, Variable a, String vk) {
		int result = 0;
		for (Example e : examples) {
			if (e.getInputValue(a).equals(vk)) {
				result += 1;
			}
		}
		return result;
		
	}

	/**
	 * Return the number of the given examples for which the output has value vk.
	 */
	@Override
	protected int countExamplesWithValueForOutput(Set<Example> examples, String vk) {
	    // Must be implemented by you
	}

}
