/*
 * generated by Xtext
 */
package org.eclipse.xtext.parsetree.unassignedtext.parseTreeConstruction;

import org.eclipse.emf.ecore.*;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IEObjectConsumer;

import org.eclipse.xtext.parsetree.unassignedtext.services.UnassignedTextTestLanguageGrammarAccess;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class UnassignedTextTestLanguageParsetreeConstructor extends org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor {
		
	@Inject
	private UnassignedTextTestLanguageGrammarAccess grammarAccess;
	
	@Override
	protected AbstractToken getRootToken(IEObjectConsumer inst) {
		return new ThisRootNode(inst);	
	}
	
protected class ThisRootNode extends RootToken {
	public ThisRootNode(IEObjectConsumer inst) {
		super(inst);
	}
	
	@Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Model_Alternatives(this, this, 0, inst);
			case 1: return new CaseInsensitiveKeywordRule_Group(this, this, 1, inst);
			case 2: return new PluralRule_Group(this, this, 2, inst);
			case 3: return new MultiRule_Group(this, this, 3, inst);
			case 4: return new DatatypeRule_Group(this, this, 4, inst);
			case 5: return new CommonTerminalsRule_Group(this, this, 5, inst);
			default: return null;
		}	
	}	
}
	

/************ begin Rule Model ****************
 *
 * Model:
 * 	CaseInsensitiveKeywordRule | PluralRule | MultiRule | DatatypeRule | CommonTerminalsRule;
 *
 **/

// CaseInsensitiveKeywordRule | PluralRule | MultiRule | DatatypeRule | CommonTerminalsRule
protected class Model_Alternatives extends AlternativesToken {

