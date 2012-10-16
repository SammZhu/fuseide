package org.fusesource.ide.fabric.camel.navigator;

import java.util.List;

import org.fusesource.fabric.camel.facade.CamelFacade;
import org.fusesource.fabric.camel.facade.mbean.CamelProcessorMBean;
import org.fusesource.ide.camel.model.Activator;
import org.fusesource.ide.commons.util.Objects;


public class CamelFacades {

	public static CamelProcessorMBean getProcessorMBean(CamelFacade camelFacade, String camelContextId, String nodeId) {
		try {
			List<CamelProcessorMBean> processors = camelFacade.getProcessors(camelContextId);
			for (CamelProcessorMBean processorMBean : processors) {
				String processorId = processorMBean.getProcessorId();
				if (Objects.equal(nodeId, processorId)) {
					return processorMBean;
				}
			}
		} catch (Exception e) {
			Activator.getLogger().warning(
					"Failed to find statistics for node: " + nodeId + " in camelContext: " + camelContextId + ". " + e,
					e);
		}
		return null;
	}

}
