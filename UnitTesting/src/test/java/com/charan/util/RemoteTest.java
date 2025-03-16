package com.charan.util;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class RemoteTest {
	
	@Test
	public void emptyTest() {
		Remote remote = Remote.getRemote();
		Remote remote1 = Remote.getRemote();
		if(remote==null || remote1==null) {
			fail("references must be not null ");
		}
		assertSame(remote, remote1);
	}
}
