/**
 * Copyright (c) 2023, 2025 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.compiler;

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

import com.google.common.io.ByteStreams;
import com.google.inject.Inject;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public class QuickDebugSourceInstallingCompilationParticipantTest extends AbstractXtendUITestCase {
	@Inject
	private WorkbenchTestHelper workbenchTestHelper;

	@Test
	public void testIfThereIsAnyStatum() throws Exception {
		// ensure JDT is fully functional and its participants registered
		workbenchTestHelper.createFile("hello/Hello.java", """
			package hello;

			public class Hello {
			}
		""");
		IResourcesSetupUtil.waitForBuild();

		final IFile source = workbenchTestHelper.createFile("somePackage/Outer.xtend", """
			package somePackage

			class Outer {
			  def dosomething() {
			  	println(1)
			  	println(2)
			  	println(3)
			  }
			}
		""");
		IResourcesSetupUtil.waitForBuild();
		final IFile clazz = source.getProject().getFile("bin/somePackage/Outer.class");
		assertTrue("bytecode not found", clazz.exists());
		final AtomicBoolean debugInfoFound = new AtomicBoolean(false);
		try (var in = clazz.getContents()) {
			final byte[] bytes = ByteStreams.toByteArray(in);
			final ClassReader r = new ClassReader(bytes);
			r.accept(new ClassVisitor(Opcodes.ASM9) {
				@Override
				public void visitSource(final String source, final String debug) {
					if ("Outer.java".equals(source)) {
						assertEquals("""
							SMAP
							Outer.java
							Xtend
							*S Xtend
							*F
							+ 0 Outer.xtend
							somePackage/Outer.xtend
							*L
							4:8,2
							5:10
							6:11
							7:12
							4:13,2
							*E
							""", debug.replace("\r", ""));
						debugInfoFound.set(true);
					}
					super.visitSource(source, debug);
				}
			}, 0);
			if (!debugInfoFound.get()) {
				fail("No source attribute found in bytecode");
			}
		}
	}
}
