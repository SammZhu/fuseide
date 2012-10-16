package org.fusesource.ide.fabric.actions.jclouds;

import static org.fusesource.ide.fabric.actions.jclouds.JClouds.text;

import org.eclipse.jface.viewers.LabelProvider;
import org.jclouds.compute.domain.ComputeMetadata;
import org.jclouds.domain.Location;
import org.jclouds.domain.ResourceMetadata;
import org.jclouds.providers.ProviderMetadata;

public class JCloudsLabelProvider extends LabelProvider {
	private static JCloudsLabelProvider instance = new JCloudsLabelProvider();

	public static JCloudsLabelProvider getInstance() {
		return instance;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof ProviderMetadata) {
			return JClouds.text((ProviderMetadata) element);
		} else if (element instanceof Location) {
			return text((Location) element);
		} else if (element instanceof ComputeMetadata) {
			return JClouds.text((ComputeMetadata) element);
		} else if (element instanceof ResourceMetadata) {
			return JClouds.text((ResourceMetadata<?>) element);
		} else {
			return super.getText(element);
		}
	}

}