package org.fusesource.ide.fabric.camel.navigator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySource;
import org.fusesource.fabric.camel.facade.CamelFacade;
import org.fusesource.fabric.camel.facade.mbean.CamelRouteMBean;
import org.fusesource.fon.util.messages.IExchange;
import org.fusesource.fon.util.messages.ITraceExchangeBrowser;
import org.fusesource.fon.util.messages.NodeStatisticsContainer;
import org.fusesource.ide.camel.model.AbstractNode;
import org.fusesource.ide.camel.model.AbstractNodeFacade;
import org.fusesource.ide.camel.model.Activator;
import org.fusesource.ide.camel.model.RouteContainer;
import org.fusesource.ide.camel.model.RouteSupport;
import org.fusesource.ide.commons.tree.Node;
import org.fusesource.ide.commons.tree.RefreshableCollectionNode;
import org.fusesource.ide.commons.ui.ImageProvider;
import org.fusesource.ide.fabric.FabricPlugin;
import org.fusesource.ide.jmx.ui.internal.views.navigator.ContextMenuProvider;


public class RoutesNode extends RefreshableCollectionNode implements AbstractNodeFacade, ContextMenuProvider, ITraceExchangeBrowser, ImageProvider {
	private final CamelContextNode camelContextNode;
	private RouteContainer routeContainer;

	public RoutesNode(CamelContextNode camelContextNode) {
		super(camelContextNode);
		this.camelContextNode = camelContextNode;
	}

	@Override
	public String toString() {
		return "Routes";
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == IPropertySheetPage.class) {
			//return new ViewPropertySheetPage(new RoutesTabViewPage(this));
			return new RoutesTabViewPage(this);
		}
		return super.getAdapter(adapter);
	}

	public CamelFacade getFacade() {
		return camelContextNode.getFacade();
	}

	public CamelContextNode getCamelContextNode() {
		return camelContextNode;
	}

	@Override
	protected void loadChildren() {
		Map<String,RouteNode> routeMap = new HashMap<String, RouteNode>();
		routeContainer = getCamelContextNode().getModelContainer();
		if (routeContainer != null) {
			List<AbstractNode> children = routeContainer.getChildren();
			for (AbstractNode node : children) {
				if (node instanceof RouteSupport) {
					RouteSupport route = (RouteSupport) node;
					RouteNode routeNode = new RouteNode(this, route);
					String id = route.getId();
					if (id != null) {
						routeMap .put(id, routeNode);
					}
					addChild(routeNode);
				}
			}
		}
		try {
			List<CamelRouteMBean> routeMBeans = getFacade().getRoutes(getManagementName());
			for (CamelRouteMBean mbean : routeMBeans) {
				String routeId = mbean.getRouteId();
				if (routeId != null) {
					RouteNode node = routeMap.get(routeId);
					if (node != null) {
						node.setRouteMBean(mbean);
					}
				}
			}
		} catch (Exception e) {
			Activator.getLogger().warning(e);
		}
	}

	public String getCamelContextId() {
		return camelContextNode.getContextId();
	}

	public String getManagementName() {
		return camelContextNode.getManagementName();
	}

	@Override
	public List<IExchange> browseExchanges() {
		return getCamelContextNode().browseExchanges();
	}

	@Override
	public NodeStatisticsContainer getNodeStatisticsContainer() {
		return getCamelContextNode().getNodeStatisticsContainer();
	}

	@Override
	public AbstractNode getAbstractNode() {
		checkLoaded();
		return routeContainer;
	}

	@Override
	public void provideContextMenu(IMenuManager menu) {
		getCamelContextNode().provideContextMenu(menu);
	}

	public List<IPropertySource> getAllProcessorsPropertySourceList() {
		List<IPropertySource> answer = new ArrayList<IPropertySource>();
		Node[] children = getChildren();
		for (Node node : children) {
			if (node instanceof ProcessorNodeSupport) {
				ProcessorNodeSupport processor = (ProcessorNodeSupport) node;
				processor.appendAllProcessorSourceList(answer);
			}
		}
		return answer;
	}

	@Override
	public Image getImage() {
		return FabricPlugin.getDefault().getImage("camel_route_folder.png");
	}
}
