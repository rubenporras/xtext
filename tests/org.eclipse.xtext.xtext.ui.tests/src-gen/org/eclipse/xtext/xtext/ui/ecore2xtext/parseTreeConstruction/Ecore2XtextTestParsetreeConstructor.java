/*
 * generated by Xtext
 */
package org.eclipse.xtext.xtext.ui.ecore2xtext.parseTreeConstruction;

import org.eclipse.emf.ecore.*;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IEObjectConsumer;

import org.eclipse.xtext.xtext.ui.ecore2xtext.services.Ecore2XtextTestGrammarAccess;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class Ecore2XtextTestParsetreeConstructor extends org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor {
		
	@Inject
	private Ecore2XtextTestGrammarAccess grammarAccess;
	
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
			case 0: return new Root_Group(this, this, 0, inst);
			case 1: return new Abstract_Alternatives(this, this, 1, inst);
			case 2: return new Concrete0_Alternatives(this, this, 2, inst);
			case 3: return new Concrete0_Impl_Group(this, this, 3, inst);
			case 4: return new Concrete1_Impl_Group(this, this, 4, inst);
			case 5: return new DiamondInheritance_Group(this, this, 5, inst);
			default: return null;
		}	
	}	
}
	

/************ begin Rule Root ****************
 *
 * Root:
 * 	{Root} "Root" name=INT0 "{" ("classes" "{" classes+=Abstract ("," classes+=Abstract)* "}")? ("concrete0"
 * 	concrete0=Concrete0)? "}";
 *
 **/

// {Root} "Root" name=INT0 "{" ("classes" "{" classes+=Abstract ("," classes+=Abstract)* "}")? ("concrete0"
// concrete0=Concrete0)? "}"
protected class Root_Group extends GroupToken {
	
	public Root_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getRootAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Root_RightCurlyBracketKeyword_6(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getRootAccess().getRootAction_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// {Root}
protected class Root_RootAction_0 extends ActionToken  {

	public Root_RootAction_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getRootAccess().getRootAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(!eObjectConsumer.isConsumed()) return null;
		return eObjectConsumer;
	}
}

// "Root"
protected class Root_RootKeyword_1 extends KeywordToken  {
	
	public Root_RootKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getRootAccess().getRootKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Root_RootAction_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// name=INT0
protected class Root_NameAssignment_2 extends AssignmentToken  {
	
	public Root_NameAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getRootAccess().getNameAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Root_RootKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getRootAccess().getNameINT0ParserRuleCall_2_0(), value, null)) {
			type = AssignmentType.DATATYPE_RULE_CALL;
			element = grammarAccess.getRootAccess().getNameINT0ParserRuleCall_2_0();
			return obj;
		}
		return null;
	}

}

// "{"
protected class Root_LeftCurlyBracketKeyword_3 extends KeywordToken  {
	
	public Root_LeftCurlyBracketKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Root_NameAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ("classes" "{" classes+=Abstract ("," classes+=Abstract)* "}")?
protected class Root_Group_4 extends GroupToken {
	
