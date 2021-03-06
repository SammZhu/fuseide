/*******************************************************************************
 * Copyright (c) 2014 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.fusesource.ide.camel.model.generated;

import java.util.Map;

import org.apache.camel.model.EnrichDefinition;
import org.apache.camel.model.language.ExpressionDefinition;
import org.apache.camel.model.ProcessorDefinition;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.fusesource.ide.camel.model.AbstractNode;
import org.fusesource.ide.camel.model.ExpressionPropertyDescriptor;
import org.fusesource.ide.camel.model.RouteContainer;
import org.fusesource.ide.camel.model.util.Objects;
import org.fusesource.ide.commons.properties.BooleanPropertyDescriptor;
import org.fusesource.ide.commons.properties.ComplexPropertyDescriptor;
import org.fusesource.ide.commons.properties.ComplexUnionPropertyDescriptor;
import org.fusesource.ide.commons.properties.EnumPropertyDescriptor;
import org.fusesource.ide.commons.properties.ListPropertyDescriptor;
import org.fusesource.ide.commons.properties.UnionTypeValue;

/**
 * The Node class from Camel's EnrichDefinition
 *
 * NOTE - this file is auto-generated using Velocity.
 *
 * DO NOT EDIT!
 */
public class Enrich extends AbstractNode {

    public static final String PROPERTY_RESOURCEURI = "Enrich.ResourceUri";
    public static final String PROPERTY_AGGREGATIONSTRATEGYREF = "Enrich.AggregationStrategyRef";
    public static final String PROPERTY_AGGREGATIONSTRATEGYMETHODNAME = "Enrich.AggregationStrategyMethodName";
    public static final String PROPERTY_AGGREGATIONSTRATEGYMETHODALLOWNULL = "Enrich.AggregationStrategyMethodAllowNull";
    public static final String PROPERTY_AGGREGATEONEXCEPTION = "Enrich.AggregateOnException";

    private String resourceUri;
    private String aggregationStrategyRef;
    private String aggregationStrategyMethodName;
    private Boolean aggregationStrategyMethodAllowNull;
    private Boolean aggregateOnException;

    public Enrich() {
    }

    public Enrich(EnrichDefinition definition, RouteContainer parent) {
        super(parent);
        loadPropertiesFromCamelDefinition(definition);
        loadChildrenFromCamelDefinition(definition);
    }

    @Override
    public String getIconName() {
        return "enrich.png";
    }

    @Override
    public String getDocumentationFileName() {
        return "enrichEIP";
    }

    @Override
    public String getCategoryName() {
        return "Transformation";
    }

    /**
     * @return the resourceUri
     */
    public String getResourceUri() {
        return this.resourceUri;
    }

    /**
     * @param resourceUri the resourceUri to set
     */
    public void setResourceUri(String resourceUri) {
        String oldValue = this.resourceUri;
        this.resourceUri = resourceUri;
        if (!isSame(oldValue, resourceUri)) {
            firePropertyChange(PROPERTY_RESOURCEURI, oldValue, resourceUri);
        }
    }

    /**
     * @return the aggregationStrategyRef
     */
    public String getAggregationStrategyRef() {
        return this.aggregationStrategyRef;
    }

    /**
     * @param aggregationStrategyRef the aggregationStrategyRef to set
     */
    public void setAggregationStrategyRef(String aggregationStrategyRef) {
        String oldValue = this.aggregationStrategyRef;
        this.aggregationStrategyRef = aggregationStrategyRef;
        if (!isSame(oldValue, aggregationStrategyRef)) {
            firePropertyChange(PROPERTY_AGGREGATIONSTRATEGYREF, oldValue, aggregationStrategyRef);
        }
    }

    /**
     * @return the aggregationStrategyMethodName
     */
    public String getAggregationStrategyMethodName() {
        return this.aggregationStrategyMethodName;
    }

