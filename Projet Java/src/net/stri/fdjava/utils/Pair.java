package net.stri.fdjava.utils;

import lombok.Getter;
import lombok.Setter;

public final class Pair<V1, V2> {

	@Getter @Setter
	private V1 value1;
	@Getter @Setter
	private V2 value2;
	
	public Pair(V1 value1, V2 value2) {
		this.value1 = value1;
		this.value2 = value2;
	}
	
	
	
}