	public Root_Group_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getRootAccess().getGroup_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Root_RightCurlyBracketKeyword_4_4(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "classes"
protected class Root_ClassesKeyword_4_0 extends KeywordToken  {
	
	public Root_ClassesKeyword_4_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getRootAccess().getClassesKeyword_4_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Root_LeftCurlyBracketKeyword_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "{"
protected class Root_LeftCurlyBracketKeyword_4_1 extends KeywordToken  {
	
	public Root_LeftCurlyBracketKeyword_4_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_4_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Root_ClassesKeyword_4_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// classes+=Abstract
protected class Root_ClassesAssignment_4_2 extends AssignmentToken  {
	
	public Root_ClassesAssignment_4_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getRootAccess().getClassesAssignment_4_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Abstract_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("classes",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("classes");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getAbstractRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Root_LeftCurlyBracketKeyword_4_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("," classes+=Abstract)*
protected class Root_Group_4_3 extends GroupToken {
	
	public Root_Group_4_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getRootAccess().getGroup_4_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Root_ClassesAssignment_4_3_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ","
protected class Root_CommaKeyword_4_3_0 extends KeywordToken  {
	
	public Root_CommaKeyword_4_3_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getRootAccess().getCommaKeyword_4_3_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Root_Group_4_3(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Root_ClassesAssignment_4_2(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// classes+=Abstract
protected class Root_ClassesAssignment_4_3_1 extends AssignmentToken  {
	
	public Root_ClassesAssignment_4_3_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getRootAccess().getClassesAssignment_4_3_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Abstract_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("classes",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("classes");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getAbstractRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_3_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Root_CommaKeyword_4_3_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// "}"
protected class Root_RightCurlyBracketKeyword_4_4 extends KeywordToken  {
	
	public Root_RightCurlyBracketKeyword_4_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getRootAccess().getRightCurlyBracketKeyword_4_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Root_Group_4_3(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Root_ClassesAssignment_4_2(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}


// ("concrete0" concrete0=Concrete0)?
protected class Root_Group_5 extends GroupToken {
	
	public Root_Group_5(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getRootAccess().getGroup_5();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Root_Concrete0Assignment_5_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "concrete0"
protected class Root_Concrete0Keyword_5_0 extends KeywordToken  {
	
	public Root_Concrete0Keyword_5_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getRootAccess().getConcrete0Keyword_5_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Root_Group_4(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Root_LeftCurlyBracketKeyword_3(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// concrete0=Concrete0
protected class Root_Concrete0Assignment_5_1 extends AssignmentToken  {
	
	public Root_Concrete0Assignment_5_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getRootAccess().getConcrete0Assignment_5_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Concrete0_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("concrete0",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("concrete0");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getConcrete0Rule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getRootAccess().getConcrete0Concrete0ParserRuleCall_5_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Root_Concrete0Keyword_5_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// "}"
protected class Root_RightCurlyBracketKeyword_6 extends KeywordToken  {
	
	public Root_RightCurlyBracketKeyword_6(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getRootAccess().getRightCurlyBracketKeyword_6();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Root_Group_5(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Root_Group_4(lastRuleCallOrigin, this, 1, inst);
			case 2: return new Root_LeftCurlyBracketKeyword_3(lastRuleCallOrigin, this, 2, inst);
			default: return null;
		}	
	}

}


/************ end Rule Root ****************/


/************ begin Rule Abstract ****************
 *
 * Abstract:
 * 	Concrete0_Impl | Concrete1_Impl | DiamondInheritance;
 *
 **/

// Concrete0_Impl | Concrete1_Impl | DiamondInheritance
protected class Abstract_Alternatives extends AlternativesToken {

	public Abstract_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getAbstractAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Abstract_Concrete0_ImplParserRuleCall_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Abstract_Concrete1_ImplParserRuleCall_1(lastRuleCallOrigin, this, 1, inst);
			case 2: return new Abstract_DiamondInheritanceParserRuleCall_2(lastRuleCallOrigin, this, 2, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getConcrete1_ImplAccess().getConcrete1Action_0().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// Concrete0_Impl
protected class Abstract_Concrete0_ImplParserRuleCall_0 extends RuleCallToken {
	
	public Abstract_Concrete0_ImplParserRuleCall_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getAbstractAccess().getConcrete0_ImplParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Concrete0_Impl_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0().getType().getClassifier())
			return null;
		if(checkForRecursion(Concrete0_Impl_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// Concrete1_Impl
protected class Abstract_Concrete1_ImplParserRuleCall_1 extends RuleCallToken {
	
	public Abstract_Concrete1_ImplParserRuleCall_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getAbstractAccess().getConcrete1_ImplParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Concrete1_Impl_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getConcrete1_ImplAccess().getConcrete1Action_0().getType().getClassifier())
			return null;
		if(checkForRecursion(Concrete1_Impl_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// DiamondInheritance
protected class Abstract_DiamondInheritanceParserRuleCall_2 extends RuleCallToken {
	
	public Abstract_DiamondInheritanceParserRuleCall_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getAbstractAccess().getDiamondInheritanceParserRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DiamondInheritance_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0().getType().getClassifier())
			return null;
		if(checkForRecursion(DiamondInheritance_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule Abstract ****************/


/************ begin Rule Concrete0 ****************
 *
 * Concrete0:
 * 	Concrete0_Impl | DiamondInheritance;
 *
 **/

// Concrete0_Impl | DiamondInheritance
protected class Concrete0_Alternatives extends AlternativesToken {

	public Concrete0_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getConcrete0Access().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Concrete0_Concrete0_ImplParserRuleCall_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Concrete0_DiamondInheritanceParserRuleCall_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// Concrete0_Impl
protected class Concrete0_Concrete0_ImplParserRuleCall_0 extends RuleCallToken {
	
	public Concrete0_Concrete0_ImplParserRuleCall_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getConcrete0Access().getConcrete0_ImplParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Concrete0_Impl_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0().getType().getClassifier())
			return null;
		if(checkForRecursion(Concrete0_Impl_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// DiamondInheritance
protected class Concrete0_DiamondInheritanceParserRuleCall_1 extends RuleCallToken {
	
	public Concrete0_DiamondInheritanceParserRuleCall_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getConcrete0Access().getDiamondInheritanceParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DiamondInheritance_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0().getType().getClassifier())
			return null;
		if(checkForRecursion(DiamondInheritance_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule Concrete0 ****************/



/************ begin Rule Concrete0_Impl ****************
 *
 * Concrete0_Impl returns Concrete0:
 * 	{Concrete0} "Concrete0" name=EString;
 *
 **/

// {Concrete0} "Concrete0" name=EString
protected class Concrete0_Impl_Group extends GroupToken {
	
	public Concrete0_Impl_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getConcrete0_ImplAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Concrete0_Impl_NameAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// {Concrete0}
protected class Concrete0_Impl_Concrete0Action_0 extends ActionToken  {

	public Concrete0_Impl_Concrete0Action_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(!eObjectConsumer.isConsumed()) return null;
		return eObjectConsumer;
	}
}

// "Concrete0"
protected class Concrete0_Impl_Concrete0Keyword_1 extends KeywordToken  {
	
	public Concrete0_Impl_Concrete0Keyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getConcrete0_ImplAccess().getConcrete0Keyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Concrete0_Impl_Concrete0Action_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// name=EString
protected class Concrete0_Impl_NameAssignment_2 extends AssignmentToken  {
	
	public Concrete0_Impl_NameAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getConcrete0_ImplAccess().getNameAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Concrete0_Impl_Concrete0Keyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getConcrete0_ImplAccess().getNameEStringParserRuleCall_2_0(), value, null)) {
			type = AssignmentType.DATATYPE_RULE_CALL;
			element = grammarAccess.getConcrete0_ImplAccess().getNameEStringParserRuleCall_2_0();
			return obj;
		}
		return null;
	}

}


/************ end Rule Concrete0_Impl ****************/



/************ begin Rule Concrete1_Impl ****************
 *
 * Concrete1_Impl returns Concrete1:
 * 	{Concrete1} "Concrete1" name=EString;
 *
 **/

// {Concrete1} "Concrete1" name=EString
protected class Concrete1_Impl_Group extends GroupToken {
	
	public Concrete1_Impl_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getConcrete1_ImplAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Concrete1_Impl_NameAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getConcrete1_ImplAccess().getConcrete1Action_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// {Concrete1}
protected class Concrete1_Impl_Concrete1Action_0 extends ActionToken  {

	public Concrete1_Impl_Concrete1Action_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getConcrete1_ImplAccess().getConcrete1Action_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(!eObjectConsumer.isConsumed()) return null;
		return eObjectConsumer;
	}
}

// "Concrete1"
protected class Concrete1_Impl_Concrete1Keyword_1 extends KeywordToken  {
	
	public Concrete1_Impl_Concrete1Keyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getConcrete1_ImplAccess().getConcrete1Keyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Concrete1_Impl_Concrete1Action_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// name=EString
protected class Concrete1_Impl_NameAssignment_2 extends AssignmentToken  {
	
	public Concrete1_Impl_NameAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getConcrete1_ImplAccess().getNameAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Concrete1_Impl_Concrete1Keyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getConcrete1_ImplAccess().getNameEStringParserRuleCall_2_0(), value, null)) {
			type = AssignmentType.DATATYPE_RULE_CALL;
			element = grammarAccess.getConcrete1_ImplAccess().getNameEStringParserRuleCall_2_0();
			return obj;
		}
		return null;
	}

}


/************ end Rule Concrete1_Impl ****************/


/************ begin Rule DiamondInheritance ****************
 *
 * DiamondInheritance:
 * 	{DiamondInheritance} "DiamondInheritance" name=EString;
 *
 **/

// {DiamondInheritance} "DiamondInheritance" name=EString
protected class DiamondInheritance_Group extends GroupToken {
	
	public DiamondInheritance_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getDiamondInheritanceAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DiamondInheritance_NameAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// {DiamondInheritance}
protected class DiamondInheritance_DiamondInheritanceAction_0 extends ActionToken  {

	public DiamondInheritance_DiamondInheritanceAction_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(!eObjectConsumer.isConsumed()) return null;
		return eObjectConsumer;
	}
}

// "DiamondInheritance"
protected class DiamondInheritance_DiamondInheritanceKeyword_1 extends KeywordToken  {
	
	public DiamondInheritance_DiamondInheritanceKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DiamondInheritance_DiamondInheritanceAction_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// name=EString
protected class DiamondInheritance_NameAssignment_2 extends AssignmentToken  {
	
	public DiamondInheritance_NameAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDiamondInheritanceAccess().getNameAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DiamondInheritance_DiamondInheritanceKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getDiamondInheritanceAccess().getNameEStringParserRuleCall_2_0(), value, null)) {
			type = AssignmentType.DATATYPE_RULE_CALL;
			element = grammarAccess.getDiamondInheritanceAccess().getNameEStringParserRuleCall_2_0();
			return obj;
		}
		return null;
	}

}


/************ end Rule DiamondInheritance ****************/

}