/*
 * generated by Xtext
 */
grammar PsiInternalPartialParserTestLanguage;

options {
	superClass=AbstractPsiAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.testlanguages.idea.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.testlanguages.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.PartialParserTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;
}

@parser::members {

	protected PartialParserTestLanguageGrammarAccess grammarAccess;

	protected PartialParserTestLanguageElementTypeProvider elementTypeProvider;

	public PsiInternalPartialParserTestLanguageParser(PsiBuilder builder, TokenStream input, PartialParserTestLanguageElementTypeProvider elementTypeProvider, PartialParserTestLanguageGrammarAccess grammarAccess) {
		this(input);
		setPsiBuilder(builder);
    	this.grammarAccess = grammarAccess;
		this.elementTypeProvider = elementTypeProvider;
	}

	@Override
	protected String getFirstRuleName() {
		return "SomeContainer";
	}

}

//Entry rule entryRuleSomeContainer
entryRuleSomeContainer:
	{ markComposite(elementTypeProvider.getSomeContainerElementType()); }
	ruleSomeContainer
	{ doneComposite(); }
	EOF;
finally {
}

// Rule SomeContainer
ruleSomeContainer:
	(
		{
			markLeaf();
		}
		otherlv_0='container'
		{
			doneLeaf(otherlv_0, elementTypeProvider.getSomeContainer_ContainerKeyword_0ElementType());
		}
		(
			(
				{
					markLeaf();
				}
				lv_name_1_0=RULE_ID
				{
					doneLeaf(lv_name_1_0, elementTypeProvider.getSomeContainer_NameIDTerminalRuleCall_1_0ElementType());
				}
			)
		)
		{
			markLeaf();
		}
		otherlv_2='{'
		{
			doneLeaf(otherlv_2, elementTypeProvider.getSomeContainer_LeftCurlyBracketKeyword_2ElementType());
		}
		(
			(
				(
					{
						markComposite(elementTypeProvider.getSomeContainer_NestedNestedParserRuleCall_3_0_0ElementType());
					}
					lv_nested_3_0=ruleNested
					{
						doneComposite();
					}
				)
			)
			    |
			(
				(
					{
						markComposite(elementTypeProvider.getSomeContainer_ContentContentParserRuleCall_3_1_0ElementType());
					}
					lv_content_4_0=ruleContent
					{
						doneComposite();
					}
				)
			)
		)*
		{
			markLeaf();
		}
		otherlv_5='}'
		{
			doneLeaf(otherlv_5, elementTypeProvider.getSomeContainer_RightCurlyBracketKeyword_4ElementType());
		}
	)
;

//Entry rule entryRuleNested
entryRuleNested:
	{ markComposite(elementTypeProvider.getNestedElementType()); }
	ruleNested
	{ doneComposite(); }
	EOF;
finally {
}

// Rule Nested
ruleNested:
	(
		{
			markLeaf();
		}
		otherlv_0='nested'
		{
			doneLeaf(otherlv_0, elementTypeProvider.getNested_NestedKeyword_0ElementType());
		}
		{
			markLeaf();
		}
		otherlv_1='{'
		{
			doneLeaf(otherlv_1, elementTypeProvider.getNested_LeftCurlyBracketKeyword_1ElementType());
		}
		(
			(
				{
					markComposite(elementTypeProvider.getNested_NestedSomeContainerParserRuleCall_2_0ElementType());
				}
				lv_nested_2_0=ruleSomeContainer
				{
					doneComposite();
				}
			)
		)+
		{
			markLeaf();
		}
		otherlv_3='}'
		{
			doneLeaf(otherlv_3, elementTypeProvider.getNested_RightCurlyBracketKeyword_3ElementType());
		}
	)
;

//Entry rule entryRuleContent
entryRuleContent:
	{ markComposite(elementTypeProvider.getContentElementType()); }
	ruleContent
	{ doneComposite(); }
	EOF;
finally {
}

// Rule Content
ruleContent:
	(
		{
			markComposite(elementTypeProvider.getContent_ChildrenParserRuleCall_0ElementType());
		}
		ruleChildren
		{
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getContent_AbstractChildrenParserRuleCall_1ElementType());
		}
		ruleAbstractChildren
		{
			doneComposite();
		}
	)
;

//Entry rule entryRuleChildren
entryRuleChildren:
	{ markComposite(elementTypeProvider.getChildrenElementType()); }
	ruleChildren
	{ doneComposite(); }
	EOF;
