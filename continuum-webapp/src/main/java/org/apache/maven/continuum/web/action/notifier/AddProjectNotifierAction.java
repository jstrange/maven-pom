package org.apache.maven.continuum.web.action.notifier;

import org.apache.maven.continuum.model.project.Project;
import org.apache.maven.continuum.model.project.ProjectNotifier;
import org.apache.maven.continuum.web.action.ContinuumActionSupport;

/*
 * Copyright 2004-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Action to add a {@link ProjectNotifier} for a specified {@link Project}.
 * 
 * @author <a href="mailto:evenisse@apache.org">Emmanuel Venisse</a>
 * @version $Id: AddNotifierAction.java 466640 2006-10-22 13:11:30Z jmcconnell $
 * @since 1.1
 *
 * @plexus.component 
 *   role="com.opensymphony.xwork.Action" 
 *   role-hint="addProjectNotifier"
 */
public class AddProjectNotifierAction
    extends ContinuumActionSupport
{
    /**
     * Identifier for the {@link Project} instance.
     */
    private int projectId;

    /**
     * Type for a {@link ProjectNotifier}.
     */
    private String notifierType;

    /**
     * Default method executed when no specific method is specified
     * for invocation.
     * @return result as a String value to determines the control flow.
     */
    public String execute()
    {
        return notifierType + "_" + INPUT;
    }

    /**
     * TODO: document!
     */
    public String doDefault()
    {
        return INPUT;
    }

    /**
     * Returns the type for the {@link ProjectNotifier}.
     * @return Notifier type as String.
     */
    public String getNotifierType()
    {
        return notifierType;
    }

    /**
     * Sets the type for the {@link ProjectNotifier}.
     * 
     * @param notifierType Notifier type to set.
     */
    public void setNotifierType( String notifierType )
    {
        this.notifierType = notifierType;
    }

    /**
     * Identifier for the Project being edited.
     * 
     * @return project id.
     */
    public int getProjectId()
    {
        return projectId;
    }

    /**
     * Sets the identifier for the Project to be edited for 
     * project notifiers.
     * 
     * @param projectId
     */
    public void setProjectId( int projectId )
    {
        this.projectId = projectId;
    }

}