    /**
     * @param aggregationStrategyMethodName the aggregationStrategyMethodName to set
     */
    public void setAggregationStrategyMethodName(String aggregationStrategyMethodName) {
        String oldValue = this.aggregationStrategyMethodName;
        this.aggregationStrategyMethodName = aggregationStrategyMethodName;
        if (!isSame(oldValue, aggregationStrategyMethodName)) {
            firePropertyChange(PROPERTY_AGGREGATIONSTRATEGYMETHODNAME, oldValue, aggregationStrategyMethodName);
        }
    }

    /**
     * @return the aggregationStrategyMethodAllowNull
     */
    public Boolean getAggregationStrategyMethodAllowNull() {
        return this.aggregationStrategyMethodAllowNull;
    }

    /**
     * @param aggregationStrategyMethodAllowNull the aggregationStrategyMethodAllowNull to set
     */
    public void setAggregationStrategyMethodAllowNull(Boolean aggregationStrategyMethodAllowNull) {
        Boolean oldValue = this.aggregationStrategyMethodAllowNull;
        this.aggregationStrategyMethodAllowNull = aggregationStrategyMethodAllowNull;
        if (!isSame(oldValue, aggregationStrategyMethodAllowNull)) {
            firePropertyChange(PROPERTY_AGGREGATIONSTRATEGYMETHODALLOWNULL, oldValue, aggregationStrategyMethodAllowNull);
        }
    }

    /**
     * @return the aggregateOnException
     */
    public Boolean getAggregateOnException() {
        return this.aggregateOnException;
    }

    /**
     * @param aggregateOnException the aggregateOnException to set
     */
    public void setAggregateOnException(Boolean aggregateOnException) {
        Boolean oldValue = this.aggregateOnException;
        this.aggregateOnException = aggregateOnException;
        if (!isSame(oldValue, aggregateOnException)) {
            firePropertyChange(PROPERTY_AGGREGATEONEXCEPTION, oldValue, aggregateOnException);
        }
    }