finally {
}

// Rule Children
ruleChildren:
	(
		{
			markLeaf();
		}
		otherlv_0='children'
		{
			doneLeaf(otherlv_0, elementTypeProvider.getChildren_ChildrenKeyword_0ElementType());
		}
		{
			markLeaf();
		}
		otherlv_1='{'
		{
			doneLeaf(otherlv_1, elementTypeProvider.getChildren_LeftCurlyBracketKeyword_1ElementType());
		}
		(
			(
				{
					markComposite(elementTypeProvider.getChildren_ChildrenChildParserRuleCall_2_0ElementType());
				}
				lv_children_2_0=ruleChild
				{
					doneComposite();
				}
			)
		)
		(
			{
				markLeaf();
			}
			otherlv_3=','
			{
				doneLeaf(otherlv_3, elementTypeProvider.getChildren_CommaKeyword_3_0ElementType());
			}
			(
				(
					{
						markComposite(elementTypeProvider.getChildren_ChildrenChildParserRuleCall_3_1_0ElementType());
					}
					lv_children_4_0=ruleChild
					{
						doneComposite();
					}
				)
			)
		)*
		{
			markLeaf();
		}
		otherlv_5='}'
		{
			doneLeaf(otherlv_5, elementTypeProvider.getChildren_RightCurlyBracketKeyword_4ElementType());
		}
	)
;

//Entry rule entryRuleChild
entryRuleChild:
	{ markComposite(elementTypeProvider.getChildElementType()); }
	ruleChild
	{ doneComposite(); }
	EOF;
finally {
}

// Rule Child
ruleChild:
	(
		{
			markLeaf();
		}
		otherlv_0='->'
		{
			doneLeaf(otherlv_0, elementTypeProvider.getChild_HyphenMinusGreaterThanSignKeyword_0ElementType());
		}
		{
			markLeaf();
		}
		otherlv_1='C'
		{
			doneLeaf(otherlv_1, elementTypeProvider.getChild_CKeyword_1ElementType());
		}
		{
			markLeaf();
		}
		otherlv_2='('
		{
			doneLeaf(otherlv_2, elementTypeProvider.getChild_LeftParenthesisKeyword_2ElementType());
		}
		(
			(
				{
					markComposite(elementTypeProvider.getChild_ValueNamedParserRuleCall_3_0ElementType());
				}
				lv_value_3_0=ruleNamed
				{
					doneComposite();
				}
			)
		)
		{
			markLeaf();
		}
		otherlv_4=')'
		{
			doneLeaf(otherlv_4, elementTypeProvider.getChild_RightParenthesisKeyword_4ElementType());
		}
	)
;

//Entry rule entryRuleAbstractChildren
entryRuleAbstractChildren:
	{ markComposite(elementTypeProvider.getAbstractChildrenElementType()); }
	ruleAbstractChildren
	{ doneComposite(); }
	EOF;
finally {
}

// Rule AbstractChildren
ruleAbstractChildren:
	(
		{
			markLeaf();
		}
		otherlv_0='abstract children'
		{
			doneLeaf(otherlv_0, elementTypeProvider.getAbstractChildren_AbstractChildrenKeyword_0ElementType());
		}
		{
			markLeaf();
		}
		otherlv_1='{'
		{
			doneLeaf(otherlv_1, elementTypeProvider.getAbstractChildren_LeftCurlyBracketKeyword_1ElementType());
		}
		(
			(
				{
					markComposite(elementTypeProvider.getAbstractChildren_AbstractChildrenAbstractChildParserRuleCall_2_0ElementType());
				}
				lv_abstractChildren_2_0=ruleAbstractChild
				{
					doneComposite();
				}
			)
		)+
		{
			markLeaf();
		}
		otherlv_3='}'
		{
			doneLeaf(otherlv_3, elementTypeProvider.getAbstractChildren_RightCurlyBracketKeyword_3ElementType());
		}
	)
;

//Entry rule entryRuleAbstractChild
entryRuleAbstractChild:
	{ markComposite(elementTypeProvider.getAbstractChildElementType()); }
	ruleAbstractChild
	{ doneComposite(); }
	EOF;
finally {
}

