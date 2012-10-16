package org.fusesource.ide.commons.ui.label;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.fusesource.ide.commons.ui.ImageProvider;
import org.fusesource.ide.commons.util.Function1;
import org.fusesource.ide.commons.util.Function1WithReturnType;
import org.fusesource.ide.commons.util.Objects;
import org.fusesource.ide.commons.util.Strings;


public class FunctionColumnLabelProvider extends ColumnLabelProvider implements Function1WithReturnType {
	private final Function1 function;

	public FunctionColumnLabelProvider(Function1 function) {
		this.function = function;
	}

	@Override
	public String getText(Object element) {
		Object answer = apply(element);
		return Strings.getOrElse(answer);
	}


	public Function1 getFunction() {
		return function;
	}

	@Override
	public Object apply(Object element) {
		return function.apply(element);
	}

	@Override
	public Class<?> getReturnType() {
		return Objects.getReturnType(function);
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof ImageProvider) {
			ImageProvider ip = (ImageProvider) element;
			return ip.getImage();
		}
		return super.getImage(element);
	}

}