    @Override
    protected void addCustomProperties(Map<String, PropertyDescriptor> descriptors) {
        super.addCustomProperties(descriptors);

        PropertyDescriptor descResourceUri = new TextPropertyDescriptor(PROPERTY_RESOURCEURI, Messages.propertyLabelEnrichResourceUri);
        PropertyDescriptor descAggregationStrategyRef = new TextPropertyDescriptor(PROPERTY_AGGREGATIONSTRATEGYREF, Messages.propertyLabelEnrichAggregationStrategyRef);
        PropertyDescriptor descAggregationStrategyMethodName = new TextPropertyDescriptor(PROPERTY_AGGREGATIONSTRATEGYMETHODNAME, Messages.propertyLabelEnrichAggregationStrategyMethodName);
        PropertyDescriptor descAggregationStrategyMethodAllowNull = new BooleanPropertyDescriptor(PROPERTY_AGGREGATIONSTRATEGYMETHODALLOWNULL, Messages.propertyLabelEnrichAggregationStrategyMethodAllowNull);
        PropertyDescriptor descAggregateOnException = new BooleanPropertyDescriptor(PROPERTY_AGGREGATEONEXCEPTION, Messages.propertyLabelEnrichAggregateOnException);

        descriptors.put(PROPERTY_RESOURCEURI, descResourceUri);
        descriptors.put(PROPERTY_AGGREGATIONSTRATEGYREF, descAggregationStrategyRef);
        descriptors.put(PROPERTY_AGGREGATIONSTRATEGYMETHODNAME, descAggregationStrategyMethodName);
        descriptors.put(PROPERTY_AGGREGATIONSTRATEGYMETHODALLOWNULL, descAggregationStrategyMethodAllowNull);
        descriptors.put(PROPERTY_AGGREGATEONEXCEPTION, descAggregateOnException);
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.views.properties.IPropertySource\#setPropertyValue(java.lang.Object, java.lang.Object)
     */
    @Override
    public void setPropertyValue(Object id, Object value) {
        if (PROPERTY_RESOURCEURI.equals(id)) {
            setResourceUri(Objects.convertTo(value, String.class));
            return;
        }
        if (PROPERTY_AGGREGATIONSTRATEGYREF.equals(id)) {
            setAggregationStrategyRef(Objects.convertTo(value, String.class));
            return;
        }
        if (PROPERTY_AGGREGATIONSTRATEGYMETHODNAME.equals(id)) {
            setAggregationStrategyMethodName(Objects.convertTo(value, String.class));
            return;
        }
        if (PROPERTY_AGGREGATIONSTRATEGYMETHODALLOWNULL.equals(id)) {
            setAggregationStrategyMethodAllowNull(Objects.convertTo(value, Boolean.class));
            return;
        }
        if (PROPERTY_AGGREGATEONEXCEPTION.equals(id)) {
            setAggregateOnException(Objects.convertTo(value, Boolean.class));
            return;
        }
        super.setPropertyValue(id, value);
    }

    /* (non-Javadoc)
     * @see org.fusesource.ide.camel.model.AbstractNode\#getPropertyValue(java.lang.Object)
     */
    @Override
    public Object getPropertyValue(Object id) {
        if (PROPERTY_RESOURCEURI.equals(id)) {
            return this.getResourceUri();
        }
        if (PROPERTY_AGGREGATIONSTRATEGYREF.equals(id)) {
            return this.getAggregationStrategyRef();
        }
        if (PROPERTY_AGGREGATIONSTRATEGYMETHODNAME.equals(id)) {
            return this.getAggregationStrategyMethodName();
        }
        if (PROPERTY_AGGREGATIONSTRATEGYMETHODALLOWNULL.equals(id)) {
            return this.getAggregationStrategyMethodAllowNull();
        }
        if (PROPERTY_AGGREGATEONEXCEPTION.equals(id)) {
            return this.getAggregateOnException();
        }
        return super.getPropertyValue(id);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public ProcessorDefinition createCamelDefinition() {
        EnrichDefinition answer = new EnrichDefinition();

        answer.setResourceUri(toXmlPropertyValue(PROPERTY_RESOURCEURI, this.getResourceUri()));
        answer.setAggregationStrategyRef(toXmlPropertyValue(PROPERTY_AGGREGATIONSTRATEGYREF, this.getAggregationStrategyRef()));
        answer.setAggregationStrategyMethodName(toXmlPropertyValue(PROPERTY_AGGREGATIONSTRATEGYMETHODNAME, this.getAggregationStrategyMethodName()));
        answer.setAggregationStrategyMethodAllowNull(toXmlPropertyValue(PROPERTY_AGGREGATIONSTRATEGYMETHODALLOWNULL, this.getAggregationStrategyMethodAllowNull()));
        answer.setAggregateOnException(toXmlPropertyValue(PROPERTY_AGGREGATEONEXCEPTION, this.getAggregateOnException()));

        super.savePropertiesToCamelDefinition(answer);
        return answer;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class<?> getCamelDefinitionClass() {
        return EnrichDefinition.class;
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected void loadPropertiesFromCamelDefinition(ProcessorDefinition processor) {
        super.loadPropertiesFromCamelDefinition(processor);

        if (processor instanceof EnrichDefinition) {
            EnrichDefinition node = (EnrichDefinition) processor;

            this.setResourceUri(node.getResourceUri());
            this.setAggregationStrategyRef(node.getAggregationStrategyRef());
            this.setAggregationStrategyMethodName(node.getAggregationStrategyMethodName());
            this.setAggregationStrategyMethodAllowNull(node.getAggregationStrategyMethodAllowNull());
            this.setAggregateOnException(node.getAggregateOnException());
        } else {
            throw new IllegalArgumentException("ProcessorDefinition not an instanceof EnrichDefinition. Was " + processor.getClass().getName());
        }
    }

}