// Rule AbstractChild
ruleAbstractChild:
	(
		{
			markComposite(elementTypeProvider.getAbstractChild_FirstConcreteParserRuleCall_0ElementType());
		}
		ruleFirstConcrete
		{
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getAbstractChild_SecondConcreteParserRuleCall_1ElementType());
		}
		ruleSecondConcrete
		{
			doneComposite();
		}
	)
;

//Entry rule entryRuleFirstConcrete
entryRuleFirstConcrete:
	{ markComposite(elementTypeProvider.getFirstConcreteElementType()); }
	ruleFirstConcrete
	{ doneComposite(); }
	EOF;
finally {
}

// Rule FirstConcrete
ruleFirstConcrete:
	(
		{
			markLeaf();
		}
		otherlv_0='->'
		{
			doneLeaf(otherlv_0, elementTypeProvider.getFirstConcrete_HyphenMinusGreaterThanSignKeyword_0ElementType());
		}
		{
			markLeaf();
		}
		otherlv_1='F'
		{
			doneLeaf(otherlv_1, elementTypeProvider.getFirstConcrete_FKeyword_1ElementType());
		}
		{
			markLeaf();
		}
		otherlv_2='('
		{
			doneLeaf(otherlv_2, elementTypeProvider.getFirstConcrete_LeftParenthesisKeyword_2ElementType());
		}
		(
			(
				{
					markComposite(elementTypeProvider.getFirstConcrete_ValueNamedParserRuleCall_3_0ElementType());
				}
				lv_value_3_0=ruleNamed
				{
					doneComposite();
				}
			)
		)
		(
			(
				{
					markLeaf();
				}
				otherlv_4=RULE_ID
				{
					doneLeaf(otherlv_4, elementTypeProvider.getFirstConcrete_ReferencedContainerSomeContainerCrossReference_4_0ElementType());
				}
			)
		)?
		{
			markLeaf();
		}
		otherlv_5=')'
		{
			doneLeaf(otherlv_5, elementTypeProvider.getFirstConcrete_RightParenthesisKeyword_5ElementType());
		}
	)
;

//Entry rule entryRuleSecondConcrete
entryRuleSecondConcrete:
	{ markComposite(elementTypeProvider.getSecondConcreteElementType()); }
	ruleSecondConcrete
	{ doneComposite(); }
	EOF;
finally {
}

// Rule SecondConcrete
ruleSecondConcrete:
	(
		{
			markLeaf();
		}
		otherlv_0='->'
		{
			doneLeaf(otherlv_0, elementTypeProvider.getSecondConcrete_HyphenMinusGreaterThanSignKeyword_0ElementType());
		}
		{
			markLeaf();
		}
		otherlv_1='F'
		{
			doneLeaf(otherlv_1, elementTypeProvider.getSecondConcrete_FKeyword_1ElementType());
		}
		{
			markLeaf();
		}
		otherlv_2='S'
		{
			doneLeaf(otherlv_2, elementTypeProvider.getSecondConcrete_SKeyword_2ElementType());
		}
		{
			markLeaf();
		}
		otherlv_3='('
		{
			doneLeaf(otherlv_3, elementTypeProvider.getSecondConcrete_LeftParenthesisKeyword_3ElementType());
		}
		(
			(
				{
					markComposite(elementTypeProvider.getSecondConcrete_ValueNamedParserRuleCall_4_0ElementType());
				}
				lv_value_4_0=ruleNamed
				{
					doneComposite();
				}
			)
		)
		(
			(
				{
					markLeaf();
				}
				otherlv_5=RULE_ID
				{
					doneLeaf(otherlv_5, elementTypeProvider.getSecondConcrete_ReferencedChildrenChildCrossReference_5_0ElementType());
				}
			)
		)?
		{
			markLeaf();
		}
		otherlv_6=')'
		{
			doneLeaf(otherlv_6, elementTypeProvider.getSecondConcrete_RightParenthesisKeyword_6ElementType());
		}
	)
;

//Entry rule entryRuleNamed
entryRuleNamed:
	{ markComposite(elementTypeProvider.getNamedElementType()); }
	ruleNamed
	{ doneComposite(); }
	EOF;
finally {
}

// Rule Named
ruleNamed:
	(
		(
			{
				markLeaf();
			}
			lv_name_0_0=RULE_ID
			{
				doneLeaf(lv_name_0_0, elementTypeProvider.getNamed_NameIDTerminalRuleCall_0ElementType());
			}
		)
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;