/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.ISetupExtension;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.impl.BinaryGrammarResourceFactoryImpl;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.LanguageConfig2;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IClassAnnotation;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.StandaloneSetupAccess;
import org.eclipse.xtext.xtext.generator.model.SuppressWarningsAnnotation;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@Singleton
@SuppressWarnings("all")
public class XtextGeneratorTemplates {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  private CodeConfig codeConfig;
  
  @Inject
  private IEncodingProvider encodingProvider;
  
  public TextFileAccess createPluginXml(final PluginXmlAccess pluginXml) {
    final TextFileAccess file = new TextFileAccess();
    file.setEncodingProvider(this.encodingProvider);
    String _path = pluginXml.getPath();
    file.setPath(_path);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<?eclipse version=\"3.0\"?>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<plugin>");
    _builder.newLine();
    {
      List<CharSequence> _entries = pluginXml.getEntries();
      for(final CharSequence entry : _entries) {
        _builder.append("\t");
        _builder.append(entry, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</plugin>");
    _builder.newLine();
    file.setContent(_builder);
    return file;
  }
  
  public JavaFileAccess createRuntimeSetup(final LanguageConfig2 langConfig) {
    final Grammar g = langConfig.getGrammar();
    TypeReference _runtimeSetup = this._xtextGeneratorNaming.getRuntimeSetup(g);
    final JavaFileAccess javaFile = new JavaFileAccess(_runtimeSetup, this.codeConfig);
    javaFile.setEncodingProvider(this.encodingProvider);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Initialization support for running Xtext languages without Equinox extension registry.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    javaFile.setTypeComment(_builder);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _runtimeSetup = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeSetup(g);
        String _simpleName = _runtimeSetup.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _runtimeGenSetup = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeGenSetup(g);
        _builder.append(_runtimeGenSetup, "");
        _builder.append("{");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static void doSetup() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("new ");
        TypeReference _runtimeSetup_1 = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeSetup(g);
        String _simpleName_1 = _runtimeSetup_1.getSimpleName();
        _builder.append(_simpleName_1, "\t\t");
        _builder.append("().createInjectorAndDoEMFRegistration();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setJavaContent(_client);
    return javaFile;
  }
  
  public JavaFileAccess createRuntimeGenSetup(final LanguageConfig2 langConfig) {
    final Grammar g = langConfig.getGrammar();
    TypeReference _runtimeGenSetup = this._xtextGeneratorNaming.getRuntimeGenSetup(g);
    final JavaFileAccess javaFile = new JavaFileAccess(_runtimeGenSetup, this.codeConfig);
    javaFile.setEncodingProvider(this.encodingProvider);
    StandaloneSetupAccess _runtimeGenSetup_1 = langConfig.getRuntimeGenSetup();
    Set<TypeReference> _imports = _runtimeGenSetup_1.getImports();
    for (final TypeReference type : _imports) {
      javaFile.importType(type);
    }
    List<IClassAnnotation> _annotations = javaFile.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _runtimeGenSetup = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeGenSetup(g);
        String _simpleName = _runtimeGenSetup.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" implements ");
        _builder.append(ISetup.class, "");
        _builder.append(", ");
        _builder.append(ISetupExtension.class, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        _builder.append(List.class, "\t");
        _builder.append("<String> getFileExtensions() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        _builder.append(Arrays.class, "\t\t");
        _builder.append(".asList(");
        {
          List<String> _fileExtensions = langConfig.getFileExtensions();
          boolean _hasElements = false;
          for(final String fileExtension : _fileExtensions) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "\t\t");
            }
            _builder.append("\"");
            _builder.append(fileExtension, "\t\t");
            _builder.append("\"");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        _builder.append(Injector.class, "\t");
        _builder.append(" createInjectorAndDoEMFRegistration() {");
        _builder.newLineIfNotEmpty();
        {
          EList<Grammar> _usedGrammars = g.getUsedGrammars();
          for(final Grammar usedGrammar : _usedGrammars) {
            _builder.append("\t\t");
            TypeReference _runtimeSetup = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeSetup(usedGrammar);
            _builder.append(_runtimeSetup, "\t\t");
            _builder.append(".doSetup();");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          EList<Grammar> _usedGrammars_1 = g.getUsedGrammars();
          boolean _isEmpty = _usedGrammars_1.isEmpty();
          if (_isEmpty) {
            _builder.append("\t\t");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("// register default ePackages");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("if (!");
            TypeReference _typeRef = TypeReference.typeRef("org.eclipse.emf.ecore.resource.Resource");
            _builder.append(_typeRef, "\t\t\t");
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(\"ecore\"))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            TypeReference _typeRef_1 = TypeReference.typeRef("org.eclipse.emf.ecore.resource.Resource");
            _builder.append(_typeRef_1, "\t\t\t\t");
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("\"ecore\", new ");
            TypeReference _typeRef_2 = TypeReference.typeRef("org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl");
            _builder.append(_typeRef_2, "\t\t\t\t\t");
            _builder.append("());");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("if (!");
            TypeReference _typeRef_3 = TypeReference.typeRef("org.eclipse.emf.ecore.resource.Resource");
            _builder.append(_typeRef_3, "\t\t\t");
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(\"xmi\"))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            TypeReference _typeRef_4 = TypeReference.typeRef("org.eclipse.emf.ecore.resource.Resource");
            _builder.append(_typeRef_4, "\t\t\t\t");
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("\"xmi\", new ");
            TypeReference _typeRef_5 = TypeReference.typeRef("org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl");
            _builder.append(_typeRef_5, "\t\t\t\t\t");
            _builder.append("());");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("if (!");
            TypeReference _typeRef_6 = TypeReference.typeRef("org.eclipse.emf.ecore.resource.Resource");
            _builder.append(_typeRef_6, "\t\t\t");
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(\"xtextbin\"))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            TypeReference _typeRef_7 = TypeReference.typeRef("org.eclipse.emf.ecore.resource.Resource");
            _builder.append(_typeRef_7, "\t\t\t\t");
            _builder.append(".Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("\"xtextbin\", new ");
            _builder.append(BinaryGrammarResourceFactoryImpl.class, "\t\t\t\t\t");
            _builder.append("());");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("if (!");
            TypeReference _typeRef_8 = TypeReference.typeRef("org.eclipse.emf.ecore.EPackage");
            _builder.append(_typeRef_8, "\t\t\t");
            _builder.append(".Registry.INSTANCE.containsKey(");
            _builder.append(XtextPackage.class, "\t\t\t");
            _builder.append(".eNS_URI))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            TypeReference _typeRef_9 = TypeReference.typeRef("org.eclipse.emf.ecore.EPackage");
            _builder.append(_typeRef_9, "\t\t\t\t");
            _builder.append(".Registry.INSTANCE.put(");
            _builder.append(XtextPackage.class, "\t\t\t\t");
            _builder.append(".eNS_URI, ");
            _builder.append(XtextPackage.class, "\t\t\t\t");
            _builder.append(".eINSTANCE);");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append(Injector.class, "\t\t");
        _builder.append(" injector = createInjector();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("register(injector);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return injector;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        _builder.append(Injector.class, "\t");
        _builder.append(" createInjector() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        _builder.append(Guice.class, "\t\t");
        _builder.append(".createInjector(new ");
        TypeReference _runtimeModule = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeModule(g);
        _builder.append(_runtimeModule, "\t\t");
        _builder.append("());");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void register(");
        _builder.append(Injector.class, "\t");
        _builder.append(" injector) {");
        _builder.newLineIfNotEmpty();
        {
          StandaloneSetupAccess _runtimeGenSetup_1 = langConfig.getRuntimeGenSetup();
          List<CharSequence> _registrations = _runtimeGenSetup_1.getRegistrations();
          for(final CharSequence reg : _registrations) {
            _builder.append("\t\t");
            _builder.append(reg, "\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setJavaContent(_client);
    javaFile.setMarkedAsGenerated(true);
    return javaFile;
  }
  
  private String getBindMethodName(final GuiceModuleAccess.Binding it) {
    String _xifexpression = null;
    boolean _and = false;
    GuiceModuleAccess.BindValue _value = it.getValue();
    boolean _isProvider = _value.isProvider();
    boolean _not = (!_isProvider);
    if (!_not) {
      _and = false;
    } else {
      GuiceModuleAccess.BindValue _value_1 = it.getValue();
      List<CharSequence> _statements = _value_1.getStatements();
      boolean _isEmpty = _statements.isEmpty();
      _and = _isEmpty;
    }
    if (_and) {
      _xifexpression = "bind";
    } else {
      String _xifexpression_1 = null;
      GuiceModuleAccess.BindValue _value_2 = it.getValue();
      List<CharSequence> _statements_1 = _value_2.getStatements();
      boolean _isEmpty_1 = _statements_1.isEmpty();
      if (_isEmpty_1) {
        _xifexpression_1 = "provide";
      } else {
        _xifexpression_1 = "configure";
      }
      _xifexpression = _xifexpression_1;
    }
    GuiceModuleAccess.BindKey _key = it.getKey();
    TypeReference _type = _key.getType();
    String _simpleMethodName = this.getSimpleMethodName(_type);
    String _plus = (_xifexpression + _simpleMethodName);
    String _xifexpression_2 = null;
    boolean _and_1 = false;
    GuiceModuleAccess.BindValue _value_3 = it.getValue();
    Object _expression = _value_3.getExpression();
    boolean _tripleNotEquals = (_expression != null);
    if (!_tripleNotEquals) {
      _and_1 = false;
    } else {
      GuiceModuleAccess.BindValue _value_4 = it.getValue();
      boolean _isProvider_1 = _value_4.isProvider();
      boolean _not_1 = (!_isProvider_1);
      _and_1 = _not_1;
    }
    if (_and_1) {
      _xifexpression_2 = "ToInstance";
    } else {
      _xifexpression_2 = "";
    }
    return (_plus + _xifexpression_2);
  }
  
  private String getSimpleMethodName(final TypeReference type) {
    String _name = type.getName();
    String _replaceAll = _name.replaceAll("<", "\\.");
    String _replaceAll_1 = _replaceAll.replaceAll(">", "\\.");
    String[] _split = _replaceAll_1.split("\\.");
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        return Boolean.valueOf(it.matches("[A-Z].*"));
      }
    };
    Iterable<String> _filter = IterableExtensions.<String>filter(((Iterable<String>)Conversions.doWrapArray(_split)), _function);
    return IterableExtensions.join(_filter, "$");
  }
  
  private boolean endsWith(final CharSequence sequence, final char c) {
    boolean _and = false;
    int _length = sequence.length();
    boolean _greaterThan = (_length > 0);
    if (!_greaterThan) {
      _and = false;
    } else {
      int _length_1 = sequence.length();
      int _minus = (_length_1 - 1);
      char _charAt = sequence.charAt(_minus);
      boolean _equals = (_charAt == c);
      _and = _equals;
    }
    return _and;
  }
  
  private StringConcatenationClient createBindingMethod(final GuiceModuleAccess.Binding it) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        {
          boolean _and = false;
          GuiceModuleAccess.BindValue _value = it.getValue();
          boolean _isProvider = _value.isProvider();
          boolean _not = (!_isProvider);
          if (!_not) {
            _and = false;
          } else {
            GuiceModuleAccess.BindValue _value_1 = it.getValue();
            List<CharSequence> _statements = _value_1.getStatements();
            boolean _isEmpty = _statements.isEmpty();
            _and = _isEmpty;
          }
          if (_and) {
            _builder.append("// contributed by ");
            String _contributedBy = it.getContributedBy();
            _builder.append(_contributedBy, "");
            _builder.newLineIfNotEmpty();
            {
              GuiceModuleAccess.BindKey _key = it.getKey();
              boolean _isSingleton = _key.isSingleton();
              if (_isSingleton) {
                _builder.append("@");
                _builder.append(SingletonBinding.class, "");
                {
                  GuiceModuleAccess.BindKey _key_1 = it.getKey();
                  boolean _isEagerSingleton = _key_1.isEagerSingleton();
                  if (_isEagerSingleton) {
                    _builder.append("(eager=true)");
                  }
                }
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("public ");
            {
              GuiceModuleAccess.BindValue _value_2 = it.getValue();
              Object _expression = _value_2.getExpression();
              boolean _tripleEquals = (_expression == null);
              if (_tripleEquals) {
                _builder.append("Class<? extends ");
                GuiceModuleAccess.BindKey _key_2 = it.getKey();
                TypeReference _type = _key_2.getType();
                _builder.append(_type, "");
                _builder.append(">");
              } else {
                GuiceModuleAccess.BindKey _key_3 = it.getKey();
                TypeReference _type_1 = _key_3.getType();
                _builder.append(_type_1, "");
              }
            }
            _builder.append(" ");
            String _bindMethodName = XtextGeneratorTemplates.this.getBindMethodName(it);
            _builder.append(_bindMethodName, "");
            _builder.append("() {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return ");
            {
              GuiceModuleAccess.BindValue _value_3 = it.getValue();
              Object _expression_1 = _value_3.getExpression();
              boolean _tripleNotEquals = (_expression_1 != null);
              if (_tripleNotEquals) {
                GuiceModuleAccess.BindValue _value_4 = it.getValue();
                Object _expression_2 = _value_4.getExpression();
                _builder.append(_expression_2, "\t");
              } else {
                GuiceModuleAccess.BindValue _value_5 = it.getValue();
                TypeReference _type_2 = _value_5.getType();
                _builder.append(_type_2, "\t");
                _builder.append(".class");
              }
            }
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          } else {
            GuiceModuleAccess.BindValue _value_6 = it.getValue();
            List<CharSequence> _statements_1 = _value_6.getStatements();
            boolean _isEmpty_1 = _statements_1.isEmpty();
            if (_isEmpty_1) {
              _builder.append("// contributed by ");
              String _contributedBy_1 = it.getContributedBy();
              _builder.append(_contributedBy_1, "");
              _builder.newLineIfNotEmpty();
              {
                GuiceModuleAccess.BindKey _key_4 = it.getKey();
                boolean _isSingleton_1 = _key_4.isSingleton();
                if (_isSingleton_1) {
                  _builder.append("@");
                  _builder.append(SingletonBinding.class, "");
                  {
                    GuiceModuleAccess.BindKey _key_5 = it.getKey();
                    boolean _isEagerSingleton_1 = _key_5.isEagerSingleton();
                    if (_isEagerSingleton_1) {
                      _builder.append("(eager=true)");
                    }
                  }
                }
              }
              _builder.newLineIfNotEmpty();
              _builder.append("public ");
              {
                GuiceModuleAccess.BindValue _value_7 = it.getValue();
                Object _expression_3 = _value_7.getExpression();
                boolean _equals = Objects.equal(_expression_3, null);
                if (_equals) {
                  _builder.append("Class<? extends ");
                  _builder.append(Provider.class, "");
                  _builder.append("<");
                  GuiceModuleAccess.BindKey _key_6 = it.getKey();
                  TypeReference _type_3 = _key_6.getType();
                  _builder.append(_type_3, "");
                  _builder.append(">>");
                } else {
                  _builder.append(Provider.class, "");
                  _builder.append("<");
                  GuiceModuleAccess.BindKey _key_7 = it.getKey();
                  TypeReference _type_4 = _key_7.getType();
                  _builder.append(_type_4, "");
                  _builder.append(">");
                }
              }
              _builder.append(" ");
              String _bindMethodName_1 = XtextGeneratorTemplates.this.getBindMethodName(it);
              _builder.append(_bindMethodName_1, "");
              _builder.append("() {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("return ");
              {
                GuiceModuleAccess.BindValue _value_8 = it.getValue();
                Object _expression_4 = _value_8.getExpression();
                boolean _notEquals = (!Objects.equal(_expression_4, null));
                if (_notEquals) {
                  GuiceModuleAccess.BindValue _value_9 = it.getValue();
                  Object _expression_5 = _value_9.getExpression();
                  _builder.append(_expression_5, "\t");
                } else {
                  GuiceModuleAccess.BindValue _value_10 = it.getValue();
                  TypeReference _type_5 = _value_10.getType();
                  _builder.append(_type_5, "\t");
                  _builder.append(".class");
                }
              }
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            } else {
              _builder.append("// contributed by ");
              String _contributedBy_2 = it.getContributedBy();
              _builder.append(_contributedBy_2, "");
              _builder.newLineIfNotEmpty();
              _builder.append("public void ");
              String _bindMethodName_2 = XtextGeneratorTemplates.this.getBindMethodName(it);
              _builder.append(_bindMethodName_2, "");
              _builder.append("(");
              _builder.append(Binder.class, "");
              _builder.append(" binder) {");
              _builder.newLineIfNotEmpty();
              {
                GuiceModuleAccess.BindValue _value_11 = it.getValue();
                List<CharSequence> _statements_2 = _value_11.getStatements();
                for(final CharSequence statement : _statements_2) {
                  _builder.append("\t");
                  _builder.append(statement, "\t");
                  {
                    boolean _endsWith = XtextGeneratorTemplates.this.endsWith(statement, ';');
                    boolean _not_1 = (!_endsWith);
                    if (_not_1) {
                      _builder.append(";");
                    }
                  }
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
      }
    };
    return _client;
  }
  
  public JavaFileAccess createRuntimeModule(final LanguageConfig2 langConfig) {
    final Grammar g = langConfig.getGrammar();
    TypeReference _runtimeModule = this._xtextGeneratorNaming.getRuntimeModule(g);
    final JavaFileAccess javaFile = new JavaFileAccess(_runtimeModule, this.codeConfig);
    javaFile.setEncodingProvider(this.encodingProvider);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Use this class to register components to be used at runtime / without the Equinox extension registry.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    javaFile.setTypeComment(_builder);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _runtimeModule = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeModule(g);
        String _simpleName = _runtimeModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _runtimeGenModule = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeGenModule(g);
        _builder.append(_runtimeGenModule, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setJavaContent(_client);
    return javaFile;
  }
  
  public JavaFileAccess createRuntimeGenModule(final LanguageConfig2 langConfig) {
    final Grammar g = langConfig.getGrammar();
    TypeReference _xifexpression = null;
    GuiceModuleAccess _runtimeGenModule = langConfig.getRuntimeGenModule();
    String _superClassName = _runtimeGenModule.getSuperClassName();
    boolean _tripleNotEquals = (_superClassName != null);
    if (_tripleNotEquals) {
      GuiceModuleAccess _runtimeGenModule_1 = langConfig.getRuntimeGenModule();
      String _superClassName_1 = _runtimeGenModule_1.getSuperClassName();
      _xifexpression = new TypeReference(_superClassName_1);
    } else {
      _xifexpression = this._xtextGeneratorNaming.getRuntimeDefaultModule(g);
    }
    final TypeReference superClass = _xifexpression;
    TypeReference _runtimeGenModule_2 = this._xtextGeneratorNaming.getRuntimeGenModule(g);
    final JavaFileAccess javaFile = new JavaFileAccess(_runtimeGenModule_2, this.codeConfig);
    javaFile.setEncodingProvider(this.encodingProvider);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Manual modifications go to {@link ");
    TypeReference _runtimeModule = this._xtextGeneratorNaming.getRuntimeModule(g);
    String _simpleName = _runtimeModule.getSimpleName();
    _builder.append(_simpleName, " ");
    _builder.append("}.");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    javaFile.setTypeComment(_builder);
    List<IClassAnnotation> _annotations = javaFile.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public abstract class ");
        TypeReference _runtimeGenModule = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeGenModule(g);
        String _simpleName = _runtimeGenModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        _builder.append(superClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        _builder.append(Properties.class, "\t");
        _builder.append(" properties = null;");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void configure(");
        _builder.append(Binder.class, "\t");
        _builder.append(" binder) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("properties = tryBindProperties(binder, \"");
        String _name = g.getName();
        String _replaceAll = _name.replaceAll("\\.", "/");
        _builder.append(_replaceAll, "\t\t");
        _builder.append(".properties\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super.configure(binder);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void configureLanguageName(");
        _builder.append(Binder.class, "\t");
        _builder.append(" binder) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("binder.bind(String.class).annotatedWith(");
        _builder.append(Names.class, "\t\t");
        _builder.append(".named(");
        _builder.append(Constants.class, "\t\t");
        _builder.append(".LANGUAGE_NAME)).toInstance(\"");
        String _name_1 = g.getName();
        _builder.append(_name_1, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void configureFileExtensions(");
        _builder.append(Binder.class, "\t");
        _builder.append(" binder) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("if (properties == null || properties.getProperty(Constants.FILE_EXTENSIONS) == null)");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("binder.bind(String.class).annotatedWith(");
        _builder.append(Names.class, "\t\t\t");
        _builder.append(".named(");
        _builder.append(Constants.class, "\t\t\t");
        _builder.append(".FILE_EXTENSIONS)).toInstance(\"");
        List<String> _fileExtensions = langConfig.getFileExtensions();
        String _join = IterableExtensions.join(_fileExtensions, ",");
        _builder.append(_join, "\t\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        {
          GuiceModuleAccess _runtimeGenModule_1 = langConfig.getRuntimeGenModule();
          Set<GuiceModuleAccess.Binding> _bindings = _runtimeGenModule_1.getBindings();
          for(final GuiceModuleAccess.Binding binding : _bindings) {
            _builder.append("\t");
            StringConcatenationClient _createBindingMethod = XtextGeneratorTemplates.this.createBindingMethod(binding);
            _builder.append(_createBindingMethod, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setJavaContent(_client);
    javaFile.setMarkedAsGenerated(true);
    return javaFile;
  }
  
  public JavaFileAccess createEclipsePluginModule(final LanguageConfig2 langConfig) {
    final Grammar g = langConfig.getGrammar();
    TypeReference _eclipsePluginModule = this._xtextGeneratorNaming.getEclipsePluginModule(g);
    final JavaFileAccess javaFile = new JavaFileAccess(_eclipsePluginModule, this.codeConfig);
    javaFile.setEncodingProvider(this.encodingProvider);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Use this class to register components to be used within the Eclipse IDE.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    javaFile.setTypeComment(_builder);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _eclipsePluginModule = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginModule(g);
        String _simpleName = _eclipsePluginModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _eclipsePluginGenModule = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginGenModule(g);
        _builder.append(_eclipsePluginGenModule, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public ");
        TypeReference _eclipsePluginModule_1 = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginModule(g);
        String _simpleName_1 = _eclipsePluginModule_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("(");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.ui.plugin.AbstractUIPlugin");
        _builder.append(_typeRef, "\t");
        _builder.append(" plugin) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super(plugin);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setJavaContent(_client);
    return javaFile;
  }
  
  public JavaFileAccess createEclipsePluginGenModule(final LanguageConfig2 langConfig) {
    final Grammar g = langConfig.getGrammar();
    TypeReference _xifexpression = null;
    GuiceModuleAccess _eclipsePluginGenModule = langConfig.getEclipsePluginGenModule();
    String _superClassName = _eclipsePluginGenModule.getSuperClassName();
    boolean _tripleNotEquals = (_superClassName != null);
    if (_tripleNotEquals) {
      GuiceModuleAccess _eclipsePluginGenModule_1 = langConfig.getEclipsePluginGenModule();
      String _superClassName_1 = _eclipsePluginGenModule_1.getSuperClassName();
      _xifexpression = new TypeReference(_superClassName_1);
    } else {
      _xifexpression = this._xtextGeneratorNaming.getEclipsePluginDefaultModule(g);
    }
    final TypeReference superClass = _xifexpression;
    TypeReference _eclipsePluginGenModule_2 = this._xtextGeneratorNaming.getEclipsePluginGenModule(g);
    final JavaFileAccess javaFile = new JavaFileAccess(_eclipsePluginGenModule_2, this.codeConfig);
    javaFile.setEncodingProvider(this.encodingProvider);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Manual modifications go to {@link ");
    TypeReference _eclipsePluginModule = this._xtextGeneratorNaming.getEclipsePluginModule(g);
    String _simpleName = _eclipsePluginModule.getSimpleName();
    _builder.append(_simpleName, " ");
    _builder.append("}.");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    javaFile.setTypeComment(_builder);
    List<IClassAnnotation> _annotations = javaFile.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public abstract class ");
        TypeReference _eclipsePluginGenModule = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginGenModule(g);
        String _simpleName = _eclipsePluginGenModule.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        _builder.append(superClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        TypeReference _eclipsePluginGenModule_1 = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginGenModule(g);
        String _simpleName_1 = _eclipsePluginGenModule_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("(");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.ui.plugin.AbstractUIPlugin");
        _builder.append(_typeRef, "\t");
        _builder.append(" plugin) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super(plugin);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        {
          GuiceModuleAccess _eclipsePluginGenModule_2 = langConfig.getEclipsePluginGenModule();
          Set<GuiceModuleAccess.Binding> _bindings = _eclipsePluginGenModule_2.getBindings();
          for(final GuiceModuleAccess.Binding binding : _bindings) {
            _builder.append("\t");
            StringConcatenationClient _createBindingMethod = XtextGeneratorTemplates.this.createBindingMethod(binding);
            _builder.append(_createBindingMethod, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setJavaContent(_client);
    javaFile.setMarkedAsGenerated(true);
    return javaFile;
  }
  
  public TextFileAccess createManifest(final ManifestAccess manifest, final TypeReference activator) {
    final TextFileAccess file = new TextFileAccess();
    file.setEncodingProvider(this.encodingProvider);
    String _path = manifest.getPath();
    file.setPath(_path);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Manifest-Version: 1.0");
    _builder.newLine();
    _builder.append("Bundle-ManifestVersion: 2");
    _builder.newLine();
    _builder.append("Bundle-Name: ");
    String _bundleName = manifest.getBundleName();
    _builder.append(_bundleName, "");
    _builder.newLineIfNotEmpty();
    _builder.append("Bundle-SymbolicName: ");
    String _elvis = null;
    String _symbolicName = manifest.getSymbolicName();
    if (_symbolicName != null) {
      _elvis = _symbolicName;
    } else {
      String _bundleName_1 = manifest.getBundleName();
      _elvis = _bundleName_1;
    }
    _builder.append(_elvis, "");
    _builder.append("; singleton:=true");
    _builder.newLineIfNotEmpty();
    {
      String _version = manifest.getVersion();
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_version);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        _builder.append("Bundle-Version: ");
        String _version_1 = manifest.getVersion();
        _builder.append(_version_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("Bundle-RequiredExecutionEnvironment: JavaSE-1.6");
    _builder.newLine();
    _builder.append("Bundle-ActivationPolicy: lazy");
    _builder.newLine();
    {
      Set<String> _exportedPackages = manifest.getExportedPackages();
      boolean _isEmpty = _exportedPackages.isEmpty();
      boolean _not_1 = (!_isEmpty);
      if (_not_1) {
        _builder.append("Export-Package: ");
        {
          Set<String> _exportedPackages_1 = manifest.getExportedPackages();
          List<String> _sort = IterableExtensions.<String>sort(_exportedPackages_1);
          boolean _hasElements = false;
          for(final String pack : _sort) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",\n ", "");
            }
            _builder.append(pack, "");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Set<String> _requiredBundles = manifest.getRequiredBundles();
      boolean _isEmpty_1 = _requiredBundles.isEmpty();
      boolean _not_2 = (!_isEmpty_1);
      if (_not_2) {
        _builder.append("Require-Bundle: ");
        {
          Set<String> _requiredBundles_1 = manifest.getRequiredBundles();
          List<String> _sort_1 = IterableExtensions.<String>sort(_requiredBundles_1);
          boolean _hasElements_1 = false;
          for(final String bundle : _sort_1) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate(",\n ", "");
            }
            _builder.append(bundle, "");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Set<String> _importedPackages = manifest.getImportedPackages();
      boolean _isEmpty_2 = _importedPackages.isEmpty();
      boolean _not_3 = (!_isEmpty_2);
      if (_not_3) {
        _builder.append("Import-Package: ");
        {
          Set<String> _importedPackages_1 = manifest.getImportedPackages();
          List<String> _sort_2 = IterableExtensions.<String>sort(_importedPackages_1);
          boolean _hasElements_2 = false;
          for(final String pack_1 : _sort_2) {
            if (!_hasElements_2) {
              _hasElements_2 = true;
            } else {
              _builder.appendImmediate(",\n ", "");
            }
            _builder.append(pack_1, "");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((activator != null)) {
        _builder.append("Bundle-Activator: ");
        _builder.append(activator, "");
        _builder.newLineIfNotEmpty();
      }
    }
    file.setContent(_builder);
    return file;
  }
  
  public JavaFileAccess createEclipsePluginExecutableExtensionFactory(final LanguageConfig2 langConfig) {
    final Grammar g = langConfig.getGrammar();
    TypeReference _eclipsePluginExecutableExtensionFactory = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(g);
    final JavaFileAccess javaFile = new JavaFileAccess(_eclipsePluginExecutableExtensionFactory, this.codeConfig);
    javaFile.setEncodingProvider(this.encodingProvider);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* This class was generated. Customizations should only happen in a newly");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* introduced subclass. ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    javaFile.setTypeComment(_builder);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _eclipsePluginExecutableExtensionFactory = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(g);
        String _simpleName = _eclipsePluginExecutableExtensionFactory.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory");
        _builder.append(_typeRef, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        TypeReference _typeRef_1 = TypeReference.typeRef("org.osgi.framework.Bundle");
        _builder.append(_typeRef_1, "\t");
        _builder.append(" getBundle() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        TypeReference _eclipsePluginActivator = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginActivator(g);
        _builder.append(_eclipsePluginActivator, "\t\t");
        _builder.append(".getInstance().getBundle();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        _builder.append(Injector.class, "\t");
        _builder.append(" getInjector() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        TypeReference _eclipsePluginActivator_1 = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginActivator(g);
        _builder.append(_eclipsePluginActivator_1, "\t\t");
        _builder.append(".getInstance().getInjector(");
        TypeReference _eclipsePluginActivator_2 = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginActivator(g);
        _builder.append(_eclipsePluginActivator_2, "\t\t");
        _builder.append(".");
        String _name = g.getName();
        String _upperCase = _name.toUpperCase();
        String _replaceAll = _upperCase.replaceAll("\\.", "_");
        _builder.append(_replaceAll, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setJavaContent(_client);
    javaFile.setMarkedAsGenerated(true);
    return javaFile;
  }
  
  public JavaFileAccess createEclipsePluginActivator(final List<LanguageConfig2> langConfigs) {
    final Function1<LanguageConfig2, Grammar> _function = new Function1<LanguageConfig2, Grammar>() {
      @Override
      public Grammar apply(final LanguageConfig2 it) {
        return it.getGrammar();
      }
    };
    List<Grammar> _map = ListExtensions.<LanguageConfig2, Grammar>map(langConfigs, _function);
    final List<Grammar> gs = IterableExtensions.<Grammar>toList(_map);
    Grammar _head = IterableExtensions.<Grammar>head(gs);
    final TypeReference activator = this._xtextGeneratorNaming.getEclipsePluginActivator(_head);
    final JavaFileAccess javaFile = new JavaFileAccess(activator, this.codeConfig);
    javaFile.setEncodingProvider(this.encodingProvider);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* This class was generated. Customizations should only happen in a newly");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* introduced subclass. ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    javaFile.setTypeComment(_builder);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        String _simpleName = activator.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        _builder.append("org.eclipse.ui.plugin.AbstractUIPlugin", "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        {
          for(final Grammar grammar : gs) {
            _builder.append("\t");
            _builder.append("public static final String ");
            String _name = grammar.getName();
            String _upperCase = _name.toUpperCase();
            String _replaceAll = _upperCase.replaceAll("\\.", "_");
            _builder.append(_replaceAll, "\t");
            _builder.append(" = \"");
            String _name_1 = grammar.getName();
            _builder.append(_name_1, "\t");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private static final ");
        _builder.append(Logger.class, "\t");
        _builder.append(" logger = ");
        _builder.append(Logger.class, "\t");
        _builder.append(".getLogger(");
        String _simpleName_1 = activator.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private static ");
        String _simpleName_2 = activator.getSimpleName();
        _builder.append(_simpleName_2, "\t");
        _builder.append(" INSTANCE;");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private ");
        _builder.append(Map.class, "\t");
        _builder.append("<String, ");
        _builder.append(Injector.class, "\t");
        _builder.append("> injectors = ");
        _builder.append(Collections.class, "\t");
        _builder.append(".synchronizedMap(");
        _builder.append(Maps.class, "\t");
        _builder.append(".<String, ");
        _builder.append(Injector.class, "\t");
        _builder.append("> newHashMapWithExpectedSize(1));");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void start(");
        TypeReference _typeRef = TypeReference.typeRef("org.osgi.framework.BundleContext");
        _builder.append(_typeRef, "\t");
        _builder.append(" context) throws Exception {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super.start(context);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("INSTANCE = this;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void stop(");
        TypeReference _typeRef_1 = TypeReference.typeRef("org.osgi.framework.BundleContext");
        _builder.append(_typeRef_1, "\t");
        _builder.append(" context) throws Exception {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("injectors.clear();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("INSTANCE = null;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("super.stop(context);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static ");
        String _simpleName_3 = activator.getSimpleName();
        _builder.append(_simpleName_3, "\t");
        _builder.append(" getInstance() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return INSTANCE;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        _builder.append(Injector.class, "\t");
        _builder.append(" getInjector(String language) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("synchronized (injectors) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append(Injector.class, "\t\t\t");
        _builder.append(" injector = injectors.get(language);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("if (injector == null) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("injectors.put(language, injector = createInjector(language));");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("return injector;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        _builder.append(Injector.class, "\t");
        _builder.append(" createInjector(String language) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append(Module.class, "\t\t\t");
        _builder.append(" runtimeModule = getRuntimeModule(language);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append(Module.class, "\t\t\t");
        _builder.append(" sharedStateModule = getSharedStateModule();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append(Module.class, "\t\t\t");
        _builder.append(" uiModule = getUiModule(language);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append(Module.class, "\t\t\t");
        _builder.append(" mergedModule = ");
        _builder.append(Modules2.class, "\t\t\t");
        _builder.append(".mixin(runtimeModule, sharedStateModule, uiModule);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("return ");
        _builder.append(Guice.class, "\t\t\t");
        _builder.append(".createInjector(mergedModule);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("} catch (Exception e) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("logger.error(\"Failed to create injector for \" + language);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("logger.error(e.getMessage(), e);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("throw new RuntimeException(\"Failed to create injector for \" + language, e);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected Module getRuntimeModule(String grammar) {");
        _builder.newLine();
        {
          for(final Grammar grammar_1 : gs) {
            _builder.append("\t\t");
            _builder.append("if (");
            String _name_2 = grammar_1.getName();
            String _upperCase_1 = _name_2.toUpperCase();
            String _replaceAll_1 = _upperCase_1.replaceAll("\\.", "_");
            _builder.append(_replaceAll_1, "\t\t");
            _builder.append(".equals(grammar)) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("return new ");
            TypeReference _runtimeModule = XtextGeneratorTemplates.this._xtextGeneratorNaming.getRuntimeModule(grammar_1);
            _builder.append(_runtimeModule, "\t\t\t");
            _builder.append("();");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("throw new IllegalArgumentException(grammar);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        _builder.append(Module.class, "\t");
        _builder.append(" getUiModule(String grammar) {");
        _builder.newLineIfNotEmpty();
        {
          for(final Grammar grammar_2 : gs) {
            _builder.append("\t\t");
            _builder.append("if (");
            String _name_3 = grammar_2.getName();
            String _upperCase_2 = _name_3.toUpperCase();
            String _replaceAll_2 = _upperCase_2.replaceAll("\\.", "_");
            _builder.append(_replaceAll_2, "\t\t");
            _builder.append(".equals(grammar)) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("return new ");
            TypeReference _eclipsePluginModule = XtextGeneratorTemplates.this._xtextGeneratorNaming.getEclipsePluginModule(grammar_2);
            _builder.append(_eclipsePluginModule, "\t\t\t");
            _builder.append("(this);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("throw new IllegalArgumentException(grammar);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        _builder.append(Module.class, "\t");
        _builder.append(" getSharedStateModule() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return new ");
        TypeReference _typeRef_2 = TypeReference.typeRef("org.eclipse.xtext.ui.shared.SharedStateModule");
        _builder.append(_typeRef_2, "\t\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setJavaContent(_client);
    javaFile.setMarkedAsGenerated(true);
    return javaFile;
  }
}