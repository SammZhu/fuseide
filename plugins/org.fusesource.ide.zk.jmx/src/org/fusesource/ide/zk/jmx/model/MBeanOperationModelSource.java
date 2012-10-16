/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.fusesource.ide.zk.jmx.model;

import java.util.Set;

import org.fusesource.ide.zk.jmx.data.JmxConnection;
import org.fusesource.ide.zk.jmx.data.MBean;
import org.fusesource.ide.zk.jmx.data.MBeanOperation;
import org.fusesource.ide.zk.core.model.DataModelSourceException;


/**
 * TODO: Comment.
 * 
 * @author Mark Masse
 */
public class MBeanOperationModelSource extends MBeanFeatureModelSource<MBeanOperationModel, MBeanOperation> {

    /**
     * TODO: Comment.
     * 
     * @param mbeanModel
     * @param jmxConnectionModel
     */
    public MBeanOperationModelSource(MBeanModel mbeanModel, JmxConnectionModel jmxConnectionModel) {
        super(mbeanModel, jmxConnectionModel);
    }

    @Override
    public Set<String> getKeys() throws DataModelSourceException {
        return getMBean().getOperationNames();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.fusesource.ide.zk.zookeeper.model.jmx.MBeanFeatureModelSource#getMBeanFeature(org.fusesource.ide.zk
     * .zookeeper.data.jmx.JmxConnection, org.fusesource.ide.zk.zookeeper.data.jmx.MBean, java.lang.String)
     */
    @Override
    protected MBeanOperation getMBeanFeature(JmxConnection jmxConnection, MBean mbean, String operationName) {
        return jmxConnection.getMBeanOperation(mbean, operationName);
    }

    @Override
    protected MBeanOperationModel createModelInternal(String operationName) {
        return new MBeanOperationModel(operationName, getMBeanModel(), getJmxConnectionModel());
    }

}
