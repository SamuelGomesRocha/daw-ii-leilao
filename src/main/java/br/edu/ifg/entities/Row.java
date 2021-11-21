package br.edu.ifg.entities;

public class Row {

	private int index;
	private Status context;
	
	public Row(int index, Status context) {
		super();
		this.index = index;
		this.context = context;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Status getContext() {
		return context;
	}

	public void setContext(Status context) {
		this.context = context;
	}
	
	
}
