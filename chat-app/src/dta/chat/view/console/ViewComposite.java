package dta.chat.view.console;

import java.util.*;

public class ViewComposite {
	private List<ViewComposite> children = new ArrayList<>();
	
	public void print(){
		children.forEach((child) -> child.print());
		children.forEach(ViewComposite::print);
	}
}