	public Model_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getModelAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Model_CaseInsensitiveKeywordRuleParserRuleCall_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Model_PluralRuleParserRuleCall_1(lastRuleCallOrigin, this, 1, inst);
			case 2: return new Model_MultiRuleParserRuleCall_2(lastRuleCallOrigin, this, 2, inst);
			case 3: return new Model_DatatypeRuleParserRuleCall_3(lastRuleCallOrigin, this, 3, inst);
			case 4: return new Model_CommonTerminalsRuleParserRuleCall_4(lastRuleCallOrigin, this, 4, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getCaseInsensitiveKeywordRuleRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getCommonTerminalsRuleRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getDatatypeRuleRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getMultiRuleRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getPluralRuleRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// CaseInsensitiveKeywordRule
protected class Model_CaseInsensitiveKeywordRuleParserRuleCall_0 extends RuleCallToken {
	
	public Model_CaseInsensitiveKeywordRuleParserRuleCall_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getModelAccess().getCaseInsensitiveKeywordRuleParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CaseInsensitiveKeywordRule_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getCaseInsensitiveKeywordRuleRule().getType().getClassifier())
			return null;
		if(checkForRecursion(CaseInsensitiveKeywordRule_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// PluralRule
protected class Model_PluralRuleParserRuleCall_1 extends RuleCallToken {
	
	public Model_PluralRuleParserRuleCall_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getModelAccess().getPluralRuleParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new PluralRule_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getPluralRuleRule().getType().getClassifier())
			return null;
		if(checkForRecursion(PluralRule_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// MultiRule
protected class Model_MultiRuleParserRuleCall_2 extends RuleCallToken {
	
	public Model_MultiRuleParserRuleCall_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getModelAccess().getMultiRuleParserRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiRule_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getMultiRuleRule().getType().getClassifier())
			return null;
		if(checkForRecursion(MultiRule_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// DatatypeRule
protected class Model_DatatypeRuleParserRuleCall_3 extends RuleCallToken {
	
	public Model_DatatypeRuleParserRuleCall_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getModelAccess().getDatatypeRuleParserRuleCall_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DatatypeRule_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getDatatypeRuleRule().getType().getClassifier())
			return null;
		if(checkForRecursion(DatatypeRule_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// CommonTerminalsRule
protected class Model_CommonTerminalsRuleParserRuleCall_4 extends RuleCallToken {
	
	public Model_CommonTerminalsRuleParserRuleCall_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getModelAccess().getCommonTerminalsRuleParserRuleCall_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CommonTerminalsRule_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getCommonTerminalsRuleRule().getType().getClassifier())
			return null;
		if(checkForRecursion(CommonTerminalsRule_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule Model ****************/


/************ begin Rule CaseInsensitiveKeywordRule ****************
 *
 * CaseInsensitiveKeywordRule:
 * 	CaseInsensitiveKeyword val=INT;
 *
 **/

// CaseInsensitiveKeyword val=INT
protected class CaseInsensitiveKeywordRule_Group extends GroupToken {
	
	public CaseInsensitiveKeywordRule_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCaseInsensitiveKeywordRuleAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CaseInsensitiveKeywordRule_ValAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getCaseInsensitiveKeywordRuleRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// CaseInsensitiveKeyword
protected class CaseInsensitiveKeywordRule_CaseInsensitiveKeywordTerminalRuleCall_0 extends UnassignedTextToken {

	public CaseInsensitiveKeywordRule_CaseInsensitiveKeywordTerminalRuleCall_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getCaseInsensitiveKeywordRuleAccess().getCaseInsensitiveKeywordTerminalRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// val=INT
protected class CaseInsensitiveKeywordRule_ValAssignment_1 extends AssignmentToken  {
	
	public CaseInsensitiveKeywordRule_ValAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCaseInsensitiveKeywordRuleAccess().getValAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CaseInsensitiveKeywordRule_CaseInsensitiveKeywordTerminalRuleCall_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("val",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("val");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getCaseInsensitiveKeywordRuleAccess().getValINTTerminalRuleCall_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getCaseInsensitiveKeywordRuleAccess().getValINTTerminalRuleCall_1_0();
			return obj;
		}
		return null;
	}

}


/************ end Rule CaseInsensitiveKeywordRule ****************/


/************ begin Rule PluralRule ****************
 *
 * PluralRule:
 * 	"contents:" count=INT Plural;
 *
 **/

// "contents:" count=INT Plural
protected class PluralRule_Group extends GroupToken {
	
	public PluralRule_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getPluralRuleAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new PluralRule_PluralTerminalRuleCall_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getPluralRuleRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "contents:"
protected class PluralRule_ContentsKeyword_0 extends KeywordToken  {
	
	public PluralRule_ContentsKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getPluralRuleAccess().getContentsKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// count=INT
protected class PluralRule_CountAssignment_1 extends AssignmentToken  {
	
	public PluralRule_CountAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPluralRuleAccess().getCountAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new PluralRule_ContentsKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("count",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("count");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getPluralRuleAccess().getCountINTTerminalRuleCall_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getPluralRuleAccess().getCountINTTerminalRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// Plural
protected class PluralRule_PluralTerminalRuleCall_2 extends UnassignedTextToken {

	public PluralRule_PluralTerminalRuleCall_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getPluralRuleAccess().getPluralTerminalRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new PluralRule_CountAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule PluralRule ****************/


/************ begin Rule MultiRule ****************
 *
 * MultiRule:
 * 	"multi" val=INT Multi Multi Multi;
 *
 **/

// "multi" val=INT Multi Multi Multi
protected class MultiRule_Group extends GroupToken {
	
	public MultiRule_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getMultiRuleAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiRule_MultiTerminalRuleCall_4(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getMultiRuleRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "multi"
protected class MultiRule_MultiKeyword_0 extends KeywordToken  {
	
	public MultiRule_MultiKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getMultiRuleAccess().getMultiKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// val=INT
protected class MultiRule_ValAssignment_1 extends AssignmentToken  {
	
	public MultiRule_ValAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getMultiRuleAccess().getValAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiRule_MultiKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("val",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("val");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getMultiRuleAccess().getValINTTerminalRuleCall_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getMultiRuleAccess().getValINTTerminalRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// Multi
protected class MultiRule_MultiTerminalRuleCall_2 extends UnassignedTextToken {

	public MultiRule_MultiTerminalRuleCall_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getMultiRuleAccess().getMultiTerminalRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiRule_ValAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// Multi
protected class MultiRule_MultiTerminalRuleCall_3 extends UnassignedTextToken {

	public MultiRule_MultiTerminalRuleCall_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getMultiRuleAccess().getMultiTerminalRuleCall_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiRule_MultiTerminalRuleCall_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// Multi
protected class MultiRule_MultiTerminalRuleCall_4 extends UnassignedTextToken {

	public MultiRule_MultiTerminalRuleCall_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getMultiRuleAccess().getMultiTerminalRuleCall_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiRule_MultiTerminalRuleCall_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule MultiRule ****************/


/************ begin Rule DatatypeRule ****************
 *
 * DatatypeRule:
 * 	"datatype" val=INT Datatype;
 *
 **/

// "datatype" val=INT Datatype
protected class DatatypeRule_Group extends GroupToken {
	
	public DatatypeRule_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getDatatypeRuleAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DatatypeRule_DatatypeParserRuleCall_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getDatatypeRuleRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "datatype"
protected class DatatypeRule_DatatypeKeyword_0 extends KeywordToken  {
	
	public DatatypeRule_DatatypeKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getDatatypeRuleAccess().getDatatypeKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// val=INT
protected class DatatypeRule_ValAssignment_1 extends AssignmentToken  {
	
	public DatatypeRule_ValAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDatatypeRuleAccess().getValAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DatatypeRule_DatatypeKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("val",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("val");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getDatatypeRuleAccess().getValINTTerminalRuleCall_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getDatatypeRuleAccess().getValINTTerminalRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// Datatype
protected class DatatypeRule_DatatypeParserRuleCall_2 extends UnassignedTextToken {

	public DatatypeRule_DatatypeParserRuleCall_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getDatatypeRuleAccess().getDatatypeParserRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DatatypeRule_ValAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule DatatypeRule ****************/




/************ begin Rule CommonTerminalsRule ****************
 *
 * CommonTerminalsRule:
 * 	"terminals" ID INT STRING val=ID;
 *
 **/

// "terminals" ID INT STRING val=ID
protected class CommonTerminalsRule_Group extends GroupToken {
	
	public CommonTerminalsRule_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCommonTerminalsRuleAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CommonTerminalsRule_ValAssignment_4(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getCommonTerminalsRuleRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "terminals"
protected class CommonTerminalsRule_TerminalsKeyword_0 extends KeywordToken  {
	
	public CommonTerminalsRule_TerminalsKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCommonTerminalsRuleAccess().getTerminalsKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// ID
protected class CommonTerminalsRule_IDTerminalRuleCall_1 extends UnassignedTextToken {

	public CommonTerminalsRule_IDTerminalRuleCall_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getCommonTerminalsRuleAccess().getIDTerminalRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CommonTerminalsRule_TerminalsKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// INT
protected class CommonTerminalsRule_INTTerminalRuleCall_2 extends UnassignedTextToken {

	public CommonTerminalsRule_INTTerminalRuleCall_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getCommonTerminalsRuleAccess().getINTTerminalRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CommonTerminalsRule_IDTerminalRuleCall_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// STRING
protected class CommonTerminalsRule_STRINGTerminalRuleCall_3 extends UnassignedTextToken {

	public CommonTerminalsRule_STRINGTerminalRuleCall_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getCommonTerminalsRuleAccess().getSTRINGTerminalRuleCall_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CommonTerminalsRule_INTTerminalRuleCall_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// val=ID
protected class CommonTerminalsRule_ValAssignment_4 extends AssignmentToken  {
	
	public CommonTerminalsRule_ValAssignment_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCommonTerminalsRuleAccess().getValAssignment_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CommonTerminalsRule_STRINGTerminalRuleCall_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("val",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("val");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getCommonTerminalsRuleAccess().getValIDTerminalRuleCall_4_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getCommonTerminalsRuleAccess().getValIDTerminalRuleCall_4_0();
			return obj;
		}
		return null;
	}

}


/************ end Rule CommonTerminalsRule ****************/

}