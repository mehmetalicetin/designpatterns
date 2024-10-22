package com.i2i.fcbs;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
class CallerTest extends TestCase {
	@Test
	void testExecute() {
		// Statik metodu mockla
		PowerMockito.mockStatic(UtilityClass.class);

		// Statik metot çağrıldığında hiçbir şey yapmasın
		PowerMockito.doNothing().when(UtilityClass.class);
		UtilityClass.performAction();

		// Gerçek metodu çağır
		UtilityClass.performAction();

		// Mocklanan metodu doğrula
		PowerMockito.verifyStatic(UtilityClass.class);
		UtilityClass.performAction();

	}
}
