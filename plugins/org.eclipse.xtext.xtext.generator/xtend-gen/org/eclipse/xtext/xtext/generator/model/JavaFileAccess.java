/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.model.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.IClassAnnotation;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@SuppressWarnings("all")
public class JavaFileAccess extends TextFileAccess {
  private static class JavaStringConcatenation extends StringConcatenation {
    private final JavaFileAccess access;
    
    public JavaStringConcatenation(final JavaFileAccess access) {
      super(access.codeConfig.getLineDelimiter());
      this.access = access;
    }
    
    @Override
    public String getStringRepresentation(final Object object) {
      String _xifexpression = null;
      if ((object instanceof TypeReference)) {
        _xifexpression = this.access.importType(((TypeReference)object));
      } else {
        String _xifexpression_1 = null;
        if ((object instanceof Class<?>)) {
          TypeReference _typeReference = new TypeReference(((Class<?>)object));
          _xifexpression_1 = this.access.importType(_typeReference);
        } else {
          _xifexpression_1 = object.toString();
        }
        _xifexpression = _xifexpression_1;
      }
      return _xifexpression;
    }
  }
  
  private final Map<String, TypeReference> imports = CollectionLiterals.<String, TypeReference>newHashMap();
  
  private final String packageName;
  
  private final CodeConfig codeConfig;
  
  @Accessors
  private CharSequence typeComment;
  
  @Accessors
  private boolean markedAsGenerated;
  
  @Accessors
  private final List<IClassAnnotation> annotations = CollectionLiterals.<IClassAnnotation>newArrayList();
  
  public JavaFileAccess(final String qualifiedName, final CodeConfig codeConfig) {
    this(new TypeReference(qualifiedName), codeConfig);
  }
  
  public JavaFileAccess(final TypeReference typeRef, final CodeConfig codeConfig) {
    String _package = typeRef.getPackage();
    this.packageName = _package;
    String _name = typeRef.getName();
    String _simpleName = typeRef.getSimpleName();
    String _plus = ((this.packageName + ".") + _simpleName);
    boolean _notEquals = (!Objects.equal(_name, _plus));
    if (_notEquals) {
      throw new IllegalArgumentException("Nested types cannot be serialized.");
    }
    String _replace = this.packageName.replace(".", "/");
    String _plus_1 = (_replace + "/");
    String _simpleName_1 = typeRef.getSimpleName();
    String _plus_2 = (_plus_1 + _simpleName_1);
    String _plus_3 = (_plus_2 + ".java");
    this.setPath(_plus_3);
    this.codeConfig = codeConfig;
  }
  
  public String importType(final TypeReference typeRef) {
    String name = typeRef.getSimpleName();
    boolean _and = false;
    boolean _isJavaDefaultType = CodeGenUtil.isJavaDefaultType(name);
    boolean _not = (!_isJavaDefaultType);
    if (!_not) {
      _and = false;
    } else {
      String _package = typeRef.getPackage();
      boolean _notEquals = (!Objects.equal(this.packageName, _package));
      _and = _notEquals;
    }
    if (_and) {
      final TypeReference imported = this.imports.get(name);
      if ((imported == null)) {
        this.imports.put(name, typeRef);
      } else {
        String _name = imported.getName();
        String _name_1 = typeRef.getName();
        boolean _notEquals_1 = (!Objects.equal(_name, _name_1));
        if (_notEquals_1) {
          String _name_2 = typeRef.getName();
          name = _name_2;
        }
      }
    }
    List<TypeReference> _arguments = typeRef.getArguments();
    final Function1<TypeReference, CharSequence> _function = new Function1<TypeReference, CharSequence>() {
      @Override
      public CharSequence apply(final TypeReference it) {
        return JavaFileAccess.this.importType(it);
      }
    };
    String _join = IterableExtensions.<TypeReference>join(_arguments, "<", ", ", ">", _function);
    return (name + _join);
  }
  
  public void setJavaContent(final StringConcatenationClient javaContent) {
    final JavaFileAccess.JavaStringConcatenation javaStringConcat = new JavaFileAccess.JavaStringConcatenation(this);
    javaStringConcat.append(javaContent);
    this.setContent(javaStringConcat);
  }
  
  @Override
  public CharSequence generate() {
    List<IClassAnnotation> _classAnnotations = this.codeConfig.getClassAnnotations();
    final Function1<IClassAnnotation, Boolean> _function = new Function1<IClassAnnotation, Boolean>() {
      @Override
      public Boolean apply(final IClassAnnotation it) {
        return Boolean.valueOf(it.appliesTo(JavaFileAccess.this));
      }
    };
    Iterable<IClassAnnotation> _filter = IterableExtensions.<IClassAnnotation>filter(_classAnnotations, _function);
    final Iterable<IClassAnnotation> classAnnotations = Iterables.<IClassAnnotation>concat(this.annotations, _filter);
    final Procedure1<IClassAnnotation> _function_1 = new Procedure1<IClassAnnotation>() {
      @Override
      public void apply(final IClassAnnotation it) {
        TypeReference _annotationImport = it.getAnnotationImport();
        JavaFileAccess.this.importType(_annotationImport);
      }
    };
    IterableExtensions.<IClassAnnotation>forEach(classAnnotations, _function_1);
    Collection<TypeReference> _values = this.imports.values();
    final Function1<TypeReference, String> _function_2 = new Function1<TypeReference, String>() {
      @Override
      public String apply(final TypeReference it) {
        return it.getName();
      }
    };
    Iterable<String> _map = IterableExtensions.<TypeReference, String>map(_values, _function_2);
    final ArrayList<String> sortedImports = Lists.<String>newArrayList(_map);
    Collections.<String>sort(sortedImports);
    StringConcatenation _builder = new StringConcatenation();
    String _fileHeader = this.codeConfig.getFileHeader();
    _builder.append(_fileHeader, "");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    _builder.append(this.packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      for(final String importName : sortedImports) {
        _builder.append("import ");
        _builder.append(importName, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append(this.typeComment, "");
    _builder.newLineIfNotEmpty();
    {
      for(final IClassAnnotation annot : classAnnotations) {
        CharSequence _generate = annot.generate();
        _builder.append(_generate, "");
        _builder.newLineIfNotEmpty();
      }
    }
    CharSequence _content = this.getContent();
    _builder.append(_content, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  @Pure
  public CharSequence getTypeComment() {
    return this.typeComment;
  }
  
  public void setTypeComment(final CharSequence typeComment) {
    this.typeComment = typeComment;
  }
  
  @Pure
  public boolean isMarkedAsGenerated() {
    return this.markedAsGenerated;
  }
  
  public void setMarkedAsGenerated(final boolean markedAsGenerated) {
    this.markedAsGenerated = markedAsGenerated;
  }
  
  @Pure
  public List<IClassAnnotation> getAnnotations() {
    return this.annotations;
  }
}