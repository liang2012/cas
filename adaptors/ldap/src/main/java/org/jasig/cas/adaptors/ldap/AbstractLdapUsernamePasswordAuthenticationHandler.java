/*
 * Copyright 2005 The JA-SIG Collaborative. All rights reserved. See license
 * distributed with this file and available online at
 * http://www.uportal.org/license.html
 */
package org.jasig.cas.adaptors.ldap;

import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.ContextSource;
import org.springframework.util.Assert;

/**
 * Abstract class to handle common LDAP functionality.
 * 
 * @author Scott Battaglia
 * @version $Revision$ $Date$
 * @since 3.0.3
 *
 */
public abstract class AbstractLdapUsernamePasswordAuthenticationHandler extends
    AbstractUsernamePasswordAuthenticationHandler {

    private LdapTemplate ldapTemplate;

    /**
     * Method to set the datasource and generate a JdbcTemplate.
     * 
     * @param dataSource the datasource to use.
     */
    public final void setContextSource(final ContextSource contextSource) {
        this.ldapTemplate = new LdapTemplate(contextSource);
    }

    /**
     * Method to return the jdbcTemplate
     * 
     * @return a fully created JdbcTemplate.
     */
    protected final LdapTemplate getLdapTemplate() {
        return this.ldapTemplate;
    }

    protected final ContextSource getContextSource() {
        return this.ldapTemplate.getContextSource();
    }

    protected final void afterPropertiesSetInternal() throws Exception {
        Assert.notNull(this.ldapTemplate);
        initDao();
    }

    /**
     * Template method to do additional set up in the dao implementations.
     * 
     * @throws Exception if there is a problem during set up.
     */
    protected void initDao() throws Exception {
        // nothing to do here...stub
    }
}