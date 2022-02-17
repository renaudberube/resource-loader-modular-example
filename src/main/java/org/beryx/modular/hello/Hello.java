package org.beryx.modular.hello;

import com.goterl.lazysodium.LazySodiumJava;
import com.goterl.lazysodium.SodiumJava;
import com.goterl.lazysodium.exceptions.SodiumException;
import com.goterl.lazysodium.utils.LibraryLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hello {
	private static final Logger logger = LoggerFactory.getLogger(Hello.class);

	public static void main(String[] args) throws SodiumException {

		logger.info("Hello, modular Java!");

		final LazySodiumJava lazy = new LazySodiumJava(
				// Forces loading from the bundled version to test
				// the modified resource-loade`r library.
				new SodiumJava(LibraryLoader.Mode.BUNDLED_ONLY));

		String hashed = lazy.cryptoGenericHash("Hello, modular Java!");
		logger.info(hashed);

	}

}
