package org.eclipse.xtext.generator.ecore.idea.lang;

import org.eclipse.xtext.generator.ecore.idea.lang.AbstractSubTestLanguageFileType;
import org.eclipse.xtext.generator.ecore.idea.lang.SubTestLanguageLanguage;

@SuppressWarnings("all")
public class SubTestLanguageFileType extends AbstractSubTestLanguageFileType {
  public final static SubTestLanguageFileType INSTANCE = new SubTestLanguageFileType();
  
  public SubTestLanguageFileType() {
    super(SubTestLanguageLanguage.INSTANCE);
  }
}