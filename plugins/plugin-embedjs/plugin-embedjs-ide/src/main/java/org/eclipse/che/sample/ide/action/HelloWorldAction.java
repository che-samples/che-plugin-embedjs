/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.che.sample.ide.action;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.action.BaseAction;
import org.eclipse.che.ide.api.parts.PartStackType;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;
import org.eclipse.che.sample.ide.view.HelloWorldViewPresenter;

/** Action for opening a part which embeds javascript code. */
@Singleton
public class HelloWorldAction extends BaseAction {

  public static final String ACTION_ID = "helloWorldFromJSAction";

  private WorkspaceAgent workspaceAgent;
  private HelloWorldViewPresenter helloWorldViewPresenter;

  @Inject
  public HelloWorldAction(
      WorkspaceAgent workspaceAgent, HelloWorldViewPresenter helloWorldViewPresenter) {
    super("Show Hello World JavaScript View");
    this.workspaceAgent = workspaceAgent;
    this.helloWorldViewPresenter = helloWorldViewPresenter;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    workspaceAgent.openPart(helloWorldViewPresenter, PartStackType.INFORMATION);
    workspaceAgent.setActivePart(helloWorldViewPresenter);
  }
}